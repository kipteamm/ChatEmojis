package org.kipteam.chatEmojis.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.kipteam.chatEmojis.Main;

import java.util.Map;

public class PlayerListener implements Listener {

    private final Main main;
    public PlayerListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        event.setCancelled(true);
        String message = event.getMessage();

        Map<String, String> emojis = this.main.getEmojis();
        for (Map.Entry<String, String> entry : emojis.entrySet()) {
            message = message.replace(":" + entry.getKey() + ":", entry.getValue());
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }
}
