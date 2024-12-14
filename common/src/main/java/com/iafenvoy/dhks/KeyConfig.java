package com.iafenvoy.dhks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Language;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

@Environment(EnvType.CLIENT)
public class KeyConfig {
    private static final Codec<Map<String, KeyObject>> CODEC = Codec.unboundedMap(Codec.STRING, RecordCodecBuilder.create(i -> i.group(
            Codec.STRING.optionalFieldOf("comment", "").forGetter(KeyObject::comment),
            Codec.STRING.fieldOf("key").forGetter(KeyObject::key),
            Codec.STRING.optionalFieldOf("modifier", "").forGetter(KeyObject::modifier)
    ).apply(i, KeyObject::new)));
    private static final Map<String, KeyObject> CONFIGS = new TreeMap<>();
    private static final String CONFIG_PATH = "./config/default-hotkeys.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static int find(String translation, int code, String modifier) {
        if (CONFIGS.containsKey(translation)) return Keys.getCode(CONFIGS.get(translation).key);
        CONFIGS.put(translation, new KeyObject(Language.getInstance().get(translation), Keys.getTranslate(code), modifier));
        return code;
    }

    static {
        try {
            CONFIGS.putAll(CODEC.parse(JsonOps.INSTANCE, JsonParser.parseString(FileUtils.readFileToString(new File(CONFIG_PATH), StandardCharsets.UTF_8))).resultOrPartial(DefaultHotkeys.LOGGER::error).orElseThrow());
        } catch (Exception e) {
            DefaultHotkeys.LOGGER.error("Failed to load {}", CONFIG_PATH, e);
        }
    }

    public static void save() {
        try {
            FileUtils.write(new File(CONFIG_PATH), GSON.toJson(CODEC.encodeStart(JsonOps.INSTANCE, CONFIGS).resultOrPartial(DefaultHotkeys.LOGGER::error).orElseThrow()), StandardCharsets.UTF_8);
        } catch (Exception e) {
            DefaultHotkeys.LOGGER.error("Failed to save {}", CONFIG_PATH, e);
        }
    }

    private record KeyObject(String comment, String key, String modifier) {
    }
}
