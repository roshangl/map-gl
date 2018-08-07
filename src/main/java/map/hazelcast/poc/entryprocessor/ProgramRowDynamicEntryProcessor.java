package map.hazelcast.poc.entryprocessor;

import com.hazelcast.map.AbstractEntryProcessor;
import map.hazelcast.poc.domain.PlanData;
import map.hazelcast.poc.domain.ProgramRow;

import java.util.Map;

public class ProgramRowDynamicEntryProcessor extends AbstractEntryProcessor<String, ProgramRow> {

    @Override
    public Object process(Map.Entry<String, ProgramRow> entry) {
        ProgramRow value = entry.getValue();

        PlanData dynamicPlanDataForDigital = new PlanData();
        dynamicPlanDataForDigital.setSalesUnits(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSalesUnits).sum());
        dynamicPlanDataForDigital.setSalesDollars(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSalesDollars).sum());
        dynamicPlanDataForDigital.setBopUnits(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getBopUnits).sum());
        dynamicPlanDataForDigital.setCost(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getCost).sum());
        dynamicPlanDataForDigital.setDoorCount(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getDoorCount).sum());
        dynamicPlanDataForDigital.setReceiptsDollars(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getReceiptsDollars).sum());
        dynamicPlanDataForDigital.setReceiptsUnits(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getReceiptsUnits).sum());
        dynamicPlanDataForDigital.setSellThruPercent(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSellThruPercent).sum());
        dynamicPlanDataForDigital.setStyleColorCount(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getStyleColorCount).sum());
        dynamicPlanDataForDigital.setTicketAUR(value.getDigitalChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getTicketAUR).sum());
        dynamicPlanDataForDigital.setStartFiscalDate(value.getStartFiscalDate());
        dynamicPlanDataForDigital.setEndFiscalDate(value.getEndFiscalDate());
        value.getDigitalChannelPlan().setDynamicPlanData(dynamicPlanDataForDigital);

        PlanData dynamicPlanDataForStore = new PlanData();
        dynamicPlanDataForStore.setSalesUnits(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSalesUnits).sum());
        dynamicPlanDataForStore.setSalesDollars(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSalesDollars).sum());
        dynamicPlanDataForStore.setBopUnits(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getBopUnits).sum());
        dynamicPlanDataForStore.setCost(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getCost).sum());
        dynamicPlanDataForStore.setDoorCount(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getDoorCount).sum());
        dynamicPlanDataForStore.setReceiptsDollars(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getReceiptsDollars).sum());
        dynamicPlanDataForStore.setReceiptsUnits(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getReceiptsUnits).sum());
        dynamicPlanDataForStore.setSellThruPercent(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSellThruPercent).sum());
        dynamicPlanDataForStore.setStyleColorCount(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getStyleColorCount).sum());
        dynamicPlanDataForStore.setTicketAUR(value.getStoreChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getTicketAUR).sum());
        dynamicPlanDataForStore.setStartFiscalDate(value.getStartFiscalDate());
        dynamicPlanDataForStore.setEndFiscalDate(value.getEndFiscalDate());
        value.getStoreChannelPlan().setDynamicPlanData(dynamicPlanDataForStore);

        PlanData dynamicPlanDataForOmni = new PlanData();
        dynamicPlanDataForOmni.setSalesUnits(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSalesUnits).sum());
        dynamicPlanDataForOmni.setSalesDollars(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSalesDollars).sum());
        dynamicPlanDataForOmni.setBopUnits(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getBopUnits).sum());
        dynamicPlanDataForOmni.setCost(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getCost).sum());
        dynamicPlanDataForOmni.setDoorCount(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getDoorCount).sum());
        dynamicPlanDataForOmni.setReceiptsDollars(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getReceiptsDollars).sum());
        dynamicPlanDataForOmni.setReceiptsUnits(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getReceiptsUnits).sum());
        dynamicPlanDataForOmni.setSellThruPercent(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getSellThruPercent).sum());
        dynamicPlanDataForOmni.setStyleColorCount(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getStyleColorCount).sum());
        dynamicPlanDataForOmni.setTicketAUR(value.getOmniChannelPlan().getWeekPlanData().parallelStream().mapToLong(PlanData::getTicketAUR).sum());
        dynamicPlanDataForOmni.setStartFiscalDate(value.getStartFiscalDate());
        dynamicPlanDataForOmni.setEndFiscalDate(value.getEndFiscalDate());
        value.getOmniChannelPlan().setDynamicPlanData(dynamicPlanDataForOmni);

        entry.setValue(value);
        return null;
    }

}
