package com.suntoon.swing.constant;

/**
 * @Description TODO
 * @Author ylf
 */
public enum FieldsEnum {

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

    ATTR_FORMULA_COL("attrFormulaCol", "公式"),

    ATTR_TVALUE_COL("attrTValueCol", "格式值");

    private final String code;

    private final String desc;

    FieldsEnum(String code, String desc) {
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
