package com.suntoon.swing.table.action;

import com.suntoon.swing.resource.ResourceLoader;
import com.suntoon.swing.table.JSTableModel;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @Description 保存操作
 * @Author ylf
 */
public class JSTableSaveAction extends JSTableBaseAction {

    private static final long serialVersionUID = 2834589546104965124L;

    /**
     * 保存操作
     * @param table
     */
    public JSTableSaveAction(JXTable table) {
        super(table);
        this.putValue(AbstractAction.NAME, "");
        this.putValue(AbstractAction.SMALL_ICON,
                new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_SAVE)));
        this.putValue(SHORT_DESCRIPTION, "保存修改数据");
    }

    /**
     * 保存操作
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            JSTableModel<?> module = (JSTableModel<?>) this.getTable().getModel();

            if (module.update()) {
                JOptionPane.showMessageDialog(null, "保存成功");
            } else {
                JOptionPane.showMessageDialog(null, "保存失败");
            }

            module.setEditable(false);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

