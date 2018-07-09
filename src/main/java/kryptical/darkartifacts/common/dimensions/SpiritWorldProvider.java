package kryptical.darkartifacts.common.dimensions;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class SpiritWorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return DarkArtifactDimensions.spiritPlane;
    }

    @Override
    public String getSaveFolder()
    {
        return "SpiritWorld";
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new SpiritChunkGenerator(world);
    }
}
