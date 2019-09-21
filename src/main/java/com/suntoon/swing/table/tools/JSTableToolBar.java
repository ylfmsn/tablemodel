package com.suntoon.swing.table.tools;

import com.suntoon.swing.JSFindBar;
import com.suntoon.swing.JSPanelToolBar;
import com.suntoon.swing.table.JSTable;
import com.suntoon.swing.table.action.*;

import javax.swing.*;

/**
 * @Description 给JSTable增加的工具条
 * @Author ylf
 * @Date 2019/9/18 0018下午 3:45
 */
public class JSTableToolBar extends JSPanelToolBar {

    private static final long serialVersionUID = -5793491647918673440L;

    /**
     * 当前操作的table
     */
    private JSTable table;

    /**
     * 当前操作的table
     *
     * @return
     */
    public JSTable getTable() {
        return table;
    }

    /**
     * 当前操作的table
     *
     * @param table
     */
    public void setTable(JSTable table) {
        this.table = table;
    }

    /**
     * 构造函数
     *
     * @param table
     * @param tableModel
     */
    public JSTableToolBar(JSTable table) {
        this.setTable(table);
    }

    /**
     * 刷新
     *
     * @param retrieve
     */
    public void enableRetrieve() {
        this.addAction(new JSTableRetrieveAction(table));
    }

    /**
     * 全选，不全选 默认操作第一列 select：Integer.Valueof(1) unSelect：Integer.Valueof(0)
     *
     */
    public void enableSelect() {
        this.addAction(new JSTableSelectAction(table));
        this.addAction(new JSTableUnSelectAction(table));
        this.addAction(new JSTableInvertSelectAction(table));
    }

    /**
     * 全选，不全选 select：Integer.Valueof(1) unSelect：Integer.Valueof(0)
     *
     * @param editColIndex
     *            操作列索引
     */
    public void enableSelect(int editColIndex) {
        JSTableSelectAction selectAction = new JSTableSelectAction(table);
        selectAction.setEditColIndex(editColIndex);
        this.addAction(selectAction);

        JSTableUnSelectAction unSelectAction = new JSTableUnSelectAction(table);
        unSelectAction.setEditColIndex(editColIndex);
        this.addAction(unSelectAction);

        JSTableInvertSelectAction invertSelectAction = new JSTableInvertSelectAction(table);
        invertSelectAction.setEditColIndex(editColIndex);
        this.addAction(invertSelectAction);
    }

    /**
     * 全选，不全选
     *
     * @param editColIndex
     *            操作列索引
     * @param selectValue
     *            选中值
     * @param unselectValue
     *            非选中值
     */
    public void enableSelect(int editColIndex, Object selectValue, Object unselectValue) {
        JSTableSelectAction selectAction = new JSTableSelectAction(table);
        selectAction.setEditColIndex(editColIndex);
        selectAction.setSelectedValue(selectValue);
        this.addAction(selectAction);

        JSTableUnSelectAction unSelectAction = new JSTableUnSelectAction(table);
        unSelectAction.setEditColIndex(editColIndex);
        unSelectAction.setUnSelectedValue(unselectValue);
        this.addAction(unSelectAction);

        JSTableInvertSelectAction invertSelectAction = new JSTableInvertSelectAction(table);
        invertSelectAction.setEditColIndex(editColIndex);
        invertSelectAction.setSelectedValue(selectValue);
        invertSelectAction.setUnSelectedValue(unselectValue);
        this.addAction(invertSelectAction);
    }

    /**
     * 导入操作
     *
     * @param fileImporListener
     *            回调接口
     */
    public void enableImp(JSFileImportActionListener fileImporListener) {
        JSTableImportAction importAction = new JSTableImportAction(table);
        importAction.addFileImportActionListener(fileImporListener);
        this.addAction(importAction);
    }

    /**
     * 编辑
     *
     * @param edit
     */
    public void enableEdit() {
        this.addAction(new JSTableEditAction(table));
    }

    /**
     * 新增
     *
     */
    public void enableAdd() {
        this.addAction(new JSTableAppendAction(table));
    }

    /**
     * 删除
     *
     * @param del
     */
    public void enableDel() {
        this.addAction(new JSTableDeleteAction(table));
    }

    /**
     * 保存
     *
     * @param save
     */
    public void enableSave() {
        this.addAction(new JSTableSaveAction(table));
    }

    /**
     * 另存
     *
     * @param saveas
     */
    public void enableSaveAs() {
        this.addAction(new JSTableSaveAsAction(table));
    }

    /**
     * 搜索
     *
     * @param search
     */
    public void enableSearch() {
        this.add(buildSearchBar());
    }

    /**
     * 使用jxtable自带的searchbar
     *
     * @return
     */
    public JComponent buildSearchBar() {
        JSFindBar searchBar = new JSFindBar(table.getSearchable(), table.getModel(), table.getColumnModel());
        return searchBar;
    }
}
