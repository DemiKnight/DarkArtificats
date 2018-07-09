package kryptical.darkartifacts.proxy;

import kryptical.darkartifacts.DarkArtifacts;
import kryptical.darkartifacts.common.DarkArtifactsConfig;
import kryptical.darkartifacts.common.dimensions.DarkArtifactDimensions;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;


@Mod.EventBusSubscriber
public class CommonProxy {

    public static Configuration mainConfig;

    public void preInit(FMLPreInitializationEvent e) {

        DarkArtifacts.logger.warn("Config PreInit");


        File directory = e.getModConfigurationDirectory();
        mainConfig = new Configuration(new File(directory.getPath(),"darkArtifacts.cfg"));
        DarkArtifactsConfig.readConfig();

        DarkArtifactDimensions.init();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e)
    {
        if (mainConfig.hasChanged()) {
            mainConfig.save();
        }

    }

    public void registerItemRenderer() {
    }
    public void registerBlockRenderer(){}
}
