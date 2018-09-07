import record.AddRecord;
import record.GetRecord;
import record.Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main{
    private static AddRecord addRecord;
    private static GetRecord getRecord;
    private static Record record;
    private JFrame frame;

    private JLabel labelAnser;

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

    private JTextField textIdAccessCard;
    private JTextField textIdDepartment;
    private JTextField textIdProduct;
    private JTextField textIdRoom;
    private JTextField textIdSupplier;
    private JTextField textIdWorker;


    public Main() {
        record = new Record();
        addRecord = new AddRecord();
        getRecord = new GetRecord();
        initialize();
        labelAnser = new JLabel();
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

      record.exit();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1400, 700);
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
        JTextField jTextField[] = {textIdAccessCard};

        headlines(xAccessCard, "Acces Card");

        columnSignatures(xAccessCard, tableAccessCard);

        textFields(xAccessCard, textFieldAccessCard);

         JButton  buttonAccesCardAdd = new JButton("ADD ACCESS CARD");
        buttonAdd(buttonAccesCardAdd, "AccessCard", textFieldAccessCard);
        buttonOptionsAdd(xAccessCard, buttonAccesCardAdd);

        idLabel(xAccessCard);
        textId(xAccessCard, jTextField);
         JButton  buttonAccesCardGet = new JButton("GET ACCESS CARD");
        buttonGet(buttonAccesCardGet, "AccessCard", jTextField);
        buttonOptionsGet(xAccessCard, buttonAccesCardGet);

    }

    private void department() {
        int xDepartment = 200;
        String[] tableDepartment = {"Name"};
        JTextField[] textFieldDepartment = {textDepartmentName};
        JTextField[] jTextField = {textIdDepartment};

        headlines(xDepartment, "Department");

        columnSignatures(xDepartment, tableDepartment);

        textFields(xDepartment, textFieldDepartment);

        JButton buttonDepartmentAdd = new JButton("ADD DEPARTMENT");
        buttonAdd(buttonDepartmentAdd, "Department", textFieldDepartment);
        buttonOptionsAdd(xDepartment, buttonDepartmentAdd);

        idLabel(xDepartment);
        textId(xDepartment, jTextField);
        JButton  buttonDepartmentGet = new JButton("GET DEPARTMENT");
        buttonGet(buttonDepartmentGet, "Department", jTextField);
        buttonOptionsGet(xDepartment, buttonDepartmentGet);

    }

    private void product() {
        int xProduct = 400;
        String[] tableProduct = new String[]{"Name", "Amount", "Price", "Department", "Supplier"};
        JTextField[] textFieldProduct = {textProductName, textProductAmount, textProductPrice, textProductDepartment, textProductSupplier};
        JTextField[] jTextField = {textIdProduct};

        headlines(xProduct, "Product");

        columnSignatures(xProduct, tableProduct);

        textFields(xProduct, textFieldProduct);

        JButton buttonProductAdd = new JButton("ADD PRODUCT");
        buttonAdd(buttonProductAdd, "Product", textFieldProduct);
        buttonOptionsAdd(xProduct, buttonProductAdd);

        idLabel(xProduct);
        textId(xProduct, jTextField);
        JButton buttonProductGet = new JButton("GET PRODUCT");
        buttonGet(buttonProductGet, "Product", jTextField);
        buttonOptionsGet(xProduct, buttonProductGet);
    }

    private void room() {
        int xRoom = 600;
        String[] tableRoom = new String[]{"Name"};
        JTextField[] jTextFieldRoom = {textRoomName};
        JTextField jTextField[] = {textIdRoom};

        headlines(xRoom, "Room");

        columnSignatures(xRoom, tableRoom);

        textFields(xRoom, jTextFieldRoom);

        JButton buttonRoomAdd = new JButton("ADD ROOM");
        buttonAdd(buttonRoomAdd, "Room", jTextFieldRoom);
        buttonOptionsAdd(xRoom, buttonRoomAdd);

        idLabel(xRoom);

        textId(xRoom, jTextField);

        JButton buttonRoomGet = new JButton("GET ROOM");
        buttonGet(buttonRoomGet, "Room", jTextField);
        buttonOptionsGet(xRoom, buttonRoomGet);
    }


    private void supplier() {
        int xSupplier = 800;
        String[] tableSupplier = new String[]{"Name", "Address", "Phone", "Nip"};
        JTextField[] jTextFieldSupplier = {textSupplierName, textSupplierAddress, textSupplierPhone, textSupplierNip};
        JTextField jTextField[] = {textIdSupplier};

        headlines(xSupplier, "Supplier");

        columnSignatures(xSupplier, tableSupplier);

        textFields(xSupplier, jTextFieldSupplier);

        JButton buttonSupplierAdd = new JButton("ADD SUPPLIER");
        buttonAdd(buttonSupplierAdd, "Supplier", jTextFieldSupplier);
        buttonOptionsAdd(xSupplier, buttonSupplierAdd);

        idLabel(xSupplier);
        textId(xSupplier, jTextField);
        JButton buttonSupplierGet = new JButton("GET SUPPLIER");
        buttonGet(buttonSupplierGet, "Supplier", jTextField);
        buttonOptionsGet(xSupplier, buttonSupplierGet);
    }


    private void worker() {
        int xWorker = 1000;
        String[] tableWorker = new String[]{"Name", "Surname", "Salary", "Department"};
        JTextField[] jTextFieldWorker = {textWorkerName, textWorkerSurname, textWorkerSalary, textWorkerDepartment};
        JTextField jTextField[] = {textIdWorker};

        headlines(xWorker, "Worker");

        columnSignatures(xWorker, tableWorker);

        textFields(xWorker, jTextFieldWorker);

        JButton buttonWorkerAdd = new JButton("ADD WORKER");
        buttonAdd(buttonWorkerAdd, "Worker", jTextFieldWorker);
        buttonOptionsAdd(xWorker, buttonWorkerAdd);

        idLabel(xWorker);
        textId(xWorker, jTextField);
        JButton buttonWorkerGet = new JButton("GET WORKER");
        buttonGet(buttonWorkerGet, "Worker", jTextField);
        buttonOptionsGet(xWorker, buttonWorkerGet);
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

    private void idLabel(int x) {
        JLabel label = new JLabel("id: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label.setBounds(25 + x, 420, 100, 45);
        frame.getContentPane().add(label);

    }

    private void answerLabel(String answer) {
        labelAnser.setText(answer);
        labelAnser.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelAnser.setBounds(25, 500, 1100, 45);
        frame.getContentPane().add(labelAnser);
    }

    private void textFields(int x, JTextField[] jTextField) {
        for (int i = 0; i < jTextField.length; i++) {
            jTextField[i] = new JTextField();
            jTextField[i].setBounds(105 + x, 35 + (i + 1) * 50, 100, 25);
            frame.getContentPane().add(jTextField[i]);
            jTextField[i].setColumns(10);
        }
    }

    private void textId(int x, JTextField[] jTextField) {
        jTextField[0] = new JTextField();
        jTextField[0].setBounds(50 + x, 430, 100, 25);
        frame.getContentPane().add(jTextField[0]);
        jTextField[0].setColumns(11);
    }

    private void buttonAdd(JButton button, final String name, final JTextField[] textFields) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    addRecord.select(name, textFields);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "wrong values!");
                } finally {
                }


            }
        });
    }

    private void buttonGet(JButton button, final String name, final JTextField[] textField) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String answerString;
                    answerString = getRecord.select(name, textField);
                    answerLabel(answerString);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "wrong values!");
                } finally {
                }


            }
        });
    }


    private void buttonOptionsAdd(int x, JButton button) {
        button.setFont(new Font("Times New Roman", Font.BOLD, 10));
        button.setBounds(10 + x, 380, 140, 20);
        frame.getContentPane().add(button);
    }




    private void buttonOptionsGet(int x, JButton button) {
        button.setFont(new Font("Times New Roman", Font.BOLD, 10));
        button.setBounds(10 + x, 480, 140, 20);
        frame.getContentPane().add(button);
    }


}