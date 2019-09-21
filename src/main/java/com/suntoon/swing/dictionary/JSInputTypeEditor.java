package com.suntoon.swing.dictionary;

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
				delegate.setValue(inputTypeEntity);
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
			System.out.println(editorComponent.getText());
			if (table.getCellEditor(row, table.getColumnCount() - 1).getCellEditorValue() != null)
				System.out.println(table.getCellEditor(row, table.getColumnCount() - 1).getCellEditorValue().toString());
			//editorComponent.setText(value.toString());
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

		/**
		 * 值发生改变的时候执行的操作
		 */
		public void setValue(Object value) {
			if (inputTypeChooser != null)
				inputTypeEntity = inputTypeChooser.getInputTypeEntity();

			//super.setValue(value);
			if (inputTypeEntity == null) {
				super.setValue(value.toString());
				editorComponent.setText(value.toString());
			} else{
				super.setValue(inputTypeEntity.getName());
				editorComponent.setText(inputTypeEntity.getName());
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
