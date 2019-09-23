package com.suntoon.swing.dictionary;

import com.suntoon.swing.entity.FieldsEntity;
import com.suntoon.swing.table.JSTableModel;
import com.suntoon.swing.table.editor.JSEditorDelegateAdapter;
import com.suntoon.swing.dictionary.JSInputtypeTabDialog.InputtypeTabChooserLisenter;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
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
	protected JSInputtypeTabDialog inputTypeChooser;

	private FieldsEntity fieldsEntity;

	private JSTableModel tableModel;

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
			inputTypeChooser = new JSInputtypeTabDialog();

		this.inputTypeChooser.addInputTypeChooserLisenter(new InputtypeTabChooserLisenter() {
			@Override
			public void afterChoose(FieldsEntity fieldsEntity) {
				delegate.setValue(fieldsEntity, selectRow);
			}

			@Override
			public void afterCancle() {
				editorComponent.validate();
				editorComponent.repaint();
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

		tableModel = (JSTableModel) table.getModel();
		selectRow = row;

		if (isSelected) {
			FieldsEntity fe = new FieldsEntity();
			fe.setAttrInputTypeCol(editorComponent.getText());
			if (tableModel.getValueAt(row, 11) == null)
				fe.setAttrTValueCol("");
			else
				fe.setAttrTValueCol(tableModel.getValueAt(row, 11).toString());
			inputTypeChooser.setValue(fe);
			inputTypeChooser.setVisible(true);
		}

		return editorComponent;
	}

	private int getArrayIndex(String arr) {

		for (int i = 0; i < inputTypeChooser.getListdata().length; i++) {
			if (arr.equals(inputTypeChooser.getListdata()[i])) {
				return i;
			}
		}

		return 0;
	}

	/**
	 * 实现的内部方法
	 *
	 */
	protected class EditorDelegate extends JSEditorDelegateAdapter {

		private static final long serialVersionUID = -9163652875049976071L;

		@Override
		public void setValue(Object value) {
			super.setValue(value);
		}

		/**
		 * 值发生改变的时候执行的操作，第一次点击是value为初始显示值：手动
		 */
		public void setValue(Object value, int row) {

			if (inputTypeChooser != null)
				fieldsEntity = inputTypeChooser.getFieldsEntity();

			if (value instanceof String) {
				setValue(value);
				editorComponent.setText(value.toString());
			} else {
				if (fieldsEntity == null) {
					setValue(((FieldsEntity) value).getAttrInputTypeCol());
					editorComponent.setText(((FieldsEntity) value).getAttrInputTypeCol());
				} else {
					setValue(fieldsEntity.getAttrInputTypeCol());
					editorComponent.setText(fieldsEntity.getAttrInputTypeCol());

					if (fieldsEntity.getAttrTValueCol() == null)
						tableModel.setValueAt("", row, 11);
					else
						tableModel.setValueAt(fieldsEntity.getAttrTValueCol(), row, 11);
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

	public FieldsEntity getFieldsEntity() {
		return fieldsEntity;
	}

	public void setFieldsEntity(FieldsEntity fieldsEntity) {
		this.fieldsEntity = fieldsEntity;
	}
}
