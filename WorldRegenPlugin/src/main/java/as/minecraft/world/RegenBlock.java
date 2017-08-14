package as.minecraft.world;

import org.slf4j.Logger;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import as.minecraft.util.BlockDataUtils;
import as.minecraft.util.BlockTypeEnumerate;

public class RegenBlock
{
	private RegenBlockType blockType;
	private int blockId;
	private int blockData;
	private int blockLight;
	private int skyLight;
	
	public RegenBlock(RegenBlockType blockType, int blockId, int blockData, int blockLight, int skyLight)
	{
		this.blockType = blockType;
		this.blockId = blockId;
		this.blockData = blockData;
		this.blockLight = blockLight;
		this.skyLight = skyLight;
	}

	public RegenBlock(RegenBlockType block)
	{
		this.blockType = block;
		//Should be air
		this.blockId = 0;
		this.blockData = 0;
		this.blockLight = 0;
		this.skyLight = 0;
	}

	public void resetBlock(Location<World> loc, Cause cause, Logger logger)
	{	
		loc.setBlockType(getBlockType(), cause);
		BlockState state = loc.getBlock();
		
		BlockType type = getBlockType();
		
		BlockDataUtils.setBlockData(loc, cause, state, type, blockData);
	}
	
	public BlockType getBlockType()
	{
		return BlockTypeEnumerate.getBlockTypeFromId(blockId);
	}
	
	public RegenBlockType getRegenBlockType() {
		return blockType;
	}

	public int getBlockId() {
		return blockId;
	}

	public int getBlockData() {
		return blockData;
	}

	public int getBlockLight() {
		return blockLight;
	}

	public int getSkyLight() {
		return skyLight;
	}
	
}
