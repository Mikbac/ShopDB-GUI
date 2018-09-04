import javax.accessibility.AccessibleComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static JFrame frame;




    public static void main(String[] args){

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

    public Main()
    {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1200, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        Main.accessCard();
        Main.department();
        Main.product();
        Main.room();
        Main.supplier();
        Main.worker();



    }
        public static void accessCard() {
            int x=0;
            JLabel labelAccessCard = new JLabel("Access Card:");
            labelAccessCard.setFont(new Font("Times New Roman", Font.BOLD, 18));
            labelAccessCard.setBounds(25+x, 25, 120, 45);
            frame.getContentPane().add(labelAccessCard);
        }
        public static void department() {
            int x=200;
            JLabel labelDepartment = new JLabel("Department:");
            labelDepartment.setFont(new Font("Times New Roman", Font.BOLD, 18));
            labelDepartment.setBounds(25+x, 25, 100, 45);
            frame.getContentPane().add(labelDepartment);
        }
        public static void product() {
            int x=400;
            JLabel labelProduct = new JLabel("Product:");
            labelProduct.setFont(new Font("Times New Roman", Font.BOLD, 18));
            labelProduct.setBounds(25+x, 25, 100, 45);
            frame.getContentPane().add(labelProduct);
        }
        public static void room() {
            int x=600;
            JLabel labelRoom = new JLabel("Room");
            labelRoom.setFont(new Font("Times New Roman", Font.BOLD, 18));
            labelRoom.setBounds(25+x, 25, 100, 45);
            frame.getContentPane().add(labelRoom);
        }
        public static void supplier() {
            int x=800;

            JLabel labelSupplier = new JLabel("Supplier:");
            labelSupplier.setFont(new Font("Times New Roman", Font.BOLD, 18));
            labelSupplier.setBounds(25+x, 25, 100, 45);
            frame.getContentPane().add(labelSupplier);
        }

        public static void worker() {
            int x=1000;

            JLabel labelWorker = new JLabel("Worker:");
            labelWorker.setFont(new Font("Times New Roman", Font.BOLD, 18));
            labelWorker.setBounds(25+x, 25, 100, 45);
            frame.getContentPane().add(labelWorker);


        }
}