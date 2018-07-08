package kryptical.darkartifacts.client;

import kryptical.darkartifacts.Reference;
import kryptical.darkartifacts.common.items.DarkArtifactItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import java.rmi.activation.ActivationGroup_Stub;

public class DarkArtifactsCreativeTabs extends CreativeTabs {

    public DarkArtifactsCreativeTabs()
    {
        super(Reference.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(DarkArtifactItems.BasicItem);
    }
}
