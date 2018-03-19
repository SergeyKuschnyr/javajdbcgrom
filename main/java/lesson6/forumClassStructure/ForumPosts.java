package lesson6.forumClassStructure;

import java.util.Date;

/**
 * Created by Kushn_000 on 19.03.2018.
 */
public class ForumPosts {
    private int id;
    private String title;
    private String content;
    private boolean ispoll;
    private Date localDate;
    private String ip;

    private ForumSubcategores forumSubcategores;
    private Users users;

    public ForumPosts(int id, String title, String content, boolean ispoll, Date localDate, String ip, ForumSubcategores forumSubcategores, Users users) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.ispoll = ispoll;
        this.localDate = localDate;
        this.ip = ip;
        this.forumSubcategores = forumSubcategores;
        this.users = users;
    }
}
