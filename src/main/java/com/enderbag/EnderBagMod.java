package com.enderbag;

import com.enderbag.item.EnderBagItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnderBagMod implements ModInitializer {

    public static final String MOD_ID = "enderbag";

    public static final Item ENDER_BAG = new EnderBagItem(
            new Item.Settings().maxCount(1)
    );

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "ender_bag"), ENDER_BAG);

      
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ENDER_BAG);
        });
    }
}
