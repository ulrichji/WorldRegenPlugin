# WorldRegenPlugin

## What it is

This is a [Sponge](https://www.spongepowered.org/) plugin that can reset chunks in a world from a backup file.

### Features

- Regenerate chunks from a backup world file. (This currently works for blocks. Entity data is not regenerated.)
- Conditional replacement of blocks. You can write expressions to determine which blocks to generate and which you dont want to regenerate. Eg: '"block_y < 30"'
	will only regenerate blocks below level 30. Look at the wiki for more details on usage. 
- **Planned:** Smart ore reset. This will move ores to new positions when chunks are regenerated.
	This is nice to have such that players don't know exactly where to find those regenerated diamonds.
- **Planned:** Dynamic chunk backup. When a new chunk is generated, it is written to the backup file so you don't have to regenerate the entire world to make the plugin work.
- **Planned:** Integration with the [GriefPrevention plugin](https://forums.spongepowered.org/t/griefprevention-official-thread-1-10-1-11-1-12-town-wecui-support/).
	It should be possible to use conditions for claimed areas.

## Basic usage

Copy your backup world to a folder called 'worldcopy' one level above the server root directory. This is one level above where you put your sponge minecraft server .jar file.
You will have to create the 'worldcopy folder' and copy the contents from inside the 'world' directory. This is currently a hard-coded value and will be changed in the future.
In the future, it will be possible to specify the backup file location in a config file.

Use the commands '/regen' or '/regenerate' to regenerate the chunk you are standing in. Use the "-e" flag to specify a conditional expression for regeneration.
For example '/regen -e "block_y < 30 && block_id = minecraft:dirt"' will regnerate all dirt below level 30, and no other blocks. Look at the wiki (here on gitub)
for more details on how to write expressions.

## Project structure

- The project is developed in eclipse using gradle. The WorldRegenPlugin folder contains the java code for the plugin, including gradle files.
- README.md is the readme of the project.
- readIds.py is a python helper program. It is very temporary and hacky. It is designed to automatically read the web page
	[Data values](https://minecraft.gamepedia.com/Data_values) from the [minecraft wiki](https://minecraft.gamepedia.com/Minecraft_Wiki)
	and generate a java file that converts between block ids and sponge block ids.
- dataPropGenerator.py and dataProps.xml are also code generators. The dataProps.xml file specifies the values to assert to blocks based on the block
	data obtained from the [chunk](https://minecraft.gamepedia.com/Chunk_format). The dataPropGenerator.py file uses the data from the xml file to 
	generate java code that sets block properties read from the block data in the chunk.
