import models.Room;
import org.junit.Test;
import sessionAction.SessionActionRoom;

public class SessionActionRoomTest {
    @Test
    public void addRoomTest() {
        SessionActionRoom sessionActionRoom = new SessionActionRoom();
        sessionActionRoom.setup();

        Room room = new Room("warehouse");
        sessionActionRoom.create(room);
        sessionActionRoom.read(room.getRoomId());
        sessionActionRoom.getRoom(room.getRoomId());
        sessionActionRoom.delete(room.getRoomId());
        sessionActionRoom.exit();
    }
}
