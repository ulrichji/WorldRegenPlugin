package as.minecraft.world;

import java.util.ArrayList;

import org.spongepowered.api.block.tileentity.Banner;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.block.tileentity.carrier.Beacon;
import org.spongepowered.api.block.tileentity.carrier.TileEntityCarrier;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.tileentity.BeaconData;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.PatternListValue;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.item.inventory.Inventory;

import com.google.common.base.Optional;

import as.minecraft.util.ColorUtil;
import as.minecraft.util.PotionEffectUtils;

public class RegenBlockEntity
{
	private String blockId = null;
	private Integer x = null;
	private Integer y = null;
	private Integer z = null;
	private String customName = null;
	private Integer baseColor = null;
	private ArrayList<RegenBannerPattern> bannerPatterns = null;
	private String lock = null;
	private Integer levels = null;
	private Integer primaryEffect = null;
	private Integer secondaryEffect = null;
	private Integer dyeColor = null;
	private Integer customColor = null;
	private ArrayList<RegenItem> itemList = null;
	private Short potionId = null;
	private Boolean storesSplashPotion = null;
	private Boolean movable = null;
	private Integer brewTime = null;
	private Byte fuel = null;
	private String lootTable = null;
	private Long lootTableSeed = null;
	
	public void setId(String id) { this.blockId = id; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setZ(int z) { this.z = z; }
	public void setCustomName(String customName) { this.customName = customName; }
	public void setBaseColor(int baseColor) { this.baseColor = baseColor; }
	public void setPatterns(ArrayList<RegenBannerPattern> bannerPatterns) { this.bannerPatterns = bannerPatterns; }
	public void setLock(String lock) { this.lock = lock; }
	public void setLevels(int levels) { this.levels = levels; }
	public void setPrimaryEffect(int primaryEffect) { this.primaryEffect = primaryEffect; }
	public void setSecondaryEffect(int secondaryEffect) { this.secondaryEffect = secondaryEffect; }
	public void setDyeColor(int dyeColor) { this.dyeColor = dyeColor; }
	public void setCustomColor(int customColor) { this.customColor = customColor; }
	public void setItems(ArrayList<RegenItem> itemList) { this.itemList = itemList; }
	public void setPotionId(short potionId) { this.potionId = potionId; }
	public void setStoresSplashPotion(boolean storesSplashPotion) { this.storesSplashPotion = storesSplashPotion; }
	public void setMovable(boolean moveable) { this.movable = moveable; }
	public void setBrewTime(int brewTime){ this.brewTime = brewTime; }
	public void setFuel(byte fuelValue) { this.fuel = fuelValue; }
	public void setLootTable(String lootTable) { this.lootTable = lootTable; }
	public void setLootTableSeed(long lootTableSeed) { this.lootTableSeed = lootTableSeed; }
	
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append("[RegenBlockEntity ");
		
		if(this.blockId != null)
			b.append("blockId="+this.blockId+", ");
		if(this.x != null)
			b.append("x="+this.x+", ");
		if(this.y != null)
			b.append("y="+this.y+", ");
		if(this.z != null)
			b.append("z="+this.z+", ");
		if(this.customName != null)
			b.append("customName=\""+this.customName+"\", ");
		if(this.baseColor != null)
			b.append("baseColor="+this.baseColor+", ");
		if(this.bannerPatterns != null)
		{
			b.append("bannerPatterns=[");
			for(RegenBannerPattern pattern : this.bannerPatterns)
				b.append(pattern.toString()+", ");
			b.append("], ");
		}
		if(this.lock != null)
			b.append("lock=\""+this.lock+"\", ");
		if(this.levels != null)
			b.append("levels="+this.levels+", ");
		if(this.primaryEffect != null)
			b.append("primaryEffect="+this.primaryEffect+", ");
		if(this.secondaryEffect != null)
			b.append("secondaryEffect="+this.secondaryEffect+", ");
		if(this.dyeColor != null)
			b.append("dyeColor="+this.dyeColor+", ");
		if(this.customColor != null)
			b.append("customColor="+this.customColor+", ");
		if(this.itemList != null)
		{
			b.append("itemList=[");
			for(RegenItem item : this.itemList)
				b.append(item.toString()+",");
			b.append("]");
		}
		if(this.potionId != null)
			b.append("potionId="+this.potionId+", ");
		if(this.storesSplashPotion != null)
			b.append("storesSplashPotion="+this.storesSplashPotion+", ");
		if(this.movable != null)
			b.append("movable="+this.movable+", ");
		if(this.brewTime != null)
			b.append("brewTime="+this.brewTime+", ");
		if(this.fuel != null)
			b.append("fuel="+this.fuel+", ");
		if(this.lootTable != null)
			b.append("lootTable=\""+this.lootTable+"\", ");
		if(this.lootTableSeed != null)
			b.append("lootTableSeed="+this.lootTableSeed+", ");
		
		b.append("]");
		return b.toString();
	}
	
	public void setInventory(Inventory inventory)
	{
		if(itemList != null)
		{
			for(RegenItem item : itemList)
			{
				inventory.offer(item.getItemStack());
			}
		}
	}
	
	public boolean hasPosition()
	{
		return this.x != null && this.y != null && this.z != null;
	}
	
	public int getX() { return this.x; }
	public int getZ() { return this.z; }
	public int getY() { return this.y; }
	
	public void setEntityData(TileEntity entity)
	{
		if(entity instanceof Banner)
		{
			Banner banner = (Banner) entity;
			banner.offer(Keys.BANNER_BASE_COLOR, ColorUtil.enumerateDyeColor(baseColor));
			PatternListValue patterns = banner.patternsList();
			
			//Remove all current patterns
			for(int i=patterns.size()-1;i>=0;i--)
				patterns.remove(i);
			for(RegenBannerPattern pattern : bannerPatterns)
				patterns.add(pattern.getBannerPatternLayer());
			
			if(patterns.exists())
				banner.offer(Keys.BANNER_PATTERNS, patterns.get());
		}
		if(entity instanceof  Beacon)
		{
			Beacon b = (Beacon)entity;
			BeaconData beaconData = b.getBeaconData();
			if(primaryEffect != null)
			{
				PotionEffectType primary = PotionEffectUtils.getPotionEffectTypeFromInt(primaryEffect);
				OptionalValue<PotionEffectType> beaconEffect = beaconData.primaryEffect();
				beaconEffect.setTo(primary);
				if(beaconEffect.exists())
					beaconData.set(Keys.BEACON_PRIMARY_EFFECT,beaconEffect.get());
				
			}
			if(secondaryEffect != null)
			{
				PotionEffectType secondary = PotionEffectUtils.getPotionEffectTypeFromInt(secondaryEffect);
				OptionalValue<PotionEffectType> beaconEffect = beaconData.secondaryEffect();
				beaconEffect.setTo(secondary);
				if(beaconEffect.exists())
					beaconData.set(Keys.BEACON_SECONDARY_EFFECT, beaconEffect.get());
			}
			b.offer(beaconData);
		}
		/*if(entity instanceof TileEntityCarrier)
		{
			TileEntityCarrier carrier = (TileEntityCarrier) entity;
			Inventory inventory = carrier.getInventory();
			inventory.clear();
			this.setInventory(inventory);
		}*/
	}
}
