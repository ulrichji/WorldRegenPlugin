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

Use the commands '/regen' or '/regenerate' to regenerate the chunk you are standing in. Use the "-e" flag to specify a conditional expression for regeneration.
For example '/regen -e "block_y < 30 && block_id = minecraft:dirt"' will regnerate all dirt below level 30, and no other blocks. Look at the wiki (here on gitub)
for more details on how to write expressions.
