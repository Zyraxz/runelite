package net.runelite.client.plugins.configexample;

//Mandatory Imports
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("configexample")
public interface ConfigExampleConfig extends Config {
    @ConfigItem(
            position = 1,
            keyName = "exampleconfig",
            name = "Welcome Greeting",
            description = "The message to show to the user when they login"
    )
    default String greeting(){
        return "Hello";
    }
}
