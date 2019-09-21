package com.suntoon.swing.dictionary;

import com.suntoon.swing.JSButtonIcon;
import com.suntoon.swing.entity.InputTypeEntity;
import com.suntoon.swing.table.editor.JSEditorDelegateAdapter;
import com.suntoon.swing.dictionary.JSInputTypeDialog.InputTypeChooserLisenter;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

/**
 * @Description 颜色编辑器
 * @Author ylf
 * @Date 2019/9/18 0018下午 3:04
 */
public class JSTableButtonEditor extends AbstractCellEditor implements TableCellEditor, TreeCellEditor {

    private static final long serialVersionUID = -1287059888797387629L;

    /**
     * 操作代理对象
     */
    private EditorDelegate delegate;

    /**
     * 当前的编辑控件
     */
    protected JButton editorComponent;

    /**
     * colorchoose对象
     */
    protected JSInputTypeDialog colorChooser;

    /**
     * 带有初始化控件对象的操作
     *
     * @param editor
     */
    public JSTableButtonEditor(JButton editor) {
        this.editorComponent = editor;
    }

    /**
     * 不带参数的默认构造函数
     */
    public JSTableButtonEditor() {
        this(new JButton(new JSButtonIcon()));

        delegate = new EditorDelegate();
        delegate.setClickCountToStart(2);

        editorComponent.addActionListener(delegate);

        if (colorChooser == null)
            colorChooser = new JSInputTypeDialog();

        this.colorChooser.addInputTypeChooserLisenter(new InputTypeChooserLisenter() {
            @Override
            public void afterChoose(InputTypeEntity inputTypeEntity) {
                //delegate.setValue(inputTypeEntity.getName());
                editorComponent.setText(inputTypeEntity.getName());
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getCellEditorValue() {
        // TODO Auto-generated method stub
        return delegate.getCellEditorValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
                                                boolean leaf, int row) {

        String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row, false);

        delegate.setValue(stringValue);
        return editorComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        delegate.setValue(value);

        if (isSelected) {
            JSButtonIcon icon = (JSButtonIcon) editorComponent.getIcon();
            //colorChooser.setColor(icon.getIconColor());
            colorChooser.setVisible(true);
        }

        return editorComponent;
    }

    /**
     * 实现的内部方法
     *
     * @author sam
     *
     */
    protected class EditorDelegate extends JSEditorDelegateAdapter {

        private static final long serialVersionUID = -9163652875049976071L;

        /**
         * 值发生改变的时候执行的操作
         */
        public void setValue(Object value) {

            super.setValue(value);
            editorComponent.setText(value.toString());

            /*JSButtonIcon icon = (JSButtonIcon) editorComponent.getIcon();
            try {

                if (value == null) {
                    icon.setIconColor(Color.BLACK);
                    return;
                }

                if (value instanceof Integer) {
                    icon.setIconColor(new Color((Integer) value));
                } else if (value instanceof Long) {
                    icon.setIconColor(new Color(((Long) value).intValue()));
                } else if (value instanceof String) {
                    icon.setIconColor(Color.getColor(value.toString()));
                } else if (value instanceof Color) {
                    icon.setIconColor((Color) value);
                }
            } catch (Exception ex) {
                icon.setIconColor(Color.BLACK);
            }*/

        }

        /**
         * Stops editing and returns true to indicate that editing has stopped.
         * This method calls <code>fireEditingStopped</code>.
         *
         * @return true
         */
        public boolean stopCellEditing() {
            fireEditingStopped();
            return true;
        }

        /**
         * Cancels editing. This method calls <code>fireEditingCanceled</code>.
         */
        @Override
        public void cancelCellEditing() {
            fireEditingCanceled();
        }

        /**
         * When an action is performed, editing is ended.
         *
         * @param e
         *            the action event
         * @see #stopCellEditing
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JSTableButtonEditor.this.stopCellEditing();
        }

        /**
         * When an item's state changes, editing is ended.
         *
         * @param e
         *            the action event
         * @see #stopCellEditing
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            JSTableButtonEditor.this.stopCellEditing();
        }
    }
}

