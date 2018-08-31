package sessionAction;

import models.Department;
import models.Worker;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionActionDepartment {

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


    public void create(Department department){


        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(department);

        session.getTransaction().commit();
        session.close();

    }



/*    public void update(Department department){


        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(department);

        session.getTransaction().commit();
        session.close();

    }*/

    public void read(int departmentId)
    {
        org.hibernate.Session session = sessionFactory.openSession();

        Department department= session.get(Department.class,departmentId);

        if(department != null){
            System.out.println("Name: " + department.getName());
        }
        else{
            System.out.println("Department could not be found!");
        }


        session.close();
    }

    public void delete( int id){
        Department department = new Department();
        department.setDepartmentId(id);

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(department);

        session.getTransaction().commit();
        session.close();

    }

}
