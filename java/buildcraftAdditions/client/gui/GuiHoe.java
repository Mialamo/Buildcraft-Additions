package buildcraftAdditions.client.gui;

import buildcraftAdditions.core.Utils;
import buildcraftAdditions.items.ItemMegaHoe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiHoe extends GuiContainer {
	
	public static ResourceLocation texture = new ResourceLocation("bcadditions", "textures/gui/GUITool.png");
	ItemMegaHoe hoe;
	ItemStack stack;
	EntityPlayer player;

	public GuiHoe(InventoryPlayer inventoryplayer, ItemMegaHoe hoe, IInventory inventory, ItemStack stack, EntityPlayer player) {
		super(new ContainerHoe(inventoryplayer, hoe, inventory, stack, player));
		this.hoe = hoe;
		this.stack = stack;
		this.player = player;
	}
	
	@Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);
        String title = Utils.localize("item.megaHoe.name");
        fontRendererObj.drawString(Utils.localize(title), (xSize - fontRendererObj.getStringWidth(title)) / 2, 6, 0x404040);
        fontRendererObj.drawString(Utils.localize("gui.inventory"), 8, (ySize - 110) + 2, 0x404040);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	}
	
	@Override
    public void onGuiClosed() {
        hoe.readBateries(stack, player);
    }

}