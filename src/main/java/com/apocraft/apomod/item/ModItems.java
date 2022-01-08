package com.apocraft.apomod.item;

import com.apocraft.apomod.ApoMod;
import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ApoMod.MOD_ID);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}