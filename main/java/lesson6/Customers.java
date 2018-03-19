package lesson6;

/**
 * Created by Kushn_000 on 18.03.2018.
 */
public class Customers {
    private int customerId;
    private String companyName;
    private String contactName;
    private String address;
    private String city;
    private String region;
    private int postCode;
    private String country;
    private int phone;
    private int fax;

    public Customers(int customerId, String companyName, String contactName, String address, String city, String region, int postCode, String country, int phone, int fax) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postCode = postCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
    }
}
