/*
 * Created by JFormDesigner on Thu Jan 04 02:53:46 CST 2018
 */

package main;
import main.MainForm;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import net.miginfocom.swing.*;
import sun.font.TextLabel;

/**
 * @author Sun Qi
 */
public class Additon extends JFrame {
    public Additon() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e1) {
        //添加记录
        //String a = textField1.getText();
        //System.out.println(a);//ok
        String b = textField1.getText();
        String c = textField2.getText();
        String d = textField3.getText();
        String e = textField4.getText();
        String f = textField5.getText();
        String g = textField6.getText();
        String h = textField7.getText();
        String i = textField8.getText();
        String j = textField9.getText();
        String k = textField10.getText();
        String l = textField11.getText();
        String m = textField12.getText();
        String sql="INSERT INTO program (Id, country, university, school, program_name, homepage, location, email, phone_number, degree, deadline_with_aid, deadline_without_aid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = MainForm.getConn();
            PreparedStatement ppd = conn.prepareStatement(sql);
            ppd.setString(1,b);
            ppd.setString(2,c);
            ppd.setString(3,d);
            ppd.setString(4,e);
            ppd.setString(5,f);
            ppd.setString(6,g);
            ppd.setString(7,h);
            ppd.setString(8,i);
            ppd.setString(9,j);
            ppd.setString(10,k);
            ppd.setString(11,l);
            ppd.setString(12,m);
            ppd.execute();
            //关闭资源！！！！
            ppd.close();
            conn.close();

            System.out.println("增加数据成功！");
            dispose();//关闭窗口
        } catch (SQLException e2) {
            System.out.println("增加数据失败： "+ e2.getMessage());
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Qi
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        textField6 = new JTextField();
        label7 = new JLabel();
        textField7 = new JTextField();
        label8 = new JLabel();
        textField8 = new JTextField();
        label9 = new JLabel();
        textField9 = new JTextField();
        label10 = new JLabel();
        textField10 = new JTextField();
        label11 = new JLabel();
        textField11 = new JTextField();
        label12 = new JLabel();
        textField12 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("Add");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[75,fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Id\uff1a");
        contentPane.add(label1, "cell 1 0");
        contentPane.add(textField1, "cell 3 0");

        //---- label2 ----
        label2.setText("country\uff1a");
        contentPane.add(label2, "cell 1 1");
        contentPane.add(textField2, "cell 3 1");

        //---- label3 ----
        label3.setText("university:");
        contentPane.add(label3, "cell 1 2");
        contentPane.add(textField3, "cell 3 2");

        //---- label4 ----
        label4.setText("school:");
        contentPane.add(label4, "cell 1 3");
        contentPane.add(textField4, "cell 3 3");

        //---- label5 ----
        label5.setText("program_name:");
        contentPane.add(label5, "cell 1 4");
        contentPane.add(textField5, "cell 3 4");

        //---- label6 ----
        label6.setText("homepage:");
        contentPane.add(label6, "cell 1 5");
        contentPane.add(textField6, "cell 3 5");

        //---- label7 ----
        label7.setText("location:");
        contentPane.add(label7, "cell 1 6");
        contentPane.add(textField7, "cell 3 6");

        //---- label8 ----
        label8.setText("email:");
        contentPane.add(label8, "cell 1 7");
        contentPane.add(textField8, "cell 3 7");

        //---- label9 ----
        label9.setText("phone_number:");
        contentPane.add(label9, "cell 1 8");
        contentPane.add(textField9, "cell 3 8");

        //---- label10 ----
        label10.setText("degree:");
        contentPane.add(label10, "cell 1 9");
        contentPane.add(textField10, "cell 3 9");

        //---- label11 ----
        label11.setText("deadline_with_aid:");
        contentPane.add(label11, "cell 1 10");
        contentPane.add(textField11, "cell 3 10");

        //---- label12 ----
        label12.setText("deadline_without_aid:");
        contentPane.add(label12, "cell 1 11");
        contentPane.add(textField12, "cell 3 11");

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 5 12");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Qi
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JTextField textField6;
    private JLabel label7;
    private JTextField textField7;
    private JLabel label8;
    private JTextField textField8;
    private JLabel label9;
    private JTextField textField9;
    private JLabel label10;
    private JTextField textField10;
    private JLabel label11;
    private JTextField textField11;
    private JLabel label12;
    private JTextField textField12;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
