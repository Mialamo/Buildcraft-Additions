package buildcraftAdditions.items.Tools;

import buildcraft.api.recipes.IIntegrationRecipeManager;
import buildcraft.silicon.ItemRedstoneChipset;
import buildcraftAdditions.items.ItemEmeraldStick;
import net.minecraft.item.ItemStack;

/**
 * Copyright (c) 2014, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class UpgradeRecepieEmeraldStick implements IIntegrationRecipeManager.IIntegrationRecipe {

    @Override
    public double getEnergyCost() {
        return 1000;
    }

    @Override
    public boolean isValidInputA(ItemStack inputA) {
        if (inputA != null && inputA.getItem() instanceof ItemKineticTool){
            ItemKineticTool tool = (ItemKineticTool) inputA.getItem();
            return !tool.isStickInstalled(inputA, "emeraldStick") && tool.isStickInstalled(inputA, "diamondStick");
        }
        return false;
    }

    @Override
    public boolean isValidInputB(ItemStack inputB) {
        return inputB != null && inputB.getItem() instanceof ItemEmeraldStick;
    }

    @Override
    public ItemStack getOutputForInputs(ItemStack inputA, ItemStack inputB, ItemStack[] components) {
        ItemStack outputStack = inputA.copy();
        ItemKineticTool output = (ItemKineticTool) outputStack.getItem();
        output.installStick(outputStack, "emeraldStick");
        output.writeUpgrades(outputStack);
        return outputStack;
    }

    @Override
    public ItemStack[] getComponents() {
        return new ItemStack[] {ItemRedstoneChipset.Chipset.DIAMOND.getStack()};
    }

    @Override
    public ItemStack[] getExampleInputsA() {
        return new ItemStack[0];
    }

    @Override
    public ItemStack[] getExampleInputsB() {
        return new ItemStack[0];
    }
}
