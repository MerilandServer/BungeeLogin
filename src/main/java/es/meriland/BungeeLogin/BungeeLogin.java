package es.meriland.BungeeLogin;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public class BungeeLogin extends Plugin {

    private BungeeList listener;

    @Override
    public void onEnable() {

        getProxy().getPluginManager().registerListener(this, listener);
        getLogger().log(Level.INFO, "BungeeLogin v" + getDescription().getVersion() + "by " + getDescription().getAuthor());
    }

}
