import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class change extends JFrame {
    public change() {
        initComponents();
    }
    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Connection connection = null;
        Statement statement = null;
        ArrayList<String> s = new ArrayList<>();
        String s1 = new String(textField1.getText());
        String s2 = new String(textField3.getText());
        String s3 = new String(textField4.getText());
        s.add("UPDATE LAB SET LNAME = "+s2+
                " WHERE LNO = (SELECT LNO FROM DEVICE WHERE DNO = "+s1+")");
        s.add("UPDATE LAB SET MAXNUM = "+s3+
                " WHERE LNO = (SELECT LNO FROM DEVICE WHERE DNO = "+s1+")");
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            if(!s2.equals(""))
                statement.addBatch(s.get(0));
            if(!s3.equals(""))
                statement.addBatch(s.get(1));
            //执行成功返回更新计数的数组
            int[] success = statement.executeBatch();  //批量执行所有sql返回一个更新计数的数组
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
        textField1 = new JTextField();
        textField3 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField4 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_12"));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_6"));

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_5"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_12"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField1)
                        .addComponent(textField4)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                    .addGap(94, 94, 94))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public static void main(String[] args){
        new change().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JTextField textField3;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField4;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
