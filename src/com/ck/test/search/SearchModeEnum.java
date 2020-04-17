package com.ck.test.search;

public enum SearchModeEnum {
    EQUAL("等于"),
    FIRST_EQUAL("第一个值等于"),
    LAST_QUEAL("最后一个值等于"),
    FIRST_GE("第一个大于等于"),
    LAST_LE("最后一个小于等于");

    private String modeName;

    SearchModeEnum(String modeName) {
        this.modeName = modeName;
    }

    public String getModeName() {
        return modeName;
    }
}
