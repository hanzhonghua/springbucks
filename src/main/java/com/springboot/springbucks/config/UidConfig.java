package com.springboot.springbucks.config;

import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.intf.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @description: uidservice
 * @author: HanZhonghua
 * @create: 2019-03-15 23:22
 */
@Component
public class UidConfig {

    @Autowired
    private IdService idService;

    public long genId(){
        return idService.genId();
    }

    public Id explaindId(long id) {
        return idService.expId(id);
    }

    public long makeId(long version, long type, long genMethod, long machine, long time, long seq) throws IllegalAccessException {

        long makeId = -1;
        if (time == -1 || seq == -1) {
            throw new IllegalAccessException("time and seq all required");
        } else if (version == -1){
            if (type == -1){
                if(genMethod == -1){
                    if(machine == -1){
                        makeId = idService.makeId(time, seq);
                    }else {
                        makeId = idService.makeId(time, seq, machine);
                    }
                }else {
                    makeId = idService.makeId(genMethod, time, seq, machine);
                }
            }else {
                makeId = idService.makeId(type, genMethod, time, seq, machine);
            }
        }else {
            makeId = idService.makeId(version, type, genMethod, time, seq, machine);
        }
        return makeId;
    }
}
