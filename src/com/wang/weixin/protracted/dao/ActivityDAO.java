package com.wang.weixin.protracted.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanganbang on 5/11/16.
 */
@Repository("activityDAO")
public class ActivityDAO {
    private String QUERY_SQL = "SELECT * FROM t_activity WHERE start_time>? ORDER BY start_time DESC";

    @Resource(name = "mysqlJdbcTemplate")
    private JdbcTemplate mysqlTemplate;
    @Resource(name = "mongodbTemplate")
    private MongoTemplate mongoTemplate;

    public List<Map<String, Object>> getActivitys(){
        return mysqlTemplate.query(QUERY_SQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            }
        }, new ResultSetExtractor<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                if (resultSet.next()){
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("id", resultSet.getString("id"));
                    map.put("title", resultSet.getString("title"));
                    map.put("content", resultSet.getString("content"));
                    map.put("picture", resultSet.getString("picture"));
                    map.put("end_time", resultSet.getString("end_time"));
                    map.put("start_time", resultSet.getString("start_time"));
                    map.put("push_uid", resultSet.getString("push_uid"));
                    map.put("published_date",resultSet.getString("published_date"));
                    map.put("commission", resultSet.getString("commission"));
                    map.put("number_people", resultSet.getString("number_people"));
                    map.put("status", resultSet.getString("status"));
                    map.put("update_time", resultSet.getString("update_time"));
                    map.put("type", resultSet.getString("type"));
                    map.put("location", resultSet.getString("location"));
                    map.put("party_localtion", resultSet.getString("party_localtion"));
                    map.put("pay_type", resultSet.getString("pay_type"));
                    map.put("contact", resultSet.getString("contact"));
                    map.put("phone_number", resultSet.getString("phone_number"));
                    list.add(map);
                }

                return list;
            }
        });
    }
}
