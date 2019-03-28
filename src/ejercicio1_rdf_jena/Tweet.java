package ejercicio1_rdf_jena;

import java.util.Date;

public class Tweet {
    
    private final long id, replyToId;
    private final User user;
    private final Language language;
    private final String text, class_;
    private final Date date;

    public Tweet(long id, long replyToId, User user, Language language, String text, String class_, Date date) {
        this.id = id;
        this.replyToId = replyToId;
        this.user = user;
        this.language = language;
        this.text = text;
        this.class_ = class_;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public long getReplyToId() {
        return replyToId;
    }

    public User getUser() {
        return user;
    }

    public Language getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }

    public String getClass_() {
        return class_;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Tweet{" + "id=" + id + ", replyToId=" + replyToId + ", user=" + user + ", language=" + language + ", text=" + text + ", class_=" + class_ + ", date=" + date + '}';
    }
    
}
