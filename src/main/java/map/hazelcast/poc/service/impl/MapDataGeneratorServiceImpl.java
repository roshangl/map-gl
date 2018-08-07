package map.hazelcast.poc.service.impl;

import map.hazelcast.poc.domain.*;
import map.hazelcast.poc.service.MapDataGeneratorService;
import map.hazelcast.poc.util.MapUtility;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

@Service
public class MapDataGeneratorServiceImpl implements MapDataGeneratorService {

    @Override
    public List<ProgramRow> getKp2Data(int numberOfPrograms, int numberOfWeeks) {
        List<ProgramRow> programRows = new ArrayList<>();
        IntStream.rangeClosed(1, numberOfPrograms).forEach(i -> {
            ProgramRow programRow = new ProgramRow();
            programRow.setTyProgram("Program Plan " + i + " 2018");
            programRow.setLyProgram(Arrays.asList("Program Plan " + i + " 2017"));

            Map<Integer, String> weekMonthMap = new HashMap<>();
            IntStream.rangeClosed(1, numberOfWeeks).forEach(value -> {
                //Months monthValue = Arrays.stream(Months.values()).filter(months -> months.getMonthNumber() == value).findFirst().orElse(null);
                Months monthValue = Months.JAN;
                Weeks weekValue = Arrays.stream(Weeks.values()).filter(weeks -> weeks.getWeekNumber() == (value>4 ? (value % 4):value)).findFirst().orElse(null);
                weekMonthMap.put(value, monthValue.getMonthName() + " " + weekValue.getWeekName() + " 2018");
            });

            ChannelPlan storeChannelPlan = new ChannelPlan();
            List<PlanData> storePlanDataList = new ArrayList<>();
            IntStream.rangeClosed(1, numberOfWeeks).forEach(j -> {
                PlanData storePlanData = new PlanData();
                storePlanData.setSalesUnits(j * 10000l + j);
                storePlanData.setSalesDollars(j * 10000l + j);
                storePlanData.setBopUnits(j * 10000l + j);
                storePlanData.setCost(j * 10000l + j);
                storePlanData.setDoorCount(j * 100l + j);
                storePlanData.setStartFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                storePlanData.setEndFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                storePlanData.setReceiptsUnits(j * 10000l + j);
                storePlanData.setReceiptsDollars(j * 10000l + j);
                storePlanData.setSellThruPercent(j * 10l + j);
                storePlanData.setStyleColorCount(j * 100l + j);
                storePlanData.setTicketAUR(j * 100l + j);
                storePlanDataList.add(storePlanData);
            });

            storeChannelPlan.setWeekPlanData(storePlanDataList);
            programRow.setStoreChannelPlan(storeChannelPlan);

            ChannelPlan digitalChannelPlan = new ChannelPlan();
            List<PlanData> digitalPlanDataList = new ArrayList<>();
            IntStream.rangeClosed(1, numberOfWeeks).forEach(j -> {
                PlanData digitalPlanData = new PlanData();
                digitalPlanData.setSalesUnits(j * 11000l + j);
                digitalPlanData.setSalesDollars(j * 11000l + j);
                digitalPlanData.setBopUnits(j * 11000l + j);
                digitalPlanData.setCost(j * 11000l + j);
                digitalPlanData.setDoorCount(j * 110l + j);
                digitalPlanData.setStartFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                digitalPlanData.setEndFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                digitalPlanData.setReceiptsUnits(j * 11000l + j);
                digitalPlanData.setReceiptsDollars(j * 11000l + j);
                digitalPlanData.setSellThruPercent(j * 11l + j);
                digitalPlanData.setStyleColorCount(j * 110l + j);
                digitalPlanData.setTicketAUR(j * 110l + j);
                digitalPlanDataList.add(digitalPlanData);
            });

            digitalChannelPlan.setWeekPlanData(digitalPlanDataList);
            programRow.setDigitalChannelPlan(digitalChannelPlan);

            ChannelPlan omniChannelPlan = new ChannelPlan();
            List<PlanData> omniPlanDataList = new ArrayList<>();
            IntStream.rangeClosed(0, numberOfWeeks - 1).forEach(j -> {
                PlanData omniPlanData = new PlanData();
                omniPlanData.setSalesUnits(storePlanDataList.get(j).getSalesUnits() + digitalPlanDataList.get(j).getSalesUnits());
                omniPlanData.setSalesDollars(storePlanDataList.get(j).getSalesDollars() + digitalPlanDataList.get(j).getSalesDollars());
                omniPlanData.setBopUnits(storePlanDataList.get(j).getBopUnits() + digitalPlanDataList.get(j).getBopUnits());
                omniPlanData.setCost(storePlanDataList.get(j).getCost() + digitalPlanDataList.get(j).getCost());
                omniPlanData.setDoorCount(storePlanDataList.get(j).getDoorCount() + digitalPlanDataList.get(j).getDoorCount());
                omniPlanData.setStartFiscalDate(storePlanDataList.get(j).getStartFiscalDate());
                omniPlanData.setEndFiscalDate(storePlanDataList.get(j).getEndFiscalDate());
                omniPlanData.setReceiptsUnits(storePlanDataList.get(j).getReceiptsUnits() + digitalPlanDataList.get(j).getReceiptsUnits());
                omniPlanData.setReceiptsDollars(storePlanDataList.get(j).getReceiptsDollars() + digitalPlanDataList.get(j).getReceiptsDollars());
                omniPlanData.setSellThruPercent(storePlanDataList.get(j).getSellThruPercent() + digitalPlanDataList.get(j).getSellThruPercent());
                omniPlanData.setStyleColorCount(storePlanDataList.get(j).getStyleColorCount() + digitalPlanDataList.get(j).getStyleColorCount());
                omniPlanData.setTicketAUR(storePlanDataList.get(j).getTicketAUR() + digitalPlanDataList.get(j).getTicketAUR());
                omniPlanDataList.add(omniPlanData);
            });

            omniChannelPlan.setWeekPlanData(omniPlanDataList);
            programRow.setOmniChannelPlan(omniChannelPlan);

            programRows.add(programRow);
        });
        return programRows;
    }

