package org.l2x9.bannerlagpatch;

import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.ShulkerBox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class BlockPlace implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        ItemStack itemStack = event.getItemInHand();
        ShulkerBox shulkerBox = null;
        int bannerAmt = 0;
        if (itemStack.getItemMeta() instanceof BlockStateMeta) {
            BlockStateMeta blockStateMeta = (BlockStateMeta) itemStack.getItemMeta();
            if (blockStateMeta.getBlockState() instanceof ShulkerBox) {
                shulkerBox = (ShulkerBox) blockStateMeta.getBlockState();
                Inventory boxInventory = shulkerBox.getInventory();
                for (ItemStack item : boxInventory.getContents()) {
                    if (item != null) {
                        if (item.getType() == Material.BANNER) {
                            bannerAmt = bannerAmt + item.getAmount();
                            if (bannerAmt > 32) {
                                boxInventory.remove(item);
                            }
                        }
                    }
                }
            }
            if (bannerAmt > 32) {
                blockStateMeta.setBlockState(shulkerBox);
                itemStack.setItemMeta(blockStateMeta);
                event.setCancelled(true);
            }
        }

    }
}