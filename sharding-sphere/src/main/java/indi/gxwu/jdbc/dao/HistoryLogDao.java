package indi.gxwu.jdbc.dao;

import indi.gxwu.jdbc.entity.HistoryLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: gx.wu
 * @Date: 2020/3/25 14:09
 * @Description: code something to describe this module what it is
 */
@Repository
public class HistoryLogDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<HistoryLog> getList(){
        String sql = "SELECT * FROM history_log WHERE 1=1 ;";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(HistoryLog.class));
    }

    public List<HistoryLog> getListByCreateTime(Date beginTime, Date endTime){
        String sql = "SELECT * FROM history_log WHERE create_time>=? AND create_time<=? ;";
        return jdbcTemplate.query(sql, new Object[]{beginTime, endTime}, new BeanPropertyRowMapper<>(HistoryLog.class));
    }

    public int save(HistoryLog data){
        String sql = "INSERT INTO history_log (id, create_time, content) VALUES(?,?,?) ";
        return jdbcTemplate.update(sql, new Object[]{data.getId(), data.getCreateTime(), data.getContent()});
    }



}
