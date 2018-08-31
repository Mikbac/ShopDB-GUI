import models.Department;
import models.Worker;
import org.junit.Test;
import sessionAction.SessionActionDepartment;
import sessionAction.SessionActionWorker;

public class MyTests {



    @Test
    public void sessionTest(){
        SessionActionWorker sessionActionWorker = new SessionActionWorker();
        sessionActionWorker.setup();
        sessionActionWorker.exit();

        SessionActionDepartment sessionActionDepartment = new SessionActionDepartment();
        sessionActionDepartment.setup();
        sessionActionDepartment.exit();
    }


    @Test
    public void workerTest(){

        SessionActionWorker session = new SessionActionWorker();
        session.setup();

        Worker worker = new Worker();
        worker.setWorkerId(1);
        worker.setName("Wojtek");
        worker.setSurname("Nowak");
        worker.setSalary(1999.99f);

        session.create(worker);
        session.read(worker.getWorkerId());
      session.delete(worker.getWorkerId());

        session.exit();
    }


    @Test
    public void departmentTest(){
        SessionActionDepartment session = new SessionActionDepartment();
        session.setup();


        Department department = new Department();
        department.setName("Vegetables");

        session.create(department);
        session.read(department.getDepartmentId());
      session.delete(department.getDepartmentId());

        session.exit();
    }

    @Test
    public void manyToOneRelationTest(){
        SessionActionDepartment sessionActionDepartment = new SessionActionDepartment();
        SessionActionWorker sessionActionWorker = new SessionActionWorker();

        Department department = new Department();
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();

        department.setName("Vegetables");

        worker1.setName("Michal");
        worker1.setSurname("Kowalski");
        worker1.setSalary(1991.89f);
        worker1.setDepartment(department);

        worker2.setName("Rafal");
        worker2.setSurname("Nowak");
        worker2.setSalary(2999.77f);
        worker2.setDepartment(department);

        sessionActionDepartment.setup();
        sessionActionWorker.setup();

        sessionActionDepartment.create(department);
        sessionActionWorker.create(worker1);
        sessionActionWorker.create(worker2);

        sessionActionWorker.exit();
        sessionActionDepartment.exit();

    }





}
