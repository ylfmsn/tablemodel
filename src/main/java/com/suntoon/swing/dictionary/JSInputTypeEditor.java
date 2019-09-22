package com.suntoon.swing.dictionary;

import com.suntoon.swing.entity.InputTypeEntity;
import com.suntoon.swing.table.JSTableModel;
import com.suntoon.swing.table.editor.JSEditorDelegateAdapter;
import com.suntoon.swing.dictionary.JSInputTypeDialog.InputTypeChooserLisenter;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

/**
 * 颜色编辑器
 * 
 * @author sam
 *
 */
public class JSInputTypeEditor extends AbstractCellEditor implements TableCellEditor, TreeCellEditor {

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
	protected JSInputTypeDialog inputTypeChooser;

	InputTypeEntity inputTypeEntity = null;

	private TableModel tableModel;

	private int selectRow;



	/**
	 * 带有初始化控件对象的操作
	 *
	 * @param editor
	 */
	public JSInputTypeEditor(JButton editor) {
		this.editorComponent = editor;
	}

	/**
	 * 不带参数的默认构造函数
	 */
	public JSInputTypeEditor() {
		this(new JButton());

		delegate = new EditorDelegate();
		delegate.setClickCountToStart(2);

		editorComponent.addActionListener(delegate);

		if (inputTypeChooser == null)
			inputTypeChooser = new JSInputTypeDialog();

		this.inputTypeChooser.addInputTypeChooserLisenter(new InputTypeChooserLisenter() {
			@Override
			public void afterChoose(InputTypeEntity inputTypeEntity) {
				delegate.setValue(inputTypeEntity, selectRow);
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

		delegate.setValue(value, row);

		tableModel = table.getModel();
		selectRow = row;

		if (isSelected) {
			inputTypeEntity.setName(tableModel.getValueAt(row, column).toString());
			inputTypeEntity.setContent(tableModel.getValueAt(row, 11).toString());
			inputTypeChooser.setInputTypeEntity(inputTypeEntity);
			inputTypeChooser.setVisible(true);
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

		@Override
		public void setValue(Object value) {
			super.setValue(value);
		}

		/**
		 * 值发生改变的时候执行的操作
		 */
		public void setValue(Object value, int row) {
			if (inputTypeChooser != null)
				inputTypeEntity = inputTypeChooser.getInputTypeEntity();

			if (value instanceof String) {
				setValue(value);
			} else {
				//super.setValue(value);
				if (inputTypeEntity == null) {
					setValue(((InputTypeEntity) value).getName());
					editorComponent.setText(((InputTypeEntity) value).getName());
					tableModel.setValueAt(((InputTypeEntity) value).getContent(), row, 11);
				} else {
					setValue(inputTypeEntity.getName());
					editorComponent.setText(inputTypeEntity.getName());
					tableModel.setValueAt(inputTypeEntity.getContent(), row, 11);
				}
			}
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
			JSInputTypeEditor.this.stopCellEditing();
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
			JSInputTypeEditor.this.stopCellEditing();
		}
	}
}
