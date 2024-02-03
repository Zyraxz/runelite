package net.runelite.client.plugins.configexample;

//Mandatory Imports
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("configexample")
public interface ConfigExampleConfig extends Config {
    @ConfigItem(
            position = 1,
            keyName = "textGreeting",
            name = "Welcome Greeting",
            description = "The message to show to the user when they login"
    )
    default String greeting(){
        return "Hello";
    }
    @ConfigItem(
            position = 2,
            keyName = "booleanConfig",
            name = "Boolean Checkbox",
            description = "Boolean Checkbox True/False, no effect."
    )
    default boolean booleanConfig() { return false; }

    @ConfigItem(
            position = 3,
            keyName = "integerConfig",
            name = "Integer Config",
            description = "Integer config for the John Example, no effect."
    )
    default int intConfig() { return 1; }

    enum OptionEnum{
        PIPES,
        PILLARS,
        GLEEBER
    }
    @ConfigItem(
            position = 4,
            keyName = "enumConfig",
            name = "Enumerator Config",
            description = "Enumerator for the John Example, no effect."
            )
    default OptionEnum enumConfig() {return OptionEnum.PILLARS;}
}
