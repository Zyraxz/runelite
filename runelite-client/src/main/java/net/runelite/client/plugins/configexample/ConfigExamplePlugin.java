package net.runelite.client.plugins.configexample;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor( //Used to inject the name, description and tags of the plugin itself.
        name = "John Example",
        description = "An Example used to teach John how to code RuneLite plugins.",
        tags = {"config", "menu", "example"},
        loadWhenOutdated = true,
        enabledByDefault = false
)

public class ConfigExamplePlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private ConfigExampleConfig config;

    @Override
    protected void startUp() throws Exception
    {
        log.info("Johns Config Example Started");
    }

    @Override
    protected void shutDown() throws Exception
    {
        log.info("Johns Config Example Ended");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
        {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "John says " + config.greeting(), null);
        }
    }

    @Provides
    ConfigExampleConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(ConfigExampleConfig.class);
    }
}