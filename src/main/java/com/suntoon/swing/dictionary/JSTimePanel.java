package com.suntoon.swing.dictionary;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Enumeration;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/9/19 0019下午 2:36
 */
public class JSTimePanel extends JPanel {

    public ButtonGroup group = new ButtonGroup();

    public JSTimePanel() {

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        JLabel label = new JLabel("图形闭合，自动填写时间");
        label.setFont(new Font("宋体", Font.PLAIN, 15));
        add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel(new MigLayout(
                "",
                "[]10[]",
                "13[]13[]13[]13[]13[]13[]13"
        ));

        JLabel timeLabel = new JLabel("时间格式");
        timeLabel.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(timeLabel, "span, wrap");
        JRadioButton radioButton1 = new JRadioButton("YYYY年MM月DD日");
        radioButton1.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton("YYYY年MM月DD日 hh时mm分ss秒");
        radioButton2.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton2, "wrap");
        JRadioButton radioButton3 = new JRadioButton("YYYY-MM-DD");
        radioButton3.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton3);
        JRadioButton radioButton4 = new JRadioButton("YYYY-MM-DD hh:mm:ss");
        radioButton4.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton4, "wrap");
        JRadioButton radioButton5 = new JRadioButton("YYYY.MM.DD");
        radioButton5.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton5);
        JRadioButton radioButton6 = new JRadioButton("YYYYMMDDhhmmss");
        radioButton6.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton6, "wrap");
        JRadioButton radioButton7 = new JRadioButton("YYYYMMDD");
        radioButton7.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton7);
        JRadioButton radioButton8 = new JRadioButton("hh:mm:ss");
        radioButton8.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton8, "wrap");
        JRadioButton radioButton9 = new JRadioButton("YYYYMMDD");
        radioButton9.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton9);
        JRadioButton radioButton10 = new JRadioButton("hh时mm分ss秒");
        radioButton10.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton10, "wrap");

        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);
        group.add(radioButton5);
        group.add(radioButton6);
        group.add(radioButton7);
        group.add(radioButton8);
        group.add(radioButton9);
        group.add(radioButton10);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public void setGroup(ButtonGroup group) {
        this.group = group;
    }

    /**
     * 获取选中项
     * @return
     */
    public String getSelected() {
        String result = null;
        Enumeration<AbstractButton> radioBtns = group.getElements();
        while (radioBtns.hasMoreElements()) {
            AbstractButton btn = radioBtns.nextElement();
            if(btn.isSelected()){
                result=btn.getText();
                break;
            }
        }

        return result;
    }

    /**
     * 设置选中想
     * @param result
     */
    public void setSelected(String result) {
        Enumeration<AbstractButton> radioBtns = group.getElements();
        while (radioBtns.hasMoreElements()) {
            AbstractButton btn = radioBtns.nextElement();
            if(btn.getText().equals(result)){
                btn.setSelected(true);
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("输入方式");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JSTimePanel(), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(750, 560);
        frame.setVisible(true);
    }
}
