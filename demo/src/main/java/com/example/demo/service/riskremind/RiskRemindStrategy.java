package com.example.demo.service.riskremind;

/**
 * DESC:风险提示策略
 *
 * @author :RiskRemindStrategy
 * @date 2021/4/24-20:43
 */

public interface RiskRemindStrategy {
    /**
     *
     * @return
     */
    String StrategyName();

    /**
     *
     * @return
     */
    String riskRemind();


}
