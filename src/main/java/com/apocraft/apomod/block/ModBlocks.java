package com.apocraft.apomod.block;

import com.apocraft.apomod.ApoMod;
import com.apocraft.apomod.item.ModItemGroup;
import com.apocraft.apomod.item.ModItems;
import net.minecraft.advancements.criterion.EntityTypePredicate;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.ICollisionReader;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBlocks {

    // FUNCTIONS & REFS

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ApoMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroup.APOMOD_TAB).rarity(Rarity.COMMON)));
    }

    // BLOCKS

    // SANDBAGS
    public static final RegistryObject<Block> SANDBAGS = BLOCKS.register("sandbags_block",
            () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_BROWN)
                    .sound(SoundType.SAND)
                    .harvestTool(ToolType.SHOVEL).harvestLevel(0)
                    .strength(4.5f, 40.0f)
            )
    );

    private static final Optional<VoxelShape> SANDBAGS_COLLISION = Stream.of(
            Block.box(0, 0, 0, 16, 12, 8),
            Block.box(8.670431198830428, 8, -0.5474962809889945, 16.67043119883043, 12, 4.4525037190110055),
            Block.box(3, 4, 0, 13, 8, 5),
            Block.box(-0.4525037190110055, 0, -0.6704311988304283, 7.5474962809889945, 4, 4.329568801169572),
            Block.box(8.670431198830428, 0, -0.5474962809889945, 16.67043119883043, 4, 4.4525037190110055),
            Block.box(-0.4525037190110055, 8, -0.6704311988304283, 7.5474962809889945, 12, 4.329568801169572)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR));

    public VoxelShape GetShape(BlockState state, Template.BlockInfo level, BlockPos position, ICollisionReader context) {
        return SANDBAGS_COLLISION.orElse(VoxelShapes.block());
    }



    //

}
