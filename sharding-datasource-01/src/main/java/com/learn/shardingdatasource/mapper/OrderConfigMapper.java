package com.learn.shardingdatasource.mapper;

import com.learn.shardingdatasource.dataobject.OrderConfigDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liujin
 * @datetime 2020/3/10 14:51
 */
@Repository
public interface OrderConfigMapper {

    OrderConfigDO selectById(@Param("id") Integer id);
}
