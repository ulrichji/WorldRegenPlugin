package as.minecraft.world;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import com.flowpowered.nbt.ByteArrayTag;
import com.flowpowered.nbt.ByteTag;
import com.flowpowered.nbt.CompoundTag;
import com.flowpowered.nbt.IntArrayTag;
import com.flowpowered.nbt.IntTag;
import com.flowpowered.nbt.ListTag;
import com.flowpowered.nbt.LongTag;
import com.flowpowered.nbt.Tag;
import com.flowpowered.nbt.TagType;

import as.minecraft.evaluator.BlockEvaluator;

public class RegenChunk
{
	private int dataVersion = 0;
	private int chunkX = 0;
	private int chunkZ = 0;
	private long lastUpdate = 0;
	private boolean lightPopulated = false;
	private boolean terrainPopulated = false;
	private byte vValue = 0;
	private long inhabitedTime = 0;
	private byte[] biomeData = null;
	private int[] heightMap = null;
	//Regen chunk as x, y, z [16][256][16]
	private RegenBlock[][][] chunkBlocks = null;
	
	private Logger logger = null;
	private BlockEvaluator evaluator = null;
	
	public RegenChunk(Tag<?> root)
	{
		parseTree(root);
	}
	
	public RegenChunk(Tag<?> root, Logger logger)
	{
		this.logger = logger;
		parseTree(root);
	}

	public void reloadChunk(Chunk c, PluginContainer rootCause)
	{
		logger.info("Reloading chunk at " + chunkX + ", 0, "+chunkZ);
		World world = c.getWorld();
		Cause cause = Cause.source(rootCause).build();
		//Reset all chunks
		for(int x=0;x<chunkBlocks.length;x++)
		{
			for(int y=0;y<chunkBlocks[x].length;y++)
			{
				for(int z=0;z<chunkBlocks[x][y].length;z++)
				{
					RegenBlock block = chunkBlocks[x][y][z];
					int xLoc = (chunkX * 16) + x;
					int yLoc = y;
					int zLoc = (chunkZ * 16) + z;
					Location<World> loc = world.getLocation(xLoc, yLoc, zLoc);
					
					//Run the expression to check if this block is to be regenerated.
					if(regenBlock(xLoc, yLoc, zLoc, chunkX, 0, chunkZ, loc, block))
						block.resetBlock(loc, cause, logger);
				}
			}
		}
	}
	
	private boolean regenBlock(int xLoc, int yLoc, int zLoc, int chunkXPos, int chunkYPos, int chunkZPos,
			Location<World> loc, RegenBlock block)
	{
		//Regenerate if the evaluator is not set.
		if(evaluator == null)
			return true;
		else
			return evaluator.evaluateBlock(xLoc, yLoc, zLoc, chunkXPos, chunkYPos, chunkZPos, loc, block);
	}

	private void parseTree(Tag<?> root)
	{
		if(root.getType() == TagType.TAG_COMPOUND)
			parseRoot((CompoundTag)root);
		else
			throw new IllegalArgumentException("Root tag must be of tag_compound type");
	}
	
	private void parseRoot(CompoundTag root)
	{
		debug("R: "+root.getName());
		for(Tag<?> tag : root.getValue())
		{
			if(tag.getType() == TagType.TAG_INT && tag.getName().equals("DataVersion"))
				parseDataVersion((IntTag)tag);
			else if(tag.getType() == TagType.TAG_COMPOUND && tag.getName().equals("Level"))
				parseLevel((CompoundTag)tag);
			else
				throw new IllegalArgumentException("The tag " + tag.getName() + " is not a valid sub-root tag");
		}
	}
	
