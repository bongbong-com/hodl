//package com.bongbong.hodl.paper.shops;
//
//import org.bukkit.Material;
//import org.bukkit.block.Block;
//import org.bukkit.inventory.ItemStack;
//import xyz.xenondevs.invui.inventory.VirtualInventory;
//
//import java.util.List;
//import java.util.UUID;
//
//public record Shop(int x, int y, int z, UUID owner, VirtualInventory stock, List<ListedItem> listedItems) {
//
//    public static int getMaterialCount(VirtualInventory inventory, Material material) {
//        int count = 0;
//        for (ItemStack item : inventory.getItems()) {
//            if (item != null && item.getType() == material) {
//                count += item.getAmount();
//            }
//        }
//        return count;
//    }
//
//    public static boolean removeMaterial(VirtualInventory inventory, Material material, int amount) {
//        int remaining = amount;
//        for (int i = 0; i < inventory.getSize(); i++) {
//            ItemStack item = inventory.getItem(i);
//            if (item != null && item.getType() == material) {
//                int itemAmount = item.getAmount();
//                if (itemAmount > remaining) {
//                    item.setAmount(itemAmount - remaining);
//                    inventory.setItem(null, i, item);
//                    return true;
//                } else {
//                    remaining -= itemAmount;
//                    inventory.setItem(null, i, null);
//                }
//            }
//            if (remaining <= 0) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void addMaterial(VirtualInventory inventory, Material material, int amount) {
//        int maxStackSize = material.getMaxStackSize();
//        for (int i = 0; i < inventory.getSize() && amount > 0; i++) {
//            ItemStack item = inventory.getItem(i);
//            if (item == null) {
//                int stackSize = Math.min(amount, maxStackSize);
//                inventory.setItem(null, i, new ItemStack(material, stackSize));
//                amount -= stackSize;
//            } else if (item.getType() == material && item.getAmount() < maxStackSize) {
//                int space = maxStackSize - item.getAmount();
//                int stackSize = Math.min(amount, space);
//                item.setAmount(item.getAmount() + stackSize);
//                inventory.setItem(null, i, item);
//                amount -= stackSize;
//            }
//        }
//        while (amount > 0) {
//            int stackSize = Math.min(amount, maxStackSize);
//            inventory.addItem(null, new ItemStack(material, stackSize));
//            amount -= stackSize;
//        }
//    }
//}
