package com.suntoon.swing.dictionary;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/9/20 0020上午 10:49
 */
public class TwoLevelListPanel extends JPanel {

    public JPanel leftPanel = new JPanel(new MigLayout("", "[]3[]", "[]5[]5[]"));

    public JPanel rightPanel = new JPanel(new MigLayout("", "[]3[]3[]3", "[]5[]5[]"));



    public TwoLevelListPanel() {

        setLayout(new BorderLayout());
        init();



    }

    private void init() {

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        add(new JLabel("调查字段的列表项，在填写时可以通过下拉选项"), BorderLayout.NORTH);

        JButton button1 = new JButton("导入TXT文件");
        button1.setFont(new Font("宋体", Font.BOLD, 10));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        leftPanel.add(button1, "w 100!");

        JButton button2 = new JButton("导入CSV文件");
        button2.setFont(new Font("宋体", Font.BOLD, 10));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        leftPanel.add(button2, "w 100!, wrap");

        JScrollPane panel = new JScrollPane();
        panel.setBackground(new Color(255, 0, 0));
        leftPanel.add(panel, "span, h 370!, w 200!, wrap");

        JButton button3= new JButton("删除");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        leftPanel.add(button3, "wrap");

        JButton button4 = new JButton("导入TXT文件");
        button4.setFont(new Font("宋体", Font.BOLD, 10));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rightPanel.add(button4, "w 100!");

        JButton button5 = new JButton("导入CSV文件");
        button5.setFont(new Font("宋体", Font.BOLD, 10));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rightPanel.add(button5, "w 100!");

        JButton button6 = new JButton("打开示例TXT文件");
        button6.setFont(new Font("宋体", Font.BOLD, 10));
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rightPanel.add(button6, "w 120!, wrap");

        JScrollPane panel1 = new JScrollPane();
        panel1.setBackground(new Color(255, 0, 0));
        rightPanel.add(panel1, "span, h 370!, w 320!, wrap");

        JButton button7= new JButton("删除");
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rightPanel.add(button7, "wrap");

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("输入方式");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TwoLevelListPanel(), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(750, 560);
        frame.setVisible(true);
    }
}
