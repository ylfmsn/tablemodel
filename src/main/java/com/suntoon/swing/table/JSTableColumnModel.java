package com.suntoon.swing.table;

import org.jdesktop.swingx.table.DefaultTableColumnModelExt;

import javax.swing.table.TableColumn;
import java.util.List;

/**
 * 扩展的TableColumnModel
 */
public class JSTableColumnModel extends DefaultTableColumnModelExt {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3443304855739066731L;
	
	/**
	 * 获取第一个可编辑列
	 * @return
	 */
	public int getFirstEditColumnModelIndex(){
		List<TableColumn> columns = this.getColumns(true);
		if (columns == null || columns.isEmpty())
			return -1;
		
		for(TableColumn coloumn : columns){
			JSTableColumn col = (JSTableColumn)coloumn;
			if (col.isEditable())
				return coloumn.getModelIndex();
		}
		
		return -1;
	}
}
