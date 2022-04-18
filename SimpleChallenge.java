package factobot.com.github.demoproject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SimpleChallenge {
    public boolean started;
    private EntityPlayer player;
    private int TotalPlacedBlocks = 0;

    public void start(EntityPlayer player) {
        this.started = true;
        this.player = player;

        // Display starting information
        GuiIngame gui = Minecraft.getMinecraft().ingameGUI;
        gui.displayTitle("Challenge", null, 1, 5, 1);
        gui.displayTitle(null, "Build 3 blocks of glass at the indicated location.", 1, 5, 1);
    }

    public void stop() {
        this.started = false;
        this.player = null;
    }

    @SubscribeEvent
    public void onPlaceBlock(BlockEvent.EntityPlaceEvent event) {
        if (!this.started) {
            return;
        }

        // Check if the block is glass
        if (event.getPlacedBlock().getBlock().getRegistryName().toString().equals("minecraft:glass")) {
            // Check if the block is placed by the player
            if (event.getEntity() instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.getEntity();
                if (player.equals(this.player)) {
                    // Check if the block is placed at the correct location
                    BlockPos pos = event.getPos();
                    if (pos.getX() == -517 && pos.getZ() == -234) {
                        this.TotalPlacedBlocks++;
                        if (this.TotalPlacedBlocks == 3) {
                            // Display success message
                            GuiIngame gui = Minecraft.getMinecraft().ingameGUI;
                            gui.displayTitle("Success", null, 1, 5, 1);
                            gui.displayTitle(null, "You have completed this challenge!", 1, 5, 1);
                        }
                    }
                }
            }
        }
    }
}
