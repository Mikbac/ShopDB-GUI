import record.AddRecord;
import record.GetRecord;
import record.Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    private static AddRecord addRecord;
    private static GetRecord getRecord;
    private static Record record;
    private JFrame frame;

    private JLabel labelAnser;

    private JTextField textAccessCardActive, textAccessCardRoom, textAccessCardWorker;
    private JTextField textDepartmentName;
    private JTextField textProductName, textProductAmount, textProductPrice, textProductDepartment, textProductSupplier;
    private JTextField textRoomName;
    private JTextField textSupplierName, textSupplierAddress, textSupplierPhone, textSupplierNip;
    private JTextField textWorkerName, textWorkerSurname, textWorkerSalary, textWorkerDepartment;
    private JTextField textIdAccessCard, textIdDepartment, textIdProduct, textIdRoom, textIdSupplier, textIdWorker;

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
        String name = "AccessCard";
        int xAccessCard = 0;
        String[] tableAccessCard = {"Active", "Room", "Worker"};
        JTextField[] textFieldAccessCard = {textAccessCardActive, textAccessCardRoom, textAccessCardWorker};
        JTextField jTextField[] = {textIdAccessCard};

        labelHeadlines(xAccessCard, "Acces Card");
        labelColumnSignatures(xAccessCard, tableAccessCard);

        textFields(xAccessCard, textFieldAccessCard);

        JButton buttonAccesCardAdd = new JButton("ADD ACCESS CARD");
        buttonAdd(buttonAccesCardAdd, name, textFieldAccessCard);
        buttonOptionsAdd(xAccessCard, buttonAccesCardAdd);

        labelId(xAccessCard);

        textId(xAccessCard, jTextField);

        JButton buttonAccesCardGet = new JButton("GET ACCESS CARD");
        buttonGet(buttonAccesCardGet, name, jTextField);
        buttonOptionsGet(xAccessCard, buttonAccesCardGet);
    }

    private void department() {
        String name = "Department";
        int xDepartment = 200;
        String[] tableDepartment = {"Name"};
        JTextField[] textFieldDepartment = {textDepartmentName};
        JTextField[] jTextField = {textIdDepartment};

        labelHeadlines(xDepartment, name);

        labelColumnSignatures(xDepartment, tableDepartment);

        textFields(xDepartment, textFieldDepartment);

        JButton buttonDepartmentAdd = new JButton("ADD DEPARTMENT");
        buttonAdd(buttonDepartmentAdd, name, textFieldDepartment);
        buttonOptionsAdd(xDepartment, buttonDepartmentAdd);

        labelId(xDepartment);

        textId(xDepartment, jTextField);

        JButton buttonDepartmentGet = new JButton("GET DEPARTMENT");
        buttonGet(buttonDepartmentGet, name, jTextField);
        buttonOptionsGet(xDepartment, buttonDepartmentGet);
    }

    private void product() {
        String name = "Product";
        int xProduct = 400;
        String[] tableProduct = new String[]{"Name", "Amount", "Price", "Department", "Supplier"};
        JTextField[] textFieldProduct = {textProductName, textProductAmount, textProductPrice, textProductDepartment, textProductSupplier};
        JTextField[] jTextField = {textIdProduct};

        labelHeadlines(xProduct, name);

        labelColumnSignatures(xProduct, tableProduct);

        textFields(xProduct, textFieldProduct);

        JButton buttonProductAdd = new JButton("ADD PRODUCT");
        buttonAdd(buttonProductAdd, name, textFieldProduct);
        buttonOptionsAdd(xProduct, buttonProductAdd);

        labelId(xProduct);

        textId(xProduct, jTextField);

        JButton buttonProductGet = new JButton("GET PRODUCT");
        buttonGet(buttonProductGet, name, jTextField);
        buttonOptionsGet(xProduct, buttonProductGet);
    }

    private void room() {
        String name = "Room";
        int xRoom = 600;
        String[] tableRoom = new String[]{"Name"};
        JTextField[] jTextFieldRoom = {textRoomName};
        JTextField jTextField[] = {textIdRoom};

        labelHeadlines(xRoom, name);

        labelColumnSignatures(xRoom, tableRoom);

        textFields(xRoom, jTextFieldRoom);

        JButton buttonRoomAdd = new JButton("ADD ROOM");
        buttonAdd(buttonRoomAdd, name, jTextFieldRoom);
        buttonOptionsAdd(xRoom, buttonRoomAdd);

        labelId(xRoom);

        textId(xRoom, jTextField);

        JButton buttonRoomGet = new JButton("GET ROOM");
        buttonGet(buttonRoomGet, name, jTextField);
        buttonOptionsGet(xRoom, buttonRoomGet);
    }

    private void supplier() {
        String name = "Supplier";
        int xSupplier = 800;
        String[] tableSupplier = new String[]{"Name", "Address", "Phone", "Nip"};
        JTextField[] jTextFieldSupplier = {textSupplierName, textSupplierAddress, textSupplierPhone, textSupplierNip};
        JTextField jTextField[] = {textIdSupplier};

        labelHeadlines(xSupplier, name);

        labelColumnSignatures(xSupplier, tableSupplier);

        textFields(xSupplier, jTextFieldSupplier);

        JButton buttonSupplierAdd = new JButton("ADD SUPPLIER");
        buttonAdd(buttonSupplierAdd, name, jTextFieldSupplier);
        buttonOptionsAdd(xSupplier, buttonSupplierAdd);

        labelId(xSupplier);

        textId(xSupplier, jTextField);

        JButton buttonSupplierGet = new JButton("GET SUPPLIER");
        buttonGet(buttonSupplierGet, name, jTextField);
        buttonOptionsGet(xSupplier, buttonSupplierGet);
    }

    private void worker() {
        String name = "Worker";
        int xWorker = 1000;
        String[] tableWorker = new String[]{"Name", "Surname", "Salary", "Department"};
        JTextField[] jTextFieldWorker = {textWorkerName, textWorkerSurname, textWorkerSalary, textWorkerDepartment};
        JTextField jTextField[] = {textIdWorker};

        labelHeadlines(xWorker, name);

        labelColumnSignatures(xWorker, tableWorker);

        textFields(xWorker, jTextFieldWorker);

        JButton buttonWorkerAdd = new JButton("ADD WORKER");
        buttonAdd(buttonWorkerAdd, name, jTextFieldWorker);
        buttonOptionsAdd(xWorker, buttonWorkerAdd);

        labelId(xWorker);

        textId(xWorker, jTextField);

        JButton buttonWorkerGet = new JButton("GET WORKER");
        buttonGet(buttonWorkerGet, name, jTextField);
        buttonOptionsGet(xWorker, buttonWorkerGet);
    }

    private void labelHeadlines(int x, String name) {
        JLabel label = new JLabel(name + ":");
        label.setFont(new Font("Times New Roman", Font.BOLD, 18));
        label.setBounds(25 + x, 25, 100, 45);
        frame.getContentPane().add(label);
    }

    private void labelColumnSignatures(int x, String[] table) {
        for (int i = 0; i < table.length; i++) {
            JLabel label = new JLabel(table[i] + ":");
            label.setFont(new Font("Times New Roman", Font.BOLD, 14));
            label.setBounds(25 + x, 25 + (i + 1) * 50, 100, 45);
            frame.getContentPane().add(label);
        }
    }

    private void labelId(int x) {
        JLabel label = new JLabel("id: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label.setBounds(25 + x, 420, 100, 45);
        frame.getContentPane().add(label);
    }

    private void labelAnswer(String answer) {
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
                    labelAnswer(answerString);
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