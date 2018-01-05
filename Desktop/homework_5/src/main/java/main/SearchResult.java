/*
 * Created by JFormDesigner on Fri Jan 05 00:26:06 CST 2018
 */

package main;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Sun Qi
 */
public class SearchResult extends JFrame {
    public SearchResult() {
        initComponents();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sun Qi
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u67e5\u8be2\u7ed3\u679c\u4e3a\uff1a");
        contentPane.add(label1, "cell 1 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sun Qi
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
