package lesson6.productClassStructure;

import java.util.Date;

/**
 * Created by Kushn_000 on 18.03.2018.
 */
public class Orders {
    private int orderid;
    private Date orderdate;
    private Date requireddate;
    private Date shippeddate;
    private String shipVia;
    private String freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private int shipPostCode;
    private String shipCountry;

    private Customers customers;
    private Employees employees;
    private Shippers shippers;

    public Orders(int orderid, Date orderdate, Date requireddate, Date shippeddate, String shipVia, String freight, String shipName, String shipAddress, String shipCity, String shipRegion, int shipPostCode, String shipCountry, Customers customers, Employees employees, Shippers shippers) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.requireddate = requireddate;
        this.shippeddate = shippeddate;
        this.shipVia = shipVia;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostCode = shipPostCode;
        this.shipCountry = shipCountry;
        this.customers = customers;
        this.employees = employees;
        this.shippers = shippers;
    }
}
