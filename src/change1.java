import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class change1 extends JFrame {
    public change1() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Connection connection = null;
        Statement statement = null;
        ArrayList<String> s = new ArrayList<>();
        String s1 = new String(textField1.getText());
        String s2 = new String(textField2.getText());
        String s3 = new String(textField3.getText());
        String s4 = new String(textField4.getText());
        s.add("UPDATE LAB SET LNAME = "+s2+" WHERE LNO ="+s1);
        s.add("UPDATE LAB SET MAXNUM = "+s3+" WHERE LNO ="+s1);
        s.add("UPDATE LAB SET PURPOSE = "+s4+" WHERE LNO ="+s1);
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            if(!s2.equals(""))
                statement.addBatch(s.get(0));
            if(!s3.equals(""))
                statement.addBatch(s.get(1));
            if(!s4.equals(""))
                statement.addBatch(s.get(2));
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
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        label4 = new JLabel();
        textField4 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_13"));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_8"));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_7"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_13"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_7"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label3)
                        .addComponent(label1)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textField1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addComponent(textField2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addComponent(textField3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addComponent(button1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                    .addGap(88, 88, 88))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addComponent(button1)
                    .addGap(21, 21, 21))
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
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JLabel label4;
    private JTextField textField4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args){
        new change1().setVisible(true);
    }
}
