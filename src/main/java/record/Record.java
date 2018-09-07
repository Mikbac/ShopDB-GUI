package record;

import sessionAction.*;

public class Record {
    protected  SessionActionAccesCard sessionActionAccesCard;
    protected  SessionActionDepartment sessionActionDepartment;
    protected  SessionActionProduct sessionActionProduct;
    protected  SessionActionRoom sessionActionRoom;
    protected  SessionActionSupplier sessionActionSupplier;
    protected  SessionActionWorker sessionActionWorker;



    public Record() {
        sessionActionAccesCard = new SessionActionAccesCard();
        sessionActionDepartment = new SessionActionDepartment();
        sessionActionProduct = new SessionActionProduct();
        sessionActionRoom = new SessionActionRoom();
        sessionActionSupplier = new SessionActionSupplier();
        sessionActionWorker = new SessionActionWorker();

    }

public void setup(){

    sessionActionAccesCard.setup();
    sessionActionDepartment.setup();
    sessionActionProduct.setup();
    sessionActionRoom.setup();
    sessionActionSupplier.setup();
    sessionActionWorker.setup();
}

    public void exit() {
        sessionActionAccesCard.exit();
        sessionActionDepartment.exit();
        sessionActionProduct.exit();
        sessionActionRoom.exit();
        sessionActionSupplier.exit();
        sessionActionWorker.exit();
    }
}
