package org.kipteam.chatEmojis;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.kipteam.chatEmojis.commands.ChatEmojisCommand;
import org.kipteam.chatEmojis.emojis.ChatEmojis;
import org.kipteam.chatEmojis.events.PlayerListener;

import java.util.Map;

public final class Main extends JavaPlugin {

    private final ChatEmojis chatEmojis = new ChatEmojis();

    @Override
    public void onEnable() {
        System.out.println("ChatEmojis enabled.");

        getCommand("chatemojis").setExecutor(new ChatEmojisCommand(this));

        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("ChatEmojis disabled.");
    }

    public Map<String, String> getEmojis() {
        return chatEmojis.getEmojis();
    }
}
