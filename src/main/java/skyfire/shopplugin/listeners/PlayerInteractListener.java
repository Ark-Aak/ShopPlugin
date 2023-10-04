package skyfire.shopplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerInteractListener implements Listener {

    Map<UUID, Long> intervals = new HashMap<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        //Player interact event
        UUID uuid = event.getPlayer().getUniqueId();
        if (intervals.containsKey(uuid)) {
            //Do nothing when the interval is too small
            if (System.currentTimeMillis() - intervals.get(uuid) < 50) {
                return;
            }
        }
        intervals.put(uuid, System.currentTimeMillis());
    }
}
