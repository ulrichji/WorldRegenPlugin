
import xml.etree.ElementTree

newline = "\n"
tab = "\t"

def getProperties(propTag):
	bits = 0
	data = ""
	key = ""
	dataType = ""
	values = []
	
	if('bits' in propTag.attrib):
		bits = propTag.attrib['bits']
	else:
		raise Exception("The Prop tag must provide a \"bits\" attribute. Eg: bits=\"0xF\"")

	if('data' in propTag.attrib):
		data = propTag.attrib['data']
	else:
		raise Exception("The Prop tag must provide a \"data\" attribute. Eg: data=\"StoneData\"")

	if('key' in propTag.attrib):
		key = propTag.attrib['key']
	else:
		raise Exception("The Prop tag must provide a \"key\" attribute. Eg: key=\"STONE_TYPE\"")

	if('dataType' in propTag.attrib):
		dataType = propTag.attrib['dataType']
	else:
		raise Exception("The prop tag must provde a \"dataType\" attribute. Eg: dataType=\"StoneType\"")

	for child in propTag:
		if(child.tag == "Val"):
			if('val' in child.attrib):
				val = child.attrib['val']
				blockType = child.text
				values.append((val,blockType))
			else:
				raise Exception("The Val tag must provide a val attribute.")
		else:
			raise Exception("The tag "+child.tag+" is not valid here.")
	
	return {'bits':bits, 'data':data, 'key':key, 'dataType':dataType, 'values':values}

def getPropertiesFromBlock(block):
	propertiesList = []
	for child in block:
		if(child.tag == "Prop"):
			properties = getProperties(child)
			propertiesList.append(properties)
		else:
			raise Exception("The tag "+child.tag+" is not valid here.")
	
	return propertiesList

def generateSetPropertiesCode(properties):
	print(properties)
	returnCode = []
	for property in properties:
		propertyClassName = property['data']
		dataVarName = propertyClassName[0].lower() + propertyClassName[1:]
		propertyNameImmutable = dataVarName + "Opt"
		keyName = property['key']
		dataTypeClassName = property['dataType']
		bits = property['bits']
		
		returnCode.extend(["Optional<Immutable",propertyClassName,"> ",propertyNameImmutable," = "])
		returnCode.extend(["state.get(Immutable"+propertyClassName,".class);",newline,tab*3])
		returnCode.extend(["if (",propertyNameImmutable,".isPresent())",newline,tab*3,"{",newline,tab*4])
		returnCode.extend([dataTypeClassName," newType = null;",newline,tab*4])
		
		first = True
		for value in property['values']:
			ifText = "else if"
			if(first):
				ifText = "if"
			returnCode.extend([ifText,"((blockData & ",bits,") == ",value[0],")",newline,tab*5])
			first = False
			returnCode.extend(["newType = ",value[1],";",newline,tab*4])
		
		returnCode.extend([propertyClassName," ",dataVarName," = ",propertyNameImmutable,".get().asMutable();",newline,tab*4])
		returnCode.extend([dataVarName,".set(Keys.",keyName,", newType);",newline,tab*4])
		returnCode.extend(["state = state.with(",dataVarName,".asImmutable()).get();",newline,tab*4])
		returnCode.extend(["loc.setBlock(state, cause);",newline,tab*3])
		returnCode.extend(["}",newline,newline,tab*2])
	
	return ''.join(returnCode)

def parseBlock(block):
	returnBlock = []
	if('type' in block.attrib):
		properties = getPropertiesFromBlock(block)
		blockType = block.attrib['type']
		returnBlock.extend(["if (blockType == BlockTypes.",blockType,")",newline,tab*2,"{",newline,tab*3])
		
		returnBlock.append(generateSetPropertiesCode(properties))
		returnBlock.extend(["}",newline,tab*2]);
		
	else:
		raise Exception("A block must support a \"type\" attribute. Eg: type=\"STONE\"")
		
	return ''.join(returnBlock)

def main():
	root = xml.etree.ElementTree.parse('dataProps.xml').getroot()
	
	classCode = []
	classCode.extend(["package as.minecraft.util;",newline,newline])
	classCode.extend(["public class BlockDataUtils",newline,"{",newline,tab])
	classCode.extend(["public static void setBlockData(Location<World> loc, Cause cause, BlockState state, BlockType blockType, int blockData)",newline,tab])
	classCode.extend(["{",newline,tab*2])
	
	for child in root:
		if(child.tag == "Block"):
			classCode.append(parseBlock(child))
		else:
			raise Exception("The tag "+child.tag + " is not valid here.")
	
	classCode.extend([newline,tab,"}",newline,"}"])
	
	print(''.join(classCode))
	
	javaFile = open("BlockDataUtils.java", "w")
	javaFile.write(''.join(classCode))
	javaFile.close()
	
main()
