package com.suntoon.swing.dictionary;

import com.suntoon.swing.entity.FieldsEntity;
import lombok.Data;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/9/23 0023上午 9:52
 */
public class JSInputtypeTabDialog extends JDialog {

    private static final long serialVersionUID = -4073734321825991766L;

    /**
     * 选项卡面板
     */
    private JTabbedPane jTabbedPane;

    /**
     * 时间格式
     */
    private JSTimePanel jsTimePanel;

    /**
     * 纬度实测坐标格式
     */
    private JSLonLatPanel jsLonLatPanelLat;

    /**
     * 经度实测坐标格式
     */
    private JSLonLatPanel jsLonLatPanelLon;

    /**
     * 中心纬度坐标格式
     */
    private JSLonLatPanel jsLonLatPanelCenterLat;

    /**
     * 中心经度坐标格式
     */
    private JSLonLatPanel jsLonLatPanelCenterLon;

    /**
     * 一级列表
     */
    private OneLevelListPanel oneLevelListPanel;

    /**
     * 二级列表
     */
    private TwoLevelListPanel twoLevelListPanel;

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
    private FieldsEntity fieldsEntity;

    /**
     * 回调事件
     */
    private InputtypeTabChooserLisenter chooseListener;

    /**
     * 设置颜色选择事件
     * @param l
     */
    public void addInputTypeChooserLisenter(InputtypeTabChooserLisenter l)
    {
        chooseListener = l;
    }

