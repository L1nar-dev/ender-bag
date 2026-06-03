package com.enderbag.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EnderBagItem extends Item {

    public EnderBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient()) {
            
            user.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                    (syncId, inv, player) -> GenericContainerScreenHandler.createGeneric9x3(
                            syncId, inv, player.getEnderChestInventory()
                    ),
                    Text.translatable("container.enderchest")
            ));

            user.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        return TypedActionResult.success(stack);
    }
}
