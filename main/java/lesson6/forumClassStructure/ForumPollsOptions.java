package lesson6.forumClassStructure;

import java.util.Date;

/**
 * Created by Kushn_000 on 19.03.2018.
 */
public class ForumPollsOptions {
    private int id;
    private String title;
    private Date localDate;
    private ForumPosts forumPosts;

    public ForumPollsOptions(int id, String title, Date localDate, ForumPosts forumPosts) {
        this.id = id;
        this.title = title;
        this.localDate = localDate;
        this.forumPosts = forumPosts;
    }
}
