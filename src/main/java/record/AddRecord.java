package record;

import models.*;
import sessionAction.*;

import javax.swing.*;

public class AddRecord extends Record{



    public AddRecord() {
setup();
    }

    public void select(String name, JTextField[] textFields) {
        if (name.equals("AccessCard")) {
            addNewAccesCard(textFields);
        } else if (name.equals("Department")) {
            addNewDepartment(textFields);
        } else if (name.equals("Product")) {
            addNewProduct(textFields);
        } else if (name.equals("Room")) {
            addNewRoom(textFields);
        } else if (name.equals("Supplier")) {
            addNewSupplier(textFields);
        } else if (name.equals("Worker")) {
            addNewWorker(textFields);
        } else {
            System.out.println("error");
        }
    }

    private void addNewAccesCard(JTextField[] text) {

        boolean active;
        Room room = sessionActionRoom.getRoom(Integer.parseInt(text[1].getText()));
        Worker worker = sessionActionWorker.getWorker(Integer.parseInt(text[2].getText()));

        if (text[0].getText().equals("true")) active = true;
        else active = false;

        AccessCard accessCard = new AccessCard(active, room, worker);

        sessionActionAccesCard.create(accessCard);

    }

    private void addNewDepartment(JTextField[] text) {

        String name = text[0].getText();

        Department department = new Department(name);

        sessionActionDepartment.create(department);

    }

    private void addNewProduct(JTextField[] text) {

        String name = text[0].getText();
        int amount = Integer.parseInt(text[1].getText());
        float price = Float.parseFloat(text[2].getText());
        Department department = sessionActionDepartment.getDepartment(Integer.parseInt(text[3].getText()));
        Supplier supplier = sessionActionSupplier.getSupplier(Integer.parseInt(text[4].getText()));

        Product product = new Product(name, amount, price, department, supplier);

        sessionActionProduct.create(product);


    }

    private void addNewRoom(JTextField[] text) {

        String name = text[0].getText();

        Room room = new Room(name);

        sessionActionRoom.create(room);

    }

    private void addNewSupplier(JTextField[] text) {

        String name = text[0].getText();
        String address = text[1].getText();
        String phone = text[2].getText();
        String nip = text[3].getText();

        Supplier supplier = new Supplier(name, address, phone, nip);

        sessionActionSupplier.create(supplier);

    }

    private void addNewWorker(JTextField[] text) {

        String name = text[0].getText();
        String surname = text[1].getText();
        float salary = Float.parseFloat(text[2].getText());
        Department department = sessionActionDepartment.getDepartment(Integer.parseInt(text[3].getText()));

        Worker worker = new Worker(name, surname, salary, department);

        sessionActionWorker.create(worker);

    }

}
