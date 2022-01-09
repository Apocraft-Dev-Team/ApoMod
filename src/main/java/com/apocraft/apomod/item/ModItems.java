package com.apocraft.apomod.item;

import com.apocraft.apomod.ApoMod;
import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ApoMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


    // APOCOLA ITEM
    public static final RegistryObject<Item> APOCOLA = ITEMS.register("apocola",
            () -> new Item(new Item.Properties().tab(ModItemGroup.APOMOD_TAB).rarity(Rarity.RARE))
    );

    // M16A4 ITEM
    public static final RegistryObject<Item> AssaultRifleM16A4 = ITEMS.register("m16a4",
            () -> new Item(new Item.Properties().tab(ModItemGroup.APOMOD_TAB).rarity(Rarity.COMMON))
    );

}
