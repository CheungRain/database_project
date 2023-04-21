import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.GroupLayout;

public class select extends JFrame {
    public select() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String s = new String(textField1.getText());
        String s1 = new String(textField2.getText());
        String s2 = new String(textField3.getText());
        String s3 = new String(textField4.getText());
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //返回查询结果集用于保存数据库查询内容
            String sql = "SELECT TNO,BEGINTIME,ENDTIME,LNO,USERNAME FROM BOOK WHERE (TNO="+s
                    +" OR TNO=(SELECT TNO FROM TEACHER WHERE TNAME="+s2+")) AND BEGINTIME>="+s2+" AND ENDTIME<="+s3;
            rs = statement.executeQuery(sql);
            //遍历结果集拿到数据
            if(rs!=null)
            System.out.println("教师编号\t\t起始时间\t\t\t\t结束时间\t\t\t\t\t实验室编号\t使用者");
            while (rs.next()) {
                System.out.println(rs.getString(1)+"\t\t\t"+rs.getString(2)+"\t"
                +rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5));
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
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label5 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_2"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_2"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_3"));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_3"));

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_3"));

        //---- label5 ----
        label5.setText(bundle.getString("label5.text_2"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addContainerGap(248, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addComponent(label1)
                                .addComponent(label3)
                                .addComponent(label4))
                            .addGap(35, 35, 35)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(textField4)
                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                            .addGap(42, 42, 42))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(label5)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1)
                    .addGap(45, 45, 45))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public static void main(String[] args){
        new select().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
