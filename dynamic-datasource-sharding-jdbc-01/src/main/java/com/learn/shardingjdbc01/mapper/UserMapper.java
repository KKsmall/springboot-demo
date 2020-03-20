package com.learn.shardingjdbc01.mapper;

import com.learn.shardingjdbc01.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liujin
 * @datetime 2020/3/10 9:31
 */
@Repository
public interface UserMapper {

    UserDO selectById(@Param("id") Integer id);
}
