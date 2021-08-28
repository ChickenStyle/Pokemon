package me.chickenstyle.pokemonplugin.items;

import me.chickenstyle.pokemonplugin.Pixelmon;
import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;


public abstract class SpecialItem {

    private ItemStack item;



    public SpecialItem(Material material,int customModelData,String displayName,String... lore) {


        this.item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();
        if (displayName != null) { meta.setCustomModelData(customModelData); }

        meta.setDisplayName(Utils.color(displayName));
        if (lore != null) {
            for (int i = 0; i < lore.length; i++) {
                lore[i] = Utils.color(lore[i]);
            }

            meta.setLore(Arrays.asList(lore));

        }
        item.setItemMeta(meta);

        item = Pixelmon.getNmsHandler().addStringTag(item,"SpecialItem",this.getClass().getName());

    }


    public abstract void onLeftClick(Trainer trainer);

    public abstract void onRightClick(Trainer trainer);

    public ItemStack getItem() {
        return item;
    }

    protected void setItem(ItemStack item) {
        this.item = item;
    }
}
