package as.minecraft.util;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.*;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class BlockDataUtils
{
	public static void setBlockData(Location<World> loc, Cause cause, BlockState state, BlockType blockType, int blockData)
	{
		if (blockType == BlockTypes.STONE)
		{
			{
				StoneType newType = null;
				if((blockData & 0xF) == 0)
					newType = StoneTypes.STONE;
				else if((blockData & 0xF) == 1)
					newType = StoneTypes.GRANITE;
				else if((blockData & 0xF) == 2)
					newType = StoneTypes.SMOOTH_GRANITE;
				else if((blockData & 0xF) == 3)
					newType = StoneTypes.DIORITE;
				else if((blockData & 0xF) == 4)
					newType = StoneTypes.SMOOTH_DIORITE;
				else if((blockData & 0xF) == 5)
					newType = StoneTypes.ANDESITE;
				else if((blockData & 0xF) == 6)
					newType = StoneTypes.SMOOTH_ANDESITE;
				state = state.with(Keys.STONE_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.PLANKS)
		{
			{
				TreeType newType = null;
				if((blockData & 0xF) == 0)
					newType = TreeTypes.OAK;
				else if((blockData & 0xF) == 1)
					newType = TreeTypes.SPRUCE;
				else if((blockData & 0xF) == 2)
					newType = TreeTypes.BIRCH;
				else if((blockData & 0xF) == 3)
					newType = TreeTypes.JUNGLE;
				else if((blockData & 0xF) == 4)
					newType = TreeTypes.ACACIA;
				else if((blockData & 0xF) == 5)
					newType = TreeTypes.DARK_OAK;
				state = state.with(Keys.TREE_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DIRT)
		{
			{
				DirtType newType = null;
				if((blockData & 0xF) == 0)
					newType = DirtTypes.DIRT;
				else if((blockData & 0xF) == 1)
					newType = DirtTypes.COARSE_DIRT;
				else if((blockData & 0xF) == 2)
					newType = DirtTypes.PODZOL;
				state = state.with(Keys.DIRT_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SAPLING)
		{
			{
				TreeType newType = null;
				if((blockData & 0x7) == 0)
					newType = TreeTypes.OAK;
				else if((blockData & 0x7) == 1)
					newType = TreeTypes.SPRUCE;
				else if((blockData & 0x7) == 2)
					newType = TreeTypes.BIRCH;
				else if((blockData & 0x7) == 3)
					newType = TreeTypes.JUNGLE;
				else if((blockData & 0x7) == 4)
					newType = TreeTypes.ACACIA;
				else if((blockData & 0x7) == 5)
					newType = TreeTypes.DARK_OAK;
				state = state.with(Keys.TREE_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WATER)
		{
			{
				Integer newType = null;
				if((blockData & 0x7) == 0)
					newType = 0;
				else if((blockData & 0x7) == 1)
					newType = 1;
				else if((blockData & 0x7) == 2)
					newType = 2;
				else if((blockData & 0x7) == 3)
					newType = 3;
				else if((blockData & 0x7) == 4)
					newType = 4;
				else if((blockData & 0x7) == 5)
					newType = 5;
				else if((blockData & 0x7) == 6)
					newType = 6;
				else if((blockData & 0x7) == 7)
					newType = 7;
				state = state.with(Keys.FLUID_LEVEL, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.FLOWING_WATER)
		{
			{
				Integer newType = null;
				if((blockData & 0x7) == 0)
					newType = 0;
				else if((blockData & 0x7) == 1)
					newType = 1;
				else if((blockData & 0x7) == 2)
					newType = 2;
				else if((blockData & 0x7) == 3)
					newType = 3;
				else if((blockData & 0x7) == 4)
					newType = 4;
				else if((blockData & 0x7) == 5)
					newType = 5;
				else if((blockData & 0x7) == 6)
					newType = 6;
				else if((blockData & 0x7) == 7)
					newType = 7;
				state = state.with(Keys.FLUID_LEVEL, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LAVA)
		{
			{
				Integer newType = null;
				if((blockData & 0x7) == 0)
					newType = 0;
				else if((blockData & 0x7) == 1)
					newType = 1;
				else if((blockData & 0x7) == 2)
					newType = 2;
				else if((blockData & 0x7) == 3)
					newType = 3;
				else if((blockData & 0x7) == 4)
					newType = 4;
				else if((blockData & 0x7) == 5)
					newType = 5;
				else if((blockData & 0x7) == 6)
					newType = 6;
				else if((blockData & 0x7) == 7)
					newType = 7;
				state = state.with(Keys.FLUID_LEVEL, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.FLOWING_LAVA)
		{
			{
				Integer newType = null;
				if((blockData & 0x7) == 0)
					newType = 0;
				else if((blockData & 0x7) == 1)
					newType = 1;
				else if((blockData & 0x7) == 2)
					newType = 2;
				else if((blockData & 0x7) == 3)
					newType = 3;
				else if((blockData & 0x7) == 4)
					newType = 4;
				else if((blockData & 0x7) == 5)
					newType = 5;
				else if((blockData & 0x7) == 6)
					newType = 6;
				else if((blockData & 0x7) == 7)
					newType = 7;
				state = state.with(Keys.FLUID_LEVEL, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SAND)
		{
			{
				SandType newType = null;
				if((blockData & 0xF) == 0)
					newType = SandTypes.NORMAL;
				else if((blockData & 0xF) == 1)
					newType = SandTypes.RED;
				state = state.with(Keys.SAND_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LOG)
		{
			{
				TreeType newType = null;
				if((blockData & 0x3) == 0)
					newType = TreeTypes.OAK;
				else if((blockData & 0x3) == 1)
					newType = TreeTypes.SPRUCE;
				else if((blockData & 0x3) == 2)
					newType = TreeTypes.BIRCH;
				else if((blockData & 0x3) == 3)
					newType = TreeTypes.JUNGLE;
				state = state.with(Keys.TREE_TYPE, newType).orElse(state);
			}
			{
				LogAxis newType = null;
				if((blockData & 0xC) == 0)
					newType = LogAxes.Y;
				else if((blockData & 0xC) == 4)
					newType = LogAxes.X;
				else if((blockData & 0xC) == 8)
					newType = LogAxes.Z;
				else if((blockData & 0xC) == 12)
					newType = LogAxes.NONE;
				state = state.with(Keys.LOG_AXIS, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LOG2)
		{
			{
				TreeType newType = null;
				if((blockData & 0x3) == 0)
					newType = TreeTypes.ACACIA;
				else if((blockData & 0x3) == 1)
					newType = TreeTypes.DARK_OAK;
				state = state.with(Keys.TREE_TYPE, newType).orElse(state);
			}
			{
				LogAxis newType = null;
				if((blockData & 0xC) == 0)
					newType = LogAxes.Y;
				else if((blockData & 0xC) == 4)
					newType = LogAxes.X;
				else if((blockData & 0xC) == 8)
					newType = LogAxes.Z;
				else if((blockData & 0xC) == 12)
					newType = LogAxes.NONE;
				state = state.with(Keys.LOG_AXIS, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LEAVES)
		{
			{
				TreeType newType = null;
				if((blockData & 0x3) == 0)
					newType = TreeTypes.OAK;
				else if((blockData & 0x3) == 1)
					newType = TreeTypes.SPRUCE;
				else if((blockData & 0x3) == 2)
					newType = TreeTypes.BIRCH;
				else if((blockData & 0x3) == 3)
					newType = TreeTypes.JUNGLE;
				state = state.with(Keys.TREE_TYPE, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.DECAYABLE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LEAVES2)
		{
			{
				TreeType newType = null;
				if((blockData & 0x3) == 0)
					newType = TreeTypes.ACACIA;
				else if((blockData & 0x3) == 1)
					newType = TreeTypes.DARK_OAK;
				state = state.with(Keys.TREE_TYPE, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.DECAYABLE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.CARPET)
		{
			{
				DyeColor newType = null;
				if((blockData & 0xF) == 0)
					newType = DyeColors.WHITE;
				else if((blockData & 0xF) == 1)
					newType = DyeColors.ORANGE;
				else if((blockData & 0xF) == 2)
					newType = DyeColors.MAGENTA;
				else if((blockData & 0xF) == 3)
					newType = DyeColors.LIGHT_BLUE;
				else if((blockData & 0xF) == 4)
					newType = DyeColors.YELLOW;
				else if((blockData & 0xF) == 5)
					newType = DyeColors.LIME;
				else if((blockData & 0xF) == 6)
					newType = DyeColors.PINK;
				else if((blockData & 0xF) == 7)
					newType = DyeColors.SILVER;
				else if((blockData & 0xF) == 8)
					newType = DyeColors.GRAY;
				else if((blockData & 0xF) == 9)
					newType = DyeColors.CYAN;
				else if((blockData & 0xF) == 10)
					newType = DyeColors.PURPLE;
				else if((blockData & 0xF) == 11)
					newType = DyeColors.BLUE;
				else if((blockData & 0xF) == 12)
					newType = DyeColors.BROWN;
				else if((blockData & 0xF) == 13)
					newType = DyeColors.GREEN;
				else if((blockData & 0xF) == 14)
					newType = DyeColors.RED;
				else if((blockData & 0xF) == 15)
					newType = DyeColors.BLACK;
				state = state.with(Keys.DYE_COLOR, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WOOL)
		{
			{
				DyeColor newType = null;
				if((blockData & 0xF) == 0)
					newType = DyeColors.WHITE;
				else if((blockData & 0xF) == 1)
					newType = DyeColors.ORANGE;
				else if((blockData & 0xF) == 2)
					newType = DyeColors.MAGENTA;
				else if((blockData & 0xF) == 3)
					newType = DyeColors.LIGHT_BLUE;
				else if((blockData & 0xF) == 4)
					newType = DyeColors.YELLOW;
				else if((blockData & 0xF) == 5)
					newType = DyeColors.LIME;
				else if((blockData & 0xF) == 6)
					newType = DyeColors.PINK;
				else if((blockData & 0xF) == 7)
					newType = DyeColors.SILVER;
				else if((blockData & 0xF) == 8)
					newType = DyeColors.GRAY;
				else if((blockData & 0xF) == 9)
					newType = DyeColors.CYAN;
				else if((blockData & 0xF) == 10)
					newType = DyeColors.PURPLE;
				else if((blockData & 0xF) == 11)
					newType = DyeColors.BLUE;
				else if((blockData & 0xF) == 12)
					newType = DyeColors.BROWN;
				else if((blockData & 0xF) == 13)
					newType = DyeColors.GREEN;
				else if((blockData & 0xF) == 14)
					newType = DyeColors.RED;
				else if((blockData & 0xF) == 15)
					newType = DyeColors.BLACK;
				state = state.with(Keys.DYE_COLOR, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STAINED_GLASS)
		{
			{
				DyeColor newType = null;
				if((blockData & 0xF) == 0)
					newType = DyeColors.WHITE;
				else if((blockData & 0xF) == 1)
					newType = DyeColors.ORANGE;
				else if((blockData & 0xF) == 2)
					newType = DyeColors.MAGENTA;
				else if((blockData & 0xF) == 3)
					newType = DyeColors.LIGHT_BLUE;
				else if((blockData & 0xF) == 4)
					newType = DyeColors.YELLOW;
				else if((blockData & 0xF) == 5)
					newType = DyeColors.LIME;
				else if((blockData & 0xF) == 6)
					newType = DyeColors.PINK;
				else if((blockData & 0xF) == 7)
					newType = DyeColors.SILVER;
				else if((blockData & 0xF) == 8)
					newType = DyeColors.GRAY;
				else if((blockData & 0xF) == 9)
					newType = DyeColors.CYAN;
				else if((blockData & 0xF) == 10)
					newType = DyeColors.PURPLE;
				else if((blockData & 0xF) == 11)
					newType = DyeColors.BLUE;
				else if((blockData & 0xF) == 12)
					newType = DyeColors.BROWN;
				else if((blockData & 0xF) == 13)
					newType = DyeColors.GREEN;
				else if((blockData & 0xF) == 14)
					newType = DyeColors.RED;
				else if((blockData & 0xF) == 15)
					newType = DyeColors.BLACK;
				state = state.with(Keys.DYE_COLOR, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.TORCH)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 1)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 2)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 4)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 5)
					newType = Direction.UP;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.REDSTONE_TORCH)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 1)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 2)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 4)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 5)
					newType = Direction.UP;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.UNLIT_REDSTONE_TORCH)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 1)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 2)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 4)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 5)
					newType = Direction.UP;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DOUBLE_STONE_SLAB)
		{
			{
				SlabType newType = null;
				if((blockData & 0x7) == 0)
					newType = SlabTypes.STONE;
				else if((blockData & 0x7) == 1)
					newType = SlabTypes.SAND;
				else if((blockData & 0x7) == 2)
					newType = SlabTypes.WOOD;
				else if((blockData & 0x7) == 3)
					newType = SlabTypes.COBBLESTONE;
				else if((blockData & 0x7) == 4)
					newType = SlabTypes.BRICK;
				else if((blockData & 0x7) == 5)
					newType = SlabTypes.SMOOTH_BRICK;
				else if((blockData & 0x7) == 6)
					newType = SlabTypes.NETHERBRICK;
				else if((blockData & 0x7) == 7)
					newType = SlabTypes.QUARTZ;
				state = state.with(Keys.SLAB_TYPE, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.SEAMLESS, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DOUBLE_STONE_SLAB2)
		{
			{
				SlabType newType = null;
				if((blockData & 0x7) == 0)
					newType = SlabTypes.RED_SAND;
				state = state.with(Keys.SLAB_TYPE, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.SEAMLESS, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STONE_SLAB)
		{
			{
				SlabType newType = null;
				if((blockData & 0x7) == 0)
					newType = SlabTypes.STONE;
				else if((blockData & 0x7) == 1)
					newType = SlabTypes.SAND;
				else if((blockData & 0x7) == 2)
					newType = SlabTypes.WOOD;
				else if((blockData & 0x7) == 3)
					newType = SlabTypes.COBBLESTONE;
				else if((blockData & 0x7) == 4)
					newType = SlabTypes.BRICK;
				else if((blockData & 0x7) == 5)
					newType = SlabTypes.SMOOTH_BRICK;
				else if((blockData & 0x7) == 6)
					newType = SlabTypes.NETHERBRICK;
				else if((blockData & 0x7) == 7)
					newType = SlabTypes.QUARTZ;
				state = state.with(Keys.SLAB_TYPE, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STONE_SLAB2)
		{
			{
				SlabType newType = null;
				if((blockData & 0x7) == 0)
					newType = SlabTypes.RED_SAND;
				state = state.with(Keys.SLAB_TYPE, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DOUBLE_WOODEN_SLAB)
		{
			{
				TreeType newType = null;
				if((blockData & 0xF) == 0)
					newType = TreeTypes.OAK;
				else if((blockData & 0xF) == 1)
					newType = TreeTypes.SPRUCE;
				else if((blockData & 0xF) == 2)
					newType = TreeTypes.BIRCH;
				else if((blockData & 0xF) == 3)
					newType = TreeTypes.JUNGLE;
				else if((blockData & 0xF) == 4)
					newType = TreeTypes.ACACIA;
				else if((blockData & 0xF) == 5)
					newType = TreeTypes.DARK_OAK;
				state = state.with(Keys.TREE_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WOODEN_SLAB)
		{
			{
				TreeType newType = null;
				if((blockData & 0x7) == 0)
					newType = TreeTypes.OAK;
				else if((blockData & 0x7) == 1)
					newType = TreeTypes.SPRUCE;
				else if((blockData & 0x7) == 2)
					newType = TreeTypes.BIRCH;
				else if((blockData & 0x7) == 3)
					newType = TreeTypes.JUNGLE;
				else if((blockData & 0x7) == 4)
					newType = TreeTypes.ACACIA;
				else if((blockData & 0x7) == 5)
					newType = TreeTypes.DARK_OAK;
				state = state.with(Keys.TREE_TYPE, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SANDSTONE)
		{
			{
				SandstoneType newType = null;
				if((blockData & 0xF) == 0)
					newType = SandstoneTypes.DEFAULT;
				else if((blockData & 0xF) == 1)
					newType = SandstoneTypes.CHISELED;
				else if((blockData & 0xF) == 2)
					newType = SandstoneTypes.SMOOTH;
				state = state.with(Keys.SANDSTONE_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.BED)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OCCUPIED, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.TALLGRASS)
		{
			{
				ShrubType newType = null;
				if((blockData & 0xF) == 0)
					newType = ShrubTypes.DEAD_BUSH;
				else if((blockData & 0xF) == 1)
					newType = ShrubTypes.TALL_GRASS;
				else if((blockData & 0xF) == 2)
					newType = ShrubTypes.FERN;
				state = state.with(Keys.SHRUB_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.RED_FLOWER)
		{
			{
				PlantType newType = null;
				if((blockData & 0xF) == 0)
					newType = PlantTypes.POPPY;
				else if((blockData & 0xF) == 1)
					newType = PlantTypes.BLUE_ORCHID;
				else if((blockData & 0xF) == 2)
					newType = PlantTypes.ALLIUM;
				else if((blockData & 0xF) == 3)
					newType = PlantTypes.HOUSTONIA;
				else if((blockData & 0xF) == 4)
					newType = PlantTypes.RED_TULIP;
				else if((blockData & 0xF) == 5)
					newType = PlantTypes.ORANGE_TULIP;
				else if((blockData & 0xF) == 6)
					newType = PlantTypes.WHITE_TULIP;
				else if((blockData & 0xF) == 7)
					newType = PlantTypes.PINK_TULIP;
				else if((blockData & 0xF) == 8)
					newType = PlantTypes.OXEYE_DAISY;
				state = state.with(Keys.PLANT_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DOUBLE_PLANT)
		{
			{
				DoublePlantType newType = null;
				if((blockData & 0x7) == 0)
					newType = DoublePlantTypes.SUNFLOWER;
				else if((blockData & 0x7) == 1)
					newType = DoublePlantTypes.SYRINGA;
				else if((blockData & 0x7) == 2)
					newType = DoublePlantTypes.GRASS;
				else if((blockData & 0x7) == 3)
					newType = DoublePlantTypes.FERN;
				else if((blockData & 0x7) == 4)
					newType = DoublePlantTypes.ROSE;
				else if((blockData & 0x7) == 5)
					newType = DoublePlantTypes.PAEONIA;
				state = state.with(Keys.DOUBLE_PLANT_TYPE, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.PISTON)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 1)
					newType = Direction.UP;
				else if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.EXTENDED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STICKY_PISTON)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 1)
					newType = Direction.UP;
				else if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.EXTENDED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.PISTON_HEAD)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 1)
					newType = Direction.UP;
				else if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PistonType newType = null;
				if((blockData & 0x8) == 0)
					newType = PistonTypes.NORMAL;
				else if((blockData & 0x8) == 8)
					newType = PistonTypes.STICKY;
				state = state.with(Keys.PISTON_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.OAK_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STONE_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.BRICK_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STONE_BRICK_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.NETHER_BRICK_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SANDSTONE_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SPRUCE_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.BIRCH_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.JUNGLE_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.QUARTZ_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.ACACIA_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DARK_OAK_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.RED_SANDSTONE_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.PURPUR_STAIRS)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.NORTH;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x4) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x4) == 4)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.REDSTONE_WIRE)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				else if((blockData & 0xF) == 8)
					newType = 8;
				else if((blockData & 0xF) == 9)
					newType = 9;
				else if((blockData & 0xF) == 10)
					newType = 10;
				else if((blockData & 0xF) == 11)
					newType = 11;
				else if((blockData & 0xF) == 12)
					newType = 12;
				else if((blockData & 0xF) == 13)
					newType = 13;
				else if((blockData & 0xF) == 14)
					newType = 14;
				else if((blockData & 0xF) == 15)
					newType = 15;
				state = state.with(Keys.POWER, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DAYLIGHT_DETECTOR)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				else if((blockData & 0xF) == 8)
					newType = 8;
				else if((blockData & 0xF) == 9)
					newType = 9;
				else if((blockData & 0xF) == 10)
					newType = 10;
				else if((blockData & 0xF) == 11)
					newType = 11;
				else if((blockData & 0xF) == 12)
					newType = 12;
				else if((blockData & 0xF) == 13)
					newType = 13;
				else if((blockData & 0xF) == 14)
					newType = 14;
				else if((blockData & 0xF) == 15)
					newType = 15;
				state = state.with(Keys.POWER, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WHEAT)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.CARROTS)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.POTATOES)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.BEETROOTS)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.FARMLAND)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				state = state.with(Keys.MOISTURE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STANDING_BANNER)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 1)
					newType = Direction.SOUTH_SOUTHWEST;
				else if((blockData & 0xF) == 2)
					newType = Direction.SOUTHWEST;
				else if((blockData & 0xF) == 3)
					newType = Direction.WEST_SOUTHWEST;
				else if((blockData & 0xF) == 4)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 5)
					newType = Direction.WEST_NORTHWEST;
				else if((blockData & 0xF) == 6)
					newType = Direction.NORTHWEST;
				else if((blockData & 0xF) == 7)
					newType = Direction.NORTH_NORTHWEST;
				else if((blockData & 0xF) == 8)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 9)
					newType = Direction.NORTH_NORTHEAST;
				else if((blockData & 0xF) == 10)
					newType = Direction.NORTHEAST;
				else if((blockData & 0xF) == 11)
					newType = Direction.EAST_NORTHEAST;
				else if((blockData & 0xF) == 12)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 13)
					newType = Direction.EAST_SOUTHEAST;
				else if((blockData & 0xF) == 14)
					newType = Direction.SOUTHEAST;
				else if((blockData & 0xF) == 15)
					newType = Direction.SOUTH_SOUTHEAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WALL_BANNER)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 4)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WOODEN_DOOR)
		{
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.IRON_DOOR)
		{
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SPRUCE_DOOR)
		{
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.BIRCH_DOOR)
		{
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.JUNGLE_DOOR)
		{
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.ACACIA_DOOR)
		{
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DARK_OAK_DOOR)
		{
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.RAIL)
		{
			{
				RailDirection newType = null;
				if((blockData & 0x8) == 0)
					newType = RailDirections.NORTH_SOUTH;
				else if((blockData & 0x8) == 1)
					newType = RailDirections.EAST_WEST;
				else if((blockData & 0x8) == 2)
					newType = RailDirections.ASCENDING_EAST;
				else if((blockData & 0x8) == 3)
					newType = RailDirections.ASCENDING_WEST;
				else if((blockData & 0x8) == 4)
					newType = RailDirections.ASCENDING_NORTH;
				else if((blockData & 0x8) == 5)
					newType = RailDirections.ASCENDING_SOUTH;
				else if((blockData & 0x8) == 6)
					newType = RailDirections.SOUTH_EAST;
				else if((blockData & 0x8) == 7)
					newType = RailDirections.SOUTH_WEST;
				else if((blockData & 0x8) == 8)
					newType = RailDirections.NORTH_WEST;
				else if((blockData & 0x8) == 9)
					newType = RailDirections.NORTH_EAST;
				state = state.with(Keys.RAIL_DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.ACTIVATOR_RAIL)
		{
			{
				RailDirection newType = null;
				if((blockData & 0x7) == 0)
					newType = RailDirections.NORTH_SOUTH;
				else if((blockData & 0x7) == 1)
					newType = RailDirections.EAST_WEST;
				else if((blockData & 0x7) == 2)
					newType = RailDirections.ASCENDING_EAST;
				else if((blockData & 0x7) == 3)
					newType = RailDirections.ASCENDING_WEST;
				else if((blockData & 0x7) == 4)
					newType = RailDirections.ASCENDING_NORTH;
				else if((blockData & 0x7) == 5)
					newType = RailDirections.ASCENDING_SOUTH;
				state = state.with(Keys.RAIL_DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DETECTOR_RAIL)
		{
			{
				RailDirection newType = null;
				if((blockData & 0x7) == 0)
					newType = RailDirections.NORTH_SOUTH;
				else if((blockData & 0x7) == 1)
					newType = RailDirections.EAST_WEST;
				else if((blockData & 0x7) == 2)
					newType = RailDirections.ASCENDING_EAST;
				else if((blockData & 0x7) == 3)
					newType = RailDirections.ASCENDING_WEST;
				else if((blockData & 0x7) == 4)
					newType = RailDirections.ASCENDING_NORTH;
				else if((blockData & 0x7) == 5)
					newType = RailDirections.ASCENDING_SOUTH;
				state = state.with(Keys.RAIL_DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.GOLDEN_RAIL)
		{
			{
				RailDirection newType = null;
				if((blockData & 0x7) == 0)
					newType = RailDirections.NORTH_SOUTH;
				else if((blockData & 0x7) == 1)
					newType = RailDirections.EAST_WEST;
				else if((blockData & 0x7) == 2)
					newType = RailDirections.ASCENDING_EAST;
				else if((blockData & 0x7) == 3)
					newType = RailDirections.ASCENDING_WEST;
				else if((blockData & 0x7) == 4)
					newType = RailDirections.ASCENDING_NORTH;
				else if((blockData & 0x7) == 5)
					newType = RailDirections.ASCENDING_SOUTH;
				state = state.with(Keys.RAIL_DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LADDER)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.FURNACE)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LIT_FURNACE)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.CHEST)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.ENDER_CHEST)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.TRAPPED_CHEST)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STANDING_SIGN)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 1)
					newType = Direction.SOUTH_SOUTHWEST;
				else if((blockData & 0xF) == 2)
					newType = Direction.SOUTHWEST;
				else if((blockData & 0xF) == 3)
					newType = Direction.WEST_SOUTHWEST;
				else if((blockData & 0xF) == 4)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 5)
					newType = Direction.WEST_NORTHWEST;
				else if((blockData & 0xF) == 6)
					newType = Direction.NORTHWEST;
				else if((blockData & 0xF) == 7)
					newType = Direction.NORTH_NORTHWEST;
				else if((blockData & 0xF) == 8)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 9)
					newType = Direction.NORTH_NORTHEAST;
				else if((blockData & 0xF) == 10)
					newType = Direction.NORTHEAST;
				else if((blockData & 0xF) == 11)
					newType = Direction.EAST_NORTHEAST;
				else if((blockData & 0xF) == 12)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 13)
					newType = Direction.EAST_SOUTHEAST;
				else if((blockData & 0xF) == 14)
					newType = Direction.SOUTHEAST;
				else if((blockData & 0xF) == 15)
					newType = Direction.SOUTH_SOUTHEAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WALL_SIGN)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 4)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DROPPER)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 1)
					newType = Direction.UP;
				else if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DISPENSER)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 1)
					newType = Direction.UP;
				else if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.HOPPER)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 5)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LEVER)
		{
			{
				Axis newType = null;
				if((blockData & 0x7) == 0)
					newType = Axis.X;
				else if((blockData & 0x7) == 1)
					newType = Axis.Y;
				else if((blockData & 0x7) == 2)
					newType = Axis.Y;
				else if((blockData & 0x7) == 3)
					newType = Axis.Y;
				else if((blockData & 0x7) == 4)
					newType = Axis.Y;
				else if((blockData & 0x7) == 5)
					newType = Axis.Z;
				else if((blockData & 0x7) == 6)
					newType = Axis.X;
				else if((blockData & 0x7) == 7)
					newType = Axis.Z;
				state = state.with(Keys.AXIS, newType).orElse(state);
			}
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x7) == 2)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 5)
					newType = Direction.UP;
				else if((blockData & 0x7) == 6)
					newType = Direction.UP;
				else if((blockData & 0x7) == 7)
					newType = Direction.DOWN;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STONE_PRESSURE_PLATE)
		{
			{
				Boolean newType = null;
				if((blockData & 0x1) == 0)
					newType = false;
				else if((blockData & 0x1) == 1)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WOODEN_PRESSURE_PLATE)
		{
			{
				Boolean newType = null;
				if((blockData & 0x1) == 0)
					newType = false;
				else if((blockData & 0x1) == 1)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LIGHT_WEIGHTED_PRESSURE_PLATE)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				else if((blockData & 0xF) == 8)
					newType = 8;
				else if((blockData & 0xF) == 9)
					newType = 9;
				else if((blockData & 0xF) == 10)
					newType = 10;
				else if((blockData & 0xF) == 11)
					newType = 11;
				else if((blockData & 0xF) == 12)
					newType = 12;
				else if((blockData & 0xF) == 13)
					newType = 13;
				else if((blockData & 0xF) == 14)
					newType = 14;
				else if((blockData & 0xF) == 15)
					newType = 15;
				state = state.with(Keys.POWER, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.HEAVY_WEIGHTED_PRESSURE_PLATE)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				else if((blockData & 0xF) == 8)
					newType = 8;
				else if((blockData & 0xF) == 9)
					newType = 9;
				else if((blockData & 0xF) == 10)
					newType = 10;
				else if((blockData & 0xF) == 11)
					newType = 11;
				else if((blockData & 0xF) == 12)
					newType = 12;
				else if((blockData & 0xF) == 13)
					newType = 13;
				else if((blockData & 0xF) == 14)
					newType = 14;
				else if((blockData & 0xF) == 15)
					newType = 15;
				state = state.with(Keys.POWER, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STONE_BUTTON)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x7) == 2)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 5)
					newType = Direction.UP;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.WOODEN_BUTTON)
		{
			{
				Direction newType = null;
				if((blockData & 0x7) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0x7) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x7) == 2)
					newType = Direction.WEST;
				else if((blockData & 0x7) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0x7) == 4)
					newType = Direction.NORTH;
				else if((blockData & 0x7) == 5)
					newType = Direction.UP;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SNOW_LAYER)
		{
			{
				Integer newType = null;
				if((blockData & 0x7) == 0)
					newType = 0;
				else if((blockData & 0x7) == 1)
					newType = 1;
				else if((blockData & 0x7) == 2)
					newType = 2;
				else if((blockData & 0x7) == 3)
					newType = 3;
				else if((blockData & 0x7) == 4)
					newType = 4;
				else if((blockData & 0x7) == 5)
					newType = 5;
				else if((blockData & 0x7) == 6)
					newType = 6;
				else if((blockData & 0x7) == 7)
					newType = 7;
				state = state.with(Keys.LAYER, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.CACTUS)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				else if((blockData & 0xF) == 8)
					newType = 8;
				else if((blockData & 0xF) == 9)
					newType = 9;
				else if((blockData & 0xF) == 10)
					newType = 10;
				else if((blockData & 0xF) == 11)
					newType = 11;
				else if((blockData & 0xF) == 12)
					newType = 12;
				else if((blockData & 0xF) == 13)
					newType = 13;
				else if((blockData & 0xF) == 14)
					newType = 14;
				else if((blockData & 0xF) == 15)
					newType = 15;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.REEDS)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				else if((blockData & 0xF) == 8)
					newType = 8;
				else if((blockData & 0xF) == 9)
					newType = 9;
				else if((blockData & 0xF) == 10)
					newType = 10;
				else if((blockData & 0xF) == 11)
					newType = 11;
				else if((blockData & 0xF) == 12)
					newType = 12;
				else if((blockData & 0xF) == 13)
					newType = 13;
				else if((blockData & 0xF) == 14)
					newType = 14;
				else if((blockData & 0xF) == 15)
					newType = 15;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.PUMPKIN)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 1)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 3)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 4)
					newType = Direction.NONE;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.LIT_PUMPKIN)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 1)
					newType = Direction.WEST;
				else if((blockData & 0xF) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 3)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 4)
					newType = Direction.NONE;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.CAKE)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				state = state.with(Keys.LAYER, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.UNPOWERED_REPEATER)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Integer newType = null;
				if((blockData & 0xC) == 0)
					newType = 1;
				else if((blockData & 0xC) == 4)
					newType = 2;
				else if((blockData & 0xC) == 8)
					newType = 3;
				else if((blockData & 0xC) == 12)
					newType = 4;
				state = state.with(Keys.DELAY, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.POWERED_REPEATER)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Integer newType = null;
				if((blockData & 0xC) == 0)
					newType = 1;
				else if((blockData & 0xC) == 4)
					newType = 2;
				else if((blockData & 0xC) == 8)
					newType = 3;
				else if((blockData & 0xC) == 12)
					newType = 4;
				state = state.with(Keys.DELAY, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.UNPOWERED_COMPARATOR)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				ComparatorType newType = null;
				if((blockData & 0x4) == 0)
					newType = ComparatorTypes.COMPARE;
				else if((blockData & 0x4) == 4)
					newType = ComparatorTypes.SUBTRACT;
				state = state.with(Keys.COMPARATOR_TYPE, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.POWERED_COMPARATOR)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				ComparatorType newType = null;
				if((blockData & 0x4) == 0)
					newType = ComparatorTypes.COMPARE;
				else if((blockData & 0x4) == 4)
					newType = ComparatorTypes.SUBTRACT;
				state = state.with(Keys.COMPARATOR_TYPE, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.TRAPDOOR)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OPEN, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.IRON_TRAPDOOR)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OPEN, newType).orElse(state);
			}
			{
				PortionType newType = null;
				if((blockData & 0x8) == 0)
					newType = PortionTypes.BOTTOM;
				else if((blockData & 0x8) == 8)
					newType = PortionTypes.TOP;
				state = state.with(Keys.PORTION_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.MONSTER_EGG)
		{
			{
				DisguisedBlockType newType = null;
				if((blockData & 0xF) == 0)
					newType = DisguisedBlockTypes.STONE;
				else if((blockData & 0xF) == 1)
					newType = DisguisedBlockTypes.COBBLESTONE;
				else if((blockData & 0xF) == 2)
					newType = DisguisedBlockTypes.STONEBRICK;
				else if((blockData & 0xF) == 3)
					newType = DisguisedBlockTypes.MOSSY_STONEBRICK;
				else if((blockData & 0xF) == 4)
					newType = DisguisedBlockTypes.CRACKED_STONEBRICK;
				else if((blockData & 0xF) == 5)
					newType = DisguisedBlockTypes.CHISELED_STONEBRICK;
				state = state.with(Keys.DISGUISED_BLOCK_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.STONEBRICK)
		{
			{
				BrickType newType = null;
				if((blockData & 0xF) == 0)
					newType = BrickTypes.DEFAULT;
				else if((blockData & 0xF) == 1)
					newType = BrickTypes.MOSSY;
				else if((blockData & 0xF) == 2)
					newType = BrickTypes.CRACKED;
				else if((blockData & 0xF) == 3)
					newType = BrickTypes.CHISELED;
				state = state.with(Keys.BRICK_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.PRISMARINE)
		{
			{
				PrismarineType newType = null;
				if((blockData & 0xF) == 0)
					newType = PrismarineTypes.ROUGH;
				else if((blockData & 0xF) == 1)
					newType = PrismarineTypes.BRICKS;
				else if((blockData & 0xF) == 2)
					newType = PrismarineTypes.DARK;
				state = state.with(Keys.PRISMARINE_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SPONGE)
		{
			{
				Boolean newType = null;
				if((blockData & 0xF) == 0)
					newType = false;
				else if((blockData & 0xF) == 1)
					newType = true;
				state = state.with(Keys.IS_WET, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.BROWN_MUSHROOM_BLOCK)
		{
			{
				BigMushroomType newType = null;
				if((blockData & 0xF) == 0)
					newType = BigMushroomTypes.ALL_INSIDE;
				else if((blockData & 0xF) == 1)
					newType = BigMushroomTypes.NORTH_WEST;
				else if((blockData & 0xF) == 2)
					newType = BigMushroomTypes.NORTH;
				else if((blockData & 0xF) == 3)
					newType = BigMushroomTypes.NORTH_EAST;
				else if((blockData & 0xF) == 4)
					newType = BigMushroomTypes.WEST;
				else if((blockData & 0xF) == 5)
					newType = BigMushroomTypes.CENTER;
				else if((blockData & 0xF) == 6)
					newType = BigMushroomTypes.EAST;
				else if((blockData & 0xF) == 7)
					newType = BigMushroomTypes.SOUTH_WEST;
				else if((blockData & 0xF) == 8)
					newType = BigMushroomTypes.SOUTH;
				else if((blockData & 0xF) == 9)
					newType = BigMushroomTypes.SOUTH_EAST;
				else if((blockData & 0xF) == 10)
					newType = BigMushroomTypes.STEM;
				else if((blockData & 0xF) == 14)
					newType = BigMushroomTypes.ALL_OUTSIDE;
				else if((blockData & 0xF) == 15)
					newType = BigMushroomTypes.ALL_STEM;
				state = state.with(Keys.BIG_MUSHROOM_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.RED_MUSHROOM_BLOCK)
		{
			{
				BigMushroomType newType = null;
				if((blockData & 0xF) == 0)
					newType = BigMushroomTypes.ALL_INSIDE;
				else if((blockData & 0xF) == 1)
					newType = BigMushroomTypes.NORTH_WEST;
				else if((blockData & 0xF) == 2)
					newType = BigMushroomTypes.NORTH;
				else if((blockData & 0xF) == 3)
					newType = BigMushroomTypes.NORTH_EAST;
				else if((blockData & 0xF) == 4)
					newType = BigMushroomTypes.WEST;
				else if((blockData & 0xF) == 5)
					newType = BigMushroomTypes.CENTER;
				else if((blockData & 0xF) == 6)
					newType = BigMushroomTypes.EAST;
				else if((blockData & 0xF) == 7)
					newType = BigMushroomTypes.SOUTH_WEST;
				else if((blockData & 0xF) == 8)
					newType = BigMushroomTypes.SOUTH;
				else if((blockData & 0xF) == 9)
					newType = BigMushroomTypes.SOUTH_EAST;
				else if((blockData & 0xF) == 10)
					newType = BigMushroomTypes.STEM;
				else if((blockData & 0xF) == 14)
					newType = BigMushroomTypes.ALL_OUTSIDE;
				else if((blockData & 0xF) == 15)
					newType = BigMushroomTypes.ALL_STEM;
				state = state.with(Keys.BIG_MUSHROOM_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.PUMPKIN_STEM)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.MELON_STEM)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				else if((blockData & 0xF) == 6)
					newType = 6;
				else if((blockData & 0xF) == 7)
					newType = 7;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.VINE)
		{
			{
				Boolean newType = null;
				if((blockData & 0x1) == 0)
					newType = false;
				else if((blockData & 0x1) == 1)
					newType = true;
				state = state.with(Keys.CONNECTED_SOUTH, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x2) == 0)
					newType = false;
				else if((blockData & 0x2) == 2)
					newType = true;
				state = state.with(Keys.CONNECTED_WEST, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.CONNECTED_NORTH, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.CONNECTED_EAST, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.FENCE_GATE)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OPEN, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SPRUCE_FENCE_GATE)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OPEN, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.BIRCH_FENCE_GATE)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OPEN, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.JUNGLE_FENCE_GATE)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OPEN, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.DARK_OAK_FENCE_GATE)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OPEN, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.ACACIA_FENCE_GATE)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.OPEN, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.NETHER_WART)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.CAULDRON)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				state = state.with(Keys.FLUID_LEVEL, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.END_PORTAL_FRAME)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.WEST;
				else if((blockData & 0x3) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.EAST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.FILLED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.COCOA)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Integer newType = null;
				if((blockData & 0xC) == 0)
					newType = 0;
				else if((blockData & 0xC) == 4)
					newType = 1;
				else if((blockData & 0xC) == 8)
					newType = 2;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.TRIPWIRE_HOOK)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = true;
				else if((blockData & 0x4) == 4)
					newType = false;
				state = state.with(Keys.DISARMED, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.TRIPWIRE)
		{
			{
				Boolean newType = null;
				if((blockData & 0x1) == 0)
					newType = false;
				else if((blockData & 0x1) == 1)
					newType = true;
				state = state.with(Keys.POWERED, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x4) == 0)
					newType = false;
				else if((blockData & 0x4) == 4)
					newType = true;
				state = state.with(Keys.ATTACHED, newType).orElse(state);
			}
			{
				Boolean newType = null;
				if((blockData & 0x8) == 0)
					newType = false;
				else if((blockData & 0x8) == 8)
					newType = true;
				state = state.with(Keys.DISARMED, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.COBBLESTONE_WALL)
		{
			{
				WallType newType = null;
				if((blockData & 0xF) == 0)
					newType = WallTypes.NORMAL;
				else if((blockData & 0xF) == 1)
					newType = WallTypes.MOSSY;
				state = state.with(Keys.WALL_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.SKULL)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 2)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 3)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 4)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 5)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.QUARTZ_BLOCK)
		{
			{
				QuartzType newType = null;
				if((blockData & 0x3) == 0)
					newType = QuartzTypes.DEFAULT;
				else if((blockData & 0x3) == 1)
					newType = QuartzTypes.CHISELED;
				else if((blockData & 0x3) == 2)
					newType = QuartzTypes.LINES_Y;
				else if((blockData & 0x3) == 3)
					newType = QuartzTypes.LINES_Z;
				else if((blockData & 0x3) == 4)
					newType = QuartzTypes.LINES_X;
				state = state.with(Keys.QUARTZ_TYPE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.ANVIL)
		{
			{
				Direction newType = null;
				if((blockData & 0x3) == 0)
					newType = Direction.NORTH;
				else if((blockData & 0x3) == 1)
					newType = Direction.EAST;
				else if((blockData & 0x3) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0x3) == 3)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.CHORUS_FLOWER)
		{
			{
				Integer newType = null;
				if((blockData & 0xF) == 0)
					newType = 0;
				else if((blockData & 0xF) == 1)
					newType = 1;
				else if((blockData & 0xF) == 2)
					newType = 2;
				else if((blockData & 0xF) == 3)
					newType = 3;
				else if((blockData & 0xF) == 4)
					newType = 4;
				else if((blockData & 0xF) == 5)
					newType = 5;
				state = state.with(Keys.GROWTH_STAGE, newType).orElse(state);
			}
			
		}
		if (blockType == BlockTypes.END_ROD)
		{
			{
				Direction newType = null;
				if((blockData & 0xF) == 0)
					newType = Direction.DOWN;
				else if((blockData & 0xF) == 1)
					newType = Direction.UP;
				else if((blockData & 0xF) == 2)
					newType = Direction.SOUTH;
				else if((blockData & 0xF) == 3)
					newType = Direction.NORTH;
				else if((blockData & 0xF) == 4)
					newType = Direction.EAST;
				else if((blockData & 0xF) == 5)
					newType = Direction.WEST;
				state = state.with(Keys.DIRECTION, newType).orElse(state);
			}
			
		}
		loc.setBlock(state, cause);
		
	}
}