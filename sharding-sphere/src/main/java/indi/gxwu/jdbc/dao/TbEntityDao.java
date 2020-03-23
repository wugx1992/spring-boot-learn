package indi.gxwu.jdbc.dao;

import indi.gxwu.jdbc.entity.TbEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: gx.wu
 * @Date: 2020/3/23 15:07
 * @Description: code something to describe this module what it is
 */
@Repository
public class TbEntityDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TbEntity> getList(){
        String sql = "SELECT * FROM test_tb ;";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(TbEntity.class));
    }


    public int save(String name){
        String sql = "INSERT INTO test_tb (name, create_time) VALUES(?,?) ";
        return jdbcTemplate.update(sql, new Object[]{name, new Date()});
    }

    public int copy(int id){
        String sql = "INSERT INTO test_tb(name, create_time) SELECT name, ? FROM test_tb WHERE id=? ";
        return jdbcTemplate.update(sql, new Object[]{new Date(), id});
    }
}
