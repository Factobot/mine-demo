package factobot.com.github.demoproject;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = DemoProject.MOD_ID,
        name = DemoProject.MOD_NAME,
        version = DemoProject.VERSION
)
public class DemoProject {
    public final EventHandler eventHandler = new EventHandler(this);
    public final SimpleChallenge simpleChallenge = new SimpleChallenge();

    public static final String MOD_ID = "demoproject";
    public static final String MOD_NAME = "DemoProject";
    public static final String VERSION = "1.0-SNAPSHOT";

    @Mod.Instance(MOD_ID)
    public static DemoProject INSTANCE;

    public DemoProject() {
        MinecraftForge.EVENT_BUS.register(this.eventHandler);
        MinecraftForge.EVENT_BUS.register(this.simpleChallenge);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        System.out.println("[DemoProject] Postinit");
    }
}
