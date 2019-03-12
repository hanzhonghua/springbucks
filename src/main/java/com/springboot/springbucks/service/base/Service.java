package com.springboot.springbucks.service.base;

import java.util.List;

public interface Service<Bean, PK> {

    /**
     * 新增记录
     *
     * @param bean
     * @return
     */
    PK insert(Bean bean);

    /**
     * 保存记录
     *
     * @param bean
     * @return
     */
    PK save(Bean bean);

    /**
     * 删除记录
     *
     * @param pk
     */
    void delete(PK pk);

    /**
     * 查询记录
     *
     * @param pk
     * @return
     */
    Bean query(PK pk);

}
