package kryptical.darkartifacts.common.dimensions;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;

public class UpperWorldProvider extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return DarkArtifactDimensions.upperworldPlane;
    }

    @Override
    public String getSaveFolder()
    {
        return "UpperWorld";
    }
}
