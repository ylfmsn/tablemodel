package com.suntoon.swing.dictionary;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Enumeration;

/**
 * @Description 坐标格式面板
 * @Author ylf
 */
public class JSLonLatPanel extends JPanel {

    /**
     * 单选框组
     */
    public ButtonGroup group = new ButtonGroup();

    public JLabel titleLabel = new JLabel();

    /**
     * 坐标格式面板
     */
    public JSLonLatPanel() {

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());

        titleLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        add(titleLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel(new MigLayout(
                "",
                "[]",
                "13[]13[]13[]13[]13"
        ));

        JLabel label = new JLabel("经纬度格式");
        label.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(label, "span, wrap");
        JRadioButton radioButton1 = new JRadioButton("DD°MM′SS″");
        radioButton1.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton1, "wrap");
        JRadioButton radioButton2 = new JRadioButton("DD  单位：度");
        radioButton2.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton2, "wrap");
        JRadioButton radioButton3 = new JRadioButton("DD.MMSS");
        radioButton3.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton3, "wrap");
        JRadioButton radioButton4 = new JRadioButton("DD度MM分SS秒");
        radioButton4.setFont(new Font("宋体", Font.PLAIN, 14));
        panel.add(radioButton4, "wrap");

        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public void setGroup(ButtonGroup group) {
        this.group = group;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(String title) {
        this.titleLabel.setText(title);
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
        JSLonLatPanel jsLonLatPanel = new JSLonLatPanel();
        jsLonLatPanel.getTitleLabel().setText("自动获取图形中心处WGS84坐标");
        frame.add(jsLonLatPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(750, 560);
        frame.setVisible(true);
    }
}
