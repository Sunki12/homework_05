/*
 * Created by JFormDesigner on Thu Jan 04 14:15:46 CST 2018
 */

package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import net.miginfocom.swing.*;

import static main.MainForm.getConn;

/**
 * @author Sun Qi
 */
public class Update extends JFrame {
    public Update() {
        initComponents();
    }
    //创建table

    public JTable update() {
        //1.创建列并赋值
        Vector<Vector<String>> rowData = new Vector<>();//储存行数据,从数据库里读取
        Vector<String> columnName = new Vector<String>();//储存列名
        columnName.add("Id");
        columnName.add("country");
        columnName.add("university");
        columnName.add("school");
        columnName.add("program_name");
        columnName.add("homepage");
        columnName.add("location");
        columnName.add("email");
        columnName.add("phone_number");
        columnName.add("degree");
        columnName.add("deadline_with_aid");
        columnName.add("deadline_without_aid");
        //2.连接数据库
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = getConn().prepareStatement("SELECT * FROM program");
            rs = ps.executeQuery();
            while(rs.next()){
                Vector<String> hang = new Vector<>();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getString(4));
                hang.add(rs.getString(5));
                hang.add(rs.getString(6));
                hang.add(rs.getString(7));
                hang.add(rs.getString(8));
                hang.add(rs.getString(9));
                hang.add(rs.getString(10));
                hang.add(rs.getString(11));
                hang.add(rs.getString(12));

                //加入到rowData
                rowData.add(hang);

            }
        }catch (Exception e2){
            e2.printStackTrace();

        }finally{
            try {
                if (ps != null) {
                    ps.close();
                }
                getConn().close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        JTable table1 = new JTable(rowData,columnName);
        table1.getTableHeader().setReorderingAllowed(false);//设置表头不可拖动

        JScrollPane scrollPane1 = new JScrollPane(table1);
        this.add(scrollPane1);
        scrollPane1.setBounds(0,1,2,17);
        table1.setBounds(0,0,500,500);
        this.setBounds(0,0,1000,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        return table1;

    }


    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }
    //=========
    private void button2MouseClicked(MouseEvent e) {
        //关闭窗口
        dispose();
    }

    //=================================
    private int getrownum(){
        int t = table1.getSelectedRow();
        System.out.println(t);
        return t;
    }

    public JTable getTable1() {
        return table1;
    }



    private void button3MouseClicked(MouseEvent e) {
        //查看


    }

    private void button1MouseClicked(MouseEvent e) throws SQLException {
        //搜索
        Vector<Vector<String>> rowData = new Vector<>();//储存行数据,从数据库里读取
        Vector<String> columnName = new Vector<String>();//储存列名
        columnName.add("Id");
        columnName.add("country");
        columnName.add("university");
        columnName.add("school");
        columnName.add("program_name");
        columnName.add("homepage");
        columnName.add("location");
        columnName.add("email");
        columnName.add("phone_number");
        columnName.add("degree");
        columnName.add("deadline_with_aid");
        columnName.add("deadline_without_aid");
        try{
            String input = textField1.getText();
            String s = "%"+input+"%";
            //System.out.println(text);
            Connection conn = MainForm.getConn();
            String sql = "SELECT * FROM program WHERE university LIKE ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,s);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Vector<String> hang = new Vector<>();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getString(4));
                hang.add(rs.getString(5));
                hang.add(rs.getString(6));
                hang.add(rs.getString(7));
                hang.add(rs.getString(8));
                hang.add(rs.getString(9));
                hang.add(rs.getString(10));
                hang.add(rs.getString(11));
                hang.add(rs.getString(12));
                rowData.add(hang);
                System.out.println(rs.getString("location"));
            }
            //System.out.println("cl");
            //关闭资源
            rs.close();
            pst.close();
            conn.close();

        }catch(SQLException e4){
            e4.printStackTrace();

        }
        JTable table1 = new JTable(rowData,columnName);
        table1.getTableHeader().setReorderingAllowed(false);//设置表头不可拖动

        JScrollPane scrollPane1 = new JScrollPane(table1);
        this.add(scrollPane1);
        scrollPane1.setBounds(0,1,2,17);
        table1.setBounds(0,0,500,500);
        this.setBounds(0,0,1000,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Qi
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane3 = new JScrollPane();
        table1 = new JTable();
        button3 = new JButton();

        //======== this ========
        setTitle("Search");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[145,fill]" +
            "[60,fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[22]" +
            "[]" +
            "[31]" +
            "[]"));
        contentPane.add(textField1, "cell 0 0 2 1");

        //---- button1 ----
        button1.setText("\u641c\u7d22");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button1MouseClicked(e);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPane.add(button1, "cell 2 0");

        //---- button2 ----
        button2.setText("\u5173\u95ed");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
                button2MouseClicked(e);
                button2MouseClicked(e);
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 3 0");

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(table1);
        }
        contentPane.add(scrollPane3, "cell 0 1 2 2");

        //---- button3 ----
        button3.setText("\u67e5\u770b");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3, "cell 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Qi
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane3;
    private JTable table1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
