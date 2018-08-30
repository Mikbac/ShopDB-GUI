import models.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {


    protected SessionFactory sessionFactory;

    protected void setup(){
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

    protected void exit(){
        sessionFactory.close();
    }

    protected void create(){

        Worker worker = new Worker();
        worker.setName("Pawel");
        worker.setSurname("Nowak");
        worker.setSalary(1999.99f);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(worker);

        session.getTransaction().commit();
        session.close();

    }

    protected void update(){

        Worker worker = new Worker();
        worker.setWorkerId(1);
        worker.setName("Wojtek");
        worker.setSurname("Nowak");
        worker.setSalary(1999.99f);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(worker);

        session.getTransaction().commit();
        session.close();

    }

    protected void readWorker()
    {
        Session session = sessionFactory.openSession();

        int workerId = 1;
        Worker worker = session.get(Worker.class,workerId);

        if(worker != null){
            System.out.println("Name: " + worker.getName());
            System.out.println("Surname: " + worker.getSurname());
            System.out.println("Salary: " + worker.getSalary());
        }
        else{
            System.out.println("Worker could not be found!");
        }


        session.close();
    }

    protected void delete(){

        Worker worker = new Worker();
        worker.setWorkerId(1);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(worker);

        session.getTransaction().commit();
        session.close();

    }


    public static void main(String[] args){




        Main manager = new Main();
        manager.setup();
        manager.create();
        // manager.update();
        // manager.delete();
        manager.readWorker();
        manager.exit();





    }
}
