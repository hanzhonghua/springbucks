package com.springboot.springbucks.controller;

import com.robert.vesta.service.bean.Id;
import com.springboot.springbucks.config.UidConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: uid生成
 * @author: HanZhonghua
 * @create: 2019-03-16 21:28
 */
@Controller
public class UidController {

    @Autowired
    private UidConfig uidConfig;

    @RequestMapping("/genId")
    @ResponseBody
    public Long genId(){
        return uidConfig.genId();
    }

    @RequestMapping("/explainId")
    @ResponseBody
    public Id explainId(@RequestParam(value = "id", defaultValue = "0")long id) {
        return uidConfig.explaindId(id);
    }

    @RequestMapping("/makeid")
    @ResponseBody
    public long makeId(
            @RequestParam(value = "version", defaultValue = "-1") long version,
            @RequestParam(value = "type", defaultValue = "-1") long type,
            @RequestParam(value = "genMethod", defaultValue = "-1") long genMethod,
            @RequestParam(value = "machine", defaultValue = "-1") long machine,
            @RequestParam(value = "time", defaultValue = "-1") long time,
            @RequestParam(value = "seq", defaultValue = "-1") long seq) {

        try {
            return uidConfig.makeId(version, type, genMethod, machine, time, seq);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
