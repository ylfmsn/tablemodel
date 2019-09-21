package com.suntoon.swing.table.defaultImpl;

import com.suntoon.swing.table.JSTableModelEvent;
import com.suntoon.swing.table.JSTableModelLinster;

import java.util.Collection;

/**
 * @Description 默认的系统实现
 * @Author ylf
 */
public class JSTableModelArrayAdapter implements JSTableModelLinster<Collection<Object[]>> {

    /**
     * 带有构造函数的tableModel
     */
    public JSTableModelArrayAdapter()
    {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beforRetrieve(JSTableModelEvent event) throws Exception {
        event.getTableModel().clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Object[]> onRetrieve() throws Exception {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afterRetrieve(JSTableModelEvent event) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beforeUpdate(JSTableModelEvent event) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean update(JSTableModelEvent event) throws Exception {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void atfterUpdate(JSTableModelEvent event) throws Exception {
        event.getTableModel().resetUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beforDelete(JSTableModelEvent event) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afterDelete(JSTableModelEvent event) throws Exception {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beforeAppend(JSTableModelEvent event) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void aftterAppend(JSTableModelEvent event) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beforeInsert(JSTableModelEvent event) throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void aftterInsert(JSTableModelEvent event) throws Exception {
    }

}