	private void parseLevel(CompoundTag levelTag)
	{
		debug("L: "+levelTag.getName());
		
		for(Tag<?> tag : levelTag.getValue())
		{
			if(tag.getType() == TagType.TAG_INT && tag.getName().equals("xPos"))
				parseXPos((IntTag)tag);
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("zPos"))
				parseZPos((IntTag)tag);
			else if(tag.getType() == TagType.TAG_LONG && tag.getName().equals("LastUpdate"))
				parseLastUpdate((LongTag)tag);
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("LightPopulated"))
				parseLightPopulated((ByteTag)tag);
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("TerrainPopulated"))
				parseTerrainPopulated((ByteTag)tag);
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("V"))
				parseV((ByteTag)tag);
			else if(tag.getType() == TagType.TAG_LONG && tag.getName().equals("InhabitedTime"))
				parseInhabitedTime((LongTag)tag);
			else if(tag.getType() == TagType.TAG_BYTE_ARRAY && tag.getName().equals("Biomes"))
				parseBiomes((ByteArrayTag)tag);
			else if(tag.getType() == TagType.TAG_INT_ARRAY && tag.getName().equals("HeightMap"))
				parseHeightMap((IntArrayTag)tag);
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Sections"))
				parseSections((ListTag<?>)tag);
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Entities"))
				parseEntities((ListTag<?>)tag);
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("TileEntities"))
				parseTileEntities((ListTag<?>)tag);
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("TileTicks"))
				parseTileTicks((ListTag<?>)tag);
			else if(tag.getName().equals("SpongeData"))
				parseSpongeData((CompoundTag)tag);
			else
				throw new IllegalArgumentException("The tag "+tag.getName()+" is not a valid tag inside level tag");
		}
	}

	private void parseSpongeData(CompoundTag tag)
	{
		debug("SD: "+tag.getName());
		//Currently, we don't need the spongeData.
	}

	private void parseTileTicks(ListTag<?> tag)
	{
		debug("TT: "+tag.getName());
		// TODO Currently unimplemented
	}

	private void parseTileEntities(ListTag<?> tag)
	{
		debug("TE: "+tag.getName());
		// TODO Currently unimplemented
	}

	private void parseEntities(ListTag<?> tag)
	{
		debug("E : "+tag.getName());
	}

	private void parseSections(ListTag<?> tag)
	{
		debug("S : "+tag.getName());
		
		//Setup the chunk block data
		chunkBlocks = new RegenBlock[16][256][16];
		ArrayList<Integer> ySectorsSet = new ArrayList<Integer>();
		
		for(Tag<?> sectionTag : tag.getValue())
		{
			if(sectionTag.getType() == TagType.TAG_COMPOUND)
			{
				int y = parseSection((CompoundTag)sectionTag);
				ySectorsSet.add(y);
			}
			else
				throw new IllegalArgumentException("The tag "+tag.getName()+" is not a valid sections tag. Only compound tags supported");
		}
		
		buildRemainingRegenBlocks(ySectorsSet);
	}

	private void buildRemainingRegenBlocks(ArrayList<Integer> ySectorsSet)
	{
		ArrayList<Integer> ySectionsToGenerate = new ArrayList<Integer>();
		for(int i=0;i<16;i++)
		{
			if(!ySectorsSet.contains(i))
				ySectionsToGenerate.add(i);
		}
		
		for(int ySection : ySectionsToGenerate)
		{
			for(int x=0;x<16;x++)
			{
				for(int y = ySection * 16; y<(ySection + 1)*16; y++)
				{
					for(int z = 0; z<16; z++)
						chunkBlocks[x][y][z] = new RegenBlock();
				}
			}
		}
	}

	private int parseSection(CompoundTag sectionTag)
	{
		byte yIndex = 0;
		byte[] blocks = null;
		byte[] add = null;
		byte[] data = null;
		byte[] blockLights = null;
		byte[] skyLights = null;
		
		for(Tag<?> tag : sectionTag.getValue())
		{
			if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("Y"))
				yIndex = ((ByteTag)tag).getValue();
			else if(tag.getType() == TagType.TAG_BYTE_ARRAY && tag.getName().equals("Blocks"))
				blocks = ((ByteArrayTag)tag).getValue();
			else if(tag.getType() == TagType.TAG_BYTE_ARRAY && tag.getName().equals("Add"))
				add = ((ByteArrayTag)tag).getValue();
			else if(tag.getType() == TagType.TAG_BYTE_ARRAY && tag.getName().equals("Data"))
				data = ((ByteArrayTag)tag).getValue();
			else if(tag.getType() == TagType.TAG_BYTE_ARRAY && tag.getName().equals("BlockLight"))
				blockLights = ((ByteArrayTag)tag).getValue();
			else if(tag.getType() == TagType.TAG_BYTE_ARRAY && tag.getName().equals("SkyLight"))
				skyLights = ((ByteArrayTag)tag).getValue();
			else
				throw new IllegalArgumentException("The tag "+tag.getName()+" is not a valid tag in a section");
		}
		
		debug("SY: "+yIndex);
		
		if(blocks == null)
			throw new IllegalArgumentException("The block tag must be proveded in a section");
		
		for(int i=0;i<blocks.length;i++)
		{
			int blockId = ((int)blocks[i]) & 0xFF;
			if(add != null)
				blockId += nibble4(add, i);
			int blockData = nibble4(data, i);
			int blockLight = nibble4(blockLights, i);
			int skyLight = nibble4(skyLights, i);
			int xPos = i % 16;
			int zPos = (i / 16) % 16;
			int yPos = (yIndex * 16) + ((i / 16) / 16);
			
			chunkBlocks[xPos][yPos][zPos] = new RegenBlock(blockId, blockData, blockLight, skyLight);
		}
		return yIndex;
	}

	private void parseHeightMap(IntArrayTag tag)
	{
		debug("HM: "+tag.getName());
		
		int[] temp = tag.getValue();
		heightMap = new int[temp.length];
		for(int i=0;i<temp.length;i++)
			heightMap[i] = temp[i];
	}

	private void parseBiomes(ByteArrayTag tag)
	{
		debug("B : "+tag.getName());
		
		byte[] temp = tag.getValue();
		biomeData = new byte[temp.length];
		for(int i=0;i<temp.length;i++)
			biomeData[i] = temp[i];
	}

	private void parseInhabitedTime(LongTag tag)
	{
		debug("IT: "+tag.getName());
		inhabitedTime = tag.getValue();
	}

	private void parseV(ByteTag tag)
	{
		debug("V : "+tag.getName());
		vValue = tag.getValue();
	}

	private void parseTerrainPopulated(ByteTag tag)
	{
		debug("TP: "+tag.getName());
		terrainPopulated = tag.getBooleanValue();
	}
	
	private void parseLightPopulated(ByteTag tag)
	{
		debug("LP: "+tag.getName());
		lightPopulated = tag.getBooleanValue();
	}

	private void parseLastUpdate(LongTag tag)
	{
		debug("LU: "+tag.getName());
		lastUpdate = tag.getValue();
	}

	private void parseZPos(IntTag tag)
	{
		debug("Z : "+tag.getName());
		chunkZ = tag.getValue();
	}

	private void parseXPos(IntTag tag)
	{
		debug("X : "+tag.getName());
		chunkX = tag.getValue();
	}

	private void parseDataVersion(IntTag dataVersionTag)
	{
		debug("DV: " + dataVersionTag.getName());
		dataVersion = dataVersionTag.getValue();
	}

	int nibble4(byte[] arr, int index)
	{
		return (index%2 == 0 ? arr[index/2]&0x0F : (arr[index/2]>>4)&0x0F);
	}
	
	private void debug(String message)
	{
		//if(logger != null)
		//	logger.info(message);
	}
	
	public void setBlockEvaluator(BlockEvaluator evaluator)
	{
		this.evaluator = evaluator;
	}
	
	public int getDataVersion() {
		return dataVersion;
	}

	public int getChunkX() {
		return chunkX;
	}

	public int getChunkZ() {
		return chunkZ;
	}

	public long getLastUpdate() {
		return lastUpdate;
	}

	public boolean isLightPopulated() {
		return lightPopulated;
	}

	public boolean isTerrainPopulated() {
		return terrainPopulated;
	}

	public byte getvValue() {
		return vValue;
	}

	public long getInhabitedTime() {
		return inhabitedTime;
	}

	public byte[] getBiomeData() {
		return biomeData;
	}

	public int[] getHeightMap() {
		return heightMap;
	}

	public RegenBlock[][][] getChunkBlocks() {
		return chunkBlocks;
	}
}
