package lesson6.forumClassStructure;

import java.util.Date;

/**
 * Created by Kushn_000 on 19.03.2018.
 */
public class Users {
    private int id;
    private String nick;
    private String password;
    private String email;
    private Date localDate;
    private float karma;
    private String ip;

    public Users(int id, String nick, String password, String email, Date localDate, float karma, String ip) {
        this.id = id;
        this.nick = nick;
        this.password = password;
        this.email = email;
        this.localDate = localDate;
        this.karma = karma;
        this.ip = ip;
    }
}
