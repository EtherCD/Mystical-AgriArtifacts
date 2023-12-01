package com.ethercd.mysticalagriexpansion.item;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.ethercd.mysticalagriexpansion.lib.ModTooltips;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

@SuppressWarnings({"unused", "NullableProblems"})
public class ItemWateringCan extends ModItem {
    private boolean water = false;
    private long ticks;
    private final int range;
    private final int chance;
    private final int delay;
    private final String name;

    public ItemWateringCan(String name, int range, int chance, float multipleDelay) {
        super(name + "_watering_can");
        this.setMaxStackSize(1);
        this.range = range;
        this.chance = chance;
        this.delay = (int)Math.ceil(1000 * multipleDelay);
        this.name = name + "_watering_can";
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected) {
            this.ticks++;
            if (this.ticks % 4 == 0) {
                this.water = true;
            }
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, stack))
            return EnumActionResult.FAIL;

        if (!ModConfig.confFakePlayerWatering && player instanceof FakePlayer)
            return EnumActionResult.FAIL;


        if (this.water) {
            Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(-range, -range, -range), pos.add(range, range, range));
            for (BlockPos aoePos : blocks) {
                IBlockState aoeState = world.getBlockState(aoePos);
                if (aoeState.getBlock() instanceof BlockFarmland) {
                    int moisture = aoeState.getValue(BlockFarmland.MOISTURE);
                    if (moisture < 7) {
                        world.setBlockState(aoePos, aoeState.withProperty(BlockFarmland.MOISTURE, 7), 2);
                    }
                }
            }

            Random rand = Utils.rand;
            for (int x = -range; x <= range; x++) {
                for (int z = -range; z <= range; z++) {
                    double d0 = pos.add(x, 0, z).getX() + rand.nextFloat();
                    double d1 = pos.add(x, 0, z).getY() + 1.0D;
                    double d2 = pos.add(x, 0, z).getZ() + rand.nextFloat();

                    IBlockState state = world.getBlockState(pos);
                    if (state.isFullCube() || state.getBlock() instanceof BlockFarmland) {
                        d1 += 0.3D;
                    }

                    world.spawnParticle(EnumParticleTypes.WATER_DROP, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[5]);
                }
            }

            if (!world.isRemote) {
                this.water = false;
                int chance = Utils.randInt(1, 100);
                if (chance <= (40 + this.chance)) {
                    for (BlockPos aoePos : blocks) {
                        Block plant = world.getBlockState(aoePos).getBlock();
                        if (plant instanceof IGrowable || plant instanceof IPlantable || plant == Blocks.MYCELIUM || plant == Blocks.CHORUS_FLOWER) {
                            world.scheduleBlockUpdate(aoePos, plant, 0, this.delay);
                        }
                    }

                    return EnumActionResult.FAIL;
                }
            }
        }

        return EnumActionResult.FAIL;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
        tooltip.add(ModTooltips.WATERING_CAN + " " + Colors.DARK_PURPLE + this.range + "x" + this.range);
    }

    public void register() {
        ModItems.add(this, this.name);
    }
}
