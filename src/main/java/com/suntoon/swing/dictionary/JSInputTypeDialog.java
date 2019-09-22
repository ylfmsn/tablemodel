package com.suntoon.swing.dictionary;

import com.suntoon.swing.entity.InputTypeEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.EventListener;

/**
 * @Description 输入方式弹出框
 * @Author ylf
 */
public class JSInputTypeDialog extends JDialog {

    private static final long serialVersionUID = -4073734321825991766L;

    /**
     * 左侧列表
     */
    public JList jList = null;

    /**
     * 左侧展现列表的面板
     */
    public JPanel leftPanel = null;

    /**
     * 右侧联动右侧列表的展示面板
     */
    public JPanel rightPanel = null;

    /**
     * 确认按钮
     */
    private JButton okButton;

    /**
     * 取消按钮
     */
    private JButton cancelButton;

    /**
     * 选中的类型值
     */
    private InputTypeEntity inputTypeEntity;

    /**
     * 回调事件
     */
    private InputTypeChooserLisenter chooseListener;

    /**
     * 设置颜色选择事件
     * @param l
     */
    public void addInputTypeChooserLisenter(InputTypeChooserLisenter l)
    {
        chooseListener = l;
    }

    /**
     * 移除listener
     */
    public void removeInputTypeChooserLisenter()
    {
        chooseListener = null;
    }


    JTextArea jTextArea = null;

    JSTimePanel jsTimePanel = null;

    JSLonLatPanel jsLonLatPanel = null;

    OneLevelListPanel oneLevelListPanel = null;

    TwoLevelListPanel twoLevelListPanel = null;

    private static String[] listdata = new String[] {
            "手写",
            "时间实测",
            "一级列表",
            "二级列表",
            "拍照",
            "截屏",
            "面积实测",
            "长度实测",
            "横坐标实测",
            "纵坐标实测",
            "纬度实测",
            "经度实测",
            "高程实测",
            "自动增加",
            "自动减少",
            "中心横坐标",
            "中心纵坐标",
            "中心经度",
            "中心纬度"
    };

    /**
     * 输入方式设置对话框
     */
    public JSInputTypeDialog() {
        super();
        initScreen();
    }

    /**
     * 带有参数的构造函数
     * @param inputTypeEntity
     */
    public JSInputTypeDialog(InputTypeEntity inputTypeEntity)
    {
        this();
        this.setInputTypeEntity(inputTypeEntity);
    }

