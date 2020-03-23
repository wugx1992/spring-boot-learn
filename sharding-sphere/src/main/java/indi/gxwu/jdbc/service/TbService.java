package indi.gxwu.jdbc.service;

import indi.gxwu.jdbc.dao.TbEntityDao;
import indi.gxwu.jdbc.entity.TbEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gx.wu
 * @Date: 2020/3/23 15:08
 * @Description: code something to describe this module what it is
 */
@Service
public class TbService {

    @Autowired
    TbEntityDao tbEntityDao;

    public List<TbEntity> getList(){
        return tbEntityDao.getList();
    }

    public int save(String name){
        return tbEntityDao.save(name);
    }
}


