package org.kipteam.chatEmojis.commands;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kipteam.chatEmojis.Main;

import java.util.Map;

public class ChatEmojisCommand implements CommandExecutor {

    private final Main main;

    public ChatEmojisCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        player.sendMessage("§7------------ [ §fChatEmojis§7 ] ------------");
        player.sendMessage("§7Hover any of the emojis to see their name.");

        int count = 0;
        TextComponent currentLine = new TextComponent();
        for (Map.Entry<String, String> entry : main.getEmojis().entrySet()) {
            TextComponent emoji = new TextComponent(entry.getValue());
            emoji.setHoverEvent(new net.md_5.bungee.api.chat.HoverEvent(
                    net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,
                    new Text(":" + entry.getKey() + ":")
            ));

            currentLine.addExtra(emoji);

            count++;
            if (count % 20 == 0) {
                player.spigot().sendMessage(currentLine);
                currentLine = new TextComponent();
            }
        }

        if (currentLine.getExtra() != null && !currentLine.getExtra().isEmpty()) {
            player.spigot().sendMessage(currentLine);
        }

        return true;
    }
}
