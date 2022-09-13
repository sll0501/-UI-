package com.lyjs.util;

import java.util.Map;

/**
 * 用例类有3个属性，分别是参数，用例说明，预置参数
 * */
public class CaseInfo {
    public void setCaseParam(Map<String, String> caseParam) {
        this.caseParam = caseParam;
    }

    public void setCaseDesc(Map<String, String> caseDesc) {
        this.caseDesc = caseDesc;
    }

    public void setCasePreset(Map<String, String> casePreset) {
        this.casePreset = casePreset;
    }

    public Map<String, String> getCaseParam() {
        return caseParam;
    }

    public Map<String, String> getCaseDesc() {
        return caseDesc;
    }

    public Map<String, String> getCasePreset() {
        return casePreset;
    }

    //    {$d}isexcute为y的时候表示需要执行
//    用例参数 在excel中以字段名开头
    private Map<String,String> caseParam;
//    用例说明 在excel中以{$d}开头
    private Map<String,String>caseDesc;
//    用例预置条件 在excel中以{$p}开头
    private Map<String,String>casePreset;

}
