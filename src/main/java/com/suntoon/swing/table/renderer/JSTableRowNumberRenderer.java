package com.suntoon.swing.table.renderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * @Description 行号渲染器
 * @Author ylf
 * @Date 2019/9/18 0018下午 1:57
 */
public class JSTableRowNumberRenderer extends DefaultTableCellRenderer {

    /**
     *
     */
    private static final long serialVersionUID = -7120562179856374728L;

    /**
     * 行号渲染器
     * 默认居中
     */
    public JSTableRowNumberRenderer() {
        super();
        this.setHorizontalAlignment(JSTableRowNumberRenderer.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        this.setText(String.valueOf(row + 1));
        return this;
    }
}
