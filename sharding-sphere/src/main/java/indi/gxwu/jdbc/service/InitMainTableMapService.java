package indi.gxwu.jdbc.service;

import indi.gxwu.jdbc.dao.HistoryLogMsgDao;
import indi.gxwu.jdbc.entity.HistoryLogMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: gx.wu
 * @Date: 2020/3/27 14:09
 * @Description: code something to describe this module what it is
 */
@Service
public class InitMainTableMapService {

    public static boolean Listened_TO_CREATE_NEW_TABLE = false;

    /**
    public static List<HistoryLogMsg> TABLE_MSG_LIST = new ArrayList<HistoryLogMsg>(){{
        add(HistoryLogMsg.builder().tableSuffix(1).beginId(1).endId(10)
                .beginTime(new DateTime(2020,03,01,00,00,00).toDate())
                .endTime(new DateTime(2020,03,21,23,59,59).toDate()).build());
        add(HistoryLogMsg.builder().tableSuffix(2).beginId(11).endId(20)
                .beginTime(new DateTime(2020,03,22,00,00,00).toDate())
                .endTime(new DateTime(2020,03,25,23,59,59).toDate()).build());
        add(HistoryLogMsg.builder().tableSuffix(3).beginId(21).endId(30)
                .beginTime(new DateTime(2020,03,26,00,00,00).toDate()).endTime(null).build());
    }};
     */
    public static List<HistoryLogMsg> TABLE_MSG_LIST = new CopyOnWriteArrayList();


    @Autowired
    HistoryLogMsgDao historyLogMsgDao;

    @Async("taskExecutor")
    public void listeningCreateNewTable(){
        while (true){
            if(Listened_TO_CREATE_NEW_TABLE){
                Listened_TO_CREATE_NEW_TABLE =false;
                //省略创建表的相关逻辑
                initOrUpdateCacheMap();
            }
        }
    }

    public void initOrUpdateCacheMap(){
            List<HistoryLogMsg> list = historyLogMsgDao.getList();
            if(list.size()==0){
                throw new NullPointerException();
            }
            TABLE_MSG_LIST.clear();
            TABLE_MSG_LIST.addAll(list);
    }
}
