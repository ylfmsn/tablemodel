package com.suntoon.swing.table.action;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @Description 空操作action对象
 * @Author ylf
 */
public class JSTableDefaultAction extends AbstractAction implements JSTableChooseAction {

    private static final long serialVersionUID = 2328363418795722955L;

    /**
     * 空操作action对象
     */
    public JSTableDefaultAction(){
        super();
        this.putValue(NAME, ".");
    }

    private Object value;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public Result getResult() {
        return Result.Cancel;
    }

    @Override
    public void setResult(Result result) {

    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

}

