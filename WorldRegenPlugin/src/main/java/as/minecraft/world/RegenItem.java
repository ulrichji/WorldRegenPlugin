package as.minecraft.world;

import java.util.ArrayList;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import as.minecraft.util.ItemTypeEnumerate;

public class RegenItem
{
	private int count = 1;
	private int slot = 0;
	private int damage = 0;
	private String id = "";
	private ArrayList<String> tags = new ArrayList<String>();
	
	public void setCount(byte count) { this.count = count; }
	public void setSlot(byte slot) { this.slot = slot; }
	public void setDamage(short damage) { this.damage = damage; }
	public void setId(String id) { this.id = id; }
	public void setTags(ArrayList<String> parseTags) { this.tags = parseTags; }
	
	public ItemType getItemType()
	{
		return ItemTypeEnumerate.getItemTypeFromItemId(id);
	}
	
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append("[RegenItem ");
		b.append("count="+count+", ");
		b.append("slot="+slot+", ");
		b.append("damage="+damage+", ");
		b.append("id="+id);
		b.append("]");
		
		return b.toString();
	}
	public DataManipulator<?, ?> getItemDataManipulator()
	{
		return null;
	}
	public ItemStack getItemStack()
	{
		ItemStack itemStack = ItemStack.builder()
				.itemType(getItemType())
				.quantity(count)
				.build();
		return itemStack;
	}
}