    @Override
    public List<ProgramRow> getLyData(int numberOfPrograms, int numberOfWeeks) {
        List<ProgramRow> programRows = new ArrayList<>();
        IntStream.rangeClosed(1, numberOfPrograms).forEach(i -> {
            //if (i % 2 != 0) {
            ProgramRow programRow = new ProgramRow();
            programRow.setTyProgram("Program Plan " + i + " 2017");

            Map<Integer, String> weekMonthMap = new HashMap<>();
            IntStream.rangeClosed(1, numberOfWeeks).forEach(value -> {
                //Months monthValue = Arrays.stream(Months.values()).filter(months -> months.getMonthNumber() == value).findFirst().orElse(null);
                Months monthValue = Months.JAN;
                Weeks weekValue = Arrays.stream(Weeks.values()).filter(weeks -> weeks.getWeekNumber() == (value>4 ? (value % 4):value)).findFirst().orElse(null);
                weekMonthMap.put(value, monthValue.getMonthName() + " " + weekValue.getWeekName() + " 2018");
            });

            ChannelPlan storeChannelPlan = new ChannelPlan();
            List<PlanData> storePlanDataList = new ArrayList<>();
            IntStream.rangeClosed(1, numberOfWeeks).forEach(j -> {
                PlanData storePlanData = new PlanData();
                storePlanData.setSalesUnits(j * 10000l + j);
                storePlanData.setSalesDollars(j * 10000l + j);
                storePlanData.setBopUnits(j * 10000l + j);
                storePlanData.setCost(j * 10000l + j);
                storePlanData.setDoorCount(j * 100l + j);
                storePlanData.setStartFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                storePlanData.setEndFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                storePlanData.setReceiptsUnits(j * 10000l + j);
                storePlanData.setReceiptsDollars(j * 10000l + j);
                storePlanData.setSellThruPercent(j * 10l + j);
                storePlanData.setStyleColorCount(j * 100l + j);
                storePlanData.setTicketAUR(j * 100l + j);
                storePlanDataList.add(storePlanData);
            });

            storeChannelPlan.setWeekPlanData(storePlanDataList);
            programRow.setStoreChannelPlan(storeChannelPlan);

            ChannelPlan digitalChannelPlan = new ChannelPlan();
            List<PlanData> digitalPlanDataList = new ArrayList<>();
            IntStream.rangeClosed(1, numberOfWeeks).forEach(j -> {
                PlanData digitalPlanData = new PlanData();
                digitalPlanData.setSalesUnits(j * 11000l + j);
                digitalPlanData.setSalesDollars(j * 11000l + j);
                digitalPlanData.setBopUnits(j * 11000l + j);
                digitalPlanData.setCost(j * 11000l + j);
                digitalPlanData.setDoorCount(j * 110l + j);
                digitalPlanData.setStartFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                digitalPlanData.setEndFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                digitalPlanData.setReceiptsUnits(j * 11000l + j);
                digitalPlanData.setReceiptsDollars(j * 11000l + j);
                digitalPlanData.setSellThruPercent(j * 11l + j);
                digitalPlanData.setStyleColorCount(j * 110l + j);
                digitalPlanData.setTicketAUR(j * 110l + j);
                digitalPlanDataList.add(digitalPlanData);
            });

            digitalChannelPlan.setWeekPlanData(digitalPlanDataList);
            programRow.setDigitalChannelPlan(digitalChannelPlan);

            ChannelPlan omniChannelPlan = new ChannelPlan();
            List<PlanData> omniPlanDataList = new ArrayList<>();
            IntStream.rangeClosed(0, numberOfWeeks - 1).forEach(j -> {
                PlanData omniPlanData = new PlanData();
                omniPlanData.setSalesUnits(storePlanDataList.get(j).getSalesUnits() + digitalPlanDataList.get(j).getSalesUnits());
                omniPlanData.setSalesDollars(storePlanDataList.get(j).getSalesDollars() + digitalPlanDataList.get(j).getSalesDollars());
                omniPlanData.setBopUnits(storePlanDataList.get(j).getBopUnits() + digitalPlanDataList.get(j).getBopUnits());
                omniPlanData.setCost(storePlanDataList.get(j).getCost() + digitalPlanDataList.get(j).getCost());
                omniPlanData.setDoorCount(storePlanDataList.get(j).getDoorCount() + digitalPlanDataList.get(j).getDoorCount());
                omniPlanData.setStartFiscalDate(storePlanDataList.get(j).getStartFiscalDate());
                omniPlanData.setEndFiscalDate(storePlanDataList.get(j).getEndFiscalDate());
                omniPlanData.setReceiptsUnits(storePlanDataList.get(j).getReceiptsUnits() + digitalPlanDataList.get(j).getReceiptsUnits());
                omniPlanData.setReceiptsDollars(storePlanDataList.get(j).getReceiptsDollars() + digitalPlanDataList.get(j).getReceiptsDollars());
                omniPlanData.setSellThruPercent(storePlanDataList.get(j).getSellThruPercent() + digitalPlanDataList.get(j).getSellThruPercent());
                omniPlanData.setStyleColorCount(storePlanDataList.get(j).getStyleColorCount() + digitalPlanDataList.get(j).getStyleColorCount());
                omniPlanData.setTicketAUR(storePlanDataList.get(j).getTicketAUR() + digitalPlanDataList.get(j).getTicketAUR());
                omniPlanDataList.add(omniPlanData);
            });

            omniChannelPlan.setWeekPlanData(omniPlanDataList);
            programRow.setOmniChannelPlan(omniChannelPlan);
            programRows.add(programRow);
            //}
        });
        return programRows;
    }

