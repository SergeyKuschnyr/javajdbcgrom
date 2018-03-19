package lesson6.productClassStructure;

/**
 * Created by Kushn_000 on 18.03.2018.
 */
public class OrdersDetalies {
    private float unitPrice;
    private int quantity;
    private int discount;

    private Orders orders;
    private Products products;

    public OrdersDetalies(float unitPrice, int quantity, int discount, Orders orders, Products products) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
        this.orders = orders;
        this.products = products;
    }
}
