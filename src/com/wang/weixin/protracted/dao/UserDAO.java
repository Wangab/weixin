package com.wang.weixin.protracted.dao;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanganbang on 5/11/16.
 */
@Repository("userDAO")
public class UserDAO {
    private String QUERY_SQL = "SELECT uid,nick FROM t_user where name=? or nick=? or communication=?";

    @Resource
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate mysqlTemplate;
    @Resource
    @Qualifier("mongodbTemplate")
    private MongoTemplate mongoTemplate;

    /**
     * 获取用户信息组成map返回
     * @param searchStr 匹配条件的搜索字段，他将与昵称、用户名、联系方式匹配来试图搜索用户信息
     * @return
     */
    public List<Map<String, Object>> getUserInfo(String searchStr){
        return mysqlTemplate.query(QUERY_SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, searchStr);
                preparedStatement.setString(2, searchStr);
                preparedStatement.setString(3, searchStr);
            }
        }, new ResultSetExtractor<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
                if(resultSet.next()){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("uid", resultSet.getString("uid"));
                    map.put("nick", resultSet.getString("nick"));
                    results.add(map);
                }
                return results;
            }
        });
    }
    public String getUserIconURL(String uid){
        Query query = new Query(Criteria.where("uid").is(uid));
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        mongoTemplate.findOne(query, Map.class, "");
    }
}