    private String[] listdata = new String[] {
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
     * 输入方式设置弹出框
     */
    public JSInputtypeTabDialog() {
        super();
        initScreen();
    }

    private void initScreen() {

        setLayout(new BorderLayout());
        jTabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        JPanel jPanel0 = new JPanel(new BorderLayout());
        jPanel0.setPreferredSize(new Dimension(600, 400));
        jPanel0.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel0.setSize(600, 400);
        JTextArea jTextArea0 = new JTextArea("功能说明：手写");
        jTextArea0.setEditable(false);
        jTextArea0.setBackground(new Color(238, 238, 238));
        jTextArea0.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel0.add(jTextArea0, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[0], jPanel0);

        jsTimePanel = new JSTimePanel();
        jTabbedPane.addTab(listdata[1], jsTimePanel);

        oneLevelListPanel = new OneLevelListPanel();
        jTabbedPane.addTab(listdata[2], oneLevelListPanel);

        twoLevelListPanel = new TwoLevelListPanel();
        jTabbedPane.addTab(listdata[3], twoLevelListPanel);

        JPanel jPanel1 = new JPanel(new BorderLayout());
        jPanel1.setPreferredSize(new Dimension(600, 400));
        jPanel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel1.setSize(600, 400);
        JTextArea jTextArea1 = new JTextArea("功能说明：预览拍照");
        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(238, 238, 238));
        jTextArea1.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel1.add(jTextArea1, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[4], jPanel1);

        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setPreferredSize(new Dimension(600, 400));
        jPanel2.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel2.setSize(600, 400);
        JTextArea jTextArea2 = new JTextArea("功能说明：截屏显示");
        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new Color(238, 238, 238));
        jTextArea2.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel2.add(jTextArea2, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[5], jPanel2);

        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setPreferredSize(new Dimension(600, 400));
        jPanel3.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel3.setSize(600, 400);
        JTextArea jTextArea3 = new JTextArea("功能说明：实时测量面积");
        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new Color(238, 238, 238));
        jTextArea3.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel3.add(jTextArea3, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[6], jPanel3);

        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setPreferredSize(new Dimension(600, 400));
        jPanel4.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel4.setSize(600, 400);
        JTextArea jTextArea4 = new JTextArea("功能说明：实时测量长度");
        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new Color(238, 238, 238));
        jTextArea4.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel4.add(jTextArea4, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[7], jPanel4);

        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.setPreferredSize(new Dimension(600, 400));
        jPanel5.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel5.setSize(600, 400);
        JTextArea jTextArea5 = new JTextArea("功能说明：实时测量横坐标，横坐标的坐标系统和当前设置的坐标系统保持一致");
        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new Color(238, 238, 238));
        jTextArea5.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel5.add(jTextArea5, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[8], jPanel5);

        JPanel jPanel6 = new JPanel(new BorderLayout());
        jPanel6.setPreferredSize(new Dimension(600, 400));
        jPanel6.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel6.setSize(600, 400);
        JTextArea jTextArea6 = new JTextArea("功能说明：实时测量纵坐标，纵坐标的坐标系统和当前设置的坐标系统保持一致");
        jTextArea6.setEditable(false);
        jTextArea6.setBackground(new Color(238, 238, 238));
        jTextArea6.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel6.add(jTextArea6, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[9], jPanel6);

        jsLonLatPanelLat = new JSLonLatPanel();
        jsLonLatPanelLat.getTitleLabel().setText("实测WGS84坐标");
        jTabbedPane.addTab(listdata[10], jsLonLatPanelLat);

        jsLonLatPanelLon = new JSLonLatPanel();
        jsLonLatPanelLon.getTitleLabel().setText("实测WGS84坐标");
        jTabbedPane.addTab(listdata[11], jsLonLatPanelLon);

        JPanel jPanel7 = new JPanel(new BorderLayout());
        jPanel7.setPreferredSize(new Dimension(600, 400));
        jPanel7.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel7.setSize(600, 400);
        JTextArea jTextArea7 = new JTextArea("功能说明：获取高程值，高程是大地高");
        jTextArea7.setEditable(false);
        jTextArea7.setBackground(new Color(238, 238, 238));
        jTextArea7.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel7.add(jTextArea7, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[12], jPanel7);

        JPanel jPanel8 = new JPanel(new BorderLayout());
        jPanel8.setPreferredSize(new Dimension(600, 400));
        jPanel8.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel8.setSize(600, 400);
        JTextArea jTextArea8 = new JTextArea("功能说明：自动增加实例");
        jTextArea8.setEditable(false);
        jTextArea8.setBackground(new Color(238, 238, 238));
        jTextArea8.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel8.add(jTextArea8, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[13], jPanel8);

        JPanel jPanel9 = new JPanel(new BorderLayout());
        jPanel9.setPreferredSize(new Dimension(600, 400));
        jPanel9.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel9.setSize(600, 400);
        JTextArea jTextArea9 = new JTextArea("功能说明：自动减少实例");
        jTextArea9.setEditable(false);
        jTextArea9.setBackground(new Color(238, 238, 238));
        jTextArea9.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel9.add(jTextArea9, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[14], jPanel9);

        JPanel jPanel10 = new JPanel(new BorderLayout());
        jPanel10.setPreferredSize(new Dimension(600, 400));
        jPanel10.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel10.setSize(600, 400);
        JTextArea jTextArea10 = new JTextArea("功能说明：自动获取图形中心横坐标，所在坐标系和图层坐标系保持一致");
        jTextArea10.setEditable(false);
        jTextArea10.setBackground(new Color(238, 238, 238));
        jTextArea10.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel10.add(jTextArea10, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[15], jPanel10);

        JPanel jPanel11 = new JPanel(new BorderLayout());
        jPanel11.setPreferredSize(new Dimension(600, 400));
        jPanel11.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel11.setSize(600, 400);
        JTextArea jTextArea11 = new JTextArea("功能说明：自动获取图形中心纵坐标，所在坐标系和图层坐标系保持一致");
        jTextArea11.setEditable(false);
        jTextArea11.setBackground(new Color(238, 238, 238));
        jTextArea11.setFont(new Font("宋体", Font.PLAIN, 14));
        jPanel11.add(jTextArea11, BorderLayout.CENTER);
        jTabbedPane.addTab(listdata[16], jPanel11);

        jsLonLatPanelCenterLat = new JSLonLatPanel();
        jsLonLatPanelCenterLat.getTitleLabel().setText("自动获取图形中心处WGS84坐标");
        jTabbedPane.addTab(listdata[17], jsLonLatPanelCenterLat);

        jsLonLatPanelCenterLon = new JSLonLatPanel();
        jsLonLatPanelCenterLon.getTitleLabel().setText("自动获取图形中心处WGS84坐标");
        jTabbedPane.addTab(listdata[18], jsLonLatPanelCenterLon);

        this.add(jTabbedPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        okButton = new JButton("确定");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jTabbedPane.getSelectedIndex();

                if (chooseListener != null){

                    fieldsEntity = setInputTypeData(index);
                    // todo
                    chooseListener.afterChoose(fieldsEntity);
                }
                setVisible(false);
            }
        });

        bottomPanel.add(okButton);
        cancelButton = new JButton("取消");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooseListener != null) {
                    chooseListener.afterCancle();
                }
                setVisible(false);
            }
        });
        bottomPanel.add(cancelButton);
        this.add(bottomPanel, BorderLayout.SOUTH);

        setTitle("输入方式");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(650, 560);
        setModal(true);
    }

    /**
     * 将选中内容存储到FieldsEnttiy中
     * @param index
     * @return
     */
    private FieldsEntity setInputTypeData(int index) {

        FieldsEntity ite = new FieldsEntity();
        ite.setAttrIdCol(index);
        ite.setAttrInputTypeCol(listdata[index]);

        switch (index) {
            case 1:
                ite.setAttrTValueCol(jsTimePanel.getSelected());
            case 2:
                break;
            case 3:
                break;
            case 10:
                ite.setAttrTValueCol(jsLonLatPanelLat.getSelected());
                break;
            case 11:
                ite.setAttrTValueCol(jsLonLatPanelLon.getSelected());
                break;
            case 17:
                ite.setAttrTValueCol(jsLonLatPanelCenterLat.getSelected());
                break;
            case 18:
                ite.setAttrTValueCol(jsLonLatPanelCenterLon.getSelected());
                break;
        }
        return ite;
    }

    /**
     * 弹出后显示选中
     */
    public void setValue(FieldsEntity fieldsEntity) {
        int index = 0;
        if (fieldsEntity != null)
            index = getArrayIndex(fieldsEntity.getAttrInputTypeCol());
        jTabbedPane.setSelectedIndex(index);
    }

    /**
     * 根据数组内容获取索引号
     * @param arr
     * @return
     */
    private int getArrayIndex(String arr) {
        for (int i = 0; i < listdata.length; i++) {
            if (arr.equals(listdata[i])) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        JSInputtypeTabDialog dialog = new JSInputtypeTabDialog();
        dialog.setTitle("输入方式");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setSize(610, 560);
        dialog.setVisible(true);
    }


    /**
     * 设置数据的操作
     * @author sam
     *
     */
    public interface InputtypeTabChooserLisenter extends EventListener
    {
        /**
         * 点击确定的按钮执行的操作
         * @param fieldsEntity
         */
        public void afterChoose(FieldsEntity fieldsEntity);

        /**
         * 取消的操作
         */
        public default void afterCancle() {};
    }

    public JSTimePanel getJsTimePanel() {
        return jsTimePanel;
    }

    public void setJsTimePanel(JSTimePanel jsTimePanel) {
        this.jsTimePanel = jsTimePanel;
    }

    public JSLonLatPanel getJsLonLatPanelLat() {
        return jsLonLatPanelLat;
    }

    public void setJsLonLatPanelLat(JSLonLatPanel jsLonLatPanelLat) {
        this.jsLonLatPanelLat = jsLonLatPanelLat;
    }

    public JSLonLatPanel getJsLonLatPanelLon() {
        return jsLonLatPanelLon;
    }

    public void setJsLonLatPanelLon(JSLonLatPanel jsLonLatPanelLon) {
        this.jsLonLatPanelLon = jsLonLatPanelLon;
    }

    public JSLonLatPanel getJsLonLatPanelCenterLat() {
        return jsLonLatPanelCenterLat;
    }

    public void setJsLonLatPanelCenterLat(JSLonLatPanel jsLonLatPanelCenterLat) {
        this.jsLonLatPanelCenterLat = jsLonLatPanelCenterLat;
    }

    public JSLonLatPanel getJsLonLatPanelCenterLon() {
        return jsLonLatPanelCenterLon;
    }

    public void setJsLonLatPanelCenterLon(JSLonLatPanel jsLonLatPanelCenterLon) {
        this.jsLonLatPanelCenterLon = jsLonLatPanelCenterLon;
    }

    public OneLevelListPanel getOneLevelListPanel() {
        return oneLevelListPanel;
    }

    public void setOneLevelListPanel(OneLevelListPanel oneLevelListPanel) {
        this.oneLevelListPanel = oneLevelListPanel;
    }

    public TwoLevelListPanel getTwoLevelListPanel() {
        return twoLevelListPanel;
    }

    public void setTwoLevelListPanel(TwoLevelListPanel twoLevelListPanel) {
        this.twoLevelListPanel = twoLevelListPanel;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public FieldsEntity getFieldsEntity() {
        return fieldsEntity;
    }

    public void setFieldsEntity(FieldsEntity fieldsEntity) {
        this.fieldsEntity = fieldsEntity;
    }

    public String[] getListdata() {
        return listdata;
    }

    public void setListdata(String[] listdata) {
        this.listdata = listdata;
    }
}
