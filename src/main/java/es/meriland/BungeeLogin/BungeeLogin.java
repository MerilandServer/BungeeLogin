package es.meriland.BungeeLogin;

import es.meriland.BungeeLogin.commands.BungeeLoginCMD;
import es.meriland.BungeeLogin.utils.StorageManagerLite;
import net.md_5.bungee.api.plugin.Plugin;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

public class BungeeLogin extends Plugin {

    private BungeeList listener;

    @Override
    public void onEnable() {

        try {
            getProxy().getPluginManager().registerCommand(this, new BungeeLoginCMD(new StorageManagerLite("SHA-256")));
        } catch (NoSuchAlgorithmException e) {
            // Se puede guardar en config el algoritmo de hasheo, si pones uno incorrecto para por aqui no debería cargarse el plugin.
            e.printStackTrace();
        }

        getProxy().getPluginManager().registerListener(this, listener);
        getLogger().log(Level.INFO, "BungeeLogin v" + getDescription().getVersion() + "by " + getDescription().getAuthor());
    }

}
