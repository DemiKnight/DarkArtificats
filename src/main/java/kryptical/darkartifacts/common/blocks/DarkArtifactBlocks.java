package kryptical.darkartifacts.common.blocks;

import kryptical.darkartifacts.common.blocks.template.BlockBasic;
import kryptical.darkartifacts.common.items.DarkArtifactItems;
import kryptical.darkartifacts.common.items.template.ItemBlockBasic;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class DarkArtifactBlocks
{
    public static BlockBasic BasicBlock = new BlockBasic();

    public static ItemBlockBasic itemBlockBasicBlock = new ItemBlockBasic(BasicBlock);

    public static void registerBlocks(IForgeRegistry<Block> registry)
    {
        registry.register(initNames(BasicBlock, "basicblock"));
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        registry.register(DarkArtifactItems.initName(itemBlockBasicBlock, "basicblock"));
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        itemBlockBasicBlock.initModel();
    }


    public static Block initNames(Block blockToName, String name)
    {
        return blockToName.setUnlocalizedName(name).setRegistryName("darkartifacts:" + name);
    }

}
