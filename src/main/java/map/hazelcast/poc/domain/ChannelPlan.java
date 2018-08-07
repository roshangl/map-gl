package map.hazelcast.poc.domain;

import java.io.Serializable;
import java.util.List;

public class ChannelPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<PlanData> weekPlanData;
    private List<PlanData> monthPlanData;
    private PlanData dynamicPlanData;

    public List<PlanData> getWeekPlanData() {
        return weekPlanData;
    }

    public void setWeekPlanData(List<PlanData> weekPlanData) {
        this.weekPlanData = weekPlanData;
    }

    public List<PlanData> getMonthPlanData() {
        return monthPlanData;
    }

    public void setMonthPlanData(List<PlanData> monthPlanData) {
        this.monthPlanData = monthPlanData;
    }

    public PlanData getDynamicPlanData() {
        return dynamicPlanData;
    }

    public void setDynamicPlanData(PlanData dynamicPlanData) {
        this.dynamicPlanData = dynamicPlanData;
    }
}
