import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class select1 extends JFrame {
    public select1() {
        initComponents();
    }
    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String s1 = new String(textField1.getText());
        String s2 = new String(textField2.getText());
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //返回查询结果集用于保存数据库查询内容
            String sql = "SELECT TIME(BEGINTIME),TIME(ENDTIME) FROM BOOK WHERE LNO="+s1
                    +" AND DATE(BEGINTIME)<=>"+s2;
            rs = statement.executeQuery(sql);
            //遍历结果集拿到数据
            if(rs.next()) {
                System.out.println("占用开始时间\t占用结束时间");
                do{
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                }while (rs.next());
            }else{
                JOptionPane.showMessageDialog(null,"当天全部空闲");
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
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        label3 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_4"));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_4"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_4"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_4"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2))
                            .addGap(77, 77, 77)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))))
                    .addContainerGap(70, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(label3)
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addComponent(button1)
                    .addContainerGap(64, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public static void main(String [] args){
        new select1().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
