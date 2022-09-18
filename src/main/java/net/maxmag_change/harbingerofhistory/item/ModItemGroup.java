package net.maxmag_change.harbingerofhistory.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.maxmag_change.harbingerofhistory.HarbingerOfHistory;
import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(
            new Identifier(HarbingerOfHistory.MOD_ID, "tanzanite"), () -> new ItemStack(ModItems.RAW_TANZANITE));
    public static final ItemGroup SPECIAL = FabricItemGroupBuilder.build(
            new Identifier(HarbingerOfHistory.MOD_ID, "special"), () -> new ItemStack(ModBlocks.JUMPY_BLOCK));
    public static final ItemGroup SCAMP = FabricItemGroupBuilder.build(
            new Identifier(HarbingerOfHistory.MOD_ID, "scamp"), () -> new ItemStack(ModBlocks.SCAMP_ORE));
}
