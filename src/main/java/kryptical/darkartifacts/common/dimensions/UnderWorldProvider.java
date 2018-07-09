package kryptical.darkartifacts.common.dimensions;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;

public class UnderWorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return DarkArtifactDimensions.underworldPlane;
    }

    @Override
    public String getSaveFolder()
    {
        return "UnderWorld";
    }
}
