package com.learn.baomidou01.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.learn.baomidou01.constant.DBConstants;
import com.learn.baomidou01.dataobject.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liujin
 * @datetime 2020/3/10 9:28
 */
@Repository
@DS(DBConstants.DATASOURCE_ORDERS)
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);
}
