# Default Hotkeys

This mod can set the default hotkeys for any keybindings.

## Usage

Config file `.minecraft\config\default-hotkeys.json` will auto generated after first launch.

```json5
{
  //Translate key
  "key.advancements": {
    //en_us translation
    "comment": "Advancements",
    //hotkey in vanilla format
    "key": "key.keyboard.l"
  },
  //...more
}
```

For all available key values, see
[Keys.java](https://github.com/CodeOfArdonia/DefaultHotkeys/blob/894408a90dd5aa795268dbe919ea7c9fc4866519/common/src/main/java/com/iafenvoy/dhks/Keys.java#L29)
