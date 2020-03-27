package indi.gxwu.jdbc.service;

import com.google.common.collect.Range;
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

        Map<String,Object> mapValue =  shardingValue.getColumnNameAndShardingValuesMap();
        Map<String, Range> rangeValue =  shardingValue.getColumnNameAndRangeValuesMap();
        if(mapValue.containsKey("create_time")){
            //固定时间的，一般都是来自存储入库的字段值
            List<Date> createTimeValue = (List)mapValue.get("create_time");
            Long id = null;
            if(mapValue.containsKey("id")){
                List<Long> idValue = (List)mapValue.get("id");
                id = idValue.get(0);
            }
            Date createTime = createTimeValue.get(0);
            Set<String> result = tryGetTableName(createTime, id, 2);
            if(result != null){
                return result;
            }
        }else if(rangeValue.containsKey("create_time")){
            //时间范围方式的，一般都是来自查询语句条件
            Range createTimeRange = rangeValue.get("create_time");
            Set<String> result = new HashSet<>();
            for(HistoryLogMsg entity : InitMainTableMapService.TABLE_MSG_LIST) {
                if(entity.getBeginTime()==null){
                    continue;
                }
                if(createTimeRange.contains(entity.getBeginTime())){
                    result.add(getTableName(entity.getTableSuffix()));
                    continue;
                }else if(entity.getEndTime()!=null && createTimeRange.contains(entity.getEndTime())){
                    result.add(getTableName(entity.getTableSuffix()));
                    continue;
                }
            }
            if(result.size()!=0){
                return result;
            }
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
                    return getTableNameResult(entity.getTableSuffix());
                }else{
                    InitMainTableMapService.Listened_TO_CREATE_NEW_TABLE = true;
                    log.warn("TODO 创建新的分表，并填充当前分表的结束时间。");
                    return tryGetTableName(createTime, id, tryCount-1);
                }
            }else if(entity.getEndTime().getTime() >= createTime.getTime()){
                return getTableNameResult(entity.getTableSuffix());
            }
        }
        return null;
    }

    /**
     *
     * @param tableSuffix
     * @return
     */
    private Set<String> getTableNameResult(int tableSuffix){
        Set<String> result = new HashSet<>();
        result.add(getTableName(tableSuffix));
        return result;
    }

    private String getTableName(int tableSuffix){
        return "history_log_"+tableSuffix;
    }


    /**
     *
     * @return
     */
    private Set<String> getAllTableName(){
        Set<String> result = new HashSet<>();
        for(HistoryLogMsg entity : InitMainTableMapService.TABLE_MSG_LIST){
            result.add(getTableName(entity.getTableSuffix()));
        }
        return result;
    }
}
