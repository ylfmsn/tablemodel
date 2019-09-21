package com.suntoon.swing.table.action;

import org.jdesktop.swingx.JXTable;

import javax.swing.AbstractAction;

/**
 * @Description 所有action对象的抽象基类
 * @Author ylf
 * @Date 2019/9/18 0018上午 11:36
 */
public abstract class JSTableBaseAction extends AbstractAction {

    private static final long serialVersionUID = -2137655328830377886L;

    /**
     * 当前操作的table对象
     */
    protected JXTable table;

    /**
     * 当前操作的table对象
     */
    public JXTable getTable() {
        return table;
    }

    /**
     * 当前操作的table对象
     */
    public void setTable(JXTable table) {
        this.table = table;
    }

    /**
     * 所有action对象的抽象基类
     * @param table
     */
    public JSTableBaseAction(JXTable table){
        super();
        this.setTable(table);
    }
}
