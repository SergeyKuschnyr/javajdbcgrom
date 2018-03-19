package lesson6;

import java.util.Date;

/**
 * Created by Kushn_000 on 18.03.2018.
 */
public class Employees {
    private int employeeid;
    private String lastName;
    private String firstName;
    private String title;
    private String titlOfCourtesy;
    private Date birthday;
    private Date hireday;
    private String address;
    private String city;
    private String region;
    private int postCode;
    private String country;
    private int homePhone;
    private String extention;
    private String photo;
    private String notes;
    private String reportsTo;

    public Employees(int employeeid, String lastName, String firstName, String title, String titlOfCourtesy, Date birthday, Date hireday, String address, String city, String region, int postCode, String country, int homePhone, String extention, String photo, String notes, String reportsTo) {
        this.employeeid = employeeid;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.titlOfCourtesy = titlOfCourtesy;
        this.birthday = birthday;
        this.hireday = hireday;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postCode = postCode;
        this.country = country;
        this.homePhone = homePhone;
        this.extention = extention;
        this.photo = photo;
        this.notes = notes;
        this.reportsTo = reportsTo;
    }
}
