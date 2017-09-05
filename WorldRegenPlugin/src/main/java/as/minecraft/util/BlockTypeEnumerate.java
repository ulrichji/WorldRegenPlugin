package as.minecraft.util;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;

public class BlockTypeEnumerate
{
	public static BlockType getBlockTypeFromId(int id)
	{
		switch(id)
		{
		case 0x0:
			return BlockTypes.AIR;
		case 0x1:
			return BlockTypes.STONE;
		case 0x2:
			return BlockTypes.GRASS;
		case 0x3:
			return BlockTypes.DIRT;
		case 0x4:
			return BlockTypes.COBBLESTONE;
		case 0x5:
			return BlockTypes.PLANKS;
		case 0x6:
			return BlockTypes.SAPLING;
		case 0x7:
			return BlockTypes.BEDROCK;
		case 0x8:
			return BlockTypes.FLOWING_WATER;
		case 0x9:
			return BlockTypes.WATER;
		case 0xA:
			return BlockTypes.FLOWING_LAVA;
		case 0xB:
			return BlockTypes.LAVA;
		case 0xC:
			return BlockTypes.SAND;
		case 0xD:
			return BlockTypes.GRAVEL;
		case 0xE:
			return BlockTypes.GOLD_ORE;
		case 0xF:
			return BlockTypes.IRON_ORE;
		case 0x10:
			return BlockTypes.COAL_ORE;
		case 0x11:
			return BlockTypes.LOG;
		case 0x12:
			return BlockTypes.LEAVES;
		case 0x13:
			return BlockTypes.SPONGE;
		case 0x14:
			return BlockTypes.GLASS;
		case 0x15:
			return BlockTypes.LAPIS_ORE;
		case 0x16:
			return BlockTypes.LAPIS_BLOCK;
		case 0x17:
			return BlockTypes.DISPENSER;
		case 0x18:
			return BlockTypes.SANDSTONE;
		case 0x19:
			return BlockTypes.NOTEBLOCK;
		case 0x1A:
			return BlockTypes.BED;
		case 0x1B:
			return BlockTypes.GOLDEN_RAIL;
		case 0x1C:
			return BlockTypes.DETECTOR_RAIL;
		case 0x1D:
			return BlockTypes.STICKY_PISTON;
		case 0x1E:
			return BlockTypes.WEB;
		case 0x1F:
			return BlockTypes.TALLGRASS;
		case 0x20:
			return BlockTypes.DEADBUSH;
		case 0x21:
			return BlockTypes.PISTON;
		case 0x22:
			return BlockTypes.PISTON_HEAD;
		case 0x23:
			return BlockTypes.WOOL;
		case 0x24:
			return BlockTypes.PISTON_EXTENSION;
		case 0x25:
			return BlockTypes.YELLOW_FLOWER;
		case 0x26:
			return BlockTypes.RED_FLOWER;
		case 0x27:
			return BlockTypes.BROWN_MUSHROOM;
		case 0x28:
			return BlockTypes.RED_MUSHROOM;
		case 0x29:
			return BlockTypes.GOLD_BLOCK;
		case 0x2A:
			return BlockTypes.IRON_BLOCK;
		case 0x2B:
			return BlockTypes.DOUBLE_STONE_SLAB;
		case 0x2C:
			return BlockTypes.STONE_SLAB;
		case 0x2D:
			return BlockTypes.BRICK_BLOCK;
		case 0x2E:
			return BlockTypes.TNT;
		case 0x2F:
			return BlockTypes.BOOKSHELF;
		case 0x30:
			return BlockTypes.MOSSY_COBBLESTONE;
		case 0x31:
			return BlockTypes.OBSIDIAN;
		case 0x32:
			return BlockTypes.TORCH;
		case 0x33:
			return BlockTypes.FIRE;
		case 0x34:
			return BlockTypes.MOB_SPAWNER;
		case 0x35:
			return BlockTypes.OAK_STAIRS;
		case 0x36:
			return BlockTypes.CHEST;
		case 0x37:
			return BlockTypes.REDSTONE_WIRE;
		case 0x38:
			return BlockTypes.DIAMOND_ORE;
		case 0x39:
			return BlockTypes.DIAMOND_BLOCK;
		case 0x3A:
			return BlockTypes.CRAFTING_TABLE;
		case 0x3B:
			return BlockTypes.WHEAT;
		case 0x3C:
			return BlockTypes.FARMLAND;
		case 0x3D:
			return BlockTypes.FURNACE;
		case 0x3E:
			return BlockTypes.LIT_FURNACE;
		case 0x3F:
			return BlockTypes.STANDING_SIGN;
		case 0x40:
			return BlockTypes.WOODEN_DOOR;
		case 0x41:
			return BlockTypes.LADDER;
		case 0x42:
			return BlockTypes.RAIL;
		case 0x43:
			return BlockTypes.STONE_STAIRS;
		case 0x44:
			return BlockTypes.WALL_SIGN;
		case 0x45:
			return BlockTypes.LEVER;
		case 0x46:
			return BlockTypes.STONE_PRESSURE_PLATE;
		case 0x47:
			return BlockTypes.IRON_DOOR;
		case 0x48:
			return BlockTypes.WOODEN_PRESSURE_PLATE;
		case 0x49:
			return BlockTypes.REDSTONE_ORE;
		case 0x4A:
			return BlockTypes.LIT_REDSTONE_ORE;
		case 0x4B:
			return BlockTypes.UNLIT_REDSTONE_TORCH;
		case 0x4C:
			return BlockTypes.REDSTONE_TORCH;
		case 0x4D:
			return BlockTypes.STONE_BUTTON;
		case 0x4E:
			return BlockTypes.SNOW_LAYER;
		case 0x4F:
			return BlockTypes.ICE;
		case 0x50:
			return BlockTypes.SNOW;
		case 0x51:
			return BlockTypes.CACTUS;
		case 0x52:
			return BlockTypes.CLAY;
		case 0x53:
			return BlockTypes.REEDS;
		case 0x54:
			return BlockTypes.JUKEBOX;
		case 0x55:
			return BlockTypes.FENCE;
		case 0x56:
			return BlockTypes.PUMPKIN;
		case 0x57:
			return BlockTypes.NETHERRACK;
		case 0x58:
			return BlockTypes.SOUL_SAND;
		case 0x59:
			return BlockTypes.GLOWSTONE;
		case 0x5A:
			return BlockTypes.PORTAL;
		case 0x5B:
			return BlockTypes.LIT_PUMPKIN;
		case 0x5C:
			return BlockTypes.CAKE;
		case 0x5D:
			return BlockTypes.UNPOWERED_REPEATER;
		case 0x5E:
			return BlockTypes.POWERED_REPEATER;
		case 0x5F:
			return BlockTypes.STAINED_GLASS;
		case 0x60:
			return BlockTypes.TRAPDOOR;
		case 0x61:
			return BlockTypes.MONSTER_EGG;
		case 0x62:
			return BlockTypes.STONEBRICK;
		case 0x63:
			return BlockTypes.BROWN_MUSHROOM_BLOCK;
		case 0x64:
			return BlockTypes.RED_MUSHROOM_BLOCK;
		case 0x65:
			return BlockTypes.IRON_BARS;
		case 0x66:
			return BlockTypes.GLASS_PANE;
		case 0x67:
			return BlockTypes.MELON_BLOCK;
		case 0x68:
			return BlockTypes.PUMPKIN_STEM;
		case 0x69:
			return BlockTypes.MELON_STEM;
		case 0x6A:
			return BlockTypes.VINE;
		case 0x6B:
			return BlockTypes.FENCE_GATE;
		case 0x6C:
			return BlockTypes.BRICK_STAIRS;
		case 0x6D:
			return BlockTypes.STONE_BRICK_STAIRS;
		case 0x6E:
			return BlockTypes.MYCELIUM;
		case 0x6F:
			return BlockTypes.WATERLILY;
		case 0x70:
			return BlockTypes.NETHER_BRICK;
		case 0x71:
			return BlockTypes.NETHER_BRICK_FENCE;
		case 0x72:
			return BlockTypes.NETHER_BRICK_STAIRS;
		case 0x73:
			return BlockTypes.NETHER_WART;
		case 0x74:
			return BlockTypes.ENCHANTING_TABLE;
		case 0x75:
			return BlockTypes.BREWING_STAND;
		case 0x76:
			return BlockTypes.CAULDRON;
		case 0x77:
			return BlockTypes.END_PORTAL;
		case 0x78:
			return BlockTypes.END_PORTAL_FRAME;
		case 0x79:
			return BlockTypes.END_STONE;
		case 0x7A:
			return BlockTypes.DRAGON_EGG;
		case 0x7B:
			return BlockTypes.REDSTONE_LAMP;
		case 0x7C:
			return BlockTypes.LIT_REDSTONE_LAMP;
		case 0x7D:
			return BlockTypes.DOUBLE_WOODEN_SLAB;
		case 0x7E:
			return BlockTypes.WOODEN_SLAB;
		case 0x7F:
			return BlockTypes.COCOA;
		case 0x80:
			return BlockTypes.SANDSTONE_STAIRS;
		case 0x81:
			return BlockTypes.EMERALD_ORE;
		case 0x82:
			return BlockTypes.ENDER_CHEST;
		case 0x83:
			return BlockTypes.TRIPWIRE_HOOK;
		case 0x84:
			return BlockTypes.TRIPWIRE;
		case 0x85:
			return BlockTypes.EMERALD_BLOCK;
		case 0x86:
			return BlockTypes.SPRUCE_STAIRS;
		case 0x87:
			return BlockTypes.BIRCH_STAIRS;
		case 0x88:
			return BlockTypes.JUNGLE_STAIRS;
		case 0x89:
			return BlockTypes.COMMAND_BLOCK;
		case 0x8A:
			return BlockTypes.BEACON;
		case 0x8B:
			return BlockTypes.COBBLESTONE_WALL;
		case 0x8C:
			return BlockTypes.FLOWER_POT;
		case 0x8D:
			return BlockTypes.CARROTS;
		case 0x8E:
			return BlockTypes.POTATOES;
		case 0x8F:
			return BlockTypes.WOODEN_BUTTON;
		case 0x90:
			return BlockTypes.SKULL;
		case 0x91:
			return BlockTypes.ANVIL;
		case 0x92:
			return BlockTypes.TRAPPED_CHEST;
		case 0x93:
			return BlockTypes.LIGHT_WEIGHTED_PRESSURE_PLATE;
		case 0x94:
			return BlockTypes.HEAVY_WEIGHTED_PRESSURE_PLATE;
		case 0x95:
			return BlockTypes.UNPOWERED_COMPARATOR;
		case 0x96:
			return BlockTypes.POWERED_COMPARATOR;
		case 0x97:
			return BlockTypes.DAYLIGHT_DETECTOR;
		case 0x98:
			return BlockTypes.REDSTONE_BLOCK;
		case 0x99:
			return BlockTypes.QUARTZ_ORE;
		case 0x9A:
			return BlockTypes.HOPPER;
		case 0x9B:
			return BlockTypes.QUARTZ_BLOCK;
		case 0x9C:
			return BlockTypes.QUARTZ_STAIRS;
		case 0x9D:
			return BlockTypes.ACTIVATOR_RAIL;
		case 0x9E:
			return BlockTypes.DROPPER;
		case 0x9F:
			return BlockTypes.STAINED_HARDENED_CLAY;
		case 0xA0:
			return BlockTypes.STAINED_GLASS_PANE;
		case 0xA1:
			return BlockTypes.LEAVES2;
		case 0xA2:
			return BlockTypes.LOG2;
		case 0xA3:
			return BlockTypes.ACACIA_STAIRS;
		case 0xA4:
			return BlockTypes.DARK_OAK_STAIRS;
		case 0xA5:
			return BlockTypes.SLIME;
		case 0xA6:
			return BlockTypes.BARRIER;
		case 0xA7:
			return BlockTypes.IRON_TRAPDOOR;
		case 0xA8:
			return BlockTypes.PRISMARINE;
		case 0xA9:
			return BlockTypes.SEA_LANTERN;
		case 0xAA:
			return BlockTypes.HAY_BLOCK;
		case 0xAB:
			return BlockTypes.CARPET;
		case 0xAC:
			return BlockTypes.HARDENED_CLAY;
		case 0xAD:
			return BlockTypes.COAL_BLOCK;
		case 0xAE:
			return BlockTypes.PACKED_ICE;
		case 0xAF:
			return BlockTypes.DOUBLE_PLANT;
		case 0xB0:
			return BlockTypes.STANDING_BANNER;
		case 0xB1:
			return BlockTypes.WALL_BANNER;
		case 0xB2:
			return BlockTypes.DAYLIGHT_DETECTOR_INVERTED;
		case 0xB3:
			return BlockTypes.RED_SANDSTONE;
		case 0xB4:
			return BlockTypes.RED_SANDSTONE_STAIRS;
		case 0xB5:
			return BlockTypes.DOUBLE_STONE_SLAB2;
		case 0xB6:
			return BlockTypes.STONE_SLAB2;
		case 0xB7:
			return BlockTypes.SPRUCE_FENCE_GATE;
		case 0xB8:
			return BlockTypes.BIRCH_FENCE_GATE;
		case 0xB9:
			return BlockTypes.JUNGLE_FENCE_GATE;
		case 0xBA:
			return BlockTypes.DARK_OAK_FENCE_GATE;
		case 0xBB:
			return BlockTypes.ACACIA_FENCE_GATE;
		case 0xBC:
			return BlockTypes.SPRUCE_FENCE;
		case 0xBD:
			return BlockTypes.BIRCH_FENCE;
		case 0xBE:
			return BlockTypes.JUNGLE_FENCE;
		case 0xBF:
			return BlockTypes.DARK_OAK_FENCE;
		case 0xC0:
			return BlockTypes.ACACIA_FENCE;
		case 0xC1:
			return BlockTypes.SPRUCE_DOOR;
		case 0xC2:
			return BlockTypes.BIRCH_DOOR;
		case 0xC3:
			return BlockTypes.JUNGLE_DOOR;
		case 0xC4:
			return BlockTypes.ACACIA_DOOR;
		case 0xC5:
			return BlockTypes.DARK_OAK_DOOR;
		case 0xC6:
			return BlockTypes.END_ROD;
		case 0xC7:
			return BlockTypes.CHORUS_PLANT;
		case 0xC8:
			return BlockTypes.CHORUS_FLOWER;
		case 0xC9:
			return BlockTypes.PURPUR_BLOCK;
		case 0xCA:
			return BlockTypes.PURPUR_PILLAR;
		case 0xCB:
			return BlockTypes.PURPUR_STAIRS;
		case 0xCC:
			return BlockTypes.PURPUR_DOUBLE_SLAB;
		case 0xCD:
			return BlockTypes.PURPUR_SLAB;
		case 0xCE:
			return BlockTypes.END_BRICKS;
		case 0xCF:
			return BlockTypes.BEETROOTS;
		case 0xD0:
			return BlockTypes.GRASS_PATH;
		case 0xD1:
			return BlockTypes.END_GATEWAY;
		case 0xD2:
			return BlockTypes.REPEATING_COMMAND_BLOCK;
		case 0xD3:
			return BlockTypes.CHAIN_COMMAND_BLOCK;
		case 0xD4:
			return BlockTypes.FROSTED_ICE;
		case 0xD5:
			return BlockTypes.MAGMA;
		case 0xD6:
			return BlockTypes.NETHER_WART_BLOCK;
		case 0xD7:
			return BlockTypes.RED_NETHER_BRICK;
		case 0xD8:
			return BlockTypes.BONE_BLOCK;
		case 0xD9:
			return BlockTypes.STRUCTURE_VOID;
		case 0xDA:
			return BlockTypes.OBSERVER;
		case 0xDB:
			return BlockTypes.WHITE_SHULKER_BOX;
		case 0xDC:
			return BlockTypes.ORANGE_SHULKER_BOX;
		case 0xDD:
			return BlockTypes.MAGENTA_SHULKER_BOX;
		case 0xDE:
			return BlockTypes.LIGHT_BLUE_SHULKER_BOX;
		case 0xDF:
			return BlockTypes.YELLOW_SHULKER_BOX;
		case 0xE0:
			return BlockTypes.LIME_SHULKER_BOX;
		case 0xE1:
			return BlockTypes.PINK_SHULKER_BOX;
		case 0xE2:
			return BlockTypes.GRAY_SHULKER_BOX;
		case 0xE3:
			return BlockTypes.SILVER_SHULKER_BOX;
		case 0xE4:
			return BlockTypes.CYAN_SHULKER_BOX;
		case 0xE5:
			return BlockTypes.PURPLE_SHULKER_BOX;
		case 0xE6:
			return BlockTypes.BLUE_SHULKER_BOX;
		case 0xE7:
			return BlockTypes.BROWN_SHULKER_BOX;
		case 0xE8:
			return BlockTypes.GREEN_SHULKER_BOX;
		case 0xE9:
			return BlockTypes.RED_SHULKER_BOX;
		case 0xEA:
			return BlockTypes.BLACK_SHULKER_BOX;
		/*case 0xEB:
			return BlockTypes.WHITE_GLAZED_TERRACOTTA;
		case 0xEC:
			return BlockTypes.ORANGE_GLAZED_TERRACOTTA;
		case 0xED:
			return BlockTypes.MAGENTA_GLAZED_TERRACOTTA;
		case 0xEE:
			return BlockTypes.LIGHT_BLUE_GLAZED_TERRACOTTA;
		case 0xEF:
			return BlockTypes.YELLOW_GLAZED_TERRACOTTA;
		case 0xF0:
			return BlockTypes.LIME_GLAZED_TERRACOTTA;
		case 0xF1:
			return BlockTypes.PINK_GLAZED_TERRACOTTA;
		case 0xF2:
			return BlockTypes.GRAY_GLAZED_TERRACOTTA;
		case 0xF3:
			return BlockTypes.SILVER_GLAZED_TERRACOTTA;
		case 0xF4:
			return BlockTypes.CYAN_GLAZED_TERRACOTTA;
		case 0xF5:
			return BlockTypes.PURPLE_GLAZED_TERRACOTTA;
		case 0xF6:
			return BlockTypes.BLUE_GLAZED_TERRACOTTA;
		case 0xF7:
			return BlockTypes.BROWN_GLAZED_TERRACOTTA;
		case 0xF8:
			return BlockTypes.GREEN_GLAZED_TERRACOTTA;
		case 0xF9:
			return BlockTypes.RED_GLAZED_TERRACOTTA;
		case 0xFA:
			return BlockTypes.BLACK_GLAZED_TERRACOTTA;
		case 0xFB:
			return BlockTypes.CONCRETE;
		case 0xFC:
			return BlockTypes.CONCRETE_POWDER;
		case 0xFD:
			return null;
		case 0xFE:
			return null;*/
		case 0xFF:
			return BlockTypes.STRUCTURE_BLOCK;
		default: 
			return null;
		}
	}
	public static String getBlockTextIdFromId(int id)
	{
		switch(id)
		{
		case 0x0:
			return "minecraft:air";
		case 0x1:
			return "minecraft:stone";
		case 0x2:
			return "minecraft:grass";
		case 0x3:
			return "minecraft:dirt";
		case 0x4:
			return "minecraft:cobblestone";
		case 0x5:
			return "minecraft:planks";
		case 0x6:
			return "minecraft:sapling";
		case 0x7:
			return "minecraft:bedrock";
		case 0x8:
			return "minecraft:flowing_water";
		case 0x9:
			return "minecraft:water";
		case 0xA:
			return "minecraft:flowing_lava";
		case 0xB:
			return "minecraft:lava";
		case 0xC:
			return "minecraft:sand";
		case 0xD:
			return "minecraft:gravel";
		case 0xE:
			return "minecraft:gold_ore";
		case 0xF:
			return "minecraft:iron_ore";
		case 0x10:
			return "minecraft:coal_ore";
		case 0x11:
			return "minecraft:log";
		case 0x12:
			return "minecraft:leaves";
		case 0x13:
			return "minecraft:sponge";
		case 0x14:
			return "minecraft:glass";
		case 0x15:
			return "minecraft:lapis_ore";
		case 0x16:
			return "minecraft:lapis_block";
		case 0x17:
			return "minecraft:dispenser";
		case 0x18:
			return "minecraft:sandstone";
		case 0x19:
			return "minecraft:noteblock";
		case 0x1A:
			return "minecraft:bed";
		case 0x1B:
			return "minecraft:golden_rail";
		case 0x1C:
			return "minecraft:detector_rail";
		case 0x1D:
			return "minecraft:sticky_piston";
		case 0x1E:
			return "minecraft:web";
		case 0x1F:
			return "minecraft:tallgrass";
		case 0x20:
			return "minecraft:deadbush";
		case 0x21:
			return "minecraft:piston";
		case 0x22:
			return "minecraft:piston_head";
		case 0x23:
			return "minecraft:wool";
		case 0x24:
			return "minecraft:piston_extension";
		case 0x25:
			return "minecraft:yellow_flower";
		case 0x26:
			return "minecraft:red_flower";
		case 0x27:
			return "minecraft:brown_mushroom";
		case 0x28:
			return "minecraft:red_mushroom";
		case 0x29:
			return "minecraft:gold_block";
		case 0x2A:
			return "minecraft:iron_block";
		case 0x2B:
			return "minecraft:double_stone_slab";
		case 0x2C:
			return "minecraft:stone_slab";
		case 0x2D:
			return "minecraft:brick_block";
		case 0x2E:
			return "minecraft:tnt";
		case 0x2F:
			return "minecraft:bookshelf";
		case 0x30:
			return "minecraft:mossy_cobblestone";
		case 0x31:
			return "minecraft:obsidian";
		case 0x32:
			return "minecraft:torch";
		case 0x33:
			return "minecraft:fire";
		case 0x34:
			return "minecraft:mob_spawner";
		case 0x35:
			return "minecraft:oak_stairs";
		case 0x36:
			return "minecraft:chest";
		case 0x37:
			return "minecraft:redstone_wire";
		case 0x38:
			return "minecraft:diamond_ore";
		case 0x39:
			return "minecraft:diamond_block";
		case 0x3A:
			return "minecraft:crafting_table";
		case 0x3B:
			return "minecraft:wheat";
		case 0x3C:
			return "minecraft:farmland";
		case 0x3D:
			return "minecraft:furnace";
		case 0x3E:
			return "minecraft:lit_furnace";
		case 0x3F:
			return "minecraft:standing_sign";
		case 0x40:
			return "minecraft:wooden_door";
		case 0x41:
			return "minecraft:ladder";
		case 0x42:
			return "minecraft:rail";
		case 0x43:
			return "minecraft:stone_stairs";
		case 0x44:
			return "minecraft:wall_sign";
		case 0x45:
			return "minecraft:lever";
		case 0x46:
			return "minecraft:stone_pressure_plate";
		case 0x47:
			return "minecraft:iron_door";
		case 0x48:
			return "minecraft:wooden_pressure_plate";
		case 0x49:
			return "minecraft:redstone_ore";
		case 0x4A:
			return "minecraft:lit_redstone_ore";
		case 0x4B:
			return "minecraft:unlit_redstone_torch";
		case 0x4C:
			return "minecraft:redstone_torch";
		case 0x4D:
			return "minecraft:stone_button";
		case 0x4E:
			return "minecraft:snow_layer";
		case 0x4F:
			return "minecraft:ice";
		case 0x50:
			return "minecraft:snow";
		case 0x51:
			return "minecraft:cactus";
		case 0x52:
			return "minecraft:clay";
		case 0x53:
			return "minecraft:reeds";
		case 0x54:
			return "minecraft:jukebox";
		case 0x55:
			return "minecraft:fence";
		case 0x56:
			return "minecraft:pumpkin";
		case 0x57:
			return "minecraft:netherrack";
		case 0x58:
			return "minecraft:soul_sand";
		case 0x59:
			return "minecraft:glowstone";
		case 0x5A:
			return "minecraft:portal";
		case 0x5B:
			return "minecraft:lit_pumpkin";
		case 0x5C:
			return "minecraft:cake";
		case 0x5D:
			return "minecraft:unpowered_repeater";
		case 0x5E:
			return "minecraft:powered_repeater";
		case 0x5F:
			return "minecraft:stained_glass";
		case 0x60:
			return "minecraft:trapdoor";
		case 0x61:
			return "minecraft:monster_egg";
		case 0x62:
			return "minecraft:stonebrick";
		case 0x63:
			return "minecraft:brown_mushroom_block";
		case 0x64:
			return "minecraft:red_mushroom_block";
		case 0x65:
			return "minecraft:iron_bars";
		case 0x66:
			return "minecraft:glass_pane";
		case 0x67:
			return "minecraft:melon_block";
		case 0x68:
			return "minecraft:pumpkin_stem";
		case 0x69:
			return "minecraft:melon_stem";
		case 0x6A:
			return "minecraft:vine";
		case 0x6B:
			return "minecraft:fence_gate";
		case 0x6C:
			return "minecraft:brick_stairs";
		case 0x6D:
			return "minecraft:stone_brick_stairs";
		case 0x6E:
			return "minecraft:mycelium";
		case 0x6F:
			return "minecraft:waterlily";
		case 0x70:
			return "minecraft:nether_brick";
		case 0x71:
			return "minecraft:nether_brick_fence";
		case 0x72:
			return "minecraft:nether_brick_stairs";
		case 0x73:
			return "minecraft:nether_wart";
		case 0x74:
			return "minecraft:enchanting_table";
		case 0x75:
			return "minecraft:brewing_stand";
		case 0x76:
			return "minecraft:cauldron";
		case 0x77:
			return "minecraft:end_portal";
		case 0x78:
			return "minecraft:end_portal_frame";
		case 0x79:
			return "minecraft:end_stone";
		case 0x7A:
			return "minecraft:dragon_egg";
		case 0x7B:
			return "minecraft:redstone_lamp";
		case 0x7C:
			return "minecraft:lit_redstone_lamp";
		case 0x7D:
			return "minecraft:double_wooden_slab";
		case 0x7E:
			return "minecraft:wooden_slab";
		case 0x7F:
			return "minecraft:cocoa";
		case 0x80:
			return "minecraft:sandstone_stairs";
		case 0x81:
			return "minecraft:emerald_ore";
		case 0x82:
			return "minecraft:ender_chest";
		case 0x83:
			return "minecraft:tripwire_hook";
		case 0x84:
			return "minecraft:tripwire";
		case 0x85:
			return "minecraft:emerald_block";
		case 0x86:
			return "minecraft:spruce_stairs";
		case 0x87:
			return "minecraft:birch_stairs";
		case 0x88:
			return "minecraft:jungle_stairs";
		case 0x89:
			return "minecraft:command_block";
		case 0x8A:
			return "minecraft:beacon";
		case 0x8B:
			return "minecraft:cobblestone_wall";
		case 0x8C:
			return "minecraft:flower_pot";
		case 0x8D:
			return "minecraft:carrots";
		case 0x8E:
			return "minecraft:potatoes";
		case 0x8F:
			return "minecraft:wooden_button";
		case 0x90:
			return "minecraft:skull";
		case 0x91:
			return "minecraft:anvil";
		case 0x92:
			return "minecraft:trapped_chest";
		case 0x93:
			return "minecraft:light_weighted_pressure_plate";
		case 0x94:
			return "minecraft:heavy_weighted_pressure_plate";
		case 0x95:
			return "minecraft:unpowered_comparator";
		case 0x96:
			return "minecraft:powered_comparator";
		case 0x97:
			return "minecraft:daylight_detector";
		case 0x98:
			return "minecraft:redstone_block";
		case 0x99:
			return "minecraft:quartz_ore";
		case 0x9A:
			return "minecraft:hopper";
		case 0x9B:
			return "minecraft:quartz_block";
		case 0x9C:
			return "minecraft:quartz_stairs";
		case 0x9D:
			return "minecraft:activator_rail";
		case 0x9E:
			return "minecraft:dropper";
		case 0x9F:
			return "minecraft:stained_hardened_clay";
		case 0xA0:
			return "minecraft:stained_glass_pane";
		case 0xA1:
			return "minecraft:leaves2";
		case 0xA2:
			return "minecraft:log2";
		case 0xA3:
			return "minecraft:acacia_stairs";
		case 0xA4:
			return "minecraft:dark_oak_stairs";
		case 0xA5:
			return "minecraft:slime";
		case 0xA6:
			return "minecraft:barrier";
		case 0xA7:
			return "minecraft:iron_trapdoor";
		case 0xA8:
			return "minecraft:prismarine";
		case 0xA9:
			return "minecraft:sea_lantern";
		case 0xAA:
			return "minecraft:hay_block";
		case 0xAB:
			return "minecraft:carpet";
		case 0xAC:
			return "minecraft:hardened_clay";
		case 0xAD:
			return "minecraft:coal_block";
		case 0xAE:
			return "minecraft:packed_ice";
		case 0xAF:
			return "minecraft:double_plant";
		case 0xB0:
			return "minecraft:standing_banner";
		case 0xB1:
			return "minecraft:wall_banner";
		case 0xB2:
			return "minecraft:daylight_detector_inverted";
		case 0xB3:
			return "minecraft:red_sandstone";
		case 0xB4:
			return "minecraft:red_sandstone_stairs";
		case 0xB5:
			return "minecraft:double_stone_slab2";
		case 0xB6:
			return "minecraft:stone_slab2";
		case 0xB7:
			return "minecraft:spruce_fence_gate";
		case 0xB8:
			return "minecraft:birch_fence_gate";
		case 0xB9:
			return "minecraft:jungle_fence_gate";
		case 0xBA:
			return "minecraft:dark_oak_fence_gate";
		case 0xBB:
			return "minecraft:acacia_fence_gate";
		case 0xBC:
			return "minecraft:spruce_fence";
		case 0xBD:
			return "minecraft:birch_fence";
		case 0xBE:
			return "minecraft:jungle_fence";
		case 0xBF:
			return "minecraft:dark_oak_fence";
		case 0xC0:
			return "minecraft:acacia_fence";
		case 0xC1:
			return "minecraft:spruce_door";
		case 0xC2:
			return "minecraft:birch_door";
		case 0xC3:
			return "minecraft:jungle_door";
		case 0xC4:
			return "minecraft:acacia_door";
		case 0xC5:
			return "minecraft:dark_oak_door";
		case 0xC6:
			return "minecraft:end_rod";
		case 0xC7:
			return "minecraft:chorus_plant";
		case 0xC8:
			return "minecraft:chorus_flower";
		case 0xC9:
			return "minecraft:purpur_block";
		case 0xCA:
			return "minecraft:purpur_pillar";
		case 0xCB:
			return "minecraft:purpur_stairs";
		case 0xCC:
			return "minecraft:purpur_double_slab";
		case 0xCD:
			return "minecraft:purpur_slab";
		case 0xCE:
			return "minecraft:end_bricks";
		case 0xCF:
			return "minecraft:beetroots";
		case 0xD0:
			return "minecraft:grass_path";
		case 0xD1:
			return "minecraft:end_gateway";
		case 0xD2:
			return "minecraft:repeating_command_block";
		case 0xD3:
			return "minecraft:chain_command_block";
		case 0xD4:
			return "minecraft:frosted_ice";
		case 0xD5:
			return "minecraft:magma";
		case 0xD6:
			return "minecraft:nether_wart_block";
		case 0xD7:
			return "minecraft:red_nether_brick";
		case 0xD8:
			return "minecraft:bone_block";
		case 0xD9:
			return "minecraft:structure_void";
		case 0xDA:
			return "minecraft:observer";
		case 0xDB:
			return "minecraft:white_shulker_box";
		case 0xDC:
			return "minecraft:orange_shulker_box";
		case 0xDD:
			return "minecraft:magenta_shulker_box";
		case 0xDE:
			return "minecraft:light_blue_shulker_box";
		case 0xDF:
			return "minecraft:yellow_shulker_box";
		case 0xE0:
			return "minecraft:lime_shulker_box";
		case 0xE1:
			return "minecraft:pink_shulker_box";
		case 0xE2:
			return "minecraft:gray_shulker_box";
		case 0xE3:
			return "minecraft:silver_shulker_box";
		case 0xE4:
			return "minecraft:cyan_shulker_box";
		case 0xE5:
			return "minecraft:purple_shulker_box";
		case 0xE6:
			return "minecraft:blue_shulker_box";
		case 0xE7:
			return "minecraft:brown_shulker_box";
		case 0xE8:
			return "minecraft:green_shulker_box";
		case 0xE9:
			return "minecraft:red_shulker_box";
		case 0xEA:
			return "minecraft:black_shulker_box";
		case 0xEB:
			return "minecraft:white_glazed_terracotta";
		case 0xEC:
			return "minecraft:orange_glazed_terracotta";
		case 0xED:
			return "minecraft:magenta_glazed_terracotta";
		case 0xEE:
			return "minecraft:light_blue_glazed_terracotta";
		case 0xEF:
			return "minecraft:yellow_glazed_terracotta";
		case 0xF0:
			return "minecraft:lime_glazed_terracotta";
		case 0xF1:
			return "minecraft:pink_glazed_terracotta";
		case 0xF2:
			return "minecraft:gray_glazed_terracotta";
		case 0xF3:
			return "minecraft:silver_glazed_terracotta";
		case 0xF4:
			return "minecraft:cyan_glazed_terracotta";
		case 0xF5:
			return "minecraft:purple_glazed_terracotta";
		case 0xF6:
			return "minecraft:blue_glazed_terracotta";
		case 0xF7:
			return "minecraft:brown_glazed_terracotta";
		case 0xF8:
			return "minecraft:green_glazed_terracotta";
		case 0xF9:
			return "minecraft:red_glazed_terracotta";
		case 0xFA:
			return "minecraft:black_glazed_terracotta";
		case 0xFB:
			return "minecraft:concrete";
		case 0xFC:
			return "minecraft:concrete_powder";
		case 0xFD:
			return null;
		case 0xFE:
			return null;
		case 0xFF:
			return "minecraft:structure_block";
		default: 
			return null;
		}
	}
	public static String getBlockNameFromId(int id)
	{
		switch(id)
		{
		case 0x0:
			return "Air";
		case 0x1:
			return "Stone";
		case 0x2:
			return "Grass Block";
		case 0x3:
			return "Dirt";
		case 0x4:
			return "Cobblestone";
		case 0x5:
			return "Wood Planks";
		case 0x6:
			return "Sapling";
		case 0x7:
			return "Bedrock";
		case 0x8:
			return "Water";
		case 0x9:
			return "Stationary Water";
		case 0xA:
			return "Lava";
		case 0xB:
			return "Stationary Lava";
		case 0xC:
			return "Sand";
		case 0xD:
			return "Gravel";
		case 0xE:
			return "Gold Ore";
		case 0xF:
			return "Iron Ore";
		case 0x10:
			return "Coal Ore";
		case 0x11:
			return "Wood";
		case 0x12:
			return "Leaves";
		case 0x13:
			return "Sponge";
		case 0x14:
			return "Glass";
		case 0x15:
			return "Lapis Lazuli Ore";
		case 0x16:
			return "Lapis Lazuli Block";
		case 0x17:
			return "Dispenser";
		case 0x18:
			return "Sandstone";
		case 0x19:
			return "Note Block";
		case 0x1A:
			return "Bed";
		case 0x1B:
			return "Powered Rail";
		case 0x1C:
			return "Detector Rail";
		case 0x1D:
			return "Sticky Piston";
		case 0x1E:
			return "Cobweb";
		case 0x1F:
			return "Grass";
		case 0x20:
			return "Dead Bush";
		case 0x21:
			return "Piston";
		case 0x22:
			return "Piston Head";
		case 0x23:
			return "Wool";
		case 0x24:
			return "Block moved by Piston";
		case 0x25:
			return "Dandelion";
		case 0x26:
			return "Poppy";
		case 0x27:
			return "Brown Mushroom";
		case 0x28:
			return "Red Mushroom";
		case 0x29:
			return "Block of Gold";
		case 0x2A:
			return "Block of Iron";
		case 0x2B:
			return "Double Stone Slab";
		case 0x2C:
			return "Stone Slab";
		case 0x2D:
			return "Bricks";
		case 0x2E:
			return "TNT";
		case 0x2F:
			return "Bookshelf";
		case 0x30:
			return "Moss Stone";
		case 0x31:
			return "Obsidian";
		case 0x32:
			return "Torch";
		case 0x33:
			return "Fire";
		case 0x34:
			return "Monster Spawner";
		case 0x35:
			return "Oak Wood Stairs";
		case 0x36:
			return "Chest";
		case 0x37:
			return "Redstone Wire";
		case 0x38:
			return "Diamond Ore";
		case 0x39:
			return "Block of Diamond";
		case 0x3A:
			return "Crafting Table";
		case 0x3B:
			return "Wheat";
		case 0x3C:
			return "Farmland";
		case 0x3D:
			return "Furnace";
		case 0x3E:
			return "Burning Furnace";
		case 0x3F:
			return "Standing Sign";
		case 0x40:
			return "Oak Door";
		case 0x41:
			return "Ladder";
		case 0x42:
			return "Rail";
		case 0x43:
			return "Cobblestone Stairs";
		case 0x44:
			return "Wall Sign";
		case 0x45:
			return "Lever";
		case 0x46:
			return "Stone Pressure Plate";
		case 0x47:
			return "Iron Door";
		case 0x48:
			return "Wooden Pressure Plate";
		case 0x49:
			return "Redstone Ore";
		case 0x4A:
			return "Glowing Redstone Ore";
		case 0x4B:
			return "Redstone Torch (inactive)";
		case 0x4C:
			return "Redstone Torch (active)";
		case 0x4D:
			return "Stone Button";
		case 0x4E:
			return "Snow (layer)";
		case 0x4F:
			return "Ice";
		case 0x50:
			return "Snow";
		case 0x51:
			return "Cactus";
		case 0x52:
			return "Clay";
		case 0x53:
			return "Sugar Cane";
		case 0x54:
			return "Jukebox";
		case 0x55:
			return "Oak Fence";
		case 0x56:
			return "Pumpkin";
		case 0x57:
			return "Netherrack";
		case 0x58:
			return "Soul Sand";
		case 0x59:
			return "Glowstone";
		case 0x5A:
			return "Nether Portal";
		case 0x5B:
			return "Jack o'Lantern";
		case 0x5C:
			return "Cake";
		case 0x5D:
			return "Redstone Repeater (inactive)";
		case 0x5E:
			return "Redstone Repeater (active)";
		case 0x5F:
			return "Stained Glass";
		case 0x60:
			return "Trapdoor";
		case 0x61:
			return "Monster Egg";
		case 0x62:
			return "Stone Bricks";
		case 0x63:
			return "Brown Mushroom (block)";
		case 0x64:
			return "Red Mushroom (block)";
		case 0x65:
			return "Iron Bars";
		case 0x66:
			return "Glass Pane";
		case 0x67:
			return "Melon";
		case 0x68:
			return "Pumpkin Stem";
		case 0x69:
			return "Melon Stem";
		case 0x6A:
			return "Vines";
		case 0x6B:
			return "Fence Gate";
		case 0x6C:
			return "Brick Stairs";
		case 0x6D:
			return "Stone Brick Stairs";
		case 0x6E:
			return "Mycelium";
		case 0x6F:
			return "Lily Pad";
		case 0x70:
			return "Nether Brick";
		case 0x71:
			return "Nether Brick Fence";
		case 0x72:
			return "Nether Brick Stairs";
		case 0x73:
			return "Nether Wart";
		case 0x74:
			return "Enchantment Table";
		case 0x75:
			return "Brewing Stand";
		case 0x76:
			return "Cauldron";
		case 0x77:
			return "End Portal";
		case 0x78:
			return "End Portal Frame";
		case 0x79:
			return "End Stone";
		case 0x7A:
			return "Dragon Egg";
		case 0x7B:
			return "Redstone Lamp (inactive)";
		case 0x7C:
			return "Redstone Lamp (active)";
		case 0x7D:
			return "Double Wooden Slab";
		case 0x7E:
			return "Wooden Slab";
		case 0x7F:
			return "Cocoa";
		case 0x80:
			return "Sandstone Stairs";
		case 0x81:
			return "Emerald Ore";
		case 0x82:
			return "Ender Chest";
		case 0x83:
			return "Tripwire Hook";
		case 0x84:
			return "Tripwire";
		case 0x85:
			return "Block of Emerald";
		case 0x86:
			return "Spruce Wood Stairs";
		case 0x87:
			return "Birch Wood Stairs";
		case 0x88:
			return "Jungle Wood Stairs";
		case 0x89:
			return "Command Block";
		case 0x8A:
			return "Beacon";
		case 0x8B:
			return "Cobblestone Wall";
		case 0x8C:
			return "Flower Pot";
		case 0x8D:
			return "Carrot";
		case 0x8E:
			return "Potato";
		case 0x8F:
			return "Wooden Button";
		case 0x90:
			return "Mob head";
		case 0x91:
			return "Anvil";
		case 0x92:
			return "Trapped Chest";
		case 0x93:
			return "Weighted Pressure Plate (Light)";
		case 0x94:
			return "Weighted Pressure Plate (Heavy)";
		case 0x95:
			return "Redstone Comparator";
		case 0x96:
			return "Redstone Comparator (deprecated)";
		case 0x97:
			return "Daylight Sensor";
		case 0x98:
			return "Block of Redstone";
		case 0x99:
			return "Nether Quartz Ore";
		case 0x9A:
			return "Hopper";
		case 0x9B:
			return "Block of Quartz";
		case 0x9C:
			return "Quartz Stairs";
		case 0x9D:
			return "Activator Rail";
		case 0x9E:
			return "Dropper";
		case 0x9F:
			return "Stained Clay";
		case 0xA0:
			return "Stained Glass Pane";
		case 0xA1:
			return "Leaves (Acacia/Dark Oak)";
		case 0xA2:
			return "Wood (Acacia/Dark Oak)";
		case 0xA3:
			return "Acacia Wood Stairs";
		case 0xA4:
			return "Dark Oak Wood Stairs";
		case 0xA5:
			return "Slime Block";
		case 0xA6:
			return "Barrier";
		case 0xA7:
			return "Iron Trapdoor";
		case 0xA8:
			return "Prismarine";
		case 0xA9:
			return "Sea Lantern";
		case 0xAA:
			return "Hay Bale";
		case 0xAB:
			return "Carpet";
		case 0xAC:
			return "Hardened Clay";
		case 0xAD:
			return "Block of Coal";
		case 0xAE:
			return "Packed Ice";
		case 0xAF:
			return "Large Flowers";
		case 0xB0:
			return "Standing Banner";
		case 0xB1:
			return "Wall Banner";
		case 0xB2:
			return "Inverted Daylight Sensor";
		case 0xB3:
			return "Red Sandstone";
		case 0xB4:
			return "Red Sandstone Stairs";
		case 0xB5:
			return "Double Red Sandstone Slab";
		case 0xB6:
			return "Red Sandstone Slab";
		case 0xB7:
			return "Spruce Fence Gate";
		case 0xB8:
			return "Birch Fence Gate";
		case 0xB9:
			return "Jungle Fence Gate";
		case 0xBA:
			return "Dark Oak Fence Gate";
		case 0xBB:
			return "Acacia Fence Gate";
		case 0xBC:
			return "Spruce Fence";
		case 0xBD:
			return "Birch Fence";
		case 0xBE:
			return "Jungle Fence";
		case 0xBF:
			return "Dark Oak Fence";
		case 0xC0:
			return "Acacia Fence";
		case 0xC1:
			return "Spruce Door";
		case 0xC2:
			return "Birch Door";
		case 0xC3:
			return "Jungle Door";
		case 0xC4:
			return "Acacia Door";
		case 0xC5:
			return "Dark Oak Door";
		case 0xC6:
			return "End Rod";
		case 0xC7:
			return "Chorus Plant";
		case 0xC8:
			return "Chorus Flower";
		case 0xC9:
			return "Purpur Block";
		case 0xCA:
			return "Purpur Pillar";
		case 0xCB:
			return "Purpur Stairs";
		case 0xCC:
			return "Purpur Double Slab";
		case 0xCD:
			return "Purpur Slab";
		case 0xCE:
			return "End Stone Bricks";
		case 0xCF:
			return "Beetroot Seeds";
		case 0xD0:
			return "Grass Path";
		case 0xD1:
			return "End Gateway";
		case 0xD2:
			return "Repeating Command Block";
		case 0xD3:
			return "Chain Command Block";
		case 0xD4:
			return "Frosted Ice";
		case 0xD5:
			return "Magma Block";
		case 0xD6:
			return "Nether Wart Block";
		case 0xD7:
			return "Red Nether Brick";
		case 0xD8:
			return "Bone Block";
		case 0xD9:
			return "Structure Void";
		case 0xDA:
			return "Observer";
		case 0xDB:
			return "White Shulker Box";
		case 0xDC:
			return "Orange Shulker Box";
		case 0xDD:
			return "Magenta Shulker Box";
		case 0xDE:
			return "Light Blue Shulker Box";
		case 0xDF:
			return "Yellow Shulker Box";
		case 0xE0:
			return "Lime Shulker Box";
		case 0xE1:
			return "Pink Shulker Box";
		case 0xE2:
			return "Gray Shulker Box";
		case 0xE3:
			return "Light Gray Shulker Box";
		case 0xE4:
			return "Cyan Shulker Box";
		case 0xE5:
			return "Purple Shulker Box";
		case 0xE6:
			return "Blue Shulker Box";
		case 0xE7:
			return "Brown Shulker Box";
		case 0xE8:
			return "Green Shulker Box";
		case 0xE9:
			return "Red Shulker Box";
		case 0xEA:
			return "Black Shulker Box";
		case 0xEB:
			return "White Glazed Terracotta";
		case 0xEC:
			return "Orange Glazed Terracotta";
		case 0xED:
			return "Magenta Glazed Terracotta";
		case 0xEE:
			return "Light Blue Glazed Terracotta";
		case 0xEF:
			return "Yellow Glazed Terracotta";
		case 0xF0:
			return "Lime Glazed Terracotta";
		case 0xF1:
			return "Pink Glazed Terracotta";
		case 0xF2:
			return "Gray Glazed Terracotta";
		case 0xF3:
			return "Light Gray Glazed Terracotta";
		case 0xF4:
			return "Cyan Glazed Terracotta";
		case 0xF5:
			return "Purple Glazed Terracotta";
		case 0xF6:
			return "Blue Glazed Terracotta";
		case 0xF7:
			return "Brown Glazed Terracotta";
		case 0xF8:
			return "Green Glazed Terracotta";
		case 0xF9:
			return "Red Glazed Terracotta";
		case 0xFA:
			return "Black Glazed Terracotta";
		case 0xFB:
			return "Concrete";
		case 0xFC:
			return "Concrete Powder";
		case 0xFD:
			return "(unused)";
		case 0xFE:
			return "(unused)";
		case 0xFF:
			return "Structure Block";
		default: 
			return null;
		}
	}
	public static BlockType getBlockTypeFromBlockId(String blockId)
	{
		switch(blockId)
		{
		case "minecraft:air":
			return BlockTypes.AIR;
		case "minecraft:stone":
			return BlockTypes.STONE;
		case "minecraft:grass":
			return BlockTypes.GRASS;
		case "minecraft:dirt":
			return BlockTypes.DIRT;
		case "minecraft:cobblestone":
			return BlockTypes.COBBLESTONE;
		case "minecraft:planks":
			return BlockTypes.PLANKS;
		case "minecraft:sapling":
			return BlockTypes.SAPLING;
		case "minecraft:bedrock":
			return BlockTypes.BEDROCK;
		case "minecraft:flowing_water":
			return BlockTypes.FLOWING_WATER;
		case "minecraft:water":
			return BlockTypes.WATER;
		case "minecraft:flowing_lava":
			return BlockTypes.FLOWING_LAVA;
		case "minecraft:lava":
			return BlockTypes.LAVA;
		case "minecraft:sand":
			return BlockTypes.SAND;
		case "minecraft:gravel":
			return BlockTypes.GRAVEL;
		case "minecraft:gold_ore":
			return BlockTypes.GOLD_ORE;
		case "minecraft:iron_ore":
			return BlockTypes.IRON_ORE;
		case "minecraft:coal_ore":
			return BlockTypes.COAL_ORE;
		case "minecraft:log":
			return BlockTypes.LOG;
		case "minecraft:leaves":
			return BlockTypes.LEAVES;
		case "minecraft:sponge":
			return BlockTypes.SPONGE;
		case "minecraft:glass":
			return BlockTypes.GLASS;
		case "minecraft:lapis_ore":
			return BlockTypes.LAPIS_ORE;
		case "minecraft:lapis_block":
			return BlockTypes.LAPIS_BLOCK;
		case "minecraft:dispenser":
			return BlockTypes.DISPENSER;
		case "minecraft:sandstone":
			return BlockTypes.SANDSTONE;
		case "minecraft:noteblock":
			return BlockTypes.NOTEBLOCK;
		case "minecraft:bed":
			return BlockTypes.BED;
		case "minecraft:golden_rail":
			return BlockTypes.GOLDEN_RAIL;
		case "minecraft:detector_rail":
			return BlockTypes.DETECTOR_RAIL;
		case "minecraft:sticky_piston":
			return BlockTypes.STICKY_PISTON;
		case "minecraft:web":
			return BlockTypes.WEB;
		case "minecraft:tallgrass":
			return BlockTypes.TALLGRASS;
		case "minecraft:deadbush":
			return BlockTypes.DEADBUSH;
		case "minecraft:piston":
			return BlockTypes.PISTON;
		case "minecraft:piston_head":
			return BlockTypes.PISTON_HEAD;
		case "minecraft:wool":
			return BlockTypes.WOOL;
		case "minecraft:piston_extension":
			return BlockTypes.PISTON_EXTENSION;
		case "minecraft:yellow_flower":
			return BlockTypes.YELLOW_FLOWER;
		case "minecraft:red_flower":
			return BlockTypes.RED_FLOWER;
		case "minecraft:brown_mushroom":
			return BlockTypes.BROWN_MUSHROOM;
		case "minecraft:red_mushroom":
			return BlockTypes.RED_MUSHROOM;
		case "minecraft:gold_block":
			return BlockTypes.GOLD_BLOCK;
		case "minecraft:iron_block":
			return BlockTypes.IRON_BLOCK;
		case "minecraft:double_stone_slab":
			return BlockTypes.DOUBLE_STONE_SLAB;
		case "minecraft:stone_slab":
			return BlockTypes.STONE_SLAB;
		case "minecraft:brick_block":
			return BlockTypes.BRICK_BLOCK;
		case "minecraft:tnt":
			return BlockTypes.TNT;
		case "minecraft:bookshelf":
			return BlockTypes.BOOKSHELF;
		case "minecraft:mossy_cobblestone":
			return BlockTypes.MOSSY_COBBLESTONE;
		case "minecraft:obsidian":
			return BlockTypes.OBSIDIAN;
		case "minecraft:torch":
			return BlockTypes.TORCH;
		case "minecraft:fire":
			return BlockTypes.FIRE;
		case "minecraft:mob_spawner":
			return BlockTypes.MOB_SPAWNER;
		case "minecraft:oak_stairs":
			return BlockTypes.OAK_STAIRS;
		case "minecraft:chest":
			return BlockTypes.CHEST;
		case "minecraft:redstone_wire":
			return BlockTypes.REDSTONE_WIRE;
		case "minecraft:diamond_ore":
			return BlockTypes.DIAMOND_ORE;
		case "minecraft:diamond_block":
			return BlockTypes.DIAMOND_BLOCK;
		case "minecraft:crafting_table":
			return BlockTypes.CRAFTING_TABLE;
		case "minecraft:wheat":
			return BlockTypes.WHEAT;
		case "minecraft:farmland":
			return BlockTypes.FARMLAND;
		case "minecraft:furnace":
			return BlockTypes.FURNACE;
		case "minecraft:lit_furnace":
			return BlockTypes.LIT_FURNACE;
		case "minecraft:standing_sign":
			return BlockTypes.STANDING_SIGN;
		case "minecraft:wooden_door":
			return BlockTypes.WOODEN_DOOR;
		case "minecraft:ladder":
			return BlockTypes.LADDER;
		case "minecraft:rail":
			return BlockTypes.RAIL;
		case "minecraft:stone_stairs":
			return BlockTypes.STONE_STAIRS;
		case "minecraft:wall_sign":
			return BlockTypes.WALL_SIGN;
		case "minecraft:lever":
			return BlockTypes.LEVER;
		case "minecraft:stone_pressure_plate":
			return BlockTypes.STONE_PRESSURE_PLATE;
		case "minecraft:iron_door":
			return BlockTypes.IRON_DOOR;
		case "minecraft:wooden_pressure_plate":
			return BlockTypes.WOODEN_PRESSURE_PLATE;
		case "minecraft:redstone_ore":
			return BlockTypes.REDSTONE_ORE;
		case "minecraft:lit_redstone_ore":
			return BlockTypes.LIT_REDSTONE_ORE;
		case "minecraft:unlit_redstone_torch":
			return BlockTypes.UNLIT_REDSTONE_TORCH;
		case "minecraft:redstone_torch":
			return BlockTypes.REDSTONE_TORCH;
		case "minecraft:stone_button":
			return BlockTypes.STONE_BUTTON;
		case "minecraft:snow_layer":
			return BlockTypes.SNOW_LAYER;
		case "minecraft:ice":
			return BlockTypes.ICE;
		case "minecraft:snow":
			return BlockTypes.SNOW;
		case "minecraft:cactus":
			return BlockTypes.CACTUS;
		case "minecraft:clay":
			return BlockTypes.CLAY;
		case "minecraft:reeds":
			return BlockTypes.REEDS;
		case "minecraft:jukebox":
			return BlockTypes.JUKEBOX;
		case "minecraft:fence":
			return BlockTypes.FENCE;
		case "minecraft:pumpkin":
			return BlockTypes.PUMPKIN;
		case "minecraft:netherrack":
			return BlockTypes.NETHERRACK;
		case "minecraft:soul_sand":
			return BlockTypes.SOUL_SAND;
		case "minecraft:glowstone":
			return BlockTypes.GLOWSTONE;
		case "minecraft:portal":
			return BlockTypes.PORTAL;
		case "minecraft:lit_pumpkin":
			return BlockTypes.LIT_PUMPKIN;
		case "minecraft:cake":
			return BlockTypes.CAKE;
		case "minecraft:unpowered_repeater":
			return BlockTypes.UNPOWERED_REPEATER;
		case "minecraft:powered_repeater":
			return BlockTypes.POWERED_REPEATER;
		case "minecraft:stained_glass":
			return BlockTypes.STAINED_GLASS;
		case "minecraft:trapdoor":
			return BlockTypes.TRAPDOOR;
		case "minecraft:monster_egg":
			return BlockTypes.MONSTER_EGG;
		case "minecraft:stonebrick":
			return BlockTypes.STONEBRICK;
		case "minecraft:brown_mushroom_block":
			return BlockTypes.BROWN_MUSHROOM_BLOCK;
		case "minecraft:red_mushroom_block":
			return BlockTypes.RED_MUSHROOM_BLOCK;
		case "minecraft:iron_bars":
			return BlockTypes.IRON_BARS;
		case "minecraft:glass_pane":
			return BlockTypes.GLASS_PANE;
		case "minecraft:melon_block":
			return BlockTypes.MELON_BLOCK;
		case "minecraft:pumpkin_stem":
			return BlockTypes.PUMPKIN_STEM;
		case "minecraft:melon_stem":
			return BlockTypes.MELON_STEM;
		case "minecraft:vine":
			return BlockTypes.VINE;
		case "minecraft:fence_gate":
			return BlockTypes.FENCE_GATE;
		case "minecraft:brick_stairs":
			return BlockTypes.BRICK_STAIRS;
		case "minecraft:stone_brick_stairs":
			return BlockTypes.STONE_BRICK_STAIRS;
		case "minecraft:mycelium":
			return BlockTypes.MYCELIUM;
		case "minecraft:waterlily":
			return BlockTypes.WATERLILY;
		case "minecraft:nether_brick":
			return BlockTypes.NETHER_BRICK;
		case "minecraft:nether_brick_fence":
			return BlockTypes.NETHER_BRICK_FENCE;
		case "minecraft:nether_brick_stairs":
			return BlockTypes.NETHER_BRICK_STAIRS;
		case "minecraft:nether_wart":
			return BlockTypes.NETHER_WART;
		case "minecraft:enchanting_table":
			return BlockTypes.ENCHANTING_TABLE;
		case "minecraft:brewing_stand":
			return BlockTypes.BREWING_STAND;
		case "minecraft:cauldron":
			return BlockTypes.CAULDRON;
		case "minecraft:end_portal":
			return BlockTypes.END_PORTAL;
		case "minecraft:end_portal_frame":
			return BlockTypes.END_PORTAL_FRAME;
		case "minecraft:end_stone":
			return BlockTypes.END_STONE;
		case "minecraft:dragon_egg":
			return BlockTypes.DRAGON_EGG;
		case "minecraft:redstone_lamp":
			return BlockTypes.REDSTONE_LAMP;
		case "minecraft:lit_redstone_lamp":
			return BlockTypes.LIT_REDSTONE_LAMP;
		case "minecraft:double_wooden_slab":
			return BlockTypes.DOUBLE_WOODEN_SLAB;
		case "minecraft:wooden_slab":
			return BlockTypes.WOODEN_SLAB;
		case "minecraft:cocoa":
			return BlockTypes.COCOA;
		case "minecraft:sandstone_stairs":
			return BlockTypes.SANDSTONE_STAIRS;
		case "minecraft:emerald_ore":
			return BlockTypes.EMERALD_ORE;
		case "minecraft:ender_chest":
			return BlockTypes.ENDER_CHEST;
		case "minecraft:tripwire_hook":
			return BlockTypes.TRIPWIRE_HOOK;
		case "minecraft:tripwire":
			return BlockTypes.TRIPWIRE;
		case "minecraft:emerald_block":
			return BlockTypes.EMERALD_BLOCK;
		case "minecraft:spruce_stairs":
			return BlockTypes.SPRUCE_STAIRS;
		case "minecraft:birch_stairs":
			return BlockTypes.BIRCH_STAIRS;
		case "minecraft:jungle_stairs":
			return BlockTypes.JUNGLE_STAIRS;
		case "minecraft:command_block":
			return BlockTypes.COMMAND_BLOCK;
		case "minecraft:beacon":
			return BlockTypes.BEACON;
		case "minecraft:cobblestone_wall":
			return BlockTypes.COBBLESTONE_WALL;
		case "minecraft:flower_pot":
			return BlockTypes.FLOWER_POT;
		case "minecraft:carrots":
			return BlockTypes.CARROTS;
		case "minecraft:potatoes":
			return BlockTypes.POTATOES;
		case "minecraft:wooden_button":
			return BlockTypes.WOODEN_BUTTON;
		case "minecraft:skull":
			return BlockTypes.SKULL;
		case "minecraft:anvil":
			return BlockTypes.ANVIL;
		case "minecraft:trapped_chest":
			return BlockTypes.TRAPPED_CHEST;
		case "minecraft:light_weighted_pressure_plate":
			return BlockTypes.LIGHT_WEIGHTED_PRESSURE_PLATE;
		case "minecraft:heavy_weighted_pressure_plate":
			return BlockTypes.HEAVY_WEIGHTED_PRESSURE_PLATE;
		case "minecraft:unpowered_comparator":
			return BlockTypes.UNPOWERED_COMPARATOR;
		case "minecraft:powered_comparator":
			return BlockTypes.POWERED_COMPARATOR;
		case "minecraft:daylight_detector":
			return BlockTypes.DAYLIGHT_DETECTOR;
		case "minecraft:redstone_block":
			return BlockTypes.REDSTONE_BLOCK;
		case "minecraft:quartz_ore":
			return BlockTypes.QUARTZ_ORE;
		case "minecraft:hopper":
			return BlockTypes.HOPPER;
		case "minecraft:quartz_block":
			return BlockTypes.QUARTZ_BLOCK;
		case "minecraft:quartz_stairs":
			return BlockTypes.QUARTZ_STAIRS;
		case "minecraft:activator_rail":
			return BlockTypes.ACTIVATOR_RAIL;
		case "minecraft:dropper":
			return BlockTypes.DROPPER;
		case "minecraft:stained_hardened_clay":
			return BlockTypes.STAINED_HARDENED_CLAY;
		case "minecraft:stained_glass_pane":
			return BlockTypes.STAINED_GLASS_PANE;
		case "minecraft:leaves2":
			return BlockTypes.LEAVES2;
		case "minecraft:log2":
			return BlockTypes.LOG2;
		case "minecraft:acacia_stairs":
			return BlockTypes.ACACIA_STAIRS;
		case "minecraft:dark_oak_stairs":
			return BlockTypes.DARK_OAK_STAIRS;
		case "minecraft:slime":
			return BlockTypes.SLIME;
		case "minecraft:barrier":
			return BlockTypes.BARRIER;
		case "minecraft:iron_trapdoor":
			return BlockTypes.IRON_TRAPDOOR;
		case "minecraft:prismarine":
			return BlockTypes.PRISMARINE;
		case "minecraft:sea_lantern":
			return BlockTypes.SEA_LANTERN;
		case "minecraft:hay_block":
			return BlockTypes.HAY_BLOCK;
		case "minecraft:carpet":
			return BlockTypes.CARPET;
		case "minecraft:hardened_clay":
			return BlockTypes.HARDENED_CLAY;
		case "minecraft:coal_block":
			return BlockTypes.COAL_BLOCK;
		case "minecraft:packed_ice":
			return BlockTypes.PACKED_ICE;
		case "minecraft:double_plant":
			return BlockTypes.DOUBLE_PLANT;
		case "minecraft:standing_banner":
			return BlockTypes.STANDING_BANNER;
		case "minecraft:wall_banner":
			return BlockTypes.WALL_BANNER;
		case "minecraft:daylight_detector_inverted":
			return BlockTypes.DAYLIGHT_DETECTOR_INVERTED;
		case "minecraft:red_sandstone":
			return BlockTypes.RED_SANDSTONE;
		case "minecraft:red_sandstone_stairs":
			return BlockTypes.RED_SANDSTONE_STAIRS;
		case "minecraft:double_stone_slab2":
			return BlockTypes.DOUBLE_STONE_SLAB2;
		case "minecraft:stone_slab2":
			return BlockTypes.STONE_SLAB2;
		case "minecraft:spruce_fence_gate":
			return BlockTypes.SPRUCE_FENCE_GATE;
		case "minecraft:birch_fence_gate":
			return BlockTypes.BIRCH_FENCE_GATE;
		case "minecraft:jungle_fence_gate":
			return BlockTypes.JUNGLE_FENCE_GATE;
		case "minecraft:dark_oak_fence_gate":
			return BlockTypes.DARK_OAK_FENCE_GATE;
		case "minecraft:acacia_fence_gate":
			return BlockTypes.ACACIA_FENCE_GATE;
		case "minecraft:spruce_fence":
			return BlockTypes.SPRUCE_FENCE;
		case "minecraft:birch_fence":
			return BlockTypes.BIRCH_FENCE;
		case "minecraft:jungle_fence":
			return BlockTypes.JUNGLE_FENCE;
		case "minecraft:dark_oak_fence":
			return BlockTypes.DARK_OAK_FENCE;
		case "minecraft:acacia_fence":
			return BlockTypes.ACACIA_FENCE;
		case "minecraft:spruce_door":
			return BlockTypes.SPRUCE_DOOR;
		case "minecraft:birch_door":
			return BlockTypes.BIRCH_DOOR;
		case "minecraft:jungle_door":
			return BlockTypes.JUNGLE_DOOR;
		case "minecraft:acacia_door":
			return BlockTypes.ACACIA_DOOR;
		case "minecraft:dark_oak_door":
			return BlockTypes.DARK_OAK_DOOR;
		case "minecraft:end_rod":
			return BlockTypes.END_ROD;
		case "minecraft:chorus_plant":
			return BlockTypes.CHORUS_PLANT;
		case "minecraft:chorus_flower":
			return BlockTypes.CHORUS_FLOWER;
		case "minecraft:purpur_block":
			return BlockTypes.PURPUR_BLOCK;
		case "minecraft:purpur_pillar":
			return BlockTypes.PURPUR_PILLAR;
		case "minecraft:purpur_stairs":
			return BlockTypes.PURPUR_STAIRS;
		case "minecraft:purpur_double_slab":
			return BlockTypes.PURPUR_DOUBLE_SLAB;
		case "minecraft:purpur_slab":
			return BlockTypes.PURPUR_SLAB;
		case "minecraft:end_bricks":
			return BlockTypes.END_BRICKS;
		case "minecraft:beetroots":
			return BlockTypes.BEETROOTS;
		case "minecraft:grass_path":
			return BlockTypes.GRASS_PATH;
		case "minecraft:end_gateway":
			return BlockTypes.END_GATEWAY;
		case "minecraft:repeating_command_block":
			return BlockTypes.REPEATING_COMMAND_BLOCK;
		case "minecraft:chain_command_block":
			return BlockTypes.CHAIN_COMMAND_BLOCK;
		case "minecraft:frosted_ice":
			return BlockTypes.FROSTED_ICE;
		case "minecraft:magma":
			return BlockTypes.MAGMA;
		case "minecraft:nether_wart_block":
			return BlockTypes.NETHER_WART_BLOCK;
		case "minecraft:red_nether_brick":
			return BlockTypes.RED_NETHER_BRICK;
		case "minecraft:bone_block":
			return BlockTypes.BONE_BLOCK;
		case "minecraft:structure_void":
			return BlockTypes.STRUCTURE_VOID;
		case "minecraft:observer":
			return BlockTypes.OBSERVER;
		case "minecraft:white_shulker_box":
			return BlockTypes.WHITE_SHULKER_BOX;
		case "minecraft:orange_shulker_box":
			return BlockTypes.ORANGE_SHULKER_BOX;
		case "minecraft:magenta_shulker_box":
			return BlockTypes.MAGENTA_SHULKER_BOX;
		case "minecraft:light_blue_shulker_box":
			return BlockTypes.LIGHT_BLUE_SHULKER_BOX;
		case "minecraft:yellow_shulker_box":
			return BlockTypes.YELLOW_SHULKER_BOX;
		case "minecraft:lime_shulker_box":
			return BlockTypes.LIME_SHULKER_BOX;
		case "minecraft:pink_shulker_box":
			return BlockTypes.PINK_SHULKER_BOX;
		case "minecraft:gray_shulker_box":
			return BlockTypes.GRAY_SHULKER_BOX;
		case "minecraft:silver_shulker_box":
			return BlockTypes.SILVER_SHULKER_BOX;
		case "minecraft:cyan_shulker_box":
			return BlockTypes.CYAN_SHULKER_BOX;
		case "minecraft:purple_shulker_box":
			return BlockTypes.PURPLE_SHULKER_BOX;
		case "minecraft:blue_shulker_box":
			return BlockTypes.BLUE_SHULKER_BOX;
		case "minecraft:brown_shulker_box":
			return BlockTypes.BROWN_SHULKER_BOX;
		case "minecraft:green_shulker_box":
			return BlockTypes.GREEN_SHULKER_BOX;
		case "minecraft:red_shulker_box":
			return BlockTypes.RED_SHULKER_BOX;
		case "minecraft:black_shulker_box":
			return BlockTypes.BLACK_SHULKER_BOX;
		/*case "minecraft:white_glazed_terracotta":
			return BlockTypes.WHITE_GLAZED_TERRACOTTA;
		case "minecraft:orange_glazed_terracotta":
			return BlockTypes.ORANGE_GLAZED_TERRACOTTA;
		case "minecraft:magenta_glazed_terracotta":
			return BlockTypes.MAGENTA_GLAZED_TERRACOTTA;
		case "minecraft:light_blue_glazed_terracotta":
			return BlockTypes.LIGHT_BLUE_GLAZED_TERRACOTTA;
		case "minecraft:yellow_glazed_terracotta":
			return BlockTypes.YELLOW_GLAZED_TERRACOTTA;
		case "minecraft:lime_glazed_terracotta":
			return BlockTypes.LIME_GLAZED_TERRACOTTA;
		case "minecraft:pink_glazed_terracotta":
			return BlockTypes.PINK_GLAZED_TERRACOTTA;
		case "minecraft:gray_glazed_terracotta":
			return BlockTypes.GRAY_GLAZED_TERRACOTTA;
		case "minecraft:silver_glazed_terracotta":
			return BlockTypes.SILVER_GLAZED_TERRACOTTA;
		case "minecraft:cyan_glazed_terracotta":
			return BlockTypes.CYAN_GLAZED_TERRACOTTA;
		case "minecraft:purple_glazed_terracotta":
			return BlockTypes.PURPLE_GLAZED_TERRACOTTA;
		case "minecraft:blue_glazed_terracotta":
			return BlockTypes.BLUE_GLAZED_TERRACOTTA;
		case "minecraft:brown_glazed_terracotta":
			return BlockTypes.BROWN_GLAZED_TERRACOTTA;
		case "minecraft:green_glazed_terracotta":
			return BlockTypes.GREEN_GLAZED_TERRACOTTA;
		case "minecraft:red_glazed_terracotta":
			return BlockTypes.RED_GLAZED_TERRACOTTA;
		case "minecraft:black_glazed_terracotta":
			return BlockTypes.BLACK_GLAZED_TERRACOTTA;
		case "minecraft:concrete":
			return BlockTypes.CONCRETE;
		case "minecraft:concrete_powder":
			return BlockTypes.CONCRETE_POWDER;
		case null:
			return null;
		case null:
			return null;*/
		case "minecraft:structure_block":
			return BlockTypes.STRUCTURE_BLOCK;
		default: 
			return null;
		}
	}
}