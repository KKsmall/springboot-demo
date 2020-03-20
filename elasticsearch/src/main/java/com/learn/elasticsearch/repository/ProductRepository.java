package com.learn.elasticsearch.repository;

import com.learn.elasticsearch.esdo.ESProductDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * 第一个泛型设置对应的实体是 ESProductDO ，第二个泛型设置对应的主键类型是 Integer 。
 * @author liujin
 * @datetime 2020/3/9 13:19
 */
public interface ProductRepository extends ElasticsearchRepository<ESProductDO, Integer> {
}
