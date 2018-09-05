import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    private JFrame frame;

    private JTextField textAccessCardActive;
    private JTextField textAccessCardRoom;
    private JTextField textAccessCardWorker;

    private JTextField textDepartmentName;

    private JTextField textProductName;
    private JTextField textProductAmount;
    private JTextField textProductPrice;
    private JTextField textProductDepartment;
    private JTextField textProductSupplier;

    private JTextField textRoomName;

    private JTextField textSupplierName;
    private JTextField textSupplierAddress;
    private JTextField textSupplierPhone;
    private JTextField textSupplierNip;

    private JTextField textWorkerName;
    private JTextField textWorkerSurname;
    private JTextField textWorkerSalary;
    private JTextField textWorkerDepartment;


    public Main() {
        initialize();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        accessCard();
        department();
        product();
        room();
        supplier();
        worker();

    }

    private void accessCard() {
        int xAccessCard = 0;
        String[] tableAccessCard = {"Active", "Room", "Worker"};
        JTextField[] textFieldAccessCard = {textAccessCardActive, textAccessCardRoom, textAccessCardWorker};

        headlines(xAccessCard, "Acces Card");

        columnSignatures(xAccessCard, tableAccessCard);

        textFields(xAccessCard, textFieldAccessCard);

        JButton buttonAccesCard = new JButton("ADD ACCESS CARD");
        buttonWorks(buttonAccesCard, "AccessCard", textFieldAccessCard);
        buttonOptions(xAccessCard, buttonAccesCard);
    }

    private void department() {
        int xDepartment = 200;
        String[] tableDepartment = {"Name"};
        JTextField[] textFieldDepartment = {textDepartmentName};

        headlines(xDepartment, "Department");

        columnSignatures(xDepartment, tableDepartment);

        textFields(xDepartment, textFieldDepartment);

        JButton buttonDepartment = new JButton("ADD DEPARTMENT");
        buttonWorks(buttonDepartment, "Department", textFieldDepartment);
        buttonOptions(xDepartment, buttonDepartment);
    }

    private void product() {
        int xProduct = 400;
        String[] tableProduct = new String[]{"Name", "Amount", "Price", "Department", "Supplier"};
        JTextField[] textFieldProduct = {textProductName, textProductAmount, textProductPrice, textProductDepartment, textProductSupplier};

        headlines(xProduct, "Product");

        columnSignatures(xProduct, tableProduct);

        textFields(xProduct, textFieldProduct);

        JButton buttonProduct = new JButton("ADD PRODUCT");
        buttonWorks(buttonProduct, "Product", textFieldProduct);
        buttonOptions(xProduct, buttonProduct);
    }

    private void room() {
        int xRoom = 600;
        String[] tableRoom = new String[]{"Name"};
        JTextField[] jTextFieldRoom = {textRoomName};

        headlines(xRoom, "Room");

        columnSignatures(xRoom, tableRoom);

        textFields(xRoom, jTextFieldRoom);

        JButton buttonRoom = new JButton("ADD ROOM");
        buttonWorks(buttonRoom, "Room", jTextFieldRoom);
        buttonOptions(xRoom, buttonRoom);
    }


    private void supplier() {
        int xSupplier = 800;
        String[] tableSupplier = new String[]{"Name", "Address", "Phone", "Nip"};
        JTextField[] jTextFieldSupplier = {textSupplierName, textSupplierAddress, textSupplierPhone, textSupplierNip};

        headlines(xSupplier, "Supplier");

        columnSignatures(xSupplier, tableSupplier);

        textFields(xSupplier, jTextFieldSupplier);

        JButton buttonSupplier = new JButton("ADD SUPPLIER");
        buttonWorks(buttonSupplier, "Supplier", jTextFieldSupplier);
        buttonOptions(xSupplier, buttonSupplier);
    }


    private void worker() {
        int xWorker = 1000;
        String[] tableWorker = new String[]{"Name", "Surname", "Salary", "Department"};
        JTextField[] jTextFieldWorker = {textWorkerName, textWorkerSurname, textWorkerSalary, textWorkerDepartment};

        headlines(xWorker, "Worker");

        columnSignatures(xWorker, tableWorker);

        textFields(xWorker, jTextFieldWorker);

        JButton buttonWorker = new JButton("ADD WORKER");
        buttonWorks(buttonWorker, "Worker", jTextFieldWorker);
        buttonOptions(xWorker, buttonWorker);
    }

    private void headlines(int x, String name) {
        JLabel label = new JLabel(name + ":");
        label.setFont(new Font("Times New Roman", Font.BOLD, 18));
        label.setBounds(25 + x, 25, 100, 45);
        frame.getContentPane().add(label);
    }

    private void columnSignatures(int x, String[] table) {

        for (int i = 0; i < table.length; i++) {
            JLabel label = new JLabel(table[i] + ":");
            label.setFont(new Font("Times New Roman", Font.BOLD, 14));
            label.setBounds(25 + x, 25 + (i + 1) * 50, 100, 45);
            frame.getContentPane().add(label);
        }

    }

    private void textFields(int x, JTextField[] jTextField) {
        for (int i = 0; i < jTextField.length; i++) {
            jTextField[i] = new JTextField();
            jTextField[i].setBounds(105 + x, 35 + (i + 1) * 50, 100, 25);
            frame.getContentPane().add(jTextField[i]);
            jTextField[i].setColumns(10);
        }
    }

    private void buttonWorks(JButton button, final String name, final JTextField[] textFields) {
        final AddRecord addRecord = new AddRecord();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    addRecord.select(name, textFields);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "wrong values!");
                } finally {
                }


            }
        });
    }


    private void buttonOptions(int x, JButton button) {
        button.setFont(new Font("Times New Roman", Font.BOLD, 10));
        button.setBounds(10 + x, 380, 140, 20);
        frame.getContentPane().add(button);
    }


}