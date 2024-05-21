package com.ethercd.mysticalagriexpansion.block.mutagenesis;

import com.blakebr0.cucumber.lib.Colors;
import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import com.ethercd.mysticalagriexpansion.block.ModBlock;
import com.ethercd.mysticalagriexpansion.gui.GuiHandler;
import com.ethercd.mysticalagriexpansion.lib.ModTooltips;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileEntityMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileInferiumMutagenesisProcessor;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings({"NullableProblems", "deprecation", "ReassignedVariable"})
public class BlockMutagenesisProcessor extends ModBlock implements ITileEntityProvider {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    private final int tier;

    public BlockMutagenesisProcessor(String name, int tier) {
        super(name, Material.ROCK, SoundType.STONE, 5.0F, 8.0F);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setCreativeTab(MACreativeTabs.CREATIVE_TAB);
        this.tier = tier;
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            IBlockState north = worldIn.getBlockState(pos.south());
            IBlockState south = worldIn.getBlockState(pos.north());
            IBlockState west = worldIn.getBlockState(pos.east());
            IBlockState east = worldIn.getBlockState(pos.west());
            EnumFacing face = (EnumFacing) state.getValue(FACING);

            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.NORTH;
            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.SOUTH;
            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.WEST;
            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.EAST;
            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
        }
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getFront(meta);
        if (facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.SOUTH;
        return getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING)).getIndex();
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityMutagenesisProcessor) {
            TileEntityMutagenesisProcessor te = (TileEntityMutagenesisProcessor) tile;

            for (int i = 0; i < te.getSizeInventory(); i++) {
                ItemStack stack = te.getStackInSlot(i);
                spawnAsEntity(world, pos, stack);
            }
        }

        super.breakBlock(world, pos, state);
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        switch (tier) {
            default:
            case 1:
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CREATION, Colors.YELLOW + 40));
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CHANCE, Colors.YELLOW + 1.0f));
                break;
            case 2:
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CREATION, Colors.GREEN + 34));
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CHANCE, Colors.GREEN + 1.25f));
                break;
            case 3:
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CREATION, Colors.GOLD + 26));
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CHANCE, Colors.GOLD + 1.5f));
                break;
            case 4:
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CREATION, Colors.AQUA + 14));
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CHANCE, Colors.AQUA + 1.75f));
                break;
            case 5:
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CREATION, Colors.RED + 6));
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CHANCE, Colors.RED + 2.0f));
                break;
            case 6:
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CREATION, Colors.DARK_PURPLE + 2));
                tooltip.add(String.format(ModTooltips.MUTAGENESIS_PROCESSOR_CHANCE, Colors.DARK_PURPLE + 3.0f));
                break;
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileInferiumMutagenesisProcessor();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float side, float hitX, float hitY) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(pos);

            if (tile instanceof TileEntityMutagenesisProcessor) {
                player.openGui(MysticalAgriexpansion.instance, GuiHandler.MUTAGENESIS_PROCESSOR, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }
}
