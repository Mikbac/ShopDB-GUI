package sessionAction;

import models.Department;
import models.Worker;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionActionWorker {

    protected SessionFactory sessionFactory;

    public void setup(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public void exit(){
        sessionFactory.close();
    }


    public void create(Worker worker){


        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(worker);

        session.getTransaction().commit();
        session.close();

    }



/*    public void update(Worker worker){


        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(worker);

        session.getTransaction().commit();
        session.close();

    }*/

    public void read(int workerId)
    {
        org.hibernate.Session session = sessionFactory.openSession();

        Worker worker = session.get(Worker.class,workerId);

        if(worker != null){
            System.out.println("Id: " + worker.getWorkerId());
            System.out.println("Name: " + worker.getName());
            System.out.println("Surname: " + worker.getSurname());
            System.out.println("Salary: " + worker.getSalary());
        }
        else{
            System.out.println("Worker could not be found!");
        }


        session.close();
    }

    public void delete(int id){
        Worker worker = new Worker();
        worker.setWorkerId(id);

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(worker);

        session.getTransaction().commit();
        session.close();

    }

}
