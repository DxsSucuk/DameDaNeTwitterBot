package de.presti.twitterdamebot.main;

import de.presti.twitterdamebot.utils.Config;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Main {

    Config config;

    private static Main instance;

    Twitter twitter;

    public static void main(String[] args) throws TwitterException {
        instance = new Main();

        instance.config = new Config();
        instance.config.init();

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();

        configurationBuilder.setOAuthConsumerKey(Main.getInstance().getConfig().getConfig().getString("twitter.consumer.key"));
        configurationBuilder.setOAuthConsumerSecret(Main.getInstance().getConfig().getConfig().getString("twitter.consumer.secret"));
        configurationBuilder.setOAuthAccessToken(Main.getInstance().getConfig().getConfig().getString("twitter.access.key"));
        configurationBuilder.setOAuthAccessTokenSecret(Main.getInstance().getConfig().getConfig().getString("twitter.access.secret"));

        instance.twitter = new TwitterFactory(configurationBuilder.build()).getInstance();

        instance.twitter.updateStatus("Test!");
    }

    public static Main getInstance() {
        return instance;
    }

    public Config getConfig() {
        return config;
    }

}
