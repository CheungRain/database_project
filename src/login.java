import java.awt.*;
import com.jgoodies.common.collect.ArrayListModel;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.event.*;
/*
 * Created by Zhang Yu on Fri Nov 25 21:59:03 CST 2022
 */

/**
 * @author Zhang Yu
 */
public class login extends JFrame {
    public login() {
        initComponents();
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        System.exit(0);
    }
    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String s1 = new String(textField1.getText());
        String s2 = new String(passwordField1.getPassword());
        boolean flag = false;
        try {
            connection = jdbcUtil.openConnection();
            String sql = "SELECT NUMBER,PWD FROM ADMIN";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                if(s1.equals(resultSet.getString(1))&&s2.equals(resultSet.getString(2))){
                    flag = true;
                    break;
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }finally{
            try {
                if (resultSet != null){
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        if(flag){
            JOptionPane.showMessageDialog(null,"登录成功");
            //this.setVisible(false);
            new menu().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"账号或密码不正确");
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        passwordField1 = new JPasswordField();

        //======== this ========
        setBackground(new Color(0x66ffcc));
        setForeground(new Color(0x99ff99));
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text"));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text"));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText(bundle.getString("button2.text"));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(135, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(label1)
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(67, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args){
        new login().setVisible(true);
    }
}
