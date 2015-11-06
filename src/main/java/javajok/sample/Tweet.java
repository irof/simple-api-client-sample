package javajok.sample;

/**
 * 一件のツイートです。
 *
 * @author irof
 */
public class Tweet {

    public String id;
    public String text;
    public TweetTimestamp timestamp;
    public String userId;

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
