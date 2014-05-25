package buildcraftAdditions.villager;

import java.util.Random;

import buildcraft.BuildCraftCore;
import buildcraftAdditions.core.BuildcraftAdditions;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class VillagerTradeHandler implements IVillageTradeHandler {

    public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random)
    {
    	//canisters
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), null, new ItemStack(BuildcraftAdditions.ironCanister, 2)));
        recipeList.add(new MerchantRecipe(new ItemStack(BuildcraftAdditions.ironCanister, 1), new ItemStack(Items.emerald, 1), new ItemStack(BuildcraftAdditions.goldCanister, 1)));
        recipeList.add(new MerchantRecipe(new ItemStack(BuildcraftAdditions.goldCanister, 1), new ItemStack(Items.emerald, 4), new ItemStack(BuildcraftAdditions.diamondCanister, 1)));

        //kinetic capsules


    }

}