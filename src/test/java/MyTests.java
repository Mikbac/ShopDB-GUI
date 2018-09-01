import models.Department;
import models.Product;
import models.Worker;
import org.junit.Test;
import sessionAction.SessionActionDepartment;
import sessionAction.SessionActionProduct;
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

        SessionActionProduct sessionActionProduct = new SessionActionProduct();
        sessionActionProduct.setup();
        sessionActionProduct.exit();
    }


    @Test
    public void workerTest(){
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
    public void departmentTest(){
        SessionActionDepartment session = new SessionActionDepartment();
        session.setup();

        Department department = new Department("Vegetables");

        session.create(department);
        session.read(department.getDepartmentId());
        session.getDepartment(department.getDepartmentId());
        session.delete(department.getDepartmentId());
        session.exit();
    }

    @Test
    public void productTest(){
        SessionActionProduct sessionActionProduct = new SessionActionProduct();
        sessionActionProduct.setup();

        Product product = new Product("Onion", 12, 5.99f, null);

        sessionActionProduct.create(product);
        sessionActionProduct.read(product.getProductId());
        sessionActionProduct.getProduct(product.getProductId());
        sessionActionProduct.delete(product.getProductId());
        sessionActionProduct.exit();
    }

    @Test
    public void manyToOneRelationDepartmentAndWorkerTest(){
        SessionActionDepartment sessionActionDepartment = new SessionActionDepartment();
        SessionActionWorker sessionActionWorker = new SessionActionWorker();

        Department department = new Department("Vegetables");
        Worker worker1 = new Worker("Michał","Kowalski",1934.23f,department);
        Worker worker2 = new Worker("Rafal", "Okon", 2999.76f, department);

        sessionActionDepartment.setup();
        sessionActionWorker.setup();

        sessionActionDepartment.create(department);
        sessionActionWorker.create(worker1);
        sessionActionWorker.create(worker2);

        sessionActionWorker.exit();
        sessionActionDepartment.exit();

    }

    @Test
    public void manyToOneRelationDepartmentAndProductTest(){
        SessionActionDepartment sessionActionDepartment = new SessionActionDepartment();
        SessionActionProduct sessionActionProduct = new SessionActionProduct();

        Department department = new Department("Vegetables");
        Product product1 = new Product("Tomato", 44, 1.99f, department);
        Product product2 = new Product("Carrot", 55, 2.19f, department);

        sessionActionDepartment.setup();
        sessionActionProduct.setup();

        sessionActionDepartment.create(department);
        sessionActionProduct.create(product1);
        sessionActionProduct.create(product2);

        sessionActionDepartment.exit();
        sessionActionProduct.exit();

    }




}
