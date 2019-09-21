package com.suntoon.swing.dictionary;

import com.suntoon.swing.constant.FieldsEnum;
import com.suntoon.swing.entity.FieldsEntity;
import com.suntoon.swing.table.*;
import com.suntoon.swing.table.defaultImpl.JSTableDefaultBuilderImpl;
import com.suntoon.swing.table.defaultImpl.JSTableModelDefaultAdapter;
import com.suntoon.swing.table.editor.JSTableCheckboxEditor;
import com.suntoon.swing.test.JSTableColorEditor;
import com.suntoon.swing.table.renderer.JSTableCheckboxRenderer;
import com.suntoon.swing.table.renderer.JSTableRowNumberRenderer;
import com.suntoon.swing.table.tools.JSTableToolBar;
import com.suntoon.swing.test.JSTableColorRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description table 表格方法
 * @Author ylf
 * @Date 2019/9/18 0018上午 10:00
 */
public class JFrameDefaultTableDemo extends JFrame {

    private static final long serialVersionUID = 8818584079585682536L;

    /**
     *
     */
    public JFrameDefaultTableDemo() {
        super();
        initCompents();
    }

    /**
     * 当前的table
     */
    private JSTable table;

    /**
     * tablemodel
     */
    private JSTableModel<Collection<FieldsEntity>> tableModel;

    /**
     * colmodel
     */
    private JSTableColumnModel colModel;

