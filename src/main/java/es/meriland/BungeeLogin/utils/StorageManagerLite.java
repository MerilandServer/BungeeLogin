package es.meriland.BungeeLogin.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Alvaro on 29/8/16.
 * This class implements the methods in order to work with SQLite
 */
public class StorageManagerLite implements  StorageInterface {

    private CryptoManager cryptoManager = null;

    public StorageManagerLite(String algorithm) throws NoSuchAlgorithmException {
        this.cryptoManager = new CryptoManager(algorithm);
    }

    @Override
    public boolean register(String uuid, String username, String password) {
        try {

            // TODO: Mejor si no hacemos el toString();

            password = this.cryptoManager.getHashWithSalt(password, this.cryptoManager.generateSalt()).toString();

            // TODO: Escribir en la base de datos

        } catch (UnsupportedEncodingException e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean check(String uuid, String password) {

        // TODO: Consulta SQL

        byte[] salt, password; // Esto lo sacamos de la DB

        if (Arrays.equals(this.cryptoManager.getHashWithSalt(password, salt), password)) {
            // TODO: Autorizar login
        }
        return false;
    }

    @Override
    public boolean exists(String uuid) {
        return false;
    }

    @Override
    public boolean delete(String uuid) {

        // TODO: SQL DELETE FROM WHERE uuid = uuid;
        // Se devuelve si existia o no.
        return false;
    }
}
