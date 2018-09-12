import models.AccessCard;
import models.Room;
import models.Worker;
import org.junit.Test;
import sessionAction.SessionActionAccesCard;
import sessionAction.SessionActionRoom;
import sessionAction.SessionActionWorker;

public class SessionActionAccesCardTest {
    @Test
    public void addAccessCardTest() {
        SessionActionAccesCard sessionActionAccesCard = new SessionActionAccesCard();
        sessionActionAccesCard.setup();

        AccessCard accessCard = new AccessCard(true, null, null);
        sessionActionAccesCard.create(accessCard);
        sessionActionAccesCard.read(accessCard.getAccessCardId());
        sessionActionAccesCard.getAccessCard(accessCard.getAccessCardId());
        sessionActionAccesCard.delete(accessCard.getAccessCardId());
        sessionActionAccesCard.exit();
    }

    @Test
    public void manyToOneRelationAccessCardAndRoom() {
        SessionActionRoom sessionActionRoom = new SessionActionRoom();
        SessionActionAccesCard sessionActionAccesCard = new SessionActionAccesCard();

        Room room = new Room("warehouse");
        AccessCard accessCard1 = new AccessCard(true, room, null);
        AccessCard accessCard2 = new AccessCard(true, room, null);


        sessionActionRoom.setup();
        sessionActionAccesCard.setup();

        sessionActionRoom.create(room);
        sessionActionAccesCard.create(accessCard1);
        sessionActionAccesCard.create(accessCard2);

        sessionActionRoom.exit();
        sessionActionAccesCard.exit();
    }

    @Test
    public void manyToOneRelationAccessCardAndWorker() {
        SessionActionWorker sessionActionWorker = new SessionActionWorker();
        SessionActionAccesCard sessionActionAccesCard = new SessionActionAccesCard();

        Worker worker = new Worker("Wojtek", "Nowak", 1234.67f, null);
        AccessCard accessCard1 = new AccessCard(true, null, worker);
        AccessCard accessCard2 = new AccessCard(true, null, worker);

        sessionActionWorker.setup();
        sessionActionAccesCard.setup();

        sessionActionWorker.create(worker);
        sessionActionAccesCard.create(accessCard1);
        sessionActionAccesCard.create(accessCard2);

        sessionActionWorker.exit();
        sessionActionAccesCard.exit();
    }
}
