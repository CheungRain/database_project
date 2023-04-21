import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class password extends JFrame {
    public password() {
        initComponents();
    }
    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Connection connection = null;
        Statement statement = null;
        String s1 = new String(textField1.getText());
        String s2 = new String(passwordField1.getPassword());
        String s5 = new String(textField3.getText());
        boolean flag = false;
        ResultSet resultSet = null;
        try {
                connection = jdbcUtil.openConnection();
                String sql = "SELECT NUMBER,PWD,TNO FROM ADMIN";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    if(s1.equals(resultSet.getString(1))&&s2.equals(resultSet.getString(2))
                            &&s5.equals(resultSet.getString(3))){
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
        String s3 = new String(textField2.getText());
        String s4 = new String(passwordField2.getPassword());
        ArrayList<String> s = new ArrayList<>();
        s.add("UPDATE ADMIN SET NUMBER ="+s3+" WHERE NUMBER ="+s1);
        s.add("UPDATE ADMIN SET PWD ="+s4+" WHERE PWD ="+s2);
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            if(flag==false) {
                JOptionPane.showMessageDialog(null, "教师号或原账号或密码不正确请重新输入");
                this.setVisible(false);
            }else{
                statement.addBatch(s.get(0));
                statement.addBatch(s.get(1));
                int[] success = statement.executeBatch();  //批量执行所有sql返回一个更新计数的数组
                JOptionPane.showMessageDialog(null, "修改成功");
                this.setVisible(false);
            }
            //执行成功返回更新计数的数组
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try {
                statement.close();
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        button1 = new JButton();
        textField3 = new JTextField();
        label5 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_15"));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_10"));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_9"));

        //---- label4 ----
        label4.setText(bundle.getString("label4.text"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_15"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- label5 ----
        label5.setText(bundle.getString("label5.text"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addComponent(label3)
                        .addComponent(label2)
                        .addComponent(label1)
                        .addComponent(label5))
                    .addGap(83, 83, 83)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(textField2)
                        .addComponent(textField1)
                        .addComponent(passwordField2)
                        .addComponent(passwordField1)
                        .addComponent(textField3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(108, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton button1;
    private JTextField textField3;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
