import models.Supplier;
import org.junit.Test;
import sessionAction.SessionActionSupplier;

public class SessionActionSupplierTest {
    @Test
    public void addSupplierTest() {
        SessionActionSupplier sessionActionSupplier = new SessionActionSupplier();
        sessionActionSupplier.setup();

        Supplier supplier = new Supplier("FoxVegetables", "Moskwa", "444555666", "9304639276");
        sessionActionSupplier.create(supplier);
        sessionActionSupplier.read(supplier.getSupplierId());
        sessionActionSupplier.getSupplier(supplier.getSupplierId());
        sessionActionSupplier.delete(supplier.getSupplierId());
        sessionActionSupplier.exit();
    }
}
