package net.maxmag_change.harbingerofhistory.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class GoldFence extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public GoldFence(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(7, 6, 7, 9, 8, 9),
            Block.createCuboidShape(7, 6, 2, 9, 8, 5),
            Block.createCuboidShape(7, 10, 2, 9, 12, 5),
            Block.createCuboidShape(7, 14, 2, 9, 16, 5),
            Block.createCuboidShape(7, 6, 11, 9, 8, 14),
            Block.createCuboidShape(7, 10, 11, 9, 12, 14),
            Block.createCuboidShape(7, 14, 11, 9, 16, 14),
            Block.createCuboidShape(7, 14, 7, 9, 16, 9),
            Block.createCuboidShape(7, 10, 7, 9, 12, 9),
            Block.createCuboidShape(7, 0, 14, 9, 18, 16),
            Block.createCuboidShape(7, 0, 9, 9, 18, 11),
            Block.createCuboidShape(7, 0, 5, 9, 18, 7),
            Block.createCuboidShape(7, 0, 0, 9, 18, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(7, 6, 7, 9, 8, 9),
            Block.createCuboidShape(2, 6, 7, 5, 8, 9),
            Block.createCuboidShape(2, 10, 7, 5, 12, 9),
            Block.createCuboidShape(2, 14, 7, 5, 16, 9),
            Block.createCuboidShape(11, 6, 7, 14, 8, 9),
            Block.createCuboidShape(11, 10, 7, 14, 12, 9),
            Block.createCuboidShape(11, 14, 7, 14, 16, 9),
            Block.createCuboidShape(7, 14, 7, 9, 16, 9),
            Block.createCuboidShape(7, 10, 7, 9, 12, 9),
            Block.createCuboidShape(14, 0, 7, 16, 18, 9),
            Block.createCuboidShape(9, 0, 7, 11, 18, 9),
            Block.createCuboidShape(5, 0, 7, 7, 18, 9),
            Block.createCuboidShape(0, 0, 7, 2, 18, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(7, 6, 7, 9, 8, 9),
            Block.createCuboidShape(7, 6, 2, 9, 8, 5),
            Block.createCuboidShape(7, 10, 2, 9, 12, 5),
            Block.createCuboidShape(7, 14, 2, 9, 16, 5),
            Block.createCuboidShape(7, 6, 11, 9, 8, 14),
            Block.createCuboidShape(7, 10, 11, 9, 12, 14),
            Block.createCuboidShape(7, 14, 11, 9, 16, 14),
            Block.createCuboidShape(7, 14, 7, 9, 16, 9),
            Block.createCuboidShape(7, 10, 7, 9, 12, 9),
            Block.createCuboidShape(7, 0, 14, 9, 18, 16),
            Block.createCuboidShape(7, 0, 9, 9, 18, 11),
            Block.createCuboidShape(7, 0, 5, 9, 18, 7),
            Block.createCuboidShape(7, 0, 0, 9, 18, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(7, 6, 7, 9, 8, 9),
            Block.createCuboidShape(2, 6, 7, 5, 8, 9),
            Block.createCuboidShape(2, 10, 7, 5, 12, 9),
            Block.createCuboidShape(2, 14, 7, 5, 16, 9),
            Block.createCuboidShape(11, 6, 7, 14, 8, 9),
            Block.createCuboidShape(11, 10, 7, 14, 12, 9),
            Block.createCuboidShape(11, 14, 7, 14, 16, 9),
            Block.createCuboidShape(7, 14, 7, 9, 16, 9),
            Block.createCuboidShape(7, 10, 7, 9, 12, 9),
            Block.createCuboidShape(14, 0, 7, 16, 18, 9),
            Block.createCuboidShape(9, 0, 7, 11, 18, 9),
            Block.createCuboidShape(5, 0, 7, 7, 18, 9),
            Block.createCuboidShape(0, 0, 7, 2, 18, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
