import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class change2 extends JFrame {
    public change2() {
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
        s.add("UPDATE TEACHER SET TNAME = "+s2+" WHERE TNO ="+s1);
        s.add("UPDATE TEACHER SET PHONE = "+s3+" WHERE TNO ="+s1);
        s.add("UPDATE TEACHER SET DEPT = "+s4+" WHERE TNO ="+s1);
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
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_14"));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_9"));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_8"));

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_6"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_14"));
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
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(label4)
                        .addComponent(label3)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(textField2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                        .addComponent(textField1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addGap(75, 75, 75))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(16, 16, 16)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addContainerGap(34, Short.MAX_VALUE))
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
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args){
        new change2().setVisible(true);
    }
}
