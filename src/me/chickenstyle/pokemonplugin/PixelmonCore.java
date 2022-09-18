package me.chickenstyle.pokemonplugin;

import me.chickenstyle.pokemonplugin.items.SpecialItem;
import me.chickenstyle.pokemonplugin.nmsversions.NMSHandler;
import me.chickenstyle.pokemonplugin.pokemons.enums.Pokeball;


import me.chickenstyle.pokemonplugin.pokemons.enums.PokemonType;
import me.chickenstyle.pokemonplugin.utils.Config;
import me.chickenstyle.pokemonplugin.utils.Logger;
import me.chickenstyle.pokemonplugin.utils.PokemonManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.LinkedHashMap;
import java.util.Map;

public class PixelmonCore extends JavaPlugin implements Listener {

    private static Map<Player,Trainer> trainers;

    private static NMSHandler nmsHandler;

    private static PixelmonCore instance;
    private Config symbolsConfig;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this,this);

        loadData();

        if (detectNMSVersion()) {
            System.out.println("SUS!");
        }

        trainers = new LinkedHashMap<>();

    }

    private boolean detectNMSVersion() {

        String version;

        try {

            version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        } catch (ArrayIndexOutOfBoundsException whatVersionAreYouUsingException) {
            return false;
        }
        version = version.substring(1);

        try {
            nmsHandler = (NMSHandler) Class.forName("me.chickenstyle.pokemonplugin.nmsversions.Handler_" +version).newInstance();
        } catch (ClassNotFoundException e) {
            return false;
        } catch (InstantiationException e) {
            return false;
        } catch (IllegalAccessException e) {
            return false;
        }

        return true;
    }

    @Override
    public void onDisable() {
        if (trainers != null && trainers.keySet() != null) {

            for (Player player:trainers.keySet()) {
                trainers.get(player).closeScoreboard();
                if (trainers.get(player).isInTrainerMode()) {
                    trainers.get(player).changeMode();
                }

                trainers.remove(player);
            }
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {


        Trainer trainer = new Trainer(e.getPlayer());


        trainer.setPokemon(
                PokemonManager.getPokemonById(4,5),
                PokemonManager.getPokemonById(151,69,true),
                PokemonManager.getPokemonById(150,25,true,Pokeball.MASTER_BALL),
                PokemonManager.getPokemonById(1,5),
                PokemonManager.getPokemonById(7,5),
                PokemonManager.getPokemonById(69,69));


        trainers.put(e.getPlayer(),trainer);




    }


    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if (trainers == null || trainers.get(e.getPlayer()) == null) return;

        Trainer trainer = trainers.get(e.getPlayer());

        if (trainer.isInTrainerMode()) {
            trainer.changeMode();
        }

        trainers.remove(trainer);
    }

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
        trainers.get(e.getPlayer()).changeMode();
    }

    @EventHandler
    public void onItemClick(PlayerInteractEvent e) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (nmsHandler.hasTag(e.getItem(),"SpecialItem")) {
            e.setCancelled(true);
            SpecialItem item = (SpecialItem) Class.forName(nmsHandler.getStringData(e.getItem(),"SpecialItem")).newInstance();

            if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
                item.onLeftClick(trainers.get(e.getPlayer()));
            } else {
                item.onRightClick(trainers.get(e.getPlayer()));
            }

        }

    }

    private void loadData() {

        //Configs
        saveDefaultConfig();
        symbolsConfig = new Config("symbols.yml");

        for (PokemonType type : PokemonType.values()) {
            type.setColor(symbolsConfig.getString("pokemonType." + type + ".typeColor"));
            type.setIcon(symbolsConfig.getString("pokemonType." + type + ".typeSymbol"));
        }


        //Loading all the pokemon data
        for (int i = 0; i < PokemonManager.getPokemonAmount(); i++) {
            int id = i + 1;

            String strId = "" + id;

            strId = id < 10 ? "00" + id : strId;
            strId = id >= 10 && id < 100 ? "0" + id : strId;
            strId = id >= 100 ? id + "" : strId;

            saveResource("pokemon_stats/" + strId + ".json",false);
        }

        Logger.log("&aSuccessfully loaded pokemon's data!");
    }

    public static NMSHandler getNmsHandler() {
        return nmsHandler;
    }

    public static PixelmonCore getInstance() {
        return instance;
    }
}
