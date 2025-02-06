package org.kipteam.chatEmojis.emojis;

import java.util.HashMap;
import java.util.Map;

public class ChatEmojis {

    private Map<String, String> chatEmojis = new HashMap<String, String>();

    public ChatEmojis() {
        chatEmojis.put("test", "U+E000");
    }

    public Map<String, String> getEmojis() {
        return this.chatEmojis;
    }
}
