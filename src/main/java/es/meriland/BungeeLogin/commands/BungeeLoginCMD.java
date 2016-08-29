package es.meriland.BungeeLogin.commands;

import es.meriland.BungeeLogin.utils.CryptoManager;
import es.meriland.BungeeLogin.utils.StorageManagerLite;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Alvaro on 29/8/16.
 */
public class BungeeLoginCMD extends Command {

    StorageManagerLite storageManagerLite = null;
    CryptoManager crytoManager = null;

    public BungeeLoginCMD(StorageManagerLite storageManagerLite) {
        super("blogin");

        this.storageManagerLite = storageManagerLite;
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        Boolean output;
        if (args.length > 0) {
            switch (args[0]) {

                case "register":
                case "r":
                    output = this.register(commandSender, args[1]);
                    break;

                case "reset":
                    output = this.reset(commandSender, args[1]);
                    break;

                default:
                    output = this.login(commandSender, args[0]);
                    break;
            }
        } else {
            if (!this.storageManagerLite.exists("UUID del tipo que lo envia")) { // Checks if the player is not registerd yet
                commandSender.sendMessage(ChatColor.AQUA + "/blogin register <pass>");
            } else if (false) { // Check if payer is logged in
                commandSender.sendMessage(ChatColor.AQUA + "/blogin <pass>");
            }
        }
    }

    private boolean register(CommandSender commandSender, String password) {

        this.storageManagerLite.register("uuid", commandSender.getName(), password);

        return true;
    }

    private boolean login(CommandSender commandSender, String password) {
        return this.storageManagerLite.check("uuid", password);
    }

    private boolean reset(CommandSender commandSender, String username) {

    }
}
