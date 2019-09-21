package com.suntoon.swing;

import javax.swing.*;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/9/18 0018上午 9:58
 */
public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrameDefaultTableDemo frm = new JFrameDefaultTableDemo();
        frm.setSize(1024 , 768);
        frm.setLocationRelativeTo(null); //在屏幕上居中
        frm.setVisible(true);
    }
}
