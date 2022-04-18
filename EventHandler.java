package factobot.com.github.demoproject;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

public class EventHandler {
    private DemoProject mod;
    public EventHandler(DemoProject mod) {
        this.mod = mod;
    }

    @SubscribeEvent
    public void onEntityMove(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            Entity entity = event.getEntity();
            BlockPos pos = entity.getPosition();
            if (pos.getX() > -521 && pos.getX() < -513 && pos.getZ() < -232 && pos.getZ() > -242) {
                if (!mod.simpleChallenge.started) {
                    mod.simpleChallenge.start((EntityPlayer) entity);
                }
            } else {
                if (mod.simpleChallenge.started) {
                    mod.simpleChallenge.stop();
                }
            }
        }
    }
}