    @Override
    public List<ProgramRow> getBuyData(int numberOfPrograms, int numberOfWeeks) {
        List<ProgramRow> programRows = new ArrayList<>();
        IntStream.rangeClosed(1, numberOfPrograms).forEach(i -> {
            // if (i % 2 != 0) {
            ProgramRow programRow = new ProgramRow();
            programRow.setTyProgram("Program Plan " + i + " 2018");

            Map<Integer, String> weekMonthMap = new HashMap<>();
            IntStream.rangeClosed(1, numberOfWeeks).forEach(value -> {
                //Months monthValue = Arrays.stream(Months.values()).filter(months -> months.getMonthNumber() == value).findFirst().orElse(null);
                Months monthValue = Months.JAN;
                Weeks weekValue = Arrays.stream(Weeks.values()).filter(weeks -> weeks.getWeekNumber() == (value>4 ? (value % 4):value)).findFirst().orElse(null);
                weekMonthMap.put(value, monthValue.getMonthName() + " " + weekValue.getWeekName() + " 2018");
            });

            ChannelPlan storeChannelPlan = new ChannelPlan();
            List<PlanData> storePlanDataList = new ArrayList<>();
            IntStream.rangeClosed(1, 4).forEach(j -> {
                PlanData storePlanData = new PlanData();
                storePlanData.setSalesUnits(j * 10000l + j);
                storePlanData.setSalesDollars(j * 10000l + j);
                storePlanData.setBopUnits(j * 10000l + j);
                storePlanData.setCost(j * 10000l + j);
                storePlanData.setDoorCount(j * 100l + j);
                storePlanData.setStartFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                storePlanData.setEndFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                storePlanData.setReceiptsUnits(j * 10000l + j);
                storePlanData.setReceiptsDollars(j * 10000l + j);
                storePlanData.setSellThruPercent(j * 10l + j);
                storePlanData.setStyleColorCount(j * 100l + j);
                storePlanData.setTicketAUR(j * 100l + j);
                storePlanDataList.add(storePlanData);
            });

            storeChannelPlan.setWeekPlanData(storePlanDataList);
            programRow.setStoreChannelPlan(storeChannelPlan);

            ChannelPlan digitalChannelPlan = new ChannelPlan();
            List<PlanData> digitalPlanDataList = new ArrayList<>();
            IntStream.rangeClosed(1, 4).forEach(j -> {
                PlanData digitalPlanData = new PlanData();
                digitalPlanData.setSalesUnits(j * 11000l + j);
                digitalPlanData.setSalesDollars(j * 11000l + j);
                digitalPlanData.setBopUnits(j * 11000l + j);
                digitalPlanData.setCost(j * 11000l + j);
                digitalPlanData.setDoorCount(j * 110l + j);
                digitalPlanData.setStartFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                digitalPlanData.setEndFiscalDate(MapUtility.convertToFiscalDate(weekMonthMap.get(j)));
                digitalPlanData.setReceiptsUnits(j * 11000l + j);
                digitalPlanData.setReceiptsDollars(j * 11000l + j);
                digitalPlanData.setSellThruPercent(j * 11l + j);
                digitalPlanData.setStyleColorCount(j * 110l + j);
                digitalPlanData.setTicketAUR(j * 110l + j);
                digitalPlanDataList.add(digitalPlanData);
            });

            digitalChannelPlan.setWeekPlanData(digitalPlanDataList);
            programRow.setDigitalChannelPlan(digitalChannelPlan);

            ChannelPlan omniChannelPlan = new ChannelPlan();
            List<PlanData> omniPlanDataList = new ArrayList<>();
            IntStream.rangeClosed(0, 3).forEach(j -> {
                PlanData omniPlanData = new PlanData();
                omniPlanData.setSalesUnits(storePlanDataList.get(j).getSalesUnits() + digitalPlanDataList.get(j).getSalesUnits());
                omniPlanData.setSalesDollars(storePlanDataList.get(j).getSalesDollars() + digitalPlanDataList.get(j).getSalesDollars());
                omniPlanData.setBopUnits(storePlanDataList.get(j).getBopUnits() + digitalPlanDataList.get(j).getBopUnits());
                omniPlanData.setCost(storePlanDataList.get(j).getCost() + digitalPlanDataList.get(j).getCost());
                omniPlanData.setDoorCount(storePlanDataList.get(j).getDoorCount() + digitalPlanDataList.get(j).getDoorCount());
                omniPlanData.setStartFiscalDate(storePlanDataList.get(j).getStartFiscalDate());
                omniPlanData.setEndFiscalDate(storePlanDataList.get(j).getEndFiscalDate());
                omniPlanData.setReceiptsUnits(storePlanDataList.get(j).getReceiptsUnits() + digitalPlanDataList.get(j).getReceiptsUnits());
                omniPlanData.setReceiptsDollars(storePlanDataList.get(j).getReceiptsDollars() + digitalPlanDataList.get(j).getReceiptsDollars());
                omniPlanData.setSellThruPercent(storePlanDataList.get(j).getSellThruPercent() + digitalPlanDataList.get(j).getSellThruPercent());
                omniPlanData.setStyleColorCount(storePlanDataList.get(j).getStyleColorCount() + digitalPlanDataList.get(j).getStyleColorCount());
                omniPlanData.setTicketAUR(storePlanDataList.get(j).getTicketAUR() + digitalPlanDataList.get(j).getTicketAUR());
                omniPlanDataList.add(omniPlanData);
            });

            omniChannelPlan.setWeekPlanData(omniPlanDataList);
            programRow.setOmniChannelPlan(omniChannelPlan);
            programRows.add(programRow);
            // }
        });
        return programRows;
    }
}
