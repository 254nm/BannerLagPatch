package org.l2x9.bannerlagpatch;

import org.bukkit.plugin.java.JavaPlugin;

public final class BannerLagPatch extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
