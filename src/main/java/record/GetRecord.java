package record;

import models.*;
import sessionAction.*;

import javax.swing.*;

public class GetRecord extends Record{



    public GetRecord() {
setup();
    }

    public String select(String name, JTextField[] textField) {
        int id = Integer.parseInt(textField[0].getText());
        if (name.equals("AccessCard")) {
            return getAccessCardRecord(id);
        } else if (name.equals("Department")) {
            return getDepartmentRecord(id);
        } else if (name.equals("Product")) {
            return getProductRecord(id);
        } else if (name.equals("Room")) {
            return getRoomRecord(id);
        } else if (name.equals("Supplier")) {
            return getSupplierRecord(id);
        } else if (name.equals("Worker")) {
            return getWorkerRecord(id);
        } else {
            return "error";
        }
    }

    private String getAccessCardRecord(int id) {
        String answer;
        AccessCard accessCard;
        accessCard = sessionActionAccesCard.getAccessCard(id);

        String idString = String.valueOf(accessCard.getAccessCardId());
        String active;
        if (accessCard.getActive()) active = "true";
        else active = "false";
        String room = getRoomRecord(accessCard.getRoom().getRoomId());
        String worker = getWorkerRecord(accessCard.getWorker().getWorkerId());

        answer = "id: " + idString + " active: " + active + " room: (" + room + ") worker: (" + worker+")";
        return answer;
    }

    private String getDepartmentRecord(int id) {
        String answer;
        Department department;
        department = sessionActionDepartment.getDepartment(id);

        String idString = String.valueOf(department.getDepartmentId());
        String name = department.getName();

        answer = "id: " + idString + " name: " + name;
        return answer;
    }

    private String getProductRecord(int id) {
        String answer;
        Product product;
        product = sessionActionProduct.getProduct(id);

        String idString = String.valueOf(product.getProductId());
        String name = product.getName();
        String amount = String.valueOf(product.getAmount());
        String price = String.valueOf(product.getPrice());
        String department = getDepartmentRecord(product.getDepartment().getDepartmentId());
        String supplier = getSupplierRecord(product.getSupplier().getSupplierId());

        answer = "id: " + idString + " name: " + name + " amount: " + amount + " price: " + price + " department: (" + department + ") Supplier: (" + supplier + ")";
        return answer;
    }

    private String getRoomRecord(int id) {
        String answer;
        Room room;
        room = sessionActionRoom.getRoom(id);
        String idString = String.valueOf(room.getRoomId());
        String name = room.getName();

        answer = "id: " + idString + " name: " + name;
        return answer;
    }

    private String getSupplierRecord(int id) {
        String answer;
        Supplier supplier;
        supplier = sessionActionSupplier.getSupplier(id);

        String idString = String.valueOf(supplier.getSupplierId());
        String name = supplier.getName();
        String address = supplier.getAddress();
        String phone = supplier.getPhone();
        String nip = supplier.getNip();

        answer = "id: " + idString + " name: " + name + " address: " + address + " phone: " + phone + " nip: " + nip;
        return answer;
    }

    private String getWorkerRecord(int id) {
        String answer;
        Worker worker;
        worker = sessionActionWorker.getWorker(id);

        String idString = String.valueOf(worker.getWorkerId());
        String name = worker.getName();
        String surname = worker.getSurname();
        String salary = String.valueOf(worker.getSalary());
        String department = getDepartmentRecord(worker.getDepartment().getDepartmentId());

        answer = "id: " + idString + " name: " + name + " surname: " + surname + " salary: " + salary + " department: (" + department + ")";
        return answer;
    }
}
