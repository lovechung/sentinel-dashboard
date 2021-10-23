package com.alibaba.csp.sentinel.dashboard.rule;

import com.alibaba.csp.sentinel.dashboard.config.DashboardConfig;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("flowRuleRedisPublisher")
public class FlowRuleRedisPublisher implements DynamicRulePublisher<List<FlowRuleEntity>> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void publish(String app, List<FlowRuleEntity> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        String msg = JSON.toJSONString(rules);
        // 持久化
        stringRedisTemplate.opsForValue().set(DashboardConfig.getRuleFlowKey() + app, msg);
        // 发布消息，通知各订阅客户端
        stringRedisTemplate.convertAndSend(DashboardConfig.getRedisPublishChannel(), msg);
    }
}
