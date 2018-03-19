package lesson6.productClassStructure;

/**
 * Created by Kushn_000 on 18.03.2018.
 */
public class Products {
    private int productid;
    private String productName;
    private int quantityPerUnit;
    private float unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
    private int recorderLevel;
    private float discountinued;

    private Suppliers suppliers;
    private Categories categories;

    public Products(int productid, String productName, int quantityPerUnit, float unitPrice, int unitsInStock, int unitsOnOrder, int recorderLevel, float discountinued, Suppliers suppliers, Categories categories) {
        this.productid = productid;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.recorderLevel = recorderLevel;
        this.discountinued = discountinued;
        this.suppliers = suppliers;
        this.categories = categories;
    }
}
