package kryptical.darkartifacts;

import kryptical.darkartifacts.client.DarkArtifactsCreativeTabs;
import kryptical.darkartifacts.common.blocks.DarkArtifactBlocks;
import kryptical.darkartifacts.common.items.DarkArtifactItems;
import kryptical.darkartifacts.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

import java.sql.Ref;

/**
 *  The mod
 */
@Mod(
        modid = Reference.MODID,
        name = Reference.NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS,
        useMetadata = true,
        updateJSON = Reference.MOD_UPDATE_JSON,
        dependencies = Reference.DEPENDENCIES
)
@Mod.EventBusSubscriber()
public class DarkArtifacts
{
    /**
     * Used to output to the console.
     */
    public static Logger logger;

    /**
     *
     */
    public static final DarkArtifactsCreativeTabs creativeTab = new DarkArtifactsCreativeTabs();

    /**
     * Used to call functions that are specific to running on the server or client. Also functions
     * that are universal.
     *
     * Examples would be: registering blocks and items for both
     *
     */
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS_PATH, serverSide = Reference.COMMON_PROXY_CLASS_PATH)
    public static CommonProxy proxy;


    /**
     * Access the
     */
    @Mod.Instance
    public static DarkArtifacts instance;

    /***
     *      ___   _              _
     *     | _ ) | |  ___   __  | |__  ___
     *     | _ \ | | / _ \ / _| | / / (_-<
     *     |___/ |_| \___/ \__| |_\_\ /__/
     *
     */
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        //Register the blocks
        DarkArtifactBlocks.registerBlocks(event.getRegistry());
    }


    /***
     *      ___   _
     *     |_ _| | |_   ___   _ __    ___
     *      | |  |  _| / -_) | '  \  (_-<
     *     |___|  \__| \___| |_|_|_| /__/
     *
     */
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        //Register Items
        DarkArtifactItems.registerItems(event.getRegistry());
        //Register ItemBlocks; blocks inside the inventory
        DarkArtifactBlocks.registerItemBlocks(event.getRegistry());
    }



    /***
     *      __  __            _         _
     *     |  \/  |  ___   __| |  ___  | |  ___
     *     | |\/| | / _ \ / _` | / -_) | | (_-<
     *     |_|  |_| \___/ \__,_| \___| |_| /__/
     *
     */
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        proxy.registerItemRenderer();
        proxy.registerBlockRenderer();
    }

    /** EVENTS */

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();



        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());


        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent  event)
    {


        proxy.postInit(event);
    }
}
