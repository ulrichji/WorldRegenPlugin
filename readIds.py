#! python3

newLine = '\n'
tab = '\t'
hexValCol = 2
blockIdCol = 3
blockNameCol = 4
itemIdCol = 3

def readCSVToTable(file,separator=",",headerCount=0):
	returnTable = []
	
	inputFile = open(file,"r")
	
	headerRows = []
	header = True
	for line in inputFile:
		cols = line.strip().split(separator)
		if(headerCount > 0):
			headerCount -= 1
			headerRows.append(cols)
		else:
			returnTable.append(cols)
	
	return returnTable, headerRows

def defaultCaseFormatter(caseStatement):
	return caseStatement

def defaultReturnFormatter(returnStatement):
	return returnStatement

def generatePackageText():
	#Return with an array as the lists are usually extended instead of appended.
	return ["package as.minecraft.util;",newLine,newLine]

def generateBlockImportStatement():
	importList = []
	
	importList.append("import org.spongepowered.api.block.BlockType;")
	importList.append(newLine)
	importList.append("import org.spongepowered.api.block.BlockTypes;")
	importList.extend([newLine,newLine])
	
	return importList

def generateItemImportStatement():
	importList = []
	
	importList.append("import org.spongepowered.api.item.ItemType;")
	importList.append(newLine)
	importList.append("import org.spongepowered.api.item.ItemTypes;")
	importList.extend([newLine,newLine])
	
	return importList

def generateClassSkeletton(className):
	classStart = []
	classEnd = []
	classStart.extend(["public class ",className,newLine,"{",newLine])
	classEnd.extend(["}"])
	
	return classStart,classEnd

def generateMethod(type="private void",name="foo",arguments=[],tabs=0):
	methodStart = []
	methodEnd = []
	
	methodStart.extend([tab*tabs,type," ",name,"("])
	argumentList = []
	for argument in arguments:
		argumentList.append(argument[0]+" "+argument[1])
	methodStart.append(", ".join(argumentList))
	
	methodStart.extend([")",newLine,tab*tabs,"{",newLine])
	methodEnd.extend([tab*tabs,"}",newLine])
	
	return methodStart,methodEnd

#Cases is the case to test returns.
def generateReturningSwitch(cases, thens, variable, tabs=0, caseFormatter=defaultCaseFormatter, returnFormatter=defaultReturnFormatter, default=None):
	switchLines = []
	
	if(len(cases) != len(thens)):
		raise Exception("Cases and returns must have the same length as each item in thems list corresponds to case with same index.")
	
	switchLines.extend([tab*tabs, "switch(",variable,")",newLine,tab*tabs,"{",newLine])
	for i in range(len(cases)):
		case = cases[i]
		returnText = thens[i]
		switchLines.extend([tab*tabs,"case ",caseFormatter(case),":",newLine])
		switchLines.extend([tab*(tabs+1),"return ",returnFormatter(returnText),";",newLine])
	
	if(default != None):
		switchLines.extend([tab*tabs,"default: ",newLine])
		switchLines.extend([tab*(tabs+1),"return ",default,";",newLine])
	
	switchLines.extend([tab*tabs,"}",newLine])
	
	return switchLines

def getHexIdCol(table):
	cases = []
	for row in table:
		cases.append(row[hexValCol])
	
	return cases

def getBlockIdCol(table):
	returns = []
	for row in table:
		returns.append(row[blockIdCol])
	
	return returns

def getItemIdCol(table):
	returns = []
	for row in table:
		returns.append(row[itemIdCol])
	
	return returns

def getBlockNameCol(table):
	blockNames = []
	for row in table:
		blockNames.append(row[blockNameCol])
	
	return blockNames

#Function adds a '0x' before the input argument and returns it. Used as hex number def. in java.
def hexCaseFormatter(value):
	return "0x"+value

#Function will convert a string block id as used in the game and minecraft wiki, etc.
#It will convert it to a block/item form used by the sponge api.
def stringIdToSpongeBlockIdFormatter(value):
	if(value == ""):
		return "null"
	return "BlockTypes."+value.replace("minecraft:","").upper()

def stringIdToSpongeItemIdFormatter(value):
	if(value == ""):
		return "null"
	return "ItemTypes."+value.replace("minecraft:","").upper()

def stringIdToJavaStringFormatter(value):
	if(value == ""):
		return "null";
		
	return "\""+value+"\""

