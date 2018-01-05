/*
 * Created by JFormDesigner on Wed Jan 03 23:57:34 CST 2018
 */

package main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Sun Qi
 */
public class MainForm extends JFrame {


    public MainForm() {
        initComponents();
        this.getContentPane().setBackground(Color.PINK);
    }

    //===========连接================
    public static Connection getConn(){
        Connection conn = null;
        //连接本地数据库

        try{
            String url = "jdbc:mysql://127.0.0.1:3306/db_program";
            String user = "root";
            String psw = "110846810";
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //获得数据库连接
            conn = DriverManager.getConnection(url,user,psw);

        }

        //连接云端数据库
        /*
        try{
            String url = "jdbc:mysql://119.27.166.115:2017/java_exp";
            String user = "whu_iss_2017";
            String psw = "iss_java_2017";
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //获得数据库连接
            conn = DriverManager.getConnection(url,user,psw);

        }*/
        catch(ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e1){
            e1.printStackTrace();
        }
        //System.out.println(conn);//说明可以成功连接
        return conn;//将获得的数据库与java的链接返回（返回类型为Connection）
    }

    //==========增加=================
    private void button2MouseClicked(MouseEvent e) {
        //增加记录
        Additon add = new Additon();
        add.setVisible(true);

    }

    //=========更新==================
    private void button6MouseClicked(MouseEvent e) {
        //更新
        Update up = new Update();
        up.update();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);


    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Qi
        button6 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("Main");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[39,fill]" +
            "[101,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]0" +
            "[]0" +
            "[]" +
            "[0]" +
            "[5]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[0]" +
            "[17]" +
            "[]" +
            "[0]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- button6 ----
        button6.setText("\u66f4\u65b0");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button6MouseClicked(e);
            }
        });
        contentPane.add(button6, "cell 1 5 2 1");

        //---- button2 ----
        button2.setText("\u589e\u52a0");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 1 9 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Qi
    private JButton button6;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