    private void initScreen() {
        setLayout(new BorderLayout());
        jList = new JList(listdata);
        jList.setFont(new Font("宋体", Font.PLAIN, 14));
        jList.setSelectedIndex(0);
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        okButton = new JButton("确定");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jList.getSelectedIndex();

                if (chooseListener != null){

                    InputTypeEntity ite1 = setInputTypeData(index);


                    // todo
                    chooseListener.afterChoose(ite1);
                }
                setVisible(false);
            }
        });

        bottomPanel.add(okButton);
        cancelButton = new JButton("取消");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooseListener != null){
                    chooseListener.afterCancle();
                }
                setVisible(false);
            }
        });
        bottomPanel.add(cancelButton);

        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(200, 400));
        leftPanel.setSize(200, 400);
        leftPanel.add(new JScrollPane(jList), BorderLayout.CENTER);
        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int index = jList.getSelectedIndex();
                    Object obj = jList.getModel().getElementAt(index);

                    switch (index) {
                        case 0 :
                            showTextAreaPanel("功能说明：" + obj.toString());
                            break;
                        case 1 :
                            showTimePanel();
                            break;
                        case 2 :
                            showOneListPanel();
                            break;
                        case 3 :
                            showTwoListPanel();
                            break;
                        case 4 :
                            showTextAreaPanel("功能说明：拍照预览");
                            break;
                        case 5 :
                            showTextAreaPanel("功能说明：截屏显示");
                            break;
                        case 6 :
                            showTextAreaPanel("功能说明：实时测量面积");
                            break;
                        case 7 :
                            showTextAreaPanel("功能说明：实时测量长度");
                            break;
                        case 8 :
                            showTextAreaPanel("功能说明：实时测量横坐标，横坐标的坐标系统和当前设置的坐标系统保持一致");
                            break;
                        case 9 :
                            showTextAreaPanel("功能说明：实时测量纵坐标，纵坐标的坐标系统和当前设置的坐标系统保持一致");
                            break;
                        case 10 :
                            showLonlatPanel(index);
                            break;
                        case 11 :
                            showLonlatPanel(index);
                            break;
                        case 12 :
                            showTextAreaPanel("功能说明：获取高程值，高程是大地高");
                            break;
                        case 13 :
                            showTextAreaPanel("功能说明：自动增加实例");
                            break;
                        case 14 :
                            showTextAreaPanel("功能说明：自动减少实例");
                            break;
                        case 15 :
                            showTextAreaPanel("功能说明：自动获取图形中心横坐标，所在的坐标系和图层坐标系保持一致");
                            break;
                        case 16 :
                            showTextAreaPanel("功能说明：自动获取图形中心纵坐标，所在的坐标系和图层坐标系保持一致");
                            break;
                        case 17 :
                            showLonlatPanel(index);
                            break;
                        case 18 :
                            showLonlatPanel(index);
                            break;
                    }
                }
            }
        });

        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(600, 400));
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        rightPanel.setSize(600, 400);
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setBackground(new Color(238, 238, 238));
        jTextArea.setFont(new Font("宋体", Font.PLAIN, 14));
        rightPanel.add(jTextArea, BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        System.out.println(getInputTypeEntity());

        setTitle("输入方式");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(810, 560);
        setModal(true);
    }

    private InputTypeEntity setInputTypeData(int index) {

        InputTypeEntity ite = new InputTypeEntity();
        ite.setIndex(index);
        ite.setName(listdata[index]);

        switch (index) {
            case 1:
                ite.setContent(jsTimePanel.getSelected());
            case 2:
                break;
            case 3:
                break;
            case 10:
                ite.setContent(jsLonLatPanel.getSelected());
                break;
            case 11:
                ite.setContent(jsLonLatPanel.getSelected());
                break;
            case 17:
                ite.setContent(jsLonLatPanel.getSelected());
                break;
            case 18:
                ite.setContent(jsLonLatPanel.getSelected());
                break;
        }
        return ite;
    }

    /**
     * 设置数据的操作
     * @author sam
     *
     */
    public interface InputTypeChooserLisenter extends EventListener
    {
        /**
         * 点击确定的按钮执行的操作
         * @param inputTypeEntity
         */
        public void afterChoose(InputTypeEntity inputTypeEntity);

        /**
         * 取消的操作
         */
        public default void afterCancle() {};
    }

    /**
     * 显示时间格式面板
     */
    private void showTimePanel() {
        rightPanel.removeAll();
        jsTimePanel = new JSTimePanel();
        rightPanel.add(jsTimePanel, BorderLayout.CENTER);
        rightPanel.validate();
        rightPanel.repaint();
    }

    /**
     * 显示一级列表面板
     */
    private void showOneListPanel() {
        rightPanel.removeAll();
        oneLevelListPanel = new OneLevelListPanel();
        rightPanel.add(oneLevelListPanel, BorderLayout.CENTER);
        rightPanel.validate();
        rightPanel.repaint();
    }

    /**
     * 显示二级列表面板
     */
    private void showTwoListPanel() {
        rightPanel.removeAll();
        twoLevelListPanel = new TwoLevelListPanel();
        rightPanel.add(twoLevelListPanel, BorderLayout.CENTER);
        rightPanel.validate();
        rightPanel.repaint();
    }

    /**
     * 显示经纬度格式面板
     * @param index
     */
    private void showLonlatPanel(int index) {

        rightPanel.removeAll();
        jsLonLatPanel = new JSLonLatPanel();
        if (index == 10 || index == 11) {
            jsLonLatPanel.getTitleLabel().setText("实测WGS84坐标");
        } else if (index == 17 || index == 18) {
            jsLonLatPanel.getTitleLabel().setText("自动获取图形中心处WGS84坐标");
        }
        rightPanel.add(jsLonLatPanel, BorderLayout.CENTER);
        rightPanel.validate();
        rightPanel.repaint();
    }

    /**
     * 切换到文本区域
     * @param content
     */
    private void showTextAreaPanel(String content) {
        rightPanel.removeAll();
        jTextArea.setText(content);
        rightPanel.add(jTextArea, BorderLayout.CENTER);
        rightPanel.validate();
        rightPanel.repaint();
    }

    public InputTypeEntity getInputTypeEntity() {
        return inputTypeEntity;
    }

    public void setInputTypeEntity(InputTypeEntity inputTypeEntity) {
        this.inputTypeEntity = inputTypeEntity;
    }

    public static void main(String[] args) {
        JSInputTypeDialog dialog = new JSInputTypeDialog();
        dialog.setTitle("输入方式");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setSize(810, 560);
        dialog.setVisible(true);
    }
}
