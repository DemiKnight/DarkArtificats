package kryptical.darkartifacts.common.blocks;

import kryptical.darkartifacts.common.blocks.template.BlockBasic;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSpiritualPortal extends BlockBasic {


    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entityplayer, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        entityplayer.changeDimension(2);
        return true;
    }

}
