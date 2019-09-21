package com.suntoon.swing;

/**
 * @Description TODO
 * @Author ylf
 * @Date 2019/9/18 0018下午 2:41
 */
public enum TestEnum {

    ATTR_ID_COL("attrIdCol", "Id"),

    ATTR_NAME_COL("attrNameCol", "名称"),

    ATTR_TYPE_COL("attrTypeCol", "类型"),

    ATTR_LENGTH_COL("attrLengthCol", "长度"),

    ATTR_PREC_COL("attrPrecCol", "精度"),

    ATTR_INPUT_TYPE_COL("attrInputTypeCol", "输入方式"),

    ATTR_ALIAS_COL("attrAliasCol", "别名"),

    ATTR_SHOW_COL("attrShowCol", "可见"),

    ATTR_KEY_COL("attrKeyCol", "关键字"),

    ATTR_DEFAULT_COL("attrDefaultCol", "默认值"),

    ATTR_FORMULA_COL("attrFormulaCol", "公式");

    private final String code;

    private final String desc;

    TestEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
