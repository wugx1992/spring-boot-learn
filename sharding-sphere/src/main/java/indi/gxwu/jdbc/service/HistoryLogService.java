package indi.gxwu.jdbc.service;

import indi.gxwu.jdbc.dao.HistoryLogDao;
import indi.gxwu.jdbc.entity.HistoryLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: gx.wu
 * @Date: 2020/3/25 14:17
 * @Description: code something to describe this module what it is
 */
@Slf4j
@Service
public class HistoryLogService {

    @Autowired
    HistoryLogDao historyLogDao;


    public List<HistoryLog> getList(){
        return historyLogDao.getList();
    }

    public List<HistoryLog> getList(Date beginTime, Date endTime){
        return historyLogDao.getListByCreateTime(beginTime, endTime);
    }


    public int save(long id, String content, Date createTime){
        return historyLogDao.save(HistoryLog.builder().id(id).createTime(createTime).content(content).build());
    }

    public int save(HistoryLog data){
        return historyLogDao.save(data);
    }
}
