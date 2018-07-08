package kryptical.darkartifacts.common.blocks.template;

import kryptical.darkartifacts.DarkArtifacts;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block {

    public BlockBasic()
    {
        super(Material.ROCK);

        setHardness(5F);
        setResistance(20F);
        setCreativeTab(DarkArtifacts.creativeTab);
    }


}
