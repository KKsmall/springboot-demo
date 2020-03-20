package com.learn.baomidou02.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.learn.baomidou02.constant.DBConstants;
import com.learn.baomidou02.dataobject.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liujin
 * @datetime 2020/3/10 9:28
 */
@Repository
public interface OrderMapper {

    @DS(DBConstants.DATASOURCE_SLAVE)
    OrderDO selectById(@Param("id") Integer id);

    @DS(DBConstants.DATASOURCE_MASTER)
    int insert(OrderDO entity);
}
