package lesson3;

/**
 * Created by Kushn_000 on 19.02.2018.
 */
public class Demo {
    public static void main(String[] args) {


        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(102, "TEST_TEST", "test_description", 150);
        //productDAO.save(product);
        //System.out.println(productDAO.getProducts());
        //productDAO.update(product);
        productDAO.delete(104);
    }
}
