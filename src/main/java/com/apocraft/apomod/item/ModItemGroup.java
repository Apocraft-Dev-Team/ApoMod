package com.apocraft.apomod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup APOMOD_TAB = new ItemGroup("apomod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.APOCOLA.get());
        }
    };

}
