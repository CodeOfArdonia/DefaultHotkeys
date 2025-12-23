package com.iafenvoy.dhks;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import org.jetbrains.annotations.NotNull;

public class Keys {
    private static final Int2ObjectOpenHashMap<String> ID_TO_KEY = new Int2ObjectOpenHashMap<>();
    private static final Object2IntOpenHashMap<String> KEY_TO_ID = new Object2IntOpenHashMap<>();

    private static void mapKey(String translationKey, int keyCode) {
        ID_TO_KEY.put(keyCode, translationKey);
        KEY_TO_ID.put(translationKey, keyCode);
    }

    @NotNull
    public static String getTranslate(int code) {
        return ID_TO_KEY.getOrDefault(code, "key.keyboard.unknown");
    }

    public static int getCode(String translate) {
        if (KEY_TO_ID.containsKey(translate)) return KEY_TO_ID.getInt(translate);
        DefaultHotkeys.LOGGER.error("Cannot resolve hotkey value {}", translate);
        return -1;
    }

    //Copy from net.minecraft.client.util.InputUtil
    static {
        mapKey("key.keyboard.unknown", -1);
        mapKey("key.mouse.left", 0);
        mapKey("key.mouse.right", 1);
        mapKey("key.mouse.middle", 2);
        mapKey("key.mouse.4", 3);
        mapKey("key.mouse.5", 4);
        mapKey("key.mouse.6", 5);
        mapKey("key.mouse.7", 6);
        mapKey("key.mouse.8", 7);
        mapKey("key.keyboard.0", 48);
        mapKey("key.keyboard.1", 49);
        mapKey("key.keyboard.2", 50);
        mapKey("key.keyboard.3", 51);
        mapKey("key.keyboard.4", 52);
        mapKey("key.keyboard.5", 53);
        mapKey("key.keyboard.6", 54);
        mapKey("key.keyboard.7", 55);
        mapKey("key.keyboard.8", 56);
        mapKey("key.keyboard.9", 57);
        mapKey("key.keyboard.a", 65);
        mapKey("key.keyboard.b", 66);
        mapKey("key.keyboard.c", 67);
        mapKey("key.keyboard.d", 68);
        mapKey("key.keyboard.e", 69);
        mapKey("key.keyboard.f", 70);
        mapKey("key.keyboard.g", 71);
        mapKey("key.keyboard.h", 72);
        mapKey("key.keyboard.i", 73);
        mapKey("key.keyboard.j", 74);
        mapKey("key.keyboard.k", 75);
        mapKey("key.keyboard.l", 76);
        mapKey("key.keyboard.m", 77);
        mapKey("key.keyboard.n", 78);
        mapKey("key.keyboard.o", 79);
        mapKey("key.keyboard.p", 80);
        mapKey("key.keyboard.q", 81);
        mapKey("key.keyboard.r", 82);
        mapKey("key.keyboard.s", 83);
        mapKey("key.keyboard.t", 84);
        mapKey("key.keyboard.u", 85);
        mapKey("key.keyboard.v", 86);
        mapKey("key.keyboard.w", 87);
        mapKey("key.keyboard.x", 88);
        mapKey("key.keyboard.y", 89);
        mapKey("key.keyboard.z", 90);
        mapKey("key.keyboard.f1", 290);
        mapKey("key.keyboard.f2", 291);
        mapKey("key.keyboard.f3", 292);
        mapKey("key.keyboard.f4", 293);
        mapKey("key.keyboard.f5", 294);
        mapKey("key.keyboard.f6", 295);
        mapKey("key.keyboard.f7", 296);
        mapKey("key.keyboard.f8", 297);
        mapKey("key.keyboard.f9", 298);
        mapKey("key.keyboard.f10", 299);
        mapKey("key.keyboard.f11", 300);
        mapKey("key.keyboard.f12", 301);
        mapKey("key.keyboard.f13", 302);
        mapKey("key.keyboard.f14", 303);
        mapKey("key.keyboard.f15", 304);
        mapKey("key.keyboard.f16", 305);
        mapKey("key.keyboard.f17", 306);
        mapKey("key.keyboard.f18", 307);
        mapKey("key.keyboard.f19", 308);
        mapKey("key.keyboard.f20", 309);
        mapKey("key.keyboard.f21", 310);
        mapKey("key.keyboard.f22", 311);
        mapKey("key.keyboard.f23", 312);
        mapKey("key.keyboard.f24", 313);
        mapKey("key.keyboard.f25", 314);
        mapKey("key.keyboard.num.lock", 282);
        mapKey("key.keyboard.keypad.0", 320);
        mapKey("key.keyboard.keypad.1", 321);
        mapKey("key.keyboard.keypad.2", 322);
        mapKey("key.keyboard.keypad.3", 323);
        mapKey("key.keyboard.keypad.4", 324);
        mapKey("key.keyboard.keypad.5", 325);
        mapKey("key.keyboard.keypad.6", 326);
        mapKey("key.keyboard.keypad.7", 327);
        mapKey("key.keyboard.keypad.8", 328);
        mapKey("key.keyboard.keypad.9", 329);
        mapKey("key.keyboard.keypad.add", 334);
        mapKey("key.keyboard.keypad.decimal", 330);
        mapKey("key.keyboard.keypad.enter", 335);
        mapKey("key.keyboard.keypad.equal", 336);
        mapKey("key.keyboard.keypad.multiply", 332);
        mapKey("key.keyboard.keypad.divide", 331);
        mapKey("key.keyboard.keypad.subtract", 333);
        mapKey("key.keyboard.down", 264);
        mapKey("key.keyboard.left", 263);
        mapKey("key.keyboard.right", 262);
        mapKey("key.keyboard.up", 265);
        mapKey("key.keyboard.apostrophe", 39);
        mapKey("key.keyboard.backslash", 92);
        mapKey("key.keyboard.comma", 44);
        mapKey("key.keyboard.equal", 61);
        mapKey("key.keyboard.grave.accent", 96);
        mapKey("key.keyboard.left.bracket", 91);
        mapKey("key.keyboard.minus", 45);
        mapKey("key.keyboard.period", 46);
        mapKey("key.keyboard.right.bracket", 93);
        mapKey("key.keyboard.semicolon", 59);
        mapKey("key.keyboard.slash", 47);
        mapKey("key.keyboard.space", 32);
        mapKey("key.keyboard.tab", 258);
        mapKey("key.keyboard.left.alt", 342);
        mapKey("key.keyboard.left.control", 341);
        mapKey("key.keyboard.left.shift", 340);
        mapKey("key.keyboard.left.win", 343);
        mapKey("key.keyboard.right.alt", 346);
        mapKey("key.keyboard.right.control", 345);
        mapKey("key.keyboard.right.shift", 344);
        mapKey("key.keyboard.right.win", 347);
        mapKey("key.keyboard.enter", 257);
        mapKey("key.keyboard.escape", 256);
        mapKey("key.keyboard.backspace", 259);
        mapKey("key.keyboard.delete", 261);
        mapKey("key.keyboard.end", 269);
        mapKey("key.keyboard.home", 268);
        mapKey("key.keyboard.insert", 260);
        mapKey("key.keyboard.page.down", 267);
        mapKey("key.keyboard.page.up", 266);
        mapKey("key.keyboard.caps.lock", 280);
        mapKey("key.keyboard.pause", 284);
        mapKey("key.keyboard.scroll.lock", 281);
        mapKey("key.keyboard.menu", 348);
        mapKey("key.keyboard.print.screen", 283);
        mapKey("key.keyboard.world.1", 161);
        mapKey("key.keyboard.world.2", 162);
    }
}
