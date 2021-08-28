package me.chickenstyle.pokemonplugin.nmsversions;

import net.minecraft.server.v1_16_R2.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class Handler_1_16_R2 implements NMSHandler {
	
	@Override
	public ItemStack removeTag(ItemStack item,String tag) {
		net.minecraft.server.v1_16_R2.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		NBTTagCompound itemCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		itemCompound.remove(tag);
		nmsItem.setTag(itemCompound);
		return CraftItemStack.asBukkitCopy(nmsItem);
	}
	
	@Override
	public ItemStack addIntTag(ItemStack item,String tag, int data) {
		net.minecraft.server.v1_16_R2.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		NBTTagCompound itemCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		itemCompound.setInt(tag, data);
		nmsItem.setTag(itemCompound);
		return CraftItemStack.asBukkitCopy(nmsItem);
	}

	@Override
	public ItemStack addStringTag(ItemStack item,String tag, String data) {
		net.minecraft.server.v1_16_R2.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		NBTTagCompound itemCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		itemCompound.setString(tag, data);
		nmsItem.setTag(itemCompound);
		return CraftItemStack.asBukkitCopy(nmsItem);
	}

	@Override
	public boolean hasTag(ItemStack item,String tag) {
		net.minecraft.server.v1_16_R2.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		NBTTagCompound itemCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		return itemCompound.hasKey(tag);
	}

	@Override
	public int getIntData(ItemStack item,String tag) {
		net.minecraft.server.v1_16_R2.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		NBTTagCompound itemCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		return itemCompound.getInt(tag);
	}

	@Override
	public String getStringData(ItemStack item,String tag) {
		net.minecraft.server.v1_16_R2.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		NBTTagCompound itemCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		return itemCompound.getString(tag);
	}
	
	 
}
