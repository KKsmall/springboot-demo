package com.learn.shardingjdbc01.mapper;

import com.learn.shardingjdbc01.dataobject.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liujin
 * @datetime 2020/3/10 9:28
 */
@Repository
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);
}
