import models.Department;
import models.Product;
import models.Supplier;
import org.junit.Test;
import sessionAction.SessionActionDepartment;
import sessionAction.SessionActionProduct;
import sessionAction.SessionActionSupplier;

public class SessionActionProductTest {

    @Test
    public void adProductTest() {
        SessionActionProduct sessionActionProduct = new SessionActionProduct();
        sessionActionProduct.setup();

        Product product = new Product("Onion", 12, 5.99f, null, null);

        sessionActionProduct.create(product);
        sessionActionProduct.read(product.getProductId());
        sessionActionProduct.getProduct(product.getProductId());
        sessionActionProduct.delete(product.getProductId());
        sessionActionProduct.exit();
    }

    @Test
    public void manyToOneRelationDepartmentAndProductTest() {
        SessionActionDepartment sessionActionDepartment = new SessionActionDepartment();
        SessionActionProduct sessionActionProduct = new SessionActionProduct();

        Department department = new Department("Vegetables");
        Product product1 = new Product("Tomato", 44, 1.99f, department, null);
        Product product2 = new Product("Carrot", 55, 2.19f, department, null);

        sessionActionDepartment.setup();
        sessionActionProduct.setup();

        sessionActionDepartment.create(department);
        sessionActionProduct.create(product1);
        sessionActionProduct.create(product2);

        sessionActionDepartment.exit();
        sessionActionProduct.exit();
    }

    @Test
    public void manyToOneRelationProductAndSupplierTest() {
        SessionActionSupplier sessionActionSupplier = new SessionActionSupplier();
        SessionActionProduct sessionActionProduct = new SessionActionProduct();

        Supplier supplier = new Supplier("FoxVegetables", "Moskwa", "444555666", "9304639276");
        Product product1 = new Product("Tomato", 44, 1.99f, null, supplier);
        Product product2 = new Product("Carrot", 55, 2.19f, null, supplier);

        sessionActionSupplier.setup();
        sessionActionProduct.setup();

        sessionActionSupplier.create(supplier);
        sessionActionProduct.create(product1);
        sessionActionProduct.create(product2);

        sessionActionSupplier.exit();
        sessionActionProduct.exit();
    }
}
