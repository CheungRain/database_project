import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class select3 extends JFrame {
    public select3() {
        initComponents();
    }
    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String s1 = new String(textField1.getText());
        String s2 = null,temp =null;
        ArrayList<String> s3 = new ArrayList<>();
        ArrayList<String> s4 = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //获取数据连接
            connection = jdbcUtil.openConnection();
            //获取发送sql指令执行sql对象
            statement = connection.createStatement();
            //返回查询结果集用于保存数据库查询内容
            String sql ="SELECT LNO,TIME(ENDTIME) FREE_BEGIN," +
                    "TIME(BEGINTIME) FREE_END FROM BOOK WHERE"
                    +" DATE(BEGINTIME)<=>"+s1+" ORDER BY LNO,BEGINTIME,ENDTIME";
            rs = statement.executeQuery(sql);
            //遍历结果集拿到数据
            if(rs.next()){
                System.out.println("实验室\t空闲开始时间\t空闲结束时间");
                do {
                    s2=rs.getString(1);
                    if(!s2.equals(temp)){
                        Collections.sort(s3);
                        Collections.sort(s4);
                        if(s3.size()>s4.size()){
                            s3.remove(0);
                        }else if(s4.size()>s3.size()){
                            s4.remove(s4.size()-1);
                        }
                        for(int i=0;i<s3.size();i++){
                            System.out.println(temp+"\t\t"+s3.get(i)+"\t"+s4.get(i));
                        }
                        s3.clear();
                        s4.clear();
                        s3.add("08:00:00");
                        s4.add("22:00:00");
                        temp=s2;
                    }
                    s3.add(rs.getString(2));
                    s4.add(rs.getString(3));
                } while (rs.next());
                if(s3.size()>0){
                    Collections.sort(s3);
                    Collections.sort(s4);
                    if(s3.size()>s4.size()){
                        s3.remove(0);
                    }else if(s4.size()>s3.size()){
                        s4.remove(s4.size()-1);
                    }
                    for(int i=0;i<s3.size();i++){
                        System.out.println(temp+"\t\t"+s3.get(i)+"\t"+s4.get(i));
                    }
                    s3.clear();
                    s4.clear();
                }
            }else{
                JOptionPane.showMessageDialog(null,"全天空闲");
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

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_6"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_6"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_5"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(97, 97, 97)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))))
                    .addContainerGap(128, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(label2)
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addComponent(button1)
                    .addContainerGap(110, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    public static void main(String [] args){
        new select3().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
