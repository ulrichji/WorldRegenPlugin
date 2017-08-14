package as.minecraft.world;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;

import com.flowpowered.nbt.CompoundTag;
import com.flowpowered.nbt.Tag;
import com.flowpowered.nbt.stream.NBTInputStream;

public class RegenWorldReader
{
	private File file;
	private Logger logger = null;
	
	public RegenWorldReader(File worldFile)
	{
		this.file = worldFile;
	}
	
	public RegenWorldReader(File worldFile, Logger logger)
	{
		this.file = worldFile;
		this.logger = logger;
	}
	
	public void setLogger(Logger logger)
	{
		this.logger = logger;
	}
	
	public RegenChunk getRegenChunk(int x, int z) throws IOException
	{
		DataInputStream stream = RegionFileCache.getChunkDataInputStream(this.file, x, z);
		
		//Stream is null if the chunk doesn't exist
		if(stream == null)
			return null;
		
		@SuppressWarnings("resource")
		NBTInputStream nbt = new NBTInputStream(stream, false);
		
		@SuppressWarnings("unchecked")
		Tag<CompoundTag> root = nbt.readTag();
		RegenChunk chunk = new RegenChunk(root, logger);
		
		return chunk;
	}
}
