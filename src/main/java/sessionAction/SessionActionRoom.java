package sessionAction;

import models.Room;

public class SessionActionRoom extends SessionAction {

    public void create(Room room) {
        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(room);

        session.getTransaction().commit();
        session.close();
    }


    public void read(int roomId) {
        org.hibernate.Session session = sessionFactory.openSession();

        Room room = session.get(Room.class, roomId);

        if (room != null) {
            System.out.println("Id: " + room.getRoomId());
            System.out.println("Name: " + room.getName());
        } else {
            System.out.println("Room could not be found!");
        }


        session.close();
    }

    public Room getRoom(int roomId) {
        org.hibernate.Session session = sessionFactory.openSession();

        Room room = session.get(Room.class, roomId);

        session.close();

        if (room != null) {
            return room;
        } else {
            return null;
        }
    }

    public void delete(int id) {
        Room room = new Room();
        room.setRoomId(id);

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(room);

        session.getTransaction().commit();
        session.close();
    }

}