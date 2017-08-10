package as.minecraft.plugin;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import com.google.inject.Inject;

@Plugin(id="worldregenplugin", name="World Regen Plugin", version = "0.0.1")
public class WorldRegenPlugin
{
	@Inject
	private Logger logger;
	
	@Listener
	public void onServerStart(GameStartedServerEvent event)
	{
		logger.info("World regen plugin started!");
		buildCommands();
	}
	
	@Inject
	private void setLogger(Logger logger)
	{
		this.logger = logger;
	}
	
	public Logger getLogger()
	{
		return logger;
	}
	
	private void buildCommands()
	{
		CommandSpec commandSpec = CommandSpec.builder()
				.description(Text.of("Regenerate current chunk"))
				.permission("worldregenplugin.command.regenerate")
				.executor(new RegenCommandExecutor())
				.build();
		
		Sponge.getCommandManager().register(this, commandSpec, "regen", "regenerate");
	}
}
