package net.maxmag_change.harbingerofhistory.block.custom;

import ca.weblite.objc.Client;
import net.fabricmc.tinyremapper.extension.mixin.common.data.Message;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.util.ChatMessages;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.datafixer.fix.RedstoneConnectionsFix;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.filter.TextStream;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;

import java.util.stream.Stream;

public class ShowCase extends Block {


    public ShowCase(AbstractBlock.Settings settings) {
        super(settings);
    }


    private static final VoxelShape VOXEL_SHAPE = Stream.of(
            Block.createCuboidShape(1, 9, 15, 15, 18, 15),
            Block.createCuboidShape(1, 9, 1, 15, 18, 1),
            Block.createCuboidShape(1, 9, 1, 1, 18, 15),
            Block.createCuboidShape(15, 9, 1, 15, 18, 15),
            Block.createCuboidShape(1, 6, 1, 15, 9, 15),
            Block.createCuboidShape(0, 0, 0, 16, 6, 16),
            Block.createCuboidShape(1, 18, 1, 15, 19, 15)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 6;

    }


}

