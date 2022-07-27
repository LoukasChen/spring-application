//package com.csp.application.shardingjdbc.ShardingAlgorithm;
//
//import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
//import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
//
//import java.util.Collection;
//
///**
// * @description: 单键分片算法
// * @author: csp52872
// * @date: 2020/10/17
// */
//public class MyShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {
//
//    @Override
//    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
//        availableTargetNames.stream().filter(targetName -> targetName.endsWith(String.valueOf(shardingValue.getValue() % 4))).findFirst();
//        for (String targetName : availableTargetNames) {
//            if (targetName.endsWith(String.valueOf(shardingValue.getValue() % 4))) {
//                return targetName;
//            }
//        }
//        throw new IllegalArgumentException();
//    }
//}
