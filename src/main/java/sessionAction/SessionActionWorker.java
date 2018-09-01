package sessionAction;

import models.Worker;

public class SessionActionWorker extends SessionAction {

    public void create(Worker worker){

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(worker);

        session.getTransaction().commit();
        session.close();

    }


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

    public Worker getWorker(int workerId){
        org.hibernate.Session session = sessionFactory.openSession();

        Worker worker = session.get(Worker.class,workerId);

        session.close();

        if(worker != null){
            return worker;
        }
        else{
            return null;
        }

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
