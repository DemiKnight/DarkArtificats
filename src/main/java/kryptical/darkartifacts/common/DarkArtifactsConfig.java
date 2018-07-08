package kryptical.darkartifacts.common;

import kryptical.darkartifacts.DarkArtifacts;
import kryptical.darkartifacts.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

    public class DarkArtifactsConfig {

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";

    public static boolean isDebug = false;
//    public static String yourRealName = "Knight";


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
    }
}
