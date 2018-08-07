package map.hazelcast.poc.entryprocessor;

import com.hazelcast.map.AbstractEntryProcessor;
import map.hazelcast.poc.domain.PlanData;
import map.hazelcast.poc.domain.ProgramRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ProgramRowMonthEntryProcessor extends AbstractEntryProcessor<String, ProgramRow> {

    @Override
    public Object process(Map.Entry<String, ProgramRow> entry) {
        ProgramRow value = entry.getValue();
        int totalMonths = value.getEndFiscalDate().getFiscalMonth().getMonthNumber()
                - value.getStartFiscalDate().getFiscalMonth().getMonthNumber() + 1;

        int beginIndex = 0;
        int endIndex;

        if (totalMonths == 1) {
            endIndex = value.getEndFiscalDate().getFiscalWeek().getWeekNumber()
                    - value.getStartFiscalDate().getFiscalWeek().getWeekNumber() + 1;
        } else {
            endIndex = 5 - value.getStartFiscalDate().getFiscalWeek().getWeekNumber();
        }

        List<PlanData> monthsPlanDataListForDigital = new ArrayList<>();
        List<PlanData> monthsPlanDataListForStore = new ArrayList<>();
        List<PlanData> monthsPlanDataListForOmni = new ArrayList<>();

        for (int i = 0; i < totalMonths; i++) {
            List<PlanData> monthPlanData = value.getDigitalChannelPlan().getWeekPlanData().subList(beginIndex, endIndex);

            PlanData planDataForDigital = new PlanData();
            planDataForDigital.setSalesUnits(monthPlanData.stream().mapToLong(PlanData::getSalesUnits).sum());
            planDataForDigital.setSalesDollars(monthPlanData.stream().mapToLong(PlanData::getSalesDollars).sum());
            planDataForDigital.setBopUnits(monthPlanData.stream().mapToLong(PlanData::getBopUnits).sum());
            planDataForDigital.setCost(monthPlanData.stream().mapToLong(PlanData::getCost).sum());
            planDataForDigital.setDoorCount(monthPlanData.stream().mapToLong(PlanData::getDoorCount).sum());
            planDataForDigital.setReceiptsDollars(monthPlanData.stream().mapToLong(PlanData::getReceiptsDollars).sum());
            planDataForDigital.setReceiptsUnits(monthPlanData.stream().mapToLong(PlanData::getReceiptsUnits).sum());
            planDataForDigital.setSellThruPercent(monthPlanData.stream().mapToLong(PlanData::getSellThruPercent).sum());
            planDataForDigital.setStyleColorCount(monthPlanData.stream().mapToLong(PlanData::getStyleColorCount).sum());
            planDataForDigital.setTicketAUR(monthPlanData.stream().mapToLong(PlanData::getTicketAUR).sum());
            planDataForDigital.setStartFiscalDate(monthPlanData.get(0).getStartFiscalDate());
            planDataForDigital.setEndFiscalDate(monthPlanData.get(monthPlanData.size() - 1).getEndFiscalDate());
            monthsPlanDataListForDigital.add(planDataForDigital);

            PlanData planDataForStore = new PlanData();
            planDataForStore.setSalesUnits(monthPlanData.stream().mapToLong(PlanData::getSalesUnits).sum());
            planDataForStore.setSalesDollars(monthPlanData.stream().mapToLong(PlanData::getSalesDollars).sum());
            planDataForStore.setBopUnits(monthPlanData.stream().mapToLong(PlanData::getBopUnits).sum());
            planDataForStore.setCost(monthPlanData.stream().mapToLong(PlanData::getCost).sum());
            planDataForStore.setDoorCount(monthPlanData.stream().mapToLong(PlanData::getDoorCount).sum());
            planDataForStore.setReceiptsDollars(monthPlanData.stream().mapToLong(PlanData::getReceiptsDollars).sum());
            planDataForStore.setReceiptsUnits(monthPlanData.stream().mapToLong(PlanData::getReceiptsUnits).sum());
            planDataForStore.setSellThruPercent(monthPlanData.stream().mapToLong(PlanData::getSellThruPercent).sum());
            planDataForStore.setStyleColorCount(monthPlanData.stream().mapToLong(PlanData::getStyleColorCount).sum());
            planDataForStore.setTicketAUR(monthPlanData.stream().mapToLong(PlanData::getTicketAUR).sum());
            planDataForStore.setStartFiscalDate(monthPlanData.get(0).getStartFiscalDate());
            planDataForStore.setEndFiscalDate(monthPlanData.get(monthPlanData.size() - 1).getEndFiscalDate());
            monthsPlanDataListForStore.add(planDataForStore);

            PlanData planDataForOmni = new PlanData();
            planDataForOmni.setSalesUnits(monthPlanData.stream().mapToLong(PlanData::getSalesUnits).sum());
            planDataForOmni.setSalesDollars(monthPlanData.stream().mapToLong(PlanData::getSalesDollars).sum());
            planDataForOmni.setBopUnits(monthPlanData.stream().mapToLong(PlanData::getBopUnits).sum());
            planDataForOmni.setCost(monthPlanData.stream().mapToLong(PlanData::getCost).sum());
            planDataForOmni.setDoorCount(monthPlanData.stream().mapToLong(PlanData::getDoorCount).sum());
            planDataForOmni.setReceiptsDollars(monthPlanData.stream().mapToLong(PlanData::getReceiptsDollars).sum());
            planDataForOmni.setReceiptsUnits(monthPlanData.stream().mapToLong(PlanData::getReceiptsUnits).sum());
            planDataForOmni.setSellThruPercent(monthPlanData.stream().mapToLong(PlanData::getSellThruPercent).sum());
            planDataForOmni.setStyleColorCount(monthPlanData.stream().mapToLong(PlanData::getStyleColorCount).sum());
            planDataForOmni.setTicketAUR(monthPlanData.stream().mapToLong(PlanData::getTicketAUR).sum());
            planDataForOmni.setStartFiscalDate(monthPlanData.get(0).getStartFiscalDate());
            planDataForOmni.setEndFiscalDate(monthPlanData.get(monthPlanData.size() - 1).getEndFiscalDate());
            monthsPlanDataListForOmni.add(planDataForOmni);

            beginIndex = endIndex;
            endIndex = (i == (totalMonths - 2)) ? endIndex + value.getEndFiscalDate().getFiscalWeek().getWeekNumber() : endIndex + 4;
        }

        value.getDigitalChannelPlan().setMonthPlanData(monthsPlanDataListForDigital);
        value.getStoreChannelPlan().setMonthPlanData(monthsPlanDataListForStore);
        value.getOmniChannelPlan().setMonthPlanData(monthsPlanDataListForOmni);

        entry.setValue(value);
        return null;
    }
}
