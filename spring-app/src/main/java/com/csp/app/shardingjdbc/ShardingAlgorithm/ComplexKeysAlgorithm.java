package com.csp.app.shardingjdbc.ShardingAlgorithm;//package com.csp.springtest.config;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shardingsphere.api.sharding.ShardingValue;
//import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
//import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
///**
// * @description: 复杂分片算法
// * @author: csp
// * @date: 2020/09/04
// */
//@Slf4j
//public class ComplexKeysAlgorithm implements ComplexKeysShardingAlgorithm {
//    @Override
//    public Collection<String> doSharding(Collection collection, ComplexKeysShardingValue complexKeysShardingValue) {
//        log.info("collection:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(complexKeysShardingValue));
//
//        List<String> shardingSuffix = new ArrayList<>();
//        /**例如：根据user_id + order_id 双分片键来进行分表*/
//        return shardingSuffix;
//    }
//}
