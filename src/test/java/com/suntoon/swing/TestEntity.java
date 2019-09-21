package com.suntoon.swing;

import lombok.Data;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/9/18 0018上午 11:33
 */
@Data
public class TestEntity {

    /**
     * id
     */
    private Integer attrIdCol;

    /**
     * 名称
     */
    private String attrNameCol;

    /**
     * 类型
     */
    private String attrTypeCol;

    /**
     * 长度
     */
    private Integer attrLengthCol;

    /**
     * 精度
     */
    private Integer attrPrecCol;

    /**
     * 输入方式
     */
    private String attrInputTypeCol;

    /**
     * 别名
     */
    private String attrAliasCol;

    /**
     * 可见
     */
    private Boolean attrShowCol;

    /**
     * 关键字
     */
    private Boolean attrKeyCol;

    /**
     * 默认值
     */
    private String attrDefaultCol;

    /**
     * 公式
     */
    private String attrFormulaCol;
}
