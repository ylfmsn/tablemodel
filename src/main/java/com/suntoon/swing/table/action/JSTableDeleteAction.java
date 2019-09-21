package com.suntoon.swing.table.action;

import com.suntoon.swing.resource.ResourceLoader;
import com.suntoon.swing.table.JSTableModel;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @Description 删除操作对象
 * @Author ylf
 * @Date 2019/9/18 0018下午 3:57
 */
public class JSTableDeleteAction extends JSTableBaseAction {

    public JSTableDeleteAction(JXTable table) {
        super(table);
        this.putValue(AbstractAction.NAME, "");
        this.putValue(AbstractAction.SMALL_ICON,
                new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_DELETE)));
        this.putValue(SHORT_DESCRIPTION, "删除选中数据");
    }

    private static final long serialVersionUID = -3068593608658058519L;

    /**
     * 删除操作
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int selectedRowCount = this.getTable().getSelectedRowCount();
            if (selectedRowCount <= 0) {
                JOptionPane.showMessageDialog(null, "请选择您要删除的数据行");
                return;
            } else if (selectedRowCount == 1) {
                int iRow = this.getTable().getSelectedRow();
                ((JSTableModel<?>) this.getTable().getModel()).delete(this.getTable().convertRowIndexToModel(iRow));
            } else {
                // > 1的情况
                int confim = JOptionPane.showConfirmDialog(null, "您将删除【" + selectedRowCount + "】行数据，是否删除?");
                if (confim == JOptionPane.OK_OPTION) {
                    int[] selectedRows = this.getTable().getSelectedRows();
                    for (int i = selectedRowCount - 1; i >= 0; i--) {
                        JSTableModel<?> model = (JSTableModel<?>) this.getTable().getModel();
                        model.delete(this.getTable().convertRowIndexToModel(selectedRows[i]));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

