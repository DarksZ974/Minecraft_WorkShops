package item;

import com.example.examplemod.ExampleMod;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ModidItems {
    public static final ArrayList<Item> ITEMS;
    public static void setItemName(Item item, String name) {
        item.setRegistryName(ExampleMod.MODID, name).setUnlocalizedName(ExampleMod.MODID + "." + name);
        ITEMS.add(item);
    }
    public static void setItemBlockName(Item item, Block block) {
        item.setRegistryName(block.getRegistryName());
        ITEMS.add(item);
    }
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    protected  static void  registerItemModels(ModelRegistryEvent e) {
        ITEMS.forEach(item -> registerItemModel(item, 0));
    }
    @SideOnly(Side.CLIENT)
    protected static void registerModel(Item item, int metadata) {
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
