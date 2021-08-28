package me.chickenstyle.pokemonplugin.items;

import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.moves.Move;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;
import me.chickenstyle.pokemonplugin.pokemons.PokemonGender;
import me.chickenstyle.pokemonplugin.pokemons.PokemonNature;
import me.chickenstyle.pokemonplugin.pokemons.PokemonType;
import me.chickenstyle.pokemonplugin.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PokemonIconItem extends SpecialItem {

    public PokemonIconItem(Pokemon pokemon) {
        super(Material.GUNPOWDER, pokemon.isShiny() ? pokemon.getID() * 1000 : pokemon.getID(), pokemon.getPokemonType(), null);
        ItemStack item = getItem();
        ItemMeta meta = item.getItemMeta();

        ArrayList<String> lore = new ArrayList<String>();
        PokemonGender gender = pokemon.getStats().getGender();
        int lvl = pokemon.getStats().getLevel();
        meta.setDisplayName(Utils.color(pokemon.getTypes()[0].getColor() +
                pokemon.getPokemonType() + " " + gender.getColor() + "" + gender.getUnicode() + " &7Lvl. " + lvl +
                (pokemon.isShiny() ? " &6★" : "")));

        for (PokemonType type:pokemon.getTypes()) {
            lore.add(Utils.color(type.getColor() + type.getIcon() + " " + type.toString(type)));
        }
        lore.add(" ");

        String hpBar = "";
        int counter = 0;

        while (counter < 40) {
            if (counter/40 < pokemon.getStats().getCurrentHp() / pokemon.getStats().getMaxHp()) {
                hpBar += "&a┇";
            } else {
                hpBar += "&7┇";
            }
            counter++;
        }

        lore.add(Utils.color("&7HP: " + hpBar));
        lore.add(Utils.color("          &f" + pokemon.getStats().getCurrentHp() + " / " + pokemon.getStats().getMaxHp()));
        lore.add(" ");
        PokemonNature nature = pokemon.getStats().getNature();

        String attColor = nature.getAttackMultiplier() == 0.9 ? "&c" :"&f";
        if (!attColor.equals("&c")){
            attColor = nature.getAttackMultiplier() == 1.1  ? "&a" : "&f";
        }

        String defColor = nature.getDefenseMultiplier() == 0.9 ? "&c" :"&f";
        if (!defColor.equals("&c")) {
            defColor = nature.getDefenseMultiplier() == 1.1 ? "&a" : "&f";
        }

        String spAttColor = nature.getSpecialAttackMultiplier() == 0.9 ? "&c" :"&f";
        if (!spAttColor.equals("&c")) {
            spAttColor = nature.getSpecialAttackMultiplier() == 1.1  ? "&a" : "&f";
        }

        String spDefColor = nature.getSpecialDefenseMultiplier() == 0.9 ? "&c" :"&f";
        if (!spDefColor.equals("&c")) {
            spDefColor = nature.getSpecialDefenseMultiplier() == 1.1 ? "&a" : "&f";
        }



        String speedColor = nature.getSpeedMultiplier() == 0.9 ? "&c" :"&f";
        if (!speedColor.equals("&c")) {
            speedColor = nature.getSpeedMultiplier() == 1.1 ? "&a" : "&f";
        }

        lore.add(Utils.color("&7Attack: " + attColor + pokemon.getStats().getAttack() + " &7Sp.Def: " + spDefColor + pokemon.getStats().getSpecialDefense()));
        lore.add(Utils.color("&7Defense: " + defColor + pokemon.getStats().getDefense() + " &7Speed: " + speedColor + pokemon.getStats().getSpeed()));
        lore.add(Utils.color("&7Sp.Atk: " + spAttColor + pokemon.getStats().getSpecialAttack()));

        lore.add(" ");

        lore.add(Utils.color("&7Nature: &f" + nature.toString()));


        for (Move move:pokemon.getMoves()) {
            if (move != null) {

            }
        }

        meta.setLore(lore);

        item.setItemMeta(meta);

        setItem(item);


    }

    public PokemonIconItem() {
        super(Material.GRAY_STAINED_GLASS_PANE,0,"&7Empty",null);
    }

    @Override
    public void onLeftClick(Trainer trainer) {

    }

    @Override
    public void onRightClick(Trainer trainer) {

    }
}
