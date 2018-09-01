package sessionAction;

import models.Department;

public class SessionActionDepartment extends SessionAction {

    public void create(Department department){


        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(department);

        session.getTransaction().commit();
        session.close();

    }


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

    public Department getDepartment(int departmentId){
        org.hibernate.Session session = sessionFactory.openSession();

        Department department= session.get(Department.class,departmentId);

        session.close();

        if(department != null){
            return department;
        }
        else{
            return null;
        }

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
