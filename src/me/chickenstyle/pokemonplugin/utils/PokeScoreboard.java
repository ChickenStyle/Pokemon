package me.chickenstyle.pokemonplugin.utils;

import com.google.common.collect.Maps;
import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.pokemons.Pokeball;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;
import me.chickenstyle.pokemonplugin.pokemons.PokemonGender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PokeScoreboard {

    SimpleScoreboard scoreboard;
    Trainer trainer;


    public PokeScoreboard(Trainer trainer) {
        this.scoreboard = new SimpleScoreboard("Your Team",trainer.getBukkitPlayer());
        this.trainer = trainer;
        send();
    }


    private void update() {
        scoreboard.clear();
        int counter = 0;
        for (Pokemon pokemon:trainer.getPokemon()) {
            if (pokemon != null) {

                Pokeball pokeball = pokemon.getPokeball();

                char background = counter == trainer.getSelectedSlot() ? pokeball.getSelectedBackground() : pokeball.getBackground();

                PokemonGender gender =  pokemon.getStats().getGender();
                scoreboard.add(background+ "\uF809\uF802" + pokemon.getIcon() + " " +Utils.color( pokemon.getTypes()[0].getColor() + pokemon.getPokemonType() + " " + gender.getColor() + gender.getUnicode() + (pokemon.isShiny() ? " &6★" : "") ));
                scoreboard.add(Utils.color("     \uF822&fLvl: " + pokemon.getLevel() + " HP: " + pokemon.getStats().getCurrentHp() +"/" + pokemon.getStats().getMaxHp()));
            } else {
                char background = counter == trainer.getSelectedSlot() ? Pokeball.POKE_BALL.getSelectedBackground() : Pokeball.POKE_BALL.getBackground();
                scoreboard.add(Utils.color(background + "\uF801 &fEmpty"));
                scoreboard.add("  ");

            }

            counter++;

        }

    }

    public void send() {
        update();
        scoreboard.draw();
        scoreboard.send();

    }

    public void close() {
        scoreboard.clear();
        scoreboard.destroy();
    }


}

class SimpleScoreboard {
    private Scoreboard scoreboard;
    private Objective obj;
    private Map<String, Integer> lines;
    private String title;
    private Boolean visible;
    private Player player;

    public SimpleScoreboard(String title,Player player) {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.title = title;
        this.lines = Maps.newLinkedHashMap();
        this.obj = null;
        this.visible = true;
        this.player = player;
    }



    public void blankLine() {
        add(" ");
    }

    public void add(String text) {
        add(text, null);
    }


    public void add(String text, Integer score) {
        String textCut = text.length() > 40 ? title.substring(0, 39) : text;
        textCut = fixDuplicates(textCut);
        lines.put(textCut, score);
    }

    public void setLine(int line,String text) {

    }

    private String fixDuplicates(String text) {
        while (lines.containsKey(text))
            text += "§r";
        if (text.length() > 48)
            text = text.substring(0, 47);
        return text;
    }



    private void build() {
        if(obj == null){
            obj = scoreboard.registerNewObjective(player.getName(), "dummy");
            obj.setDisplayName(title);
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
    }

    public void destroy(){
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        if(obj != null){
            obj.setDisplaySlot(null);
            obj.unregister();
            obj = null;
        }
    }

    public void clear(){
        for (Map.Entry<String, Integer> entry : lines.entrySet()) {
            scoreboard.resetScores(entry.getKey());
        }
        lines.clear();
    }

    public void draw(){
        if(obj == null){
            build();
        }

        int index = lines.size();

        for (Map.Entry<String, Integer> entry : lines.entrySet()) {
            Integer score = entry.getValue() != null ? entry.getValue() : index;
            obj.getScore(entry.getKey()).setScore(score);
            index -= 1;
        }
    }

    public void send(){
        player.setScoreboard(scoreboard);
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Scoreboard getBukkitScoreboard(){
        return scoreboard;
    }



}
