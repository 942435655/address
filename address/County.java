package com.tcwl.admin.address;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by admin on 2017/4/21.
 */
public class County {

    @JSONField(name = "region_name")
    private String regionName;

    @JSONField(name = "region_id")
    private String regionId;

    @JSONField(name = "parent_id")
    private String parentId;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public static void main(String[] args) {
        String s = "110000北京市";
        System.out.println(s.substring(0,6));
        String s2 = "110100市辖区";
        System.out.println(s2.substring(0,6));
    }
}
