# Default Hotkeys

This mod can set the default hotkeys for any keybindings.

## Usage

Config file `.minecraft\config\default-hotkeys.json` will auto generated after first launch.

```json5
{
  "key.advancements": {
    //Translate key
    "comment": "Advancements",
    //en_us translation
    "key": "key.keyboard.l"
    //hotkey in vanilla format
  },
  //...more
}
```

For all available key values, see
[Keys.java](https://github.com/CodeOfArdonia/DefaultHotkeys/blob/894408a90dd5aa795268dbe919ea7c9fc4866519/common/src/main/java/com/iafenvoy/dhks/Keys.java#L29)