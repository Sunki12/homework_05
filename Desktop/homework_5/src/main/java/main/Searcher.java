package main;

import search.FileHandler;
import search.Parser;
import search.WebSpider;
import vo.Program;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * 请不要对此接口进行任何修改
 */
public final class Searcher {

    /**
     * 请不要对此函数进行任何操作，一句话也不允许加
     * @param args
     */
    public static void main(String[] args) {
        //实例化显示主窗体
        MainForm mv = new MainForm();
        mv.setVisible(true);
        /*
        JTable table1 = new JTable();
        table1.setVisible(true);
        table1.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应

                //得到选中的行列的索引值

                int r= table1.getSelectedRow();

                int c= table1.getSelectedColumn();

                //得到选中的单元格的值，表格中都是字符串

                Object value= table1.getValueAt(r, c);

                String info=r+"行"+c+"列值 : "+value.toString();

                javax.swing.JOptionPane.showMessageDialog(null,info);

            }
        });*/

        try {
            Class.forName("search.impl.Manager");
        } catch (ClassNotFoundException e) {
            System.out.println("Manager类不存在");
        }

        List<WebSpider> webSpiders = main.SearchManager.getWebSpider();

        List<Program> programs = new ArrayList<>();
        for (WebSpider webSpider : webSpiders) {
            Parser parser = webSpider.getParser();
            List<String> pages = webSpider.getHtmlFromWeb();//可以得到pages！即项目地址的lists
            for (String page : pages) {
                programs.add(parser.parseHtml(page));
            }
        }

        FileHandler fileHandler = main.SearchManager.getFileHandler();
        fileHandler.program2File(programs);


    }
}
