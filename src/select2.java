import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class select2 extends JFrame {
    public select2() {
        initComponents();
    }
    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String s1 = new String(textField1.getText());
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //返回查询结果集用于保存数据库查询内容
            String sql="SELECT LNO FROM DEVICE WHERE DNO="+s1;
            rs = statement.executeQuery(sql);
            //遍历结果集拿到数据
            if(rs!=null)
                System.out.println("实验室号");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }finally {
            //执行完数据库操作后记得关闭数据库连接资源
            try{
                rs.close();
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
        label1.setText(bundle.getString("label1.text_5"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_5"));
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
                    .addGap(54, 54, 54)
                    .addComponent(label1)
                    .addGap(86, 86, 86)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                    .addContainerGap(145, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)
                    .addComponent(button1)
                    .addContainerGap(113, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public static void main(String [] args){
        new select2().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
