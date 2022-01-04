package draylar.gofish.mixin;

import draylar.gofish.item.ExtendedFishingRodItem;
import net.minecraft.client.render.entity.FishingBobberEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FishingBobberEntityRenderer.class)
public class FishingBobberEntityRendererMixin {

	@Redirect(
	    method = "render",
	    at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z")
    )
    private boolean itemIsRod(ItemStack itemStack, Item item) {
        // if hand stack item is item original method looks for OR is new fishing rod
        if (itemStack.getItem() == item || itemStack.getItem() instanceof ExtendedFishingRodItem) {
            // return true
            return true;
        }
        return false;
    }
}
