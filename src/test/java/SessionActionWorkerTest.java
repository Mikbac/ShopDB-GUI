import models.Department;
import models.Worker;
import org.junit.Test;
import sessionAction.SessionActionDepartment;
import sessionAction.SessionActionWorker;

public class SessionActionWorkerTest {

    @Test
    public void addWorkerTest() {
        SessionActionWorker sessionActionWorker = new SessionActionWorker();
        sessionActionWorker.setup();

        Worker worker = new Worker("Wojtek", "Nowak", 1234.67f, null);

        sessionActionWorker.create(worker);
        sessionActionWorker.read(worker.getWorkerId());
        sessionActionWorker.getWorker(worker.getWorkerId());
        sessionActionWorker.delete(worker.getWorkerId());
        sessionActionWorker.exit();
    }

    @Test
    public void manyToOneRelationDepartmentAndWorkerTest() {
        SessionActionDepartment sessionActionDepartment = new SessionActionDepartment();
        SessionActionWorker sessionActionWorker = new SessionActionWorker();

        Department department = new Department("Vegetables");
        Worker worker1 = new Worker("Michał", "Kowalski", 1934.23f, department);
        Worker worker2 = new Worker("Rafal", "Okon", 2999.76f, department);

        sessionActionDepartment.setup();
        sessionActionWorker.setup();

        sessionActionDepartment.create(department);
        sessionActionWorker.create(worker1);
        sessionActionWorker.create(worker2);

        sessionActionWorker.exit();
        sessionActionDepartment.exit();
    }
}
