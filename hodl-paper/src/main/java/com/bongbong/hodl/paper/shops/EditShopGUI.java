//package com.bongbong.hodl.paper.shops;
//
//
//import org.bukkit.block.Block;
//import org.bukkit.entity.Player;
//import org.bukkit.event.inventory.ClickType;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.jetbrains.annotations.NotNull;
//import xyz.xenondevs.invui.gui.Gui;
//import xyz.xenondevs.invui.inventory.Inventory;
//import xyz.xenondevs.invui.inventory.VirtualInventory;
//import xyz.xenondevs.invui.item.Item;
//import org.bukkit.Material;
//import xyz.xenondevs.invui.item.ItemProvider;
//import xyz.xenondevs.invui.item.builder.ItemBuilder;
//import xyz.xenondevs.invui.item.impl.AbstractItem;
//import xyz.xenondevs.invui.item.impl.SimpleItem;
//import xyz.xenondevs.invui.window.Window;
//
//import java.util.Arrays;
//
//public class EditShopGUI {
//
//    public static void sendShopGui(Player player) {
//        Item border = new SimpleItem(new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE));
//        Gui gui = Gui.normal()
//                .setStructure(
//                        "# # # # # # # # #",
//                        "# . . . . . . . #",
//                        "# # # # # # # # #")
//                .addIngredient('#', border)
//                .build();
//
//        gui.setItem(2, 1, new EditItem());
//        gui.setItem(4, 1, new StockItem());
//        gui.setItem(6, 1, new ToggleItem());
//
//        Window window = Window.single()
//                .setViewer(player)
//                .setTitle("Edit Shop")
//                .setGui(gui)
//                .build();
//
//    }
//
//    static class StockItem extends AbstractItem {
//
//        private int count;
//
//        @Override
//        public ItemProvider getItemProvider() {
//            return new ItemBuilder(Material.ANVIL).setDisplayName("&eModify Shop Settings");
//        }
//
//        @Override
//        public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
//
//            notifyWindows(); // this will update the ItemStack that is displayed to the player
//        }
//
//    }
//
//    static class EditItem extends AbstractItem {
//
//        private int count;
//
//        @Override
//        public ItemProvider getItemProvider() {
//            return new ItemBuilder(Material.CHEST).setDisplayName("&6Check Stock");
//        }
//
//        @Override
//        public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
//
//            notifyWindows(); // this will update the ItemStack that is displayed to the player
//        }
//
//    }
//
//    static class ToggleItem extends AbstractItem {
//
//        private boolean enabled;
//
//        @Override
//        public ItemProvider getItemProvider() {
//            return enabled ?
//                    new ItemBuilder(Material.LIME_DYE).setDisplayName("&aShop Enabled &7(Click to disable)") :
//                    new ItemBuilder(Material.EMERALD).setDisplayName("&cShop Disabled &7(Click to enable)");
//        }
//
//        @Override
//        public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
//
//            notifyWindows(); // this will update the ItemStack that is displayed to the player
//        }
//
//    }
//}
