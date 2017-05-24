package com.tcwl.admin.address;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by admin on 2017/4/21.
 */
public class Province {

    private String province;

    @JSONField(name = "region_id")
    private String regionId;

    @JSONField(name = "parent_id")
    private String parentId;

    private List<City> parent;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public List<City> getParent() {
        return parent;
    }

    public void setParent(List<City> parent) {
        this.parent = parent;
    }
}
