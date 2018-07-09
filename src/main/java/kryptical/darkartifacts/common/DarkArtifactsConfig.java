package kryptical.darkartifacts.common;

import kryptical.darkartifacts.DarkArtifacts;
import kryptical.darkartifacts.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

    public class DarkArtifactsConfig {

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";

    public static boolean isDebug = false;
//    public static String yourRealName = "Knight";

    /* Dimension entries */

    public static int dimensionIDSpirit = 543;
    public static int dimensionIDUnderworld = 544;
    public static int dimensionIDUpperworld = 545;



    public static void readConfig()
    {
        Configuration config = CommonProxy.mainConfig;

        try
        {
            config.load();

            initGeneralConfig(config);
            initDimensionsConfig(config);

        }
        catch(Exception e)
        {
            DarkArtifacts.logger.error("Problem loading config file!", e);
        }
        finally{
            if(config.hasChanged())
            {
                config.save();
            }
        }
    }


    private static void initGeneralConfig(Configuration configIn)
    {
        configIn.addCustomCategoryComment(CATEGORY_GENERAL,"General Settings");
        isDebug = configIn.getBoolean("isDebug", CATEGORY_GENERAL, isDebug, "Enables extra output whilst the game is setting up.");
//        yourRealName = configIn.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
    }

    private static void initDimensionsConfig(Configuration configIn)
    {
        configIn.addCustomCategoryComment(CATEGORY_DIMENSIONS,"Dimension settings");
        dimensionIDSpirit = configIn.getInt("dimensionID-Spirit",CATEGORY_DIMENSIONS, dimensionIDSpirit,2,999,"The ID for the spirit Dimension");
        dimensionIDUnderworld = configIn.getInt("dimensionID-underworld",CATEGORY_DIMENSIONS, dimensionIDUnderworld,2,999,"The ID for the underworld Dimension");
        dimensionIDUpperworld = configIn.getInt("dimensionID-upperworld",CATEGORY_DIMENSIONS, dimensionIDUpperworld,2,999,"The ID for the upperworld Dimension");

    }
}
