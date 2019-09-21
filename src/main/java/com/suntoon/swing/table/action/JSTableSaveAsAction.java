package com.suntoon.swing.table.action;

import com.suntoon.swing.entity.FieldsEntity;
import com.suntoon.swing.resource.ResourceLoader;
import com.suntoon.swing.table.JSTableModel;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description 保存操作
 * @Author ylf
 */
public class JSTableSaveAsAction extends JSTableBaseAction {

    private static final long serialVersionUID = 2834589546104965124L;

    /**
     * 保存操作
     * @param table
     */
    public JSTableSaveAsAction(JXTable table) {
        super(table);
        this.putValue(AbstractAction.NAME, "");
        this.putValue(AbstractAction.SMALL_ICON,
                new ImageIcon(ResourceLoader.getResource(ResourceLoader.IMAGE_SAVE)));
        this.putValue(SHORT_DESCRIPTION, "另存为...");
    }

    /**
     * 保存操作
     */
    @Override
    public void actionPerformed(ActionEvent ev) {
        try {
            JSTableModel<?> module = (JSTableModel<?>) this.getTable().getModel();
            List<FieldsEntity> list = (List<FieldsEntity>) module.getDatas();

            /**1.创建document*/
            Document document = DocumentHelper.createDocument();
            /**2.添加根元素*/
            Element rootElement = document.addElement("EMTabsDefine");
            Element tableElement = rootElement.addElement("EMTable").addAttribute("Name", "");
            for(FieldsEntity data : list){
                rootElement = object2Element(tableElement, data, String.valueOf(data.getAttrIdCol()));
            }
            /**3.将document写到xml中并保存到服务器指定的目录中*/
            FileOutputStream xmlOut;
            try {
                xmlOut = new FileOutputStream(new File("d:/person.sdt"));
                OutputFormat format = OutputFormat.createPrettyPrint();
                format.setEncoding("GBK");
                XMLWriter xmlWriter = new XMLWriter(xmlOut, format);
                xmlWriter.write(document);
                xmlWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Element object2Element(Element root,Object obj,String id){
        try {
            //获取Document根元素
            Class clazz = obj.getClass();
            //创建一个节点元素
            Element nodeElement = root.addElement("EMField");
            Field[] fields = clazz.getDeclaredFields();
            //遍历属性
            for(Field field :fields){
                /**拼接出属性对应的getter方法名*/
                //获取对象属性
                String fieldName = field.getName();
                StringBuilder sb = new StringBuilder();
                sb.append("get");
                sb.append(fieldName.substring(0,1).toUpperCase());
                if(fieldName.length()>1){
                    sb.append(fieldName.substring(1));
                }
                String getMethodName = sb.toString();
                //反射method对象
                Method getMethod = obj.getClass().getMethod(getMethodName);
                //调用方法获取值
                Object fieldValue = getMethod.invoke(obj);
                //添加元素属性
                switch (fieldName) {
                    case "attrNameCol":
                        nodeElement.addAttribute("Name", fieldValue.toString());
                        break;
                    case "attrTypeCol":
                        nodeElement.addAttribute("Type", fieldValue.toString());
                        break;
                    case "attrLengthCol":
                        nodeElement.addAttribute("Length", fieldValue.toString());
                        break;
                    case "attrPrecCol":
                        nodeElement.addAttribute("Decimal", fieldValue.toString());
                        break;
                    case "attrKeyCol":
                        nodeElement.addAttribute("IsKey", fieldValue.toString().toUpperCase());
                        break;
                    case "attrShowCol":
                        nodeElement.addAttribute("IsShow", fieldValue.toString().toUpperCase());
                        break;
                    case "attrInputTypeCol":
                        nodeElement.addAttribute("InputType", fieldValue.toString());
                        break;
                    case "attrAliasCol":
                        nodeElement.addAttribute("AliasName", fieldValue.toString());
                        break;
                    case "attrDefaultCol":
                        nodeElement.addAttribute("Default", fieldValue.toString());
                        break;
                    case "attrFormulaCol":
                        nodeElement.addAttribute("Formula", fieldValue.toString());
                        break;
                    default:
                        break;
                }

                nodeElement.addAttribute("IsQueryField", "").addAttribute("Explain", "").addAttribute("TValue", "")
                        .addAttribute("ValueTmpl1", "").addAttribute("VT1Enable", "FALSE");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return root;
    }

}

