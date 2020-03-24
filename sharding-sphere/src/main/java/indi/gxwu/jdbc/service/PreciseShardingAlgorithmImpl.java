package indi.gxwu.jdbc.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Author: gx.wu
 * @Date: 2020/3/24 11:50
 * @Description: code something to describe this module what it is
 */
@Slf4j
public class PreciseShardingAlgorithmImpl implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        String dbName = "ds";
        Long val = shardingValue.getValue();
        long v = val%2;

        log.info("shardingValue: {}, v: {}", val, v);

        dbName += v;
        for (String each : availableTargetNames) {
            if (each.equals(dbName)) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}