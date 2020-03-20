package com.learn.baomidou01.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.learn.baomidou01.constant.DBConstants;
import com.learn.baomidou01.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liujin
 * @datetime 2020/3/10 9:31
 */
@Repository
//@DS 注解，是 dynamic-datasource-spring-boot-starter 提供，
// 可添加在 Service 或 Mapper 的类/接口上，或者方法上。
// 在其 value 属性种，填写数据源的名字,是数据源的名字！！！。
@DS(DBConstants.DATASOURCE_USERS)
public interface UserMapper {

    UserDO selectById(@Param("id") Integer id);
}
