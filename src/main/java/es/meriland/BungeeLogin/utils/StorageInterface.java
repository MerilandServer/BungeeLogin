package es.meriland.BungeeLogin.utils;

/**
 * Created by Alvaro on 29/8/16.
 */
public interface StorageInterface {

    /**
     * Register
     * Stores a new user in the database with its password
     * @param uuid
     * @param username
     * @param password
     * @return
     */
    boolean register(String uuid, String username, String password);

    /**
     * Check
     * Returns if the provided password is equal to the stored one
     * @param uuid
     * @return
     */
    boolean check(String uuid, String password);

    /**
     * Exists
     * Returns if a user if registed
     * @param uuid
     * @return
     */
    boolean exists(String uuid);

    /**
     * Delete
     * Returns if the deletion atempt was successful
     * @param uuid
     * @return
     */
    boolean delete(String uuid);
}
