package com.suntoon.swing.dictionary;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.Serializable;

/**
 * 颜色显示列
 * 
 * @author sam
 *
 */
public class JSInputTypeRenderer extends JButton implements TableCellRenderer, Serializable {

	private static final long serialVersionUID = -2271791531155280948L;

	/**
	 * 构造函数
	 */
	public JSInputTypeRenderer()
	{
		super();
	}

	/**
	 * 重写的对象绘制方法
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		if (isSelected) {
			this.setBackground(table.getSelectionBackground());
		} else {
			this.setBackground(table.getBackground());
		}
		
		try
		{
			this.setText(value.toString());
		}
		catch(Exception ex)
		{
			this.setText("手动");
		}

		return this;
	}
}
