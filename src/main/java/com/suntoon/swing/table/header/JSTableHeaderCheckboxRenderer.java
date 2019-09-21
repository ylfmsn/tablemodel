package com.suntoon.swing.table.header;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

/**
 * @Description 表头带有选择框的控件
 * @Author ylf
 * @Date 2019/9/18 0018上午 10:07
 */
public class JSTableHeaderCheckboxRenderer extends JCheckBox implements TableCellRenderer, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5916141000327482269L;

    /**
     * 表头带有选择框的控件
     */
    public JSTableHeaderCheckboxRenderer() {
        super();
        this.setHorizontalAlignment(JSTableHeaderCheckboxRenderer.CENTER);
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JSTableHeaderCheckboxRenderer.this.setSelected(!JSTableHeaderCheckboxRenderer.this.isSelected());
            }
        });
    }

    /**
     *
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {

        return this;
    }

}

