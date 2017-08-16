package as.minecraft.plugin;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import com.flowpowered.math.vector.Vector3i;

import as.minecraft.evaluator.BlockEvaluator;
import as.minecraft.world.RegenChunk;
import as.minecraft.world.RegenWorldReader;

public class RegenCommandExecutor implements CommandExecutor
{
	private Logger logger;
	private RegenWorldReader worldReader;
	private WorldRegenPlugin plugin;
	
	public RegenCommandExecutor(WorldRegenPlugin worldRegenPlugin, Logger logger)
	{
		this.logger = logger;
		this.plugin = worldRegenPlugin;
		File worldFile = new File("../worldcopy");
		worldReader = new RegenWorldReader(worldFile, logger);
	}
	
	public RegenCommandExecutor(WorldRegenPlugin plugin)
	{
		this.logger = null;
		this.plugin = plugin;
	}
	
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{
		if(src instanceof Player)
		{
			Player p = (Player)src;
			World world = p.getWorld();
			Location<World> loc = p.getLocation();
			Vector3i chunkpos = loc.getChunkPosition();
			Optional<Chunk> c = world.getChunk(chunkpos);
			
			Chunk chunk = c.get();
			
			String expression = "true";
			Optional<String> expr = args.<String>getOne("expression");
			if(expr.isPresent())
				expression = expr.get();
			
			reloadChunk(chunk, src, expression);
		}
		else if(src instanceof ConsoleSource)
		{
			src.sendMessage(Text.of("You cannot issue this command from console"));
			return CommandResult.empty();
		}
		else if(src instanceof CommandBlockSource)
		{
			CommandBlockSource cbs = (CommandBlockSource) src;
			World world = cbs.getWorld();
			Location<World> loc = cbs.getLocation();
			Vector3i chunkpos = loc.getChunkPosition();
			src.sendMessage(Text.of(world.getName() + ":" + chunkpos.getX() + "," + chunkpos.getY() + "," + chunkpos.getZ()));
		}
		else
		{
			src.sendMessage(Text.of("You cannot issue this command"));
			return CommandResult.empty();
		}
		
		return CommandResult.success();
	}
	
	public void reloadChunk(Chunk c, CommandSource src, String expression)
	{
		BlockEvaluator evaluator = new BlockEvaluator();
		evaluator.setExpression(expression);
		Vector3i chunkPos = c.getPosition();
		try {
			RegenChunk regenChunk = worldReader.getRegenChunk(chunkPos.getX(), chunkPos.getZ());
			
			if(regenChunk == null)
			{
				logger.error("The chunk at X: " + chunkPos.getX() + ", Z: " + chunkPos.getZ() + " could not be loaded. Is this chunk in the backup world?"); 
				src.sendMessage(Text.of("The chunk at X: " + chunkPos.getX() + ", Z: " + chunkPos.getZ() + " could not be loaded. Is this chunk in the backup world?"));
			}
			else
			{
				regenChunk.setBlockEvaluator(evaluator);
				regenChunk.reloadChunk(c, this.plugin.getPluginContainer());	
				src.sendMessage(Text.of("Chunk at x: "+regenChunk.getChunkX() + ", y: " + regenChunk.getChunkZ() + " regenerated"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
