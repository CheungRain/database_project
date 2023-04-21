import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class statistics extends JFrame {
    public statistics() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //返回查询结果集用于保存数据库查询内容
            String sql="SELECT LNO,SUM(TIMESTAMPDIFF(MINUTE,BEGINTIME,ENDTIME))/43200/12 YEAR " +
                    "FROM BOOK GROUP BY LNO";
            rs = statement.executeQuery(sql);
            //遍历结果集拿到数据
            if(rs!=null)
                System.out.println("实验室号\t预约时间年份计算");
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t\t"+
                        rs.getString(2));
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
    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //返回查询结果集用于保存数据库查询内容
            String sql="SELECT LNO,SUM(TIMESTAMPDIFF(MINUTE,BEGINTIME,ENDTIME))/43200 MONTH " +
                    "FROM BOOK GROUP BY LNO";
            rs = statement.executeQuery(sql);
            //遍历结果集拿到数据
            if(rs!=null)
                System.out.println("实验室号\t预约时间月份计算");
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t\t"+
                        rs.getString(2));
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
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_16"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_3"));
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
                    .addGap(145, 145, 145)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addContainerGap(169, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(button1)
                    .addGap(71, 71, 71)
                    .addComponent(button2)
                    .addContainerGap(83, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public static void main(String [] args){
        new statistics().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
