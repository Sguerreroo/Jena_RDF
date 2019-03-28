package ejercicio1_rdf_jena;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.jena.atlas.logging.LogCtl;
import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Ejercicio1_RDF_Jena {
    
    private static final int TWEETS_PER_SEARCH = 190;
    private static final int MAX_TWEETS_PER_SEARCH = 200;
    private static final List<Tweet> tweets = new ArrayList<>();
    private final String class_ = "UniónDeportivaLasPalmas";

    public static void main(String[] args) {
        LogCtl.setCmdLogging();
        
        TweetModel tweetModel = new TweetModel();
        Twitter twitter = new TwitterFactory().getInstance();
        
        tweetsSearch(twitter, "#nasa");
        
        for (Tweet tweet : tweets) {
            System.out.println(tweet);
            tweetModel.addResource(twitter, tweet);
        }
        System.out.println("\n\n\n ----------------- TURTLE ----------------- \n\n");
        tweetModel.serialize();

    }

    private static void tweetsSearch(Twitter twitter, String hashtag) {
        try {
            Query query = new Query(hashtag);
            query.setCount(TWEETS_PER_SEARCH);
            List<Status> tweets_result = twitter.search(query).getTweets();
            System.out.println("Se han recuperado " + tweets_result.size() + " tweets");
            tweets_result.forEach((tweet) -> {
                System.out.println(tweet.getLang());
                System.out.println(get_lenguage(tweet.getLang()));
                tweets.add(new Tweet(
                                     tweet.getId(),
                                     tweet.getInReplyToStatusId(),
                                     new User(tweet.getUser().getName(), tweet.getUser().getLocation()),
                                     new Language(tweet.getLang(), get_lenguage(tweet.getLang())),
                                     tweet.getText(),
                                     "",
                                     tweet.getCreatedAt()));
            });
          
        } catch (TwitterException te) {
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
    
    private static String get_lenguage(String iso3){
        for (Locale country : Locale.getAvailableLocales()) {
            if(country.toLanguageTag().equals(iso3))
                return country.getDisplayLanguage();
        }
        return "";
    }
}