def blockNameFormatter(value):
	value = value.strip()
	#Remove single letters from the right side as they are only extra information
	#TODO this might only be the case for most items. I can't think of any exceptions now (and name is not critical as it is only "esthetical")
	findSpecialLetters = True
	while(findSpecialLetters):
		spacePos = value.rfind(" ")
		specialLetter = value[spacePos+1:]
		
		if(len(specialLetter.strip()) == 1):
			value = value[:spacePos]
		else:
			findSpecialLetters = False
	
	return "\""+value+"\""

##Requires a very specific table layout as input
def generateBlockIdJavaCode(table):
	javaCode = []
	javaCode.extend(generatePackageText())
	javaCode.extend(generateBlockImportStatement())
	classStart,classEnd = generateClassSkeletton("BlockTypeEnumerate")
	javaCode.extend(classStart)
	
	tabulation = 1
	methodStart,methodEnd=generateMethod(type="public static BlockType",name="getBlockTypeFromId",arguments=[("int","id")],tabs=tabulation)
	javaCode.extend(methodStart)
	
	tabulation=2
	javaCode.extend(generateReturningSwitch(getHexIdCol(table), getBlockIdCol(table), "id", tabs=tabulation, caseFormatter=hexCaseFormatter, returnFormatter=stringIdToSpongeBlockIdFormatter, default="null"))
	javaCode.extend(methodEnd)
	
	tabulation=1
	methodStart,methodEnd = generateMethod(type="public static String",name="getBlockTextIdFromId",arguments=[("int","id")],tabs=tabulation)
	javaCode.extend(methodStart)
	
	tabulation=2
	javaCode.extend(generateReturningSwitch(getHexIdCol(table), getBlockIdCol(table), "id", tabs=tabulation, caseFormatter=hexCaseFormatter, returnFormatter=stringIdToJavaStringFormatter, default="null"))
	javaCode.extend(methodEnd)
	
	tabulation=1
	methodStart,methodEnd = generateMethod(type="public static String",name="getBlockNameFromId",arguments=[("int","id")],tabs=tabulation)
	javaCode.extend(methodStart)
	
	tabulation=2
	javaCode.extend(generateReturningSwitch(getHexIdCol(table), getBlockNameCol(table), "id", tabs=tabulation,caseFormatter=hexCaseFormatter, returnFormatter=blockNameFormatter, default="null"))
	javaCode.extend(methodEnd)
	
	tabulation=1
	methodStart,methodEnd = generateMethod(type="public static BlockType",name="getBlockTypeFromBlockId",arguments=[("String","blockId")],tabs=tabulation)
	javaCode.extend(methodStart)
	
	tabulation=2
	javaCode.extend(generateReturningSwitch(getBlockIdCol(table), getBlockIdCol(table), "blockId", tabs=tabulation, caseFormatter=stringIdToJavaStringFormatter, returnFormatter=stringIdToSpongeBlockIdFormatter, default="null"))
	javaCode.extend(methodEnd)
	
	javaCode.extend(classEnd)
	
	return ''.join(javaCode)

def generateItemIdJavaCode(table):
	javaCode = []
	
	javaCode.extend(generatePackageText())
	javaCode.extend(generateItemImportStatement())
	
	classStart,classEnd = generateClassSkeletton("ItemTypeEnumerate")
	javaCode.extend(classStart)
	
	tabulation=1
	methodStart,methodEnd=generateMethod(type="public static ItemType",name="getItemTypeFromItemId",arguments=[("String","itemId")],tabs=tabulation)
	javaCode.extend(methodStart)
	
	tabulation=2
	javaCode.extend(generateReturningSwitch(getItemIdCol(table), getItemIdCol(table), "itemId", tabs=tabulation, caseFormatter=stringIdToJavaStringFormatter, returnFormatter=stringIdToSpongeItemIdFormatter, default="null"))
	javaCode.extend(methodEnd)
	
	javaCode.extend(classEnd)
	
	return ''.join(javaCode)

def main():
	blockTable,blockHeader = readCSVToTable("blocks.csv", headerCount=1)
	itemTable,itemHeader = readCSVToTable("items.csv", headerCount=1)
	
	outfile = open("BlockTypeEnumerate.java","w")
	outfile.write(generateBlockIdJavaCode(blockTable))
	outfile.close()
	
	outfile = open("ItemTypeEnumerate.java","w")
	outfile.write(generateItemIdJavaCode(itemTable))

main()