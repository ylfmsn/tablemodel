package com.suntoon.swing.test;

import com.suntoon.swing.table.editor.JSEditorDelegateAdapter;
import com.suntoon.swing.test.JSColorChooserDialog.ColorChooserLisenter;

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
public class JSTableColorEditor extends AbstractCellEditor implements TableCellEditor, TreeCellEditor {

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
	protected JSColorChooserDialog colorChooser;

	/**
	 * 带有初始化控件对象的操作
	 * 
	 * @param editor
	 */
	public JSTableColorEditor(JButton editor) {
		this.editorComponent = editor;
	}

	/**
	 * 不带参数的默认构造函数
	 */
	public JSTableColorEditor() {
		this(new JButton());

		delegate = new EditorDelegate();
		delegate.setClickCountToStart(2);

		editorComponent.addActionListener(delegate);

		if (colorChooser == null)
			colorChooser = new JSColorChooserDialog();

		this.colorChooser.addColorChooserLisenter(new ColorChooserLisenter() {
			@Override
			public void afterChoose(Color color) {
				delegate.setValue(color);
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
			//JSButtonIcon icon = (JSButtonIcon) editorComponent.getIcon();
			System.out.println(editorComponent.getText());
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

			//JSButtonIcon icon = (JSButtonIcon) editorComponent.getIcon();
			int green = ((Color) value).getGreen();
			editorComponent.setText(String.valueOf(green));
			/*try {

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
			JSTableColorEditor.this.stopCellEditing();
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
			JSTableColorEditor.this.stopCellEditing();
		}
	}
}
