package com.suntoon.swing.table.action;

import com.suntoon.swing.resource.ResourceLoader;
import com.suntoon.swing.table.JSTableColumnModel;
import com.suntoon.swing.table.JSTableModel;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @Description 追加操作对象
 * @Author ylf
 * @Date 2019/9/18 0018下午 3:57
 */
public class JSTableAppendAction extends JSTableBaseAction {

    public JSTableAppendAction(JXTable table) {
        super(table);
        this.putValue(AbstractAction.NAME, "");
        this.putValue(AbstractAction.SMALL_ICON,
                new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_ADD_SMALL)));
        this.putValue(SHORT_DESCRIPTION, "追加数据");
    }

    private static final long serialVersionUID = -3068593608658058519L;

    /**
     * 追加数据
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JSTableModel<?> module = (JSTableModel<?>) this.getTable().getModel();
            boolean result = module.append();
            if (!result) {
                JOptionPane.showMessageDialog(null, "追加数据失败");
                return;
            }
            //module.setValueAt("字段" + (module.getRowCount() - 1), module.getRowCount() - 1, 1);
            int iRow = this.getTable().convertRowIndexToView(this.getTable().getRowCount() - 1);
            this.getTable().scrollRowToVisible(iRow);
            if (!module.getEditable()) {
                module.setEditable(true);
            }

            JSTableColumnModel colModel = (JSTableColumnModel) this.getTable().getColumnModel();

            this.getTable().changeSelection(iRow, 0, false, false);
            this.getTable().setEditingRow(iRow);
            this.getTable().editCellAt(iRow,
                    getTable().convertColumnIndexToView(colModel.getFirstEditColumnModelIndex()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
