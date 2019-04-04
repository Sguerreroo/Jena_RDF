package ejercicio1_rdf_jena;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.AS;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.ORG;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RSS;
import org.apache.jena.vocabulary.VCARD;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TweetModel {
    private final Model model;
    private final String baseURI = "http://www.si2.com/si2/";
    private int tweetCount;

    public TweetModel() {
        this.model = ModelFactory.createDefaultModel();
        
        model.setNsPrefix("si2", this.baseURI);
        model.setNsPrefix("dce", "http://purl.org/dc/elements/1.1/"); //id, date, creator, language
        model.setNsPrefix("vcard", "http://www.w3.org/2001/vcard-rdf/3.0#"); // label, nickname
        model.setNsPrefix("rss", "http://purl.org/rss/1.0/"); // text
        model.setNsPrefix("org", "http://www.w3.org/ns/org#"); // location
        model.setNsPrefix("as", "http://www.w3.org/ns/activitystreams#"); // replyTo
        
        this.tweetCount = 1;
    }
    
    public Resource addResource(Twitter twitter, Tweet tw) {
        User user = tw.getUser();
        Language language_ = tw.getLanguage();
        
        Property language_identifier =  ResourceFactory.createProperty(baseURI + language_.getId());
        
        Resource tweet = model.createResource(baseURI + "tweet_" + this.tweetCount++);
        Resource author = model.createResource(baseURI + "user_" + user.getName().replace(" ", ""));
        Resource language = model.createResource(baseURI + "language_" + language_.getLabel());
        Resource hashtag = model.createResource(baseURI + tw.getHashtag().substring(1));
        Resource topic = model.createResource(baseURI + "topic_" + tw.getClass_());
        
        tweet.addProperty(DC_11.creator, author)
             .addProperty(DC_11.relation, hashtag)
             .addLiteral(DC_11.identifier, tw.getId())
             .addLiteral(DC_11.date, tw.getDate().toString())
             .addLiteral(RSS.textinput, tw.getText());
        
        author.addLiteral(VCARD.NICKNAME, user.getName());
        
        if (!user.getLocation().isEmpty())
            author.addLiteral(ORG.location, user.getLocation());
        
        if (!language_.getLabel().isEmpty() && !language_.getLabel().equals(" ")) {
            tweet.addProperty(DC_11.language, language);
            language.addLiteral(language_identifier, language_.getId())
                    .addLiteral(VCARD.LABEL, language_.getLabel());
        }
        
        hashtag.addProperty(RDF.type, topic);
        
        topic.addLiteral(VCARD.LABEL, tw.getClass_());
        
        Status tweetReply = checkIfReply(twitter, tw);
        
        if (tweetReply != null) {
            Tweet new_tweet = new Tweet(
                                    tweetReply.getId(),
                                    -1,
                                    new User(tweetReply.getUser().getName(), tweetReply.getUser().getLocation()),
                                    new Language(tweetReply.getLang(), get_lenguage(tweetReply.getLang())),
                                    tweetReply.getText(),
                                    tw.getClass_(),
                                    tw.getHashtag(),
                                    tweetReply.getCreatedAt());
            Resource replyToTweetResource = addResource(twitter, new_tweet);
            tweet.addProperty(AS.inReplyTo, replyToTweetResource);
        }

        return tweet;
    }
    
    public void serializeTurtle() {
        if (!model.isEmpty()) {
            try {
                File file = new File("example.ttl");
                String path = file.getAbsolutePath();
                FileOutputStream fOS = new FileOutputStream(file);
                RDFDataMgr.write(fOS, model, Lang.TURTLE);
                fOS.close();
                JOptionPane.showMessageDialog(null,
                                              "Su fichero de exportación ha sido creado correctamente en " + path,
                                              "Exportación",
                                              JOptionPane.PLAIN_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                                              "Ha ocurrido un error con su fichero de exportación",
                                              "Exportación",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                                              "Antes de exportar debe realizar alguna búsqueda",
                                              "Exportación",
                                              JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void serializeXML() {
         if (!model.isEmpty()) {
            try {
                File file = new File("example.xml");
                String path = file.getAbsolutePath();
                FileOutputStream fOS = new FileOutputStream(file);
                RDFDataMgr.write(fOS, model, Lang.RDFXML);
                fOS.close();
                JOptionPane.showMessageDialog(null,
                                              "Su fichero de exportación ha sido creado correctamente en " + path,
                                              "Exportación",
                                              JOptionPane.PLAIN_MESSAGE);
            }  catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                                              "Ha ocurrido un error con su fichero de exportación",
                                              "Exportación",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                                              "Antes de exportar debe realizar alguna búsqueda",
                                              "Exportación",
                                              JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Status checkIfReply(Twitter twitter, Tweet tw) {
        final long replyToId = tw.getReplyToId();
        Status new_tweet = null;
        if (replyToId != -1) {
            try {
                new_tweet = twitter.showStatus(replyToId);
            } catch (TwitterException e) {
                System.err.print("Failed to search tweets: " + e.getMessage());
            }
        }
        return new_tweet;
    }
    
    private static String get_lenguage(String iso3){
        for (Locale country : Locale.getAvailableLocales()) {
            if(country.toLanguageTag().equals(iso3))
                return country.getDisplayLanguage();
        }
        return "";
    }
}
