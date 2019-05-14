package by.epam.hospital.config;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Service classes that extract information from properties-files
 */
public final class ConfigurationManager {
    private ConfigurationManager() {
        Locale locale = Locale.getDefault();
        dataBase = ResourceBundle.getBundle("info", locale);
    }

    private ResourceBundle dataBase;
    private static ConfigurationManager instance;

    static {
        instance = new ConfigurationManager();
    }

    /**
     * Method that get property
     *
     * @param key key of property
     * @return property
     */
    public static String get(final String key) {
        return instance.dataBase.getString(key);
    }
}