    /**
     * 初始化控件
     */
    private void initCompents() {
        JPanel panel = new JPanel(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        DefaultTableCellRenderer renderR = new DefaultTableCellRenderer();
        renderR.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

        // id
        JSTableColumn col0 = new JSTableColumn();
        col0.setIdentifier(FieldsEnum.ATTR_ID_COL.getCode());      // id
        col0.setTitle(FieldsEnum.ATTR_ID_COL.getDesc());
        col0.setHeaderValue(FieldsEnum.ATTR_ID_COL.getDesc());
        col0.setModelIndex(0);
        col0.setEditable(false);
        col0.setWidth(40);
        JSTableRowNumberRenderer rownNumRender = new JSTableRowNumberRenderer();
        rownNumRender.setHorizontalAlignment(JSTableRowNumberRenderer.CENTER);
        col0.setCellRenderer(rownNumRender);     //行号渲染器

        // 名称
        // 系统默认的渲染器和编辑器
        JSTableColumn col1 = new JSTableColumn();
        col1.setIdentifier(FieldsEnum.ATTR_NAME_COL.getCode()); // 对应的实体字段
        col1.setTitle(FieldsEnum.ATTR_NAME_COL.getDesc());
        col1.setHeaderValue(FieldsEnum.ATTR_NAME_COL.getDesc());
        col1.setModelIndex(1); // 这个必须逐次增加
        col1.setWidth(90);
        col1.setDefaultValue("");

        // 类型
        // 因为这个字段是存的字符串，演示一下原生的控件的效果
        JSTableColumn col2 = new JSTableColumn();
        col2.setIdentifier(FieldsEnum.ATTR_TYPE_COL.getCode());
        col2.setTitle(FieldsEnum.ATTR_TYPE_COL.getDesc());
        col2.setHeaderValue(FieldsEnum.ATTR_TYPE_COL.getDesc());
        col2.setModelIndex(2);
        col2.setWidth(75);
        col2.setDefaultValue("整数");
        JComboBox<String> cbGender = new JComboBox<>(new String[] { "整数", "字符", "浮点" });
        DefaultCellEditor editorGender = new DefaultCellEditor(cbGender);
        col2.setCellRenderer(renderC); // 居中显示
        col2.setCellEditor(editorGender); // 普通的下拉列表框

        // 长度
        // 以下是数字微调控件的示例
        JSTableColumn col3 = new JSTableColumn();
        col3.setIdentifier(FieldsEnum.ATTR_LENGTH_COL.getCode());
        col3.setTitle(FieldsEnum.ATTR_LENGTH_COL.getDesc());
        col3.setHeaderValue(FieldsEnum.ATTR_LENGTH_COL.getDesc());
        col3.setModelIndex(3);
        col3.setWidth(25);
        col3.setMinWidth(25);
        col3.setCellRenderer(renderR); // 右侧显示

        // 精度
        // 以下是数字微调控件的示例
        JSTableColumn col4 = new JSTableColumn();
        col4.setIdentifier(FieldsEnum.ATTR_PREC_COL.getCode());
        col4.setTitle(FieldsEnum.ATTR_PREC_COL.getDesc());
        col4.setHeaderValue(FieldsEnum.ATTR_PREC_COL.getDesc());
        col4.setModelIndex(4);
        col4.setWidth(25);
        col4.setMinWidth(25);
        col4.setCellRenderer(renderR); // 右侧显示
        // 带有范围限定的
        //col3.setCellEditor(new JSTableSpinnerEditor(new JSpinner(new SpinnerNumberModel(1, 1, 255, 1))));

        // 输入方式
        JSTableColumn col5 = new JSTableColumn();
        col5.setIdentifier(FieldsEnum.ATTR_INPUT_TYPE_COL.getCode());
        col5.setTitle(FieldsEnum.ATTR_INPUT_TYPE_COL.getDesc());
        col5.setHeaderValue(FieldsEnum.ATTR_INPUT_TYPE_COL.getDesc());
        col5.setModelIndex(5);
        col5.setMinWidth(160);
        col5.setMaxWidth(160);
        //col5.setDefaultValue();
        col5.setCellRenderer(new JSInputTypeRenderer());
        col5.setCellEditor(new JSInputTypeEditor());

        // 别名
        // 系统默认的渲染器和编辑器
        JSTableColumn col6 = new JSTableColumn();
        col6.setIdentifier(FieldsEnum.ATTR_ALIAS_COL.getCode()); // 对应的实体字段
        col6.setTitle(FieldsEnum.ATTR_ALIAS_COL.getDesc());
        col6.setHeaderValue(FieldsEnum.ATTR_ALIAS_COL.getDesc());
        col6.setModelIndex(6); // 这个必须逐次增加
        col6.setWidth(90);
        col6.setDefaultValue("");

        // 可见
        JSTableColumn col7 = new JSTableColumn();
        col7.setIdentifier(FieldsEnum.ATTR_SHOW_COL.getCode());
        col7.setTitle(FieldsEnum.ATTR_SHOW_COL.getDesc());
        col7.setHeaderValue(FieldsEnum.ATTR_SHOW_COL.getDesc());
        col7.setModelIndex(7);
        col7.setWidth(15);
        col7.setMinWidth(15);
        col7.setDefaultValue(false);
        JSTableCheckboxRenderer jsTableCheckboxRenderer = new JSTableCheckboxRenderer();
        jsTableCheckboxRenderer.setHorizontalAlignment(JSTableCheckboxRenderer.CENTER);
        col7.setCellRenderer(jsTableCheckboxRenderer);
        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.setHorizontalAlignment(JCheckBox.CENTER);
        col7.setCellEditor(new JSTableCheckboxEditor(jCheckBox));
        jsTableCheckboxRenderer.setEnabled(true);
        col7.setSortable(false);

        // 关键字
        JSTableColumn col8 = new JSTableColumn();
        col8.setIdentifier(FieldsEnum.ATTR_KEY_COL.getCode());
        col8.setTitle(FieldsEnum.ATTR_KEY_COL.getDesc());
        col8.setHeaderValue(FieldsEnum.ATTR_KEY_COL.getDesc());
        col8.setModelIndex(8);
        col8.setWidth(15);
        col8.setMinWidth(15);
        col8.setDefaultValue(false);
        JSTableCheckboxRenderer jsTableCheckboxRenderer1 = new JSTableCheckboxRenderer();
        jsTableCheckboxRenderer1.setHorizontalAlignment(JSTableCheckboxRenderer.CENTER);
        col8.setCellRenderer(jsTableCheckboxRenderer1);
        JCheckBox jCheckBox1 = new JCheckBox();
        jCheckBox1.setHorizontalAlignment(JCheckBox.CENTER);
        col8.setCellEditor(new JSTableCheckboxEditor(jCheckBox1));
        jsTableCheckboxRenderer1.setEnabled(true);
        col8.setSortable(false);

        // 默认值
        // 系统默认的渲染器和编辑器
        JSTableColumn col9 = new JSTableColumn();
        col9.setIdentifier(FieldsEnum.ATTR_DEFAULT_COL.getCode()); // 对应的实体字段
        col9.setTitle(FieldsEnum.ATTR_DEFAULT_COL.getDesc());
        col9.setHeaderValue(FieldsEnum.ATTR_DEFAULT_COL.getDesc());
        col9.setModelIndex(9); // 这个必须逐次增加
        col9.setWidth(110);
        col9.setDefaultValue("");

        // 公式
        // 系统默认的渲染器和编辑器
        JSTableColumn col10 = new JSTableColumn();
        col10.setIdentifier(FieldsEnum.ATTR_FORMULA_COL.getCode()); // 对应的实体字段
        col10.setTitle(FieldsEnum.ATTR_FORMULA_COL.getDesc());
        col10.setHeaderValue(FieldsEnum.ATTR_FORMULA_COL.getDesc());
        col10.setModelIndex(10); // 这个必须逐次增加
        col10.setWidth(110);
        col10.setDefaultValue("");

        // 公式
        // 系统默认的渲染器和编辑器
        JSTableColumn col11 = new JSTableColumn();
        col11.setIdentifier(FieldsEnum.ATTR_TVALUE_COL.getCode()); // 对应的实体字段
        col11.setModelIndex(11); // 这个必须逐次增加
        col11.setDefaultValue("");
        col11.setVisible(false);

        try {
            JSTableBuilder<Collection<FieldsEntity>> builder = new JSTableDefaultBuilderImpl<>(FieldsEntity.class, col0,
                    col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11);
            colModel = builder.buildTableColumnModel();
            tableModel = builder.buildTableModel();
            table = new JSTable(tableModel, colModel);
            table.getTableHeader().setReorderingAllowed(false);

            tableModel.setTableModelLinster(new JSTableModelDefaultAdapter<FieldsEntity>() {

                @Override
                public Collection<FieldsEntity> onRetrieve() throws Exception {

                    List<FieldsEntity> result = new LinkedList<>();
                    for (int i = 0; i < 110; i++) {
                        FieldsEntity entity = new FieldsEntity();
                        entity.setAttrIdCol(i);
                        entity.setAttrNameCol("name:" + i);
                        entity.setAttrTypeCol(i % 3 == 0 ? "整数" : (i % 2 == 1 ? "字符" : "浮点"));
                        entity.setAttrLengthCol((i + 2) % 20);
                        entity.setAttrPrecCol((i + 3) % 20);
                        entity.setAttrInputTypeCol("手写");
                        entity.setAttrAliasCol("alias:" + i);
                        entity.setAttrShowCol(i % 2 == 0 ? true : false);
                        entity.setAttrKeyCol(i % 2 == 0 ? false : true);
                        entity.setAttrDefaultCol("default:" + i);
                        entity.setAttrFormulaCol("formula:" + i);
                        entity.setAttrTValueCol("tvalue:" + i);
                        result.add(entity);
                    }

                    return result;
                }
            });

            panel.add(new JScrollPane(table), BorderLayout.CENTER);
            this.add(panel, BorderLayout.CENTER);

            // 加载数据
            tableModel.retrieve();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 加个工具条
        // 以下是测试表格显示风格的操作
        JSTableToolBar toolBar = new JSTableToolBar(table);
        toolBar.enableRetrieve();
        toolBar.enableEdit();
        toolBar.enableAdd();
        toolBar.enableDel();
        toolBar.enableSave();
        toolBar.enableSaveAs();
        this.add(toolBar,BorderLayout.NORTH);
    }

    /**
     * 生成操作菜单
     *
     * @return
     */
    public JPopupMenu createMenu() {

        JPopupMenu menu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("样式设置");
        menu.add(item1);

        return menu;
    }
}
