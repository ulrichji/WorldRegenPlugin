package as.minecraft.plugin;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import com.google.inject.Inject;

@Plugin(id="worldregenplugin", name="World Regen Plugin", version = "0.0.3")
public class WorldRegenPlugin
{
	@Inject
	private Logger logger;
	@Inject
	private PluginContainer container;
	
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
	
	@Inject
	private void setPluginContainer(PluginContainer container)
	{
		this.container = container;
	}
	
	public PluginContainer getPluginContainer()
	{
		return container;
	}
	
	private void buildCommands()
	{
		CommandSpec commandSpec = CommandSpec.builder()
				.description(Text.of("Regenerate current chunk"))
				.permission("worldregenplugin.command.regenerate")
				.executor(new RegenCommandExecutor(this, logger))
				.arguments(GenericArguments.flags().valueFlag(GenericArguments.string(Text.of("expression")),
						"e").buildWith(GenericArguments.none()))
				.build();
		
		Sponge.getCommandManager().register(this, commandSpec, "regen", "regenerate");
	}
}
