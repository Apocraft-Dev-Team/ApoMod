package com.apocraft.apomod.world.biome;

import com.apocraft.apomod.ApoMod;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }

    private static int calculateSkyColor(float input) {
        float lvt_1_1_ = input / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, ApoMod.MOD_ID);



    public static final RegistryObject<Biome> HELLFIRE_BIOME = BIOMES.register("hellfire_biome",
            () -> makeHellfireBiome(() -> ModConfiguredSurfaceBuilders.HELLFIRE_SURFACE, 0.125f, 0.05f));

    private static Biome makeHellfireBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.desertSpawns(mobspawninfo$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder())
                .surfaceBuilder(ConfiguredSurfaceBuilders.DESERT);

        DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDesertVegetation(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDesertExtraDecoration(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addSurfaceFreezing(biomegenerationsettings$builder);
        return (new Biome.Builder())
                .precipitation(Biome.RainType.NONE)
                .biomeCategory(Biome.Category.DESERT)
                .depth(depth).scale(scale)
                .temperature(4.0F).downfall(-1.0F)
                .specialEffects((new BiomeAmbience.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(4.0F))
                        .ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()
                ).mobSpawnSettings(mobspawninfo$builder.build())
                .generationSettings(biomegenerationsettings$builder.build())
                .build();
    }

}
