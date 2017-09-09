package as.minecraft.world;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.nbt.ByteArrayTag;
import com.flowpowered.nbt.ByteTag;
import com.flowpowered.nbt.CompoundTag;
import com.flowpowered.nbt.DoubleTag;
import com.flowpowered.nbt.FloatTag;
import com.flowpowered.nbt.IntArrayTag;
import com.flowpowered.nbt.IntTag;
import com.flowpowered.nbt.ListTag;
import com.flowpowered.nbt.LongTag;
import com.flowpowered.nbt.ShortTag;
import com.flowpowered.nbt.StringTag;
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
	private ArrayList<RegenEntity> entities = new ArrayList<RegenEntity>();
	private ArrayList<RegenBlockEntity> blockEntities = new ArrayList<RegenBlockEntity>();
	
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
		applyBlockEntities();
	}

	private void applyBlockEntities()
	{
		for(RegenBlockEntity entity : blockEntities)
		{
			if(entity.hasPosition())
			{
				int entityChunkX = entity.getX() < 0 ? (entity.getX() - 15) / 16 : entity.getX() / 16;
				int entityChunkZ = entity.getZ() < 0 ? (entity.getZ() - 15) / 16 : entity.getZ() / 16;
				
				if(entityChunkX == chunkX && entityChunkZ == chunkZ)
				{
					int blockX = entity.getX() % 16;
					int blockZ = entity.getZ() % 16;
					int blockY = entity.getY();
					
					if(blockX < 0) blockX += 16;
					if(blockY < 0) blockZ += 16;
					
					chunkBlocks[blockX][blockY][blockZ].setBlockEntity(entity);
				}
				else
					throw new IllegalArgumentException("Block has invalid position");
			}
		}
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

	private void parseTileEntities(ListTag<?> tileEntitiesTag)
	{
		debug("TEL: "+tileEntitiesTag.getName());
		
		for(Tag<?> tag : tileEntitiesTag.getValue())
		{
			if(tag.getType() == TagType.TAG_COMPOUND)
				parseTileEntity((CompoundTag)tag);
			else
				throw new IllegalArgumentException("Tag of type "+tag.getType().toString()+" is not allowed in tile entity list");
		}
	}

	private void parseTileEntity(CompoundTag tileEntity)
	{
		debug("TE: "+tileEntity.getName());
		
		RegenBlockEntity entity = new RegenBlockEntity();
		
		for(Tag<?> tag : tileEntity.getValue())
		{
			if(tag.getType() == TagType.TAG_STRING && tag.getName().equals("id"))
				entity.setId(((StringTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("x"))
				entity.setX(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("y"))
				entity.setY(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("z"))
				entity.setZ(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_STRING && tag.getName().equals("CustomName"))
				entity.setCustomName(((StringTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("Base"))
				entity.setBaseColor(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Patterns"))
				entity.setPatterns(getBannerPatterns((ListTag<?>)tag));
			else if(tag.getType() == TagType.TAG_STRING && tag.getName().equals("Lock"))
				entity.setLock(((StringTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("Levels"))
				entity.setLevels(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("Primary"))
				entity.setPrimaryEffect(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("Secondary"))
				entity.setSecondaryEffect(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("color"))
				entity.setDyeColor(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("CusomColor"))
				entity.setCustomColor(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Items"))
				entity.setItems(parseItemsList((ListTag<?>)tag));
			else if(tag.getType() == TagType.TAG_SHORT && tag.getName().equals("PotionId"))
				entity.setPotionId(((ShortTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("SplashPotion"))
				entity.setStoresSplashPotion(((ByteTag)tag).getBooleanValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("isMovable"))
				entity.setMovable(((ByteTag)tag).getBooleanValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("BrewTime"))
				entity.setBrewTime(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("Fuel"))
				entity.setFuel(((ByteTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_STRING && tag.getName().equals("LootTable"))
				entity.setLootTable(((StringTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_LONG && tag.getName().equals("LootTableSeed"))
				entity.setLootTableSeed(((LongTag)tag).getValue());
			else
				debug("Extra tag: "+tag.getType().toString() + " , "+tag.getName());
		}
		
		System.out.println(entity.toString());
		blockEntities.add(entity);
	}

	private ArrayList<RegenItem> parseItemsList(ListTag<?> itemList)
	{
		ArrayList<RegenItem> items = new ArrayList<RegenItem>();
		
		for(Tag<?> tag : itemList.getValue())
		{
			if(tag.getType() == TagType.TAG_COMPOUND)
				items.add(parseItem((CompoundTag)tag));
			else
				throw new IllegalArgumentException("A tag of type "+tag.getType() + " is not valid in an item list. Only COMPOUND tags supported.");
		}
		
		return items;
	}

	private RegenItem parseItem(CompoundTag itemTag)
	{
		RegenItem item = new RegenItem();
		
		for(Tag<?> tag : itemTag.getValue())
		{
			if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("Count"))
				item.setCount(((ByteTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("Slot"))
				item.setSlot(((ByteTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_SHORT && tag.getName().equals("Damage"))
				item.setDamage(((ShortTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_STRING && tag.getName().equals("id"))
				item.setId(((StringTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_COMPOUND && tag.getName().equals("tag"))
				parseItemTag((CompoundTag)tag, item);
		}
		
		return item;
	}

	private void parseItemTag(CompoundTag itemTag, RegenItem item)
	{
		for(Tag<?> tag : itemTag.getValue())
		{
			debug("Tag: "+tag.getType() + ", "+tag.getName());
		}
	}

	private ArrayList<RegenBannerPattern> getBannerPatterns(ListTag<?> patternListTag)
	{
		ArrayList<RegenBannerPattern> patternList = new ArrayList<RegenBannerPattern>();
		
		for(Tag<?> tag : patternListTag.getValue())
		{
			if(tag.getType() == TagType.TAG_COMPOUND)
				patternList.add(getRegenBannerPattern((CompoundTag)tag));
			else
				throw new IllegalArgumentException("The tag "+tag.getType()+" is not valid in a patterns list tag");
		}
		
		return patternList;
	}

	private RegenBannerPattern getRegenBannerPattern(CompoundTag patternTag)
	{
		String pattern = "";
		int color = 0;
		
		for(Tag<?> tag : patternTag.getValue())
		{
			if(tag.getType() == TagType.TAG_INT && tag.getName().equals("Color"))
				color = ((IntTag)tag).getValue();
			else if(tag.getType() == TagType.TAG_STRING && tag.getName().equals("Pattern"))
				pattern = ((StringTag)tag).getValue();
			else
				throw new IllegalArgumentException("The tag "+tag.getName()+" of type "+tag.getType()+" is invalid in a banner pattern tag");
		}
		
		return new RegenBannerPattern(pattern, color);
	}
	
	private ArrayList<String> parseTags(ListTag<?> tags)
	{
		ArrayList<String> returnTags = new ArrayList<String>();
		
		for(Tag<?> tag : tags.getValue())
		{
			if(tag.getType() == TagType.TAG_STRING)
				returnTags.add(((StringTag)tag).getValue());
			else
				throw new IllegalArgumentException("Tag list contained "+tag.getType().toString()+" tags. Only string tags are allowed");
		}
		
		return returnTags;
	}

	private Object parsePassengers(Tag<?> tag)
	{
		//TODO implement
		return null;
	}

	private Vector2f parseEntityFloatRotation(ListTag<?> rotationList)
	{
		double yaw=0, pitch=0;
		int index = 0;
		
		for(Tag<?> tag : rotationList.getValue())
		{
			if(tag.getType() == TagType.TAG_FLOAT)
			{
				if(index == 0)
					yaw = ((FloatTag)tag).getValue();
				else if(index == 1)
					pitch = ((FloatTag)tag).getValue();
				
				index ++;
			}
			else
				throw new IllegalArgumentException("Tag of type "+tag.getType().toString()+" is not a valid rotation tag type");
		}
		
		return new Vector2f(yaw,pitch);
	}

	private Vector3d parseEntityDoubleCoord(ListTag<?> posList)
	{
		double x=0,y=0,z=0;
		int index = 0;
		
		for(Tag<?> tag : posList.getValue())
		{
			if(tag.getType() == TagType.TAG_DOUBLE)
			{
				if(index == 0)
					x = ((DoubleTag)tag).getValue();
				else if(index == 1)
					y = ((DoubleTag)tag).getValue();
				else if(index == 2)
					z = ((DoubleTag)tag).getValue();
				
				index ++;
			}
			else
				throw new IllegalArgumentException("Tag of type "+tag.getType().toString()+" is not a valid coordinate tag type");
		}
		
		return new Vector3d(x,y,z);
	}

	private void parseEntities(ListTag<?> entityTag)
	{
		debug("E : "+entityTag.getName());
		RegenEntity entity = new RegenEntity();
		for(Tag<?> tag : entityTag.getValue())
		{
			if(tag.getType() == TagType.TAG_STRING && tag.getName().equals("id"))
				entity.setId(((StringTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Pos"))
				entity.setPos(parseEntityDoubleCoord((ListTag<?>)tag));
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Motion"))
				entity.setMotion(parseEntityDoubleCoord((ListTag<?>)tag));
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Rotation"))
				entity.setRotation(parseEntityFloatRotation((ListTag<?>)tag));
			else if(tag.getType() == TagType.TAG_FLOAT && tag.getName().equals("FallDistance"))
				entity.setFallDistance(((FloatTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_SHORT && tag.getName().equals("Fire"))
				entity.setFire(((ShortTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_SHORT &&  tag.getName().equals("Air"))
				entity.setAir(((ShortTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("OnGround"))
				entity.setOnGround(((ByteTag)tag).getBooleanValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("NoGravity"))
				entity.setNoGravity(((ByteTag)tag).getBooleanValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("Dimension"))
				entity.setDimension(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("Invulnerable"))
				entity.setInvulnerable(((ByteTag)tag).getBooleanValue());
			else if(tag.getType() == TagType.TAG_INT && tag.getName().equals("PortalCooldown"))
				entity.setPortalCooldown(((IntTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_LONG && tag.getName().equals("UUIDMost"))
				entity.setUUIDMost(((LongTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_LONG && tag.getName().equals("UUIDLeast"))
				entity.setUUIDLeast(((LongTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_STRING	&& tag.getName().equals("CustomName"))
				entity.setCustomName(((StringTag)tag).getValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("CustomNameVisible"))
				entity.setCustomNameVisible(((ByteTag)tag).getBooleanValue());
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("Silent"))
				entity.setSilent(((ByteTag)tag).getBooleanValue());
			else if(tag.getType() == TagType.TAG_COMPOUND && tag.getName().equals("Riding"))
			{/*Skip this as it is deprecated in 1.9*/}
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Passengers"))
				entity.setPassengers(parsePassengers(tag));
			else if(tag.getType() == TagType.TAG_BYTE && tag.getName().equals("Glowing"))
				entity.setGlowing(((ByteTag)tag).getBooleanValue());
			else if(tag.getType() == TagType.TAG_LIST && tag.getName().equals("Tags"))
				entity.setTags(parseTags((ListTag<?>)tag));
			else if(tag.getType() == TagType.TAG_COMPOUND && tag.getName().equals("CommandStats"))
			{/*TODO: Handle command stats.*/}
			else
				debug("ExtraTag: "+tag.getName());
		}
		
		//TODO: implement
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
		if(logger != null)
			logger.info(message);
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
