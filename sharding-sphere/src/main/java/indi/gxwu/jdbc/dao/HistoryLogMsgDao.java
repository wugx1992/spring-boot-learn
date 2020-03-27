package indi.gxwu.jdbc.dao;

import indi.gxwu.jdbc.entity.HistoryLogMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: gx.wu
 * @Date: 2020/3/27 14:20
 * @Description: code something to describe this module what it is
 */
@Repository
public class HistoryLogMsgDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<HistoryLogMsg> getList(){
        String sql = "SELECT * FROM history_log_msg ORDER BY table_suffix ;";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(HistoryLogMsg.class));
    }

}
