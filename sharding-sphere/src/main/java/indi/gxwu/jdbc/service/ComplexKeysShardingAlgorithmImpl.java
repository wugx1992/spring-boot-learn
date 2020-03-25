package indi.gxwu.jdbc.service;

import indi.gxwu.jdbc.entity.HistoryLogMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.joda.time.DateTime;
import java.util.*;

/**
 * @Author: gx.wu
 * @Date: 2020/3/25 11:14
 * @Description: code something to describe this module what it is
 */
@Slf4j
public class ComplexKeysShardingAlgorithmImpl implements ComplexKeysShardingAlgorithm {

    private static List<HistoryLogMsg> TABLE_MSG_LIST = new ArrayList<HistoryLogMsg>(){{
        add(HistoryLogMsg.builder().tableSuffix(1).beginId(1).endId(10)
                .beginTime(new DateTime(2020,03,01,00,00,00).toDate())
                .endTime(new DateTime(2020,03,21,23,59,59).toDate()).build());
        add(HistoryLogMsg.builder().tableSuffix(2).beginId(11).endId(20)
                .beginTime(new DateTime(2020,03,22,00,00,00).toDate())
                .endTime(new DateTime(2020,03,25,23,59,59).toDate()).build());
        add(HistoryLogMsg.builder().tableSuffix(3).beginId(21).endId(30)
                .beginTime(new DateTime(2020,03,26,00,00,00).toDate()).endTime(null).build());
    }};


    /**
     * Sharding.
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding results for data sources or tables's names
     */
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {

        //TODO 判断columnNameAndShardingValuesMap、columnNameAndRangeValuesMap的值

        log.info("shardingValue class : {}", shardingValue.getClass());
        log.info("availableTargetNames: {}, shardingValue: {}", availableTargetNames, shardingValue);
        Map<String,Object> value =  shardingValue.getColumnNameAndShardingValuesMap();
        if(!value.containsKey("create_time")){
            return getAllTableName();
        }

        List<Date> createTimeValue = (List)value.get("create_time");

        Long id = null;
        if(value.containsKey("id")){
            List<Long> idValue = (List)value.get("id");
            id = idValue.get(0);
        }
        Date createTime = createTimeValue.get(0);


        for(HistoryLogMsg entity : TABLE_MSG_LIST){
           if(entity.getBeginTime().getTime()>createTime.getTime()){
               continue;
           }

           if(entity.getEndTime() == null){
               if(id==null || entity.getEndId()>=id){
                   return getTableName(entity.getTableSuffix());
               }else{
                   log.warn("TODO 创建新的分表，并填充当前分表的结束时间");
               }
           }else if(entity.getEndTime().getTime() >= createTime.getTime()){
               return getTableName(entity.getTableSuffix());
           }
        }

        return getAllTableName();
    }

    private Set<String> getTableName(int tableSuffix){
        Set<String> result = new HashSet<>();
        result.add("history_log_"+tableSuffix);
        return result;
    }

    private Set<String> getAllTableName(){
        Set<String> result = new HashSet<>();
        for(HistoryLogMsg entity : TABLE_MSG_LIST){
            result.add("history_log_"+entity.getTableSuffix());
        }
        return result;
    }
}
