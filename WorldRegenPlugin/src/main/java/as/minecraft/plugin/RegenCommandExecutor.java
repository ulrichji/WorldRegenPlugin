package as.minecraft.plugin;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import com.flowpowered.math.vector.Vector3i;

public class RegenCommandExecutor implements CommandExecutor
{

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{
		if(src instanceof Player)
		{
			Player p = (Player)src;
			World world = p.getWorld();
			Location<World> loc = p.getLocation();
			Vector3i chunkpos = loc.getChunkPosition();
			src.sendMessage(Text.of(world.getName() + ":" + chunkpos.getX() + "," + chunkpos.getY() + "," + chunkpos.getZ()));
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
	
}
