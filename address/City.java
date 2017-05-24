package com.tcwl.admin.address;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.File;
import java.util.List;

/**
 * Created by admin on 2017/4/21.
 */
public class City {

    @JSONField(name = "region_name")
    private String regionName;

    @JSONField(name = "region_id")
    private String regionId;

    @JSONField(name = "parent_id")
    private String parentId;

    private List<County> county;

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

    public List<County> getCounty() {
        return county;
    }

    public void setCounty(List<County> county) {
        this.county = county;
    }
}
