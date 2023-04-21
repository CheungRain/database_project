import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
public class menu extends JFrame {
    public menu() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        frame1.setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        frame2.setVisible(true);
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        frame3.setVisible(true);
    }

    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
        new select().setVisible(true);
    }

    private void button7MouseClicked(MouseEvent e) {
        // TODO add your code here
        new select1().setVisible(true);
    }

    private void button8MouseClicked(MouseEvent e) {
        // TODO add your code here
        new select2().setVisible(true);
    }

    private void button9MouseClicked(MouseEvent e) {
        // TODO add your code here
        new select3().setVisible(true);
    }

    private void button13MouseClicked(MouseEvent e) {
        // TODO add your code here
        new drop().setVisible(true);
    }

    private void button14MouseClicked(MouseEvent e) {
        // TODO add your code here
        new drop1().setVisible(true);
    }

    private void button15MouseClicked(MouseEvent e) {
        // TODO add your code here
        new drop2().setVisible(true);
    }

    private void button16MouseClicked(MouseEvent e) {
        // TODO add your code here
        new drop3().setVisible(true);
    }

    private void button17MouseClicked(MouseEvent e) {
        // TODO add your code here
        new drop4().setVisible(true);
    }

    private void button10MouseClicked(MouseEvent e) {
        // TODO add your code here
        new change().setVisible(true);
    }

    private void button11MouseClicked(MouseEvent e) {
        // TODO add your code here
        new change1().setVisible(true);
    }

    private void button12MouseClicked(MouseEvent e) {
        // TODO add your code here
        new change2().setVisible(true);
    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
        new password().setVisible(true);
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        new statistics().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        frame1 = new JFrame();
        label2 = new JLabel();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        frame2 = new JFrame();
        label3 = new JLabel();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        frame3 = new JFrame();
        label4 = new JLabel();
        button13 = new JButton();
        button14 = new JButton();
        button15 = new JButton();
        button16 = new JButton();
        button17 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_3"));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_3"));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_2"));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_2"));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_2"));
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });

        //---- button5 ----
        button5.setText(bundle.getString("button5.text_2"));
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(146, 146, 146)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button5)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3)
                        .addComponent(button4)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(label1)))
                    .addContainerGap(168, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addGap(12, 12, 12)
                    .addComponent(button2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button3)
                    .addGap(12, 12, 12)
                    .addComponent(button4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button5)
                    .addContainerGap(33, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== frame1 ========
        {
            var frame1ContentPane = frame1.getContentPane();

            //---- label2 ----
            label2.setText(bundle.getString("label2.text_2"));

            //---- button6 ----
            button6.setText(bundle.getString("button6.text"));
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button6MouseClicked(e);
                }
            });

            //---- button7 ----
            button7.setText(bundle.getString("button7.text"));
            button7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button7MouseClicked(e);
                }
            });

            //---- button8 ----
            button8.setText(bundle.getString("button8.text"));
            button8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button8MouseClicked(e);
                }
            });

            //---- button9 ----
            button9.setText(bundle.getString("button9.text"));
            button9.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button9MouseClicked(e);
                }
            });

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(label2)))
                        .addGap(33, 33, 33))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button9)
                        .addContainerGap(8, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }

        //======== frame2 ========
        {
            var frame2ContentPane = frame2.getContentPane();

            //---- label3 ----
            label3.setText(bundle.getString("label3.text_2"));

            //---- button10 ----
            button10.setText(bundle.getString("button10.text"));
            button10.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button10MouseClicked(e);
                }
            });

            //---- button11 ----
            button11.setText(bundle.getString("button11.text"));
            button11.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button11MouseClicked(e);
                }
            });

            //---- button12 ----
            button12.setText(bundle.getString("button12.text"));
            button12.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button12MouseClicked(e);
                }
            });

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame2ContentPaneLayout.createParallelGroup()
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(frame2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(button11)
                                    .addComponent(button10)
                                    .addComponent(button12, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(label3)))
                        .addContainerGap(40, Short.MAX_VALUE))
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addGroup(frame2ContentPaneLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button10)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button11)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button12)
                        .addContainerGap(17, Short.MAX_VALUE))
            );
            frame2.pack();
            frame2.setLocationRelativeTo(frame2.getOwner());
        }

        //======== frame3 ========
        {
            var frame3ContentPane = frame3.getContentPane();

            //---- label4 ----
            label4.setText(bundle.getString("label4.text_2"));

            //---- button13 ----
            button13.setText(bundle.getString("button13.text"));
            button13.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button13MouseClicked(e);
                }
            });

            //---- button14 ----
            button14.setText(bundle.getString("button14.text"));
            button14.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button14MouseClicked(e);
                }
            });

            //---- button15 ----
            button15.setText(bundle.getString("button15.text"));
            button15.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button15MouseClicked(e);
                }
            });

            //---- button16 ----
            button16.setText(bundle.getString("button16.text"));
            button16.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button16MouseClicked(e);
                }
            });

            //---- button17 ----
            button17.setText(bundle.getString("button17.text"));
            button17.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button17MouseClicked(e);
                }
            });

            GroupLayout frame3ContentPaneLayout = new GroupLayout(frame3ContentPane);
            frame3ContentPane.setLayout(frame3ContentPaneLayout);
            frame3ContentPaneLayout.setHorizontalGroup(
                frame3ContentPaneLayout.createParallelGroup()
                    .addGroup(frame3ContentPaneLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(label4)
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, frame3ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addGroup(frame3ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(button16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48))
            );
            frame3ContentPaneLayout.setVerticalGroup(
                frame3ContentPaneLayout.createParallelGroup()
                    .addGroup(frame3ContentPaneLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(label4)
                        .addGap(18, 18, 18)
                        .addComponent(button13)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button14)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button15)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button16)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button17)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            frame3.pack();
            frame3.setLocationRelativeTo(frame3.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JFrame frame1;
    private JLabel label2;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JFrame frame2;
    private JLabel label3;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JFrame frame3;
    private JLabel label4;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
