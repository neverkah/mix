package com.wmx.leaf.service;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//直接使用 spring注入
@Service
public class LeafService {
    @Autowired
    private SegmentService segmentService;
//    @Autowired
//    private SnowflakeService snowflakeService;


    public long genId(){
        Result r = segmentService.getId("leaf-segment-test");

        if(null != r){
           return r.getId();
        }

        return -1;
    }
}