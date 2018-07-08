package kryptical.darkartifacts.common.items.template;

import kryptical.darkartifacts.DarkArtifacts;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item {

    public ItemBase()
    {
        super();
        setCreativeTab(DarkArtifacts.creativeTab);
    }


    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(this,0, new ModelResourceLocation(getRegistryName(),"inventory"));
    }

}

