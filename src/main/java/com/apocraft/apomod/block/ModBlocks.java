package com.apocraft.apomod.block;

import com.apocraft.apomod.ApoMod;
import com.apocraft.apomod.item.ModItemGroup;
import com.apocraft.apomod.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    // FUNCTIONS & REFS

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ApoMod.MOD_ID);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroup.APOMOD_TAB).rarity(Rarity.COMMON))
        );
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // BLOCKS

    public static final RegistryObject<Block> SANDBAGS = registerBlock("sandbags_block",
            () -> new Block(AbstractBlock.Properties.of(Material.SAND)
                    .harvestLevel(0)
                    .harvestTool(ToolType.SHOVEL)
                    .sound(SoundType.SAND)
                    .speedFactor(1.0f)
                    .dynamicShape()
            )
    );

}
