package as.minecraft.util;

import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;

public class PotionEffectUtils
{
	public static PotionEffectType getPotionEffectTypeFromInt(Integer primaryEffect)
	{
		switch(primaryEffect)
		{
		case 1:
			return PotionEffectTypes.SPEED;
		case 2:
			return PotionEffectTypes.SLOWNESS;
		case 3:
			return PotionEffectTypes.HASTE;
		case 4:
			return PotionEffectTypes.MINING_FATIGUE;
		case 5:
			return PotionEffectTypes.STRENGTH;
		case 6:
			return PotionEffectTypes.INSTANT_HEALTH;
		case 7:
			return PotionEffectTypes.INSTANT_DAMAGE;
		case 8:
			return PotionEffectTypes.JUMP_BOOST;
		case 9:
			return PotionEffectTypes.NAUSEA;
		case 10:
			return PotionEffectTypes.REGENERATION;
		case 11:
			return PotionEffectTypes.RESISTANCE;
		case 12:
			return PotionEffectTypes.FIRE_RESISTANCE;
		case 13:
			return PotionEffectTypes.WATER_BREATHING;
		case 14:
			return PotionEffectTypes.INVISIBILITY;
		case 15:
			return PotionEffectTypes.BLINDNESS;
		case 16:
			return PotionEffectTypes.NIGHT_VISION;
		case 17:
			return PotionEffectTypes.HUNGER;
		case 18:
			return PotionEffectTypes.WEAKNESS;
		case 19:
			return PotionEffectTypes.POISON;
		case 20:
			return PotionEffectTypes.WITHER;
		case 21:
			return PotionEffectTypes.HEALTH_BOOST;
		case 22:
			return PotionEffectTypes.ABSORPTION;
		case 23:
			return PotionEffectTypes.SATURATION;
		case 24:
			return PotionEffectTypes.GLOWING;
		case 25:
			return PotionEffectTypes.LEVITATION;
		case 26:
			return PotionEffectTypes.LUCK;
		case 27:
			return PotionEffectTypes.UNLUCK;
		default:
			return null;
		}
	}
	
}
