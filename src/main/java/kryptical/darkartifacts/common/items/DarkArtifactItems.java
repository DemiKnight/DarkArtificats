package kryptical.darkartifacts.common.items;

import kryptical.darkartifacts.common.items.template.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class DarkArtifactItems {

    //Item Registry
    public static final ItemBase BasicItem = new ItemBase();

//    public static final ItemBase BasicItem;

    public static void registerItems(IForgeRegistry<Item> registry)
    {
        registry.register(initName(BasicItem,"basicitem"));
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        BasicItem.initModel();
    }

    public static Item initName(Item itemToName, String name)
    {
        return itemToName.setUnlocalizedName(name).setRegistryName("DarkArtifacts:" + name);
    }


}
