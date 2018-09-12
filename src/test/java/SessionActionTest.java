import org.junit.Test;
import sessionAction.*;

public class SessionActionTest {

    @Test
    public void sessionTest() {
        SessionActionWorker sessionActionWorker = new SessionActionWorker();
        sessionActionWorker.setup();
        sessionActionWorker.exit();

        SessionActionDepartment sessionActionDepartment = new SessionActionDepartment();
        sessionActionDepartment.setup();
        sessionActionDepartment.exit();

        SessionActionProduct sessionActionProduct = new SessionActionProduct();
        sessionActionProduct.setup();
        sessionActionProduct.exit();

        SessionActionSupplier sessionActionSupplier = new SessionActionSupplier();
        sessionActionSupplier.setup();
        sessionActionSupplier.exit();

        SessionActionAccesCard sessionActionAccesCard = new SessionActionAccesCard();
        sessionActionAccesCard.setup();
        sessionActionAccesCard.exit();

        SessionActionRoom sessionActionRoom = new SessionActionRoom();
        sessionActionRoom.setup();
        sessionActionRoom.exit();
    }


}
