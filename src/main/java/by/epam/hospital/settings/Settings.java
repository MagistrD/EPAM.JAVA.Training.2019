package by.epam.hospital.settings;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * method for reading setting from .property file
 */
public final class Settings {
    private Settings() {
        Locale locale = Locale.getDefault();
        dataBase = ResourceBundle.getBundle("info", locale);
    }

    private ResourceBundle dataBase;
    private static Settings instance;

    static {
        instance = new Settings();
    }

    /**
     * getter for property by key
     *
     * @param key key
     * @return property
     */
    public static String get(final String key) {
        return instance.dataBase.getString(key);
    }
}
