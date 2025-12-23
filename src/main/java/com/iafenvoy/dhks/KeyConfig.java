package com.iafenvoy.dhks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.resources.language.I18n;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KeyConfig {
    private static final Codec<List<KeyObject>> CODEC = RecordCodecBuilder.<KeyObject>create(i -> i.group(
            Codec.STRING.optionalFieldOf("comment", "").forGetter(KeyObject::comment),
            Codec.STRING.optionalFieldOf("translation", "").forGetter(x -> I18n.get(x.comment())),
            Codec.STRING.fieldOf("key").forGetter(KeyObject::key),
            Codec.STRING.optionalFieldOf("modifier", "").forGetter(KeyObject::modifier)
    ).apply(i, KeyObject::new)).listOf();
    private static final Map<String, KeyObject> KEY_MAP = new TreeMap<>();
    private static final String CONFIG_PATH = "./config/default-hotkeys.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static int find(String translationKey, int code, String modifier) {
        if (KEY_MAP.containsKey(translationKey)) return Keys.getCode(KEY_MAP.get(translationKey).key);
        KEY_MAP.put(translationKey, new KeyObject(translationKey, Keys.getTranslate(code), modifier));
        return code;
    }

    static {
        try {
            CODEC.parse(JsonOps.INSTANCE, JsonParser.parseString(FileUtils.readFileToString(new File(CONFIG_PATH), StandardCharsets.UTF_8))).resultOrPartial(DefaultHotkeys.LOGGER::error).orElseThrow().forEach(x -> KEY_MAP.put(x.comment, x));
        } catch (Exception e) {
            DefaultHotkeys.LOGGER.error("Failed to load {}", CONFIG_PATH, e);
        }
    }

    public static void save() {
        try {
            DefaultHotkeys.LOGGER.info("Saving default keybindings to {}", CONFIG_PATH);
            FileUtils.write(new File(CONFIG_PATH), GSON.toJson(CODEC.encodeStart(JsonOps.INSTANCE, KEY_MAP.values().stream().toList()).resultOrPartial(DefaultHotkeys.LOGGER::error).orElseThrow()), StandardCharsets.UTF_8);
        } catch (Exception e) {
            DefaultHotkeys.LOGGER.error("Failed to save {}", CONFIG_PATH, e);
        }
    }

    private record KeyObject(String comment, String key, String modifier) {
        public KeyObject(String comment, String translation, String key, String modifier) {
            this(comment, key, modifier);
        }
    }
}
