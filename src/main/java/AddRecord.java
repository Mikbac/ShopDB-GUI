import javax.swing.*;

public class AddRecord {

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
        System.out.println(text[0].getText());
    }

    private void addNewDepartment(JTextField[] text) {
        System.out.println(text[0].getText());
    }

    private void addNewProduct(JTextField[] text) {
        System.out.println(text[0].getText());
    }

    private void addNewRoom(JTextField[] text) {
        System.out.println(text[0].getText());
    }

    private void addNewSupplier(JTextField[] text) {
        System.out.println(text[0].getText());
    }

    private void addNewWorker(JTextField[] text) {
        System.out.println(text[0].getText());
    }

}
