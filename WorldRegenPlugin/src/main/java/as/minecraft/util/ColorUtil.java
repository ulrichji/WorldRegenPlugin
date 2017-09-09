package as.minecraft.util;

import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.util.Color;

public class ColorUtil
{
	public static DyeColor enumerateDyeColor(int colorIndex)
	{
		switch(colorIndex)
		{
		case 0:
			return DyeColors.WHITE;
		case 1:
			return DyeColors.ORANGE;
		case 2:
			return DyeColors.MAGENTA;
		case 3:
			return DyeColors.LIGHT_BLUE;
		case 4:
			return DyeColors.YELLOW;
		case 5:
			return DyeColors.LIME;
		case 6:
			return DyeColors.PINK;
		case 7:
			return DyeColors.GRAY;
		case 8:
			return DyeColors.SILVER;
		case 9:
			return DyeColors.CYAN;
		case 10:
			return DyeColors.PURPLE;
		case 11:
			return DyeColors.BLUE;
		case 12:
			return DyeColors.BROWN;
		case 13:
			return DyeColors.GREEN;
		case 14:
			return DyeColors.RED;
		case 15:
			return DyeColors.BLACK;
		default:
			return DyeColors.BLACK;
		}
	}
	
	public static DyeColor getDyeColorFromIntColor(int color)
	{
		Color c = Color.ofRgb(color);
		
		int closestDist = Integer.MAX_VALUE;
		DyeColor closestColor = null;
		
		DyeColor currentColor = DyeColors.BLACK;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.BLUE;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.BROWN;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.CYAN;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.GRAY;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.GREEN;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.LIGHT_BLUE;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.LIME;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.MAGENTA;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.ORANGE;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.PINK;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.PURPLE;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.RED;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.SILVER;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.WHITE;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		currentColor = DyeColors.YELLOW;
		if(getColorDistSquared(c, currentColor.getColor()) < closestDist)
		{
			closestDist = getColorDistSquared(c, currentColor.getColor());
			closestColor =  currentColor;
		}
		
		return closestColor;
	}
	
	private static int getColorDistSquared(Color c1, Color c2)
	{
		int dist = 0;
		int redDist = c1.getRed() - c2.getRed();
		int greenDist = c1.getGreen() - c2.getGreen();
		int blueDist = c1.getBlue() - c2.getBlue();
		
		dist += redDist*redDist;
		dist += greenDist*greenDist;
		dist += blueDist*blueDist;
		
		return dist;
	}
}
