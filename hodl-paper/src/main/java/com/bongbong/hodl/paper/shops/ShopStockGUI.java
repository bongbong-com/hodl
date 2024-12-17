//package com.bongbong.hodl.paper.shops;
//
//import org.bukkit.Material;
//import org.bukkit.entity.Player;
//import org.bukkit.event.inventory.ClickType;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.bukkit.inventory.ItemStack;
//import org.jetbrains.annotations.NotNull;
//import xyz.xenondevs.invui.gui.Gui;
//import xyz.xenondevs.invui.gui.structure.Structure;
//import xyz.xenondevs.invui.inventory.VirtualInventory;
//import xyz.xenondevs.invui.item.Item;
//import xyz.xenondevs.invui.item.ItemProvider;
//import xyz.xenondevs.invui.item.builder.ItemBuilder;
//import xyz.xenondevs.invui.item.impl.AbstractItem;
//import xyz.xenondevs.invui.item.impl.SimpleItem;
//import xyz.xenondevs.invui.window.Window;
//
//public class ShopStockGUI {
//
//    public static void sendStockGUI(Player player, VirtualInventory inventory) {
//        Item border = new SimpleItem(new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE));
//
//        Structure structure = new Structure(
//                ". . . . . . . . .",
//                ". . . . . . . . .",
//                ". . . . . . . . .",
//                ". . . . . . . . .",
//                ". . . . . . . . .",
//                "# # # # < # # # #")
//                .addIngredient('.', inventory)
//                .addIngredient('#', border)
//                .addIngredient('<', new BackItem());
//
//        Gui gui = Gui.normal()
//                .setStructure(structure)
//                .build();
//
//        Window.single()
//                .setViewer(player)
//                .setTitle("Shop Stock")
//                .setGui(gui)
//                .build();
//    }
//
//    static class BackItem extends AbstractItem {
//        @Override
//        public ItemProvider getItemProvider() {
//            return new ItemBuilder(Material.RED_BED).setDisplayName("&cGo Back");
//        }
//
//        @Override
//        public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
//            EditShopGUI.sendShopGui(player);
//            notifyWindows(); // this will update the ItemStack that is displayed to the player
//        }
//    }
//
//}
