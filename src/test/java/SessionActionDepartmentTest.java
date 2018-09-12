import models.Department;
import org.junit.jupiter.api.Test;
import sessionAction.SessionActionDepartment;

public class SessionActionDepartmentTest {

    @Test
    public void addDepartmentTest() {
        SessionActionDepartment session = new SessionActionDepartment();
        session.setup();

        Department department = new Department("Vegetables");

        session.create(department);
        session.read(department.getDepartmentId());
        session.getDepartment(department.getDepartmentId());
        session.delete(department.getDepartmentId());
        session.exit();
    }


}
