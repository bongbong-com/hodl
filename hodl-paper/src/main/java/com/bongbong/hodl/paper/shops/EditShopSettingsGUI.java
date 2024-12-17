//package com.bongbong.hodl.paper.shops;
//
//import org.bukkit.Material;
//import org.bukkit.entity.Player;
//import org.bukkit.event.inventory.ClickType;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.jetbrains.annotations.NotNull;
//import xyz.xenondevs.invui.gui.Gui;
//import xyz.xenondevs.invui.gui.PagedGui;
//import xyz.xenondevs.invui.gui.structure.Markers;
//import xyz.xenondevs.invui.item.Item;
//import xyz.xenondevs.invui.item.ItemProvider;
//import xyz.xenondevs.invui.item.builder.ItemBuilder;
//import xyz.xenondevs.invui.item.impl.AbstractItem;
//import xyz.xenondevs.invui.item.impl.SimpleItem;
//import xyz.xenondevs.invui.item.impl.controlitem.PageItem;
//import xyz.xenondevs.invui.window.Window;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class EditShopSettingsGUI {
//
//    public static void itemBrowserGUI(Player player) {
//        Item border = new SimpleItem(new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE));
//
//        List<Item> items = Arrays.stream(Material.values())
//                .filter(material -> !material.isAir() && material.isItem())
//                .map(material -> new SimpleItem(new ItemBuilder(material)))
//                .collect(Collectors.toList());
//
//        Gui gui = PagedGui.items()
//                .setStructure(
//                        "# # # # # # # # #",
//                        "# x x x x x x x #",
//                        "# x x x x x x x #",
//                        "# # # < # > # # #")
//                .addIngredient('#', border)
//                .addIngredient('x', Markers.CONTENT_LIST_SLOT_HORIZONTAL) // where paged items should be put
//                .addIngredient('^', new BackItem())
//                .addIngredient('<', new PreviousItem())
//                .addIngredient('>', new ForwardItem())
//                .setContent(items)
//                .build();
//
//        Window window = Window.single()
//                .setViewer(player)
//                .setTitle("Select A Material")
//                .setGui(gui)
//                .build();
//
//    }
//
//    static class FilterItem extends AbstractItem {
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
//    static class SearchItem extends AbstractItem {
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
//    static class PreviousItem extends PageItem {
//
//        public PreviousItem() {
//            super(false);
//        }
//
//        @Override
//        public ItemProvider getItemProvider(PagedGui<?> gui) {
//            ItemBuilder builder = new ItemBuilder(Material.RED_STAINED_GLASS_PANE);
//            builder.setDisplayName("Previous page")
//                    .addLoreLines(gui.hasPreviousPage()
//                            ? "Go to page " + gui.getCurrentPage() + "/" + gui.getPageAmount()
//                            : "You can't go further back");
//
//            return builder;
//        }
//
//    }
//
//    static class ForwardItem extends PageItem {
//
//        public ForwardItem() {
//            super(true);
//        }
//
//        @Override
//        public ItemProvider getItemProvider(PagedGui<?> gui) {
//            ItemBuilder builder = new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE);
//            builder.setDisplayName("Next page")
//                    .addLoreLines(gui.hasNextPage()
//                            ? "Go to page " + (gui.getCurrentPage() + 2) + "/" + gui.getPageAmount()
//                            : "There are no more pages");
//
//            return builder;
//        }
//
//    }
//}
