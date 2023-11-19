package lapotist.se1.mixin;

import lapotist.se1.ExtendedSwordItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin
{
	private ItemStack selectedItem;

	@Inject(at = @At("HEAD"), method = "dropItem*")
	private void dropSelectedItem(CallbackInfoReturnable info)
	{
		System.out.println("Item dropped");
		if(this.selectedItem.getItem() instanceof ExtendedSwordItem)
		{
			System.out.println("Extended Dong dropped");
			((ExtendedSwordItem)this.selectedItem.getItem()).SetRange(false);
		}
	}
}


