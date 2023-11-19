package lapotist.se1;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DiamondTools implements ToolMaterial {

    public static final DiamondTools INSTANCE = new DiamondTools();
    @Override
    public int getDurability() {
        return 2000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 20F;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 1;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.DIAMOND_PLATE);
    }
}
