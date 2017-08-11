#! python2

import codecs
import urllib

from HTMLParser import HTMLParser

def isNumber(num):
	num = num.replace("A","1")
	num = num.replace("B","1")
	num = num.replace("C","1")
	num = num.replace("D","1")
	num = num.replace("E","1")
	num = num.replace("F","1")
	
	return num.isdigit()

class MyHTMLParser(HTMLParser):
	
	def setup(self):
		self.inTable = False
		self.firstRow = False
		self.colNum = -1
		self.inCol = False
		self.link = False
		self.colDone = False
		self.row = []
		self.allRows = []

	def handle_starttag(self, tag, attrs):
		if(tag == "table" and ('data-description', 'Block IDs') in attrs):
			self.inTable = True
			self.firstRow = True
			self.colNum = 0
		elif(self.inTable and self.firstRow == False and tag == "td"):
			self.inCol = True
		elif(self.inCol and tag == "a"):
			self.link = True

	def handle_endtag(self, tag):
		if(self.inTable and tag == "table"):
			self.inTable = False
		elif(tag == "tr"):
			self.firstRow = False
			self.colNum = 0
			self.rowDone = False
			
			#Verify that the row is ok before continuing.
			if(len(self.row) >= 3 and isNumber(self.row[0]) and isNumber(self.row[1])):
				self.allRows.append(self.row)
			
			self.row = []
		elif(tag == "td"):
			self.inCol = False
			self.colNum += 1
		elif(tag == "a"):
			self.link = False

	def handle_data(self, data):
		if(self.link and self.rowDone == False):
			self.row.append(data)
			if(self.colNum == 4):
				self.rowDone = True
		elif(self.inCol and self.rowDone == False):
			self.row.append(data)
			self.rowDone == True

def to_camel_case(snake_str):
    components = snake_str.split('_')
    # We capitalize the first letter of each component except the first one
    # with the 'title' method and join them together.
    return components[0] + "".join(x.title() for x in components[1:])

def createJavaCode(elementList):
	package = "as.minecraft.util"
	className = "BlockTypeEnumerate"
	newline = "\n"
	tab = "\t"
	
	textList = ["package ",package,";",newline,newline,
	"import org.spongepowered.api.block.BlockType;",newline,"import org.spongepowered.api.block.BlockTypes;",newline,newline,
	"public class ",className,newline,"{",newline]
	
	textList.extend([tab,"public static BlockType getBlockTypeFromId(int id)", newline,tab,"{",newline])
	textList.extend([tab,tab,"switch(id)",newline,tab,tab,"{",newline])
	for elm in elementList:
		id = "0x"+elm[1]
		value = elm[2].replace("minecraft:","").upper()
		if(value != "(UNUSED)"):
			textList.extend([tab,tab,"case ",id,":",newline,tab,tab,tab,"return BlockTypes.",value,";",newline])
	textList.extend([tab,tab,"default: ",newline,tab,tab,tab,"return BlockTypes.AIR;",newline])
	textList.extend([tab,tab,"}",newline,tab,"}",newline])
	
	textList.extend([tab,"public static String getBlockTextIdFromId(int id)", newline,tab,"{",newline])
	textList.extend([tab,tab,"switch(id)",newline,tab,tab,"{",newline])
	for elm in elementList:
		id = "0x"+elm[1]
		value = elm[2]
		textList.extend([tab,tab,"case ",id,":",newline,tab,tab,tab,"return \"",value,"\";",newline])
	textList.extend([tab,tab,"default: ",newline,tab,tab,tab,"return \"unknown block\";",newline])
	textList.extend([tab,tab,"}",newline,tab,"}",newline])
	
	textList.extend([tab,"public static String getBlockNameFromId(int id)", newline,tab,"{",newline])
	textList.extend([tab,tab,"switch(id)",newline,tab,tab,"{",newline])
	for elm in elementList:
		id = "0x"+elm[1]
		vale = elm[2]
		#To take undefined into consideration as well
		if(len(elm) > 3):
			value = elm[3]
		textList.extend([tab,tab,"case ",id,":",newline,tab,tab,tab,"return \"",value,"\";",newline])
	textList.extend([tab,tab,"default: ",newline,tab,tab,tab,"return \"UNKNOWN BLOCK\";",newline])
	textList.extend([tab,tab,"}",newline,tab,"}",newline])
	
	
	textList.extend(["}"])
	
	return ''.join(textList)
	

def main():
	page = urllib.urlopen("https://minecraft.gamepedia.com/Data_values").read()
	print(page)
	parser = MyHTMLParser()
	parser.setup()
	parser.feed(page)
	
	outfile = open("BlockTypeEnumerate.java","w")
	print(createJavaCode(parser.allRows))
	outfile.write(createJavaCode(parser.allRows))
	outfile.close()

main()