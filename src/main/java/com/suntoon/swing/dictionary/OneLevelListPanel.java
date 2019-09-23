package com.suntoon.swing.dictionary;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/9/20 0020上午 10:49
 */
public class OneLevelListPanel extends JPanel {


    public OneLevelListPanel() {

        setLayout(new MigLayout(
                "",
                "[]3[]3[]3[]3[]",
                "5[]5[]5[]5[]5"
        ));

        JLabel label = new JLabel("调查字段的列表项，在填写时可以通过下拉选项");
        label.setFont(new Font("宋体", Font.PLAIN, 14));
        add(label, "span, wrap");

        JButton button1 = new JButton("导入TXT文件");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(button1, "w 140!");

        JButton button2 = new JButton("导入CSV文件");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(button2, "w 140!");

        JButton button3 = new JButton("打开示例TXT文件");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(button3, "w 140!, wrap");

        JScrollPane panel = new JScrollPane();
        panel.setBackground(new Color(255, 0, 0));
        add(panel, "span, h 370!, w 470!, wrap");

        JButton button4 = new JButton("删除");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(button4, "wrap");
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("输入方式");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new OneLevelListPanel(), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(750, 560);
        frame.setVisible(true);
    }













}
