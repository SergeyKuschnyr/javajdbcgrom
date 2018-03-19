package lesson6.forumClassStructure;

import java.util.Date;

/**
 * Created by Kushn_000 on 19.03.2018.
 */
public class ForumSubcategores {
    private int id;
    private String title;
    private String description;
    private Date localDate;
    private String ip;

    private ForumCategories forumCategories;

    public ForumSubcategores(int id, String title, String description, Date localDate, String ip, ForumCategories forumCategories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.localDate = localDate;
        this.ip = ip;
        this.forumCategories = forumCategories;
    }
}
