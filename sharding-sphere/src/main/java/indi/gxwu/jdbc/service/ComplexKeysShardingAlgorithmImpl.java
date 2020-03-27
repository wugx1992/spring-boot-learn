package indi.gxwu.jdbc.service;

import indi.gxwu.jdbc.entity.HistoryLogMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import java.util.*;

/**
 * @Author: gx.wu
 * @Date: 2020/3/25 11:14
 * @Description: code something to describe this module what it is
 */
@Slf4j
public class ComplexKeysShardingAlgorithmImpl implements ComplexKeysShardingAlgorithm {

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

        Set<String> result = tryGetTableName(createTime, id, 2);
        if(result != null){
            return result;
        }

        return getAllTableName();
    }

    /**
     *
     * @param createTime
     * @param id
     * @param tryCount
     * @return
     */
    private Set<String> tryGetTableName(Date createTime, Long id, int tryCount){
        if(tryCount<=0){
            throw new NullPointerException();
        }

        for(HistoryLogMsg entity : InitMainTableMapService.TABLE_MSG_LIST){
            if(entity.getBeginTime().getTime()>createTime.getTime()){
                continue;
            }

            if(entity.getEndTime() == null){
                if(id==null || entity.getEndId()>=id){
                    return getTableName(entity.getTableSuffix());
                }else{
                    InitMainTableMapService.Listened_TO_CREATE_NEW_TABLE = true;
                    log.warn("TODO 创建新的分表，并填充当前分表的结束时间。");
                    return tryGetTableName(createTime, id, tryCount-1);
                }
            }else if(entity.getEndTime().getTime() >= createTime.getTime()){
                return getTableName(entity.getTableSuffix());
            }
        }
        return null;
    }

    /**
     *
     * @param tableSuffix
     * @return
     */
    private Set<String> getTableName(int tableSuffix){
        Set<String> result = new HashSet<>();
        result.add("history_log_"+tableSuffix);
        return result;
    }


    /**
     *
     * @return
     */
    private Set<String> getAllTableName(){
        Set<String> result = new HashSet<>();
        for(HistoryLogMsg entity : InitMainTableMapService.TABLE_MSG_LIST){
            result.add("history_log_"+entity.getTableSuffix());
        }
        return result;
    }
}
