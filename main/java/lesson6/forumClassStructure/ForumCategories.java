package lesson6.forumClassStructure;

import java.util.Date;

/**
 * Created by Kushn_000 on 19.03.2018.
 */
public class ForumCategories {
    private int id;
    private String title;
    private String description;
    private Date localDate;
    private int ip;

    public ForumCategories(int id, String title, String description, Date local_date, int ip) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.localDate = localDate;
        this.ip = ip;
    }
}
