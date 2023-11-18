package lapotist.se1;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static <T extends Item> T register(T item, String ID) {
        // Create the identifier for the item.
        Identifier itemID = new Identifier("se1", ID);

        // Register the item.
        T registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static final Item DIAMOND_SPADE = register(
            new Item(new FabricItemSettings()),
            "diamond_spade"
    );

    public static final Item DIAMOND_PLATE = register(
            new Item(new FabricItemSettings()),
            "diamond_plate");

    public static void initialize() {

    }
}