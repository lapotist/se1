package lapotist.se1;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static <T extends Item> T register(T item, String ID) {
        // Create the identifier for the item.
        Identifier itemID = new Identifier("se1", ID);

        // Return the registered item!
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static final Item DIAMOND_SPADE = register(
            new ShovelItem(DiamondTools.INSTANCE, 3F, 10.0F, new FabricItemSettings()),
            "diamond_spade");


    public static final Item DIAMOND_PLATE = register(
            new Item(new FabricItemSettings()),
            "diamond_plate");

    public static final Item DIAMOND_KNIFE = register(
            new SwordItem(DiamondTools.INSTANCE,15 , 15.0F, new FabricItemSettings()),
            "diamond_knife");

    public static void AddToTools(Item item) {
        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(item));
    }

    public static void initialize() {
        AddToTools(ModItems.DIAMOND_SPADE);
        AddToTools(ModItems.DIAMOND_KNIFE);
    }
}