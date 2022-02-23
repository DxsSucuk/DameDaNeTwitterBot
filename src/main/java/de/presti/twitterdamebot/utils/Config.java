package de.presti.twitterdamebot.utils;

import org.simpleyaml.configuration.file.FileConfiguration;
import org.simpleyaml.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    FileConfiguration cfg;

    public void init() {

        cfg = getConfig();

        if (!getFile().exists()) {
            cfg.options().copyDefaults(true);
            cfg.options().copyHeader(true);
            cfg.options().header("""
                    ################################
                    #                              #
                    # Dame Da Ne Bot Config File   #
                    # by Presti                    #
                    #                              #
                    ################################
                    """);
            cfg.addDefault("twitter.consumer.key", "yourTwitterConsumerKey");
            cfg.addDefault("twitter.consumer.secret", "yourTwitterConsumerSecret");
            cfg.addDefault("twitter.access.key", "yourTwitterAccessKey");
            cfg.addDefault("twitter.access.secret", "yourTwitterAccessSecret");

            try {
                cfg.save(getFile());
            } catch (Exception ignored) {
            }
        }
    }

    public FileConfiguration getConfig() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public File getFile() {
        return new File("config.yml");
    }

}
