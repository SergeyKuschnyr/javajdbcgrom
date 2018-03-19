package lesson6.forumClassStructure;

import java.util.Date;

/**
 * Created by Kushn_000 on 19.03.2018.
 */
public class ForumPollsOptionsVotes {
    private int id;
    private Date localDate;
    private String ip;
    private ForumPollsOptions forumPollsOptions;
    private Users users;

    public ForumPollsOptionsVotes(int id, Date localDate, String ip, ForumPollsOptions forumPollsOptions, Users users) {
        this.id = id;
        this.localDate = localDate;
        this.ip = ip;
        this.forumPollsOptions = forumPollsOptions;
        this.users = users;
    }
}
