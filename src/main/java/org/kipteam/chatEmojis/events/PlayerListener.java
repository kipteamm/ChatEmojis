package org.kipteam.chatEmojis.events;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.kipteam.chatEmojis.Main;

import java.util.Map;

public class PlayerListener implements Listener {

    private final Main main;
    public PlayerListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack("https://github.com/kipteamm/ChatEmojis/blob/master/src/main/resources/ChatEmojisResourcePack.zip");
    }

    @EventHandler
    public void onResourceStatus(PlayerResourcePackStatusEvent event) {
        if (!event.getStatus().equals(PlayerResourcePackStatusEvent.Status.DECLINED)) return;

        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GRAY + "Your client failed to load the server resource pack. This server uses a resource pack to show emojis, however installing it is optional.");
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        event.setCancelled(true);
        String message = event.getMessage();

        Map<String, String> emojis = this.main.getEmojis();

        TextComponent finalMessage = new TextComponent(event.getPlayer().getDisplayName() + ": ");
        for (String word : message.split(" ")) {
            TextComponent part;
            if (word.matches(":.*:") && emojis.containsKey(word.substring(1, word.length() - 1))) {
                String emoji = emojis.get(word.substring(1, word.length() - 1));

                part = new TextComponent(emoji);
                part.setHoverEvent(new net.md_5.bungee.api.chat.HoverEvent(
                        net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,
                        new Text(word)
                ));
            } else {
                part = new TextComponent(word);
            }

            finalMessage.addExtra(part);
            finalMessage.addExtra(" ");
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(finalMessage);
        }
    }
}
