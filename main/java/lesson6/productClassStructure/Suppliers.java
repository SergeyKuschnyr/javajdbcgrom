package lesson6.productClassStructure;

/**
 * Created by Kushn_000 on 18.03.2018.
 */
public class Suppliers {
    private int supplierId;
    private Shippers contactName;
    private Shippers contactTitle;
    private String adress;
    private String city;
    private String region;
    private int postCode;
    private String counrty;
    private int phone;
    private int fax;
    private String homePage;

    public Suppliers(int supplierId, Shippers contactName, Shippers contactTitle, String adress, String city, String region, int postCode, String counrty, int phone, int fax, String homePage) {
        this.supplierId = supplierId;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.adress = adress;
        this.city = city;
        this.region = region;
        this.postCode = postCode;
        this.counrty = counrty;
        this.phone = phone;
        this.fax = fax;
        this.homePage = homePage;
    }
}
