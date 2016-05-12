package com.wang.weixin.protracted.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wanganbang on 5/11/16.
 */
@Repository("activityDAO")
public class ActivityDAO {
    @Resource
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate mysqlTemplate;
    @Resource
    @Qualifier("mongodbTemplate")
    private MongoTemplate mongoTemplate;
}
