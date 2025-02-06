package org.kipteam.chatEmojis.emojis;

import java.util.HashMap;
import java.util.Map;

public class ChatEmojis {

    private Map<String, String> chatEmojis = new HashMap<String, String>();

    public ChatEmojis() {
        chatEmojis.put("joy", "\uE000");
        chatEmojis.put("grimacing", "\uE001");
        chatEmojis.put("grimace", "\uE001");
        chatEmojis.put("heart_eyes", "\uE002");
        chatEmojis.put("amazing", "\uE002");
        chatEmojis.put("angry", "\uE003");
        chatEmojis.put("furious", "\uE003");
        chatEmojis.put("confused", "\uE004");
        chatEmojis.put("what", "\uE004");
        chatEmojis.put("?", "\uE004");
        chatEmojis.put("sunglasses", "\uE005");
        chatEmojis.put("cool", "\uE005");
        chatEmojis.put("hot", "\uE006");
        chatEmojis.put("grinning", "\uE007");
        chatEmojis.put("grin", "\uE007");
        chatEmojis.put("nerd", "\uE008");
        chatEmojis.put("scream", "\uE009");
        chatEmojis.put("scared", "\uE009");
        chatEmojis.put("sick", "\uE010");
        chatEmojis.put("puke", "\uE010");
        chatEmojis.put("disgusted", "\uE010");
        chatEmojis.put("sob", "\uE011");
        chatEmojis.put("crying", "\uE011");
        chatEmojis.put("sad", "\uE012");
        chatEmojis.put("skull", "\uE013");
    }

    public Map<String, String> getEmojis() {
        return this.chatEmojis;
    }
}
