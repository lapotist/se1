package lapotist.se1;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ExtendedSwordItem extends SwordItem
{
    public static double reach = 0;
    public static double attack_range = 0;
    private static LivingEntity liver = null;
    private static boolean active = false;

    public ExtendedSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, double reachBonus, double attackReachBonus)
    {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        reach = reachBonus;
        attack_range = attackReachBonus;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(active != (((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() == this))
        {
            System.out.println("New enitiy reaching: " + entity);
            liver = (LivingEntity)entity;
            SetRange(((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() == this);
        }
        active = ((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() == this;
    }

    public void SetRange(boolean change_range)
    {
        if (change_range)
        {
            System.out.println("On");
            liver.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(reach);
            liver.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(attack_range);
        }
        else
        {
            System.out.println("Off");
            liver.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(0.0);
            liver.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(0.0);
        }
    }
}