import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
public class drop2 extends JFrame {
    public drop2() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Connection connection = null;
        Statement statement = null;
        String s = new String(textField1.getText());
        String sql = "DELETE FROM LAB WHERE LNO ="+s;
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //删除成功返回1
            int success = statement.executeUpdate(sql);
        } catch (Exception e1) {
            e1.printStackTrace();
        }finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try{
                statement.close();
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_9"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_9"));
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
                    .addGap(89, 89, 89)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField1))
                    .addGap(88, 88, 88))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addComponent(button1)
                    .addContainerGap(111, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
