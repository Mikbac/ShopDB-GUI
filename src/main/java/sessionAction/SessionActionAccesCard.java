package sessionAction;

import models.AccessCard;

public class SessionActionAccesCard extends SessionAction{

    public void create(AccessCard accessCard){

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(accessCard);

        session.getTransaction().commit();
        session.close();

    }


    public void read(int accessCardId)
    {
        org.hibernate.Session session = sessionFactory.openSession();

        AccessCard accessCard= session.get(AccessCard.class,accessCardId);

        if(accessCard != null){
            System.out.println("Id: " + accessCard.getAccessCardId());
            System.out.println("Active: " + accessCard.getActive());
            System.out.println("Room: " + accessCard.getRoom());
            System.out.println("Worker: " + accessCard.getWorker());
        }
        else{
            System.out.println("AccessCard could not be found!");
        }


        session.close();
    }

    public AccessCard getAccessCard(int accessCardId){
        org.hibernate.Session session = sessionFactory.openSession();

        AccessCard accessCard= session.get(AccessCard.class,accessCardId);

        session.close();

        if(accessCard != null){
            return accessCard;
        }
        else{
            return null;
        }

    }

    public void delete( int id){
        AccessCard accessCard = new AccessCard();
        accessCard.setAccessCardId(id);

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(accessCard);

        session.getTransaction().commit();
        session.close();

    }

}
