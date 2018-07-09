package kryptical.darkartifacts.common.dimensions;

import kryptical.darkartifacts.Reference;
import kryptical.darkartifacts.common.DarkArtifactsConfig;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DarkArtifactDimensions {

    public static DimensionType spiritPlane;
    public static DimensionType underworldPlane;
    public static DimensionType upperworldPlane;

    private static void registerDimensionTypes()
    {
        spiritPlane = DimensionType.register(Reference.MODID,"_spirit", DarkArtifactsConfig.dimensionIDSpirit, SpiritWorldProvider.class,false);
        underworldPlane = DimensionType.register(Reference.MODID,"_underworld", DarkArtifactsConfig.dimensionIDUnderworld, UnderWorldProvider.class,false);
        upperworldPlane = DimensionType.register(Reference.MODID,"_upperworld", DarkArtifactsConfig.dimensionIDUpperworld, UpperWorldProvider.class,false);
    }

    private static void registerDimensions()
    {
        DimensionManager.registerDimension(DarkArtifactsConfig.dimensionIDSpirit, spiritPlane);
        DimensionManager.registerDimension(DarkArtifactsConfig.dimensionIDUnderworld, underworldPlane);
        DimensionManager.registerDimension(DarkArtifactsConfig.dimensionIDUpperworld, upperworldPlane);
    }

    public static void init()
    {
        registerDimensionTypes();
        registerDimensions();
    }


    public static Integer findFreeDimensionID()
    {
        for (int i=2; i <= 999; i++)
        {
            if (!DimensionManager.isDimensionRegistered(i))
            {
                // DEBUG
                System.out.println("Found free dimension ID = "+i);
                return i;
            }
        }

        // DEBUG
        System.out.println("ERROR: Could not find free dimension ID");
        return 534;
    }
}
