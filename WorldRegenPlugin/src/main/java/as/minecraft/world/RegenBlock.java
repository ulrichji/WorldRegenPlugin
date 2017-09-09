package as.minecraft.world;

import org.slf4j.Logger;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.tileentity.Banner;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.block.tileentity.carrier.TileEntityCarrier;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import as.minecraft.util.BlockDataUtils;
import as.minecraft.util.BlockTypeEnumerate;

public class RegenBlock
{
	private int blockId;
	private int blockData;
	private int blockLight;
	private int skyLight;
	private RegenBlockEntity blockEntity = null;
	
	public RegenBlock(int blockId, int blockData, int blockLight, int skyLight)
	{
		this.blockId = blockId;
		this.blockData = blockData;
		this.blockLight = blockLight;
		this.skyLight = skyLight;
	}

	public RegenBlock()
	{
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
		
		if(blockEntity != null)
		{
			if(loc.getTileEntity().isPresent())
			{
				if(loc.getTileEntity().isPresent())
				{
					TileEntity entity = loc.getTileEntity().get();
					blockEntity.setEntityData(entity);
				}
			}
		}
	}
	
	public BlockType getBlockType()
	{
		return BlockTypeEnumerate.getBlockTypeFromId(blockId);
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

	public boolean hasBlockEntity()
	{
		return blockEntity != null;
	}
	
	public RegenBlockEntity getBlockEntity()
	{
		return blockEntity;
	}
	
	public void setBlockEntity(RegenBlockEntity entity)
	{
		this.blockEntity = entity;
	}
	
}
