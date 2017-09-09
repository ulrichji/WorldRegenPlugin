package as.minecraft.world;

import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.BannerPatternShapes;
import org.spongepowered.api.data.type.DyeColor;

import as.minecraft.util.ColorUtil;

public class RegenBannerPattern
{
	private final int color;
	private final String pattern;
	public RegenBannerPattern(String pattern, int color)
	{
		this.pattern = pattern;
		this.color = color;
	}
	
	public PatternLayer getBannerPatternLayer()
	{
		PatternLayer layer = PatternLayer.of(getBannerPatternShape(), getDyeColor());
		return layer;
	}

	private DyeColor getDyeColor()
	{
		return ColorUtil.enumerateDyeColor(color);
	}

	private BannerPatternShape getBannerPatternShape()
	{
		switch(this.pattern)
		{
		case "bs":
			return BannerPatternShapes.STRIPE_BOTTOM;
		case "ts":
			return BannerPatternShapes.STRIPE_TOP;
		case "ls":
			return BannerPatternShapes.STRIPE_LEFT;
		case "rs":
			return BannerPatternShapes.STRIPE_RIGHT;
		case "cs":
			return BannerPatternShapes.STRIPE_CENTER;
		case "ms":
			return BannerPatternShapes.STRIPE_MIDDLE;
		case "drs":
			return BannerPatternShapes.STRIPE_DOWNRIGHT;
		case "dls":
			return BannerPatternShapes.STRIPE_DOWNLEFT;
		case "ss":
			return BannerPatternShapes.STRIPE_SMALL;
		case "cr":
			return BannerPatternShapes.CROSS;
		case "sc":
			return BannerPatternShapes.STRAIGHT_CROSS;
		case "ld":
			return BannerPatternShapes.DIAGONAL_LEFT;
		case "rud":
			return BannerPatternShapes.DIAGONAL_RIGHT_MIRROR;
		case "lud":
			return BannerPatternShapes.DIAGONAL_LEFT_MIRROR;
		case "rd":
			return BannerPatternShapes.DIAGONAL_RIGHT;
		case "vh":
			//FIXME is this left or right?
			return BannerPatternShapes.HALF_VERTICAL;
		case "vrh":
			//FIXME is this left or right?
			return BannerPatternShapes.HALF_VERTICAL_MIRROR;
		case "hh":
			//FIXME is this top or bottom?
			return BannerPatternShapes.HALF_HORIZONTAL;
		case "hhb":
			return BannerPatternShapes.HALF_HORIZONTAL_MIRROR;
		case "bl":
			return BannerPatternShapes.SQUARE_BOTTOM_LEFT;
		case "br":
			return BannerPatternShapes.SQUARE_BOTTOM_RIGHT;
		case "tl":
			return BannerPatternShapes.SQUARE_TOP_LEFT;
		case "tr":
			return BannerPatternShapes.SQUARE_TOP_RIGHT;
		case "bt":
			return BannerPatternShapes.TRIANGLE_BOTTOM;
		case "tt":
			return BannerPatternShapes.TRIANGLE_TOP;
		case "bts":
			return BannerPatternShapes.TRIANGLES_BOTTOM;
		case "tts":
			return BannerPatternShapes.TRIANGLES_TOP;
		case "mc":
			return BannerPatternShapes.CIRCLE_MIDDLE;
		case "mr":
			return BannerPatternShapes.RHOMBUS_MIDDLE;
		case "bo":
			return BannerPatternShapes.BORDER;
		case "cbo":
			return BannerPatternShapes.CURLY_BORDER;
		case "bri":
			return BannerPatternShapes.BRICKS;
		case "gra":
			return BannerPatternShapes.GRADIENT;
		case "gru":
			return BannerPatternShapes.GRADIENT_UP;
		case "cre":
			return BannerPatternShapes.CREEPER;
		case "sku":
			return BannerPatternShapes.SKULL;
		case "flo":
			return BannerPatternShapes.FLOWER;
		case "moc":
			return BannerPatternShapes.MOJANG;
		default:
			return BannerPatternShapes.BASE;
		}
	}
	
}
