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

public class Lantern extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public Lantern(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(6, 15, 6, 10, 17, 10),
            Block.createCuboidShape(6, 12, 6, 10, 13, 10),
            Block.createCuboidShape(5, 10, 5, 11, 11, 11),
            Block.createCuboidShape(5, 2, 5, 11, 3, 11),
            Block.createCuboidShape(5, 3, 5, 6, 10, 6),
            Block.createCuboidShape(5, 3, 10, 6, 10, 11),
            Block.createCuboidShape(10, 3, 10, 11, 10, 11),
            Block.createCuboidShape(10, 3, 5, 11, 10, 6),
            Block.createCuboidShape(7, 14, 7, 9, 15, 9),
            Block.createCuboidShape(7, 13, 7, 9, 14, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(6, 15, 6, 10, 17, 10),
            Block.createCuboidShape(6, 12, 6, 10, 13, 10),
            Block.createCuboidShape(5, 10, 5, 11, 11, 11),
            Block.createCuboidShape(5, 2, 5, 11, 3, 11),
            Block.createCuboidShape(5, 3, 5, 6, 10, 6),
            Block.createCuboidShape(5, 3, 10, 6, 10, 11),
            Block.createCuboidShape(10, 3, 10, 11, 10, 11),
            Block.createCuboidShape(10, 3, 5, 11, 10, 6),
            Block.createCuboidShape(7, 14, 7, 9, 15, 9),
            Block.createCuboidShape(7, 13, 7, 9, 14, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(6, 15, 6, 10, 17, 10),
            Block.createCuboidShape(6, 12, 6, 10, 13, 10),
            Block.createCuboidShape(5, 10, 5, 11, 11, 11),
            Block.createCuboidShape(5, 2, 5, 11, 3, 11),
            Block.createCuboidShape(5, 3, 5, 6, 10, 6),
            Block.createCuboidShape(5, 3, 10, 6, 10, 11),
            Block.createCuboidShape(10, 3, 10, 11, 10, 11),
            Block.createCuboidShape(10, 3, 5, 11, 10, 6),
            Block.createCuboidShape(7, 14, 7, 9, 15, 9),
            Block.createCuboidShape(7, 13, 7, 9, 14, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(6, 15, 6, 10, 17, 10),
            Block.createCuboidShape(6, 12, 6, 10, 13, 10),
            Block.createCuboidShape(5, 10, 5, 11, 11, 11),
            Block.createCuboidShape(5, 2, 5, 11, 3, 11),
            Block.createCuboidShape(5, 3, 5, 6, 10, 6),
            Block.createCuboidShape(5, 3, 10, 6, 10, 11),
            Block.createCuboidShape(10, 3, 10, 11, 10, 11),
            Block.createCuboidShape(10, 3, 5, 11, 10, 6),
            Block.createCuboidShape(7, 14, 7, 9, 15, 9),
            Block.createCuboidShape(7, 13, 7, 9, 14, 9)
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
