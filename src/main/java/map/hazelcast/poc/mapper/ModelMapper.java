package map.hazelcast.poc.mapper;

import map.hazelcast.poc.domain.FiscalDate;
import map.hazelcast.poc.domain.PlanData;
import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.domain.PlanDataDateColumns;
import map.hazelcast.poc.domain.PlanDataLongColumns;
import map.hazelcast.poc.response.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ModelMapper {

    public List<ProgramRowResponse> transformProgramRow(ProgramRow kp2Data, ProgramRow lyData, ProgramRow buyData, TimePeriodGroup timePeriodGroup) {
        List<ProgramRowResponse> responses = new ArrayList<>();
        switch (timePeriodGroup) {
            case WEEK:
                IntStream.range(0, kp2Data.getOmniChannelPlan().getWeekPlanData().size()).parallel().forEach(i ->
                {
                    ProgramRowResponse finalResponse = new ProgramRowResponse();
                    finalResponse.setTyProgram(kp2Data.getTyProgram());
                    finalResponse.setLyProgram(kp2Data.getLyProgram());
                    finalResponse.setOmniChannelPlan(getChannelPlanData(kp2Data.getOmniChannelPlan().getWeekPlanData().get(i),
                            lyData.getOmniChannelPlan().getWeekPlanData().get(i),
                            buyData.getOmniChannelPlan().getWeekPlanData().get(i),
                            1));
                    finalResponse.setStoreChannelPlan(getChannelPlanData(kp2Data.getStoreChannelPlan().getWeekPlanData().get(i),
                            lyData.getStoreChannelPlan().getWeekPlanData().get(i),
                            buyData.getStoreChannelPlan().getWeekPlanData().get(i),
                            2));
                    finalResponse.setDigitalChannelPlan(getChannelPlanData(kp2Data.getDigitalChannelPlan().getWeekPlanData().get(i),
                            lyData.getDigitalChannelPlan().getWeekPlanData().get(i),
                            buyData.getDigitalChannelPlan().getWeekPlanData().get(i),
                            3));
                    responses.add(finalResponse);
                });
                break;
            case MONTH:
                IntStream.range(0, kp2Data.getOmniChannelPlan().getMonthPlanData().size()).parallel().forEach(i ->
                {
                    ProgramRowResponse finalResponse = new ProgramRowResponse();
                    finalResponse.setTyProgram(kp2Data.getTyProgram());
                    finalResponse.setLyProgram(kp2Data.getLyProgram());
                    finalResponse.setOmniChannelPlan(getChannelPlanData(kp2Data.getOmniChannelPlan().getMonthPlanData().get(i),
                            lyData.getOmniChannelPlan().getMonthPlanData().get(i),
                            buyData.getOmniChannelPlan().getMonthPlanData().get(i),
                            1));
                    finalResponse.setStoreChannelPlan(getChannelPlanData(kp2Data.getStoreChannelPlan().getMonthPlanData().get(i),
                            lyData.getStoreChannelPlan().getMonthPlanData().get(i),
                            buyData.getStoreChannelPlan().getMonthPlanData().get(i),
                            2));
                    finalResponse.setDigitalChannelPlan(getChannelPlanData(kp2Data.getDigitalChannelPlan().getMonthPlanData().get(i),
                            lyData.getDigitalChannelPlan().getMonthPlanData().get(i),
                            buyData.getDigitalChannelPlan().getMonthPlanData().get(i),
                            3));
                    responses.add(finalResponse);
                });
                break;
            case QUARTER:
                break;
            case DYNAMIC:
                ProgramRowResponse finalResponse = new ProgramRowResponse();
                finalResponse.setTyProgram(kp2Data.getTyProgram());
                finalResponse.setLyProgram(kp2Data.getLyProgram());
                finalResponse.setOmniChannelPlan(getChannelPlanData(kp2Data.getOmniChannelPlan().getDynamicPlanData(),
                        lyData.getOmniChannelPlan().getDynamicPlanData(),
                        buyData.getOmniChannelPlan().getDynamicPlanData(),
                        1));
                finalResponse.setStoreChannelPlan(getChannelPlanData(kp2Data.getStoreChannelPlan().getDynamicPlanData(),
                        lyData.getStoreChannelPlan().getDynamicPlanData(),
                        buyData.getStoreChannelPlan().getDynamicPlanData(),
                        2));
                finalResponse.setDigitalChannelPlan(getChannelPlanData(kp2Data.getDigitalChannelPlan().getDynamicPlanData(),
                        lyData.getDigitalChannelPlan().getDynamicPlanData(),
                        buyData.getDigitalChannelPlan().getDynamicPlanData(),
                        3));
                responses.add(finalResponse);
                break;
        }
        return responses;
    }

    private PlanDataResponse getChannelPlanData(PlanData kp2PlanData, PlanData lyPlanData, PlanData buyPlanData, int i) {
        PlanDataResponse planDataResponse = new PlanDataResponse();
        Arrays.stream(PlanDataLongColumns.values()).parallel().forEach(temp -> getLongPlanData(planDataResponse, kp2PlanData, lyPlanData, buyPlanData, temp));
        Arrays.stream(PlanDataDateColumns.values()).parallel().forEach(date -> getDatePlanData(planDataResponse, kp2PlanData, lyPlanData, buyPlanData, date));
        return planDataResponse;
    }

    private void getDatePlanData(PlanDataResponse planDataResponse, PlanData kp2PlanData, PlanData lyPlanData, PlanData buyPlanData, PlanDataDateColumns date) {
        String value = date.getValue();
        List<FiscalDateResponse> fiscalDates = new ArrayList<>();

        FiscalDateResponse fiscalDateKp2 = new FiscalDateResponse();
        FiscalDateResponse fiscalDateLy = new FiscalDateResponse();
        FiscalDateResponse fiscalDateBuy = new FiscalDateResponse();
        FiscalDateResponse fiscalDatePlan = new FiscalDateResponse();
        fiscalDateKp2.setPlanName(ChannelPlanEnumResponse.KP2);
        fiscalDateLy.setPlanName(ChannelPlanEnumResponse.LY);
        fiscalDateBuy.setPlanName(ChannelPlanEnumResponse.BUY);
        fiscalDatePlan.setPlanName(ChannelPlanEnumResponse.PLAN);
        Object returnValueKp2 = null;
        Object returnValueLy = null;
        Object returnValueBuy = null;
        try {
            Method methodKp2 = kp2PlanData.getClass().getMethod("get" + value);
            Method methodLy = lyPlanData.getClass().getMethod("get" + value);
            Method methodBuy = buyPlanData.getClass().getMethod("get" + value);
            methodKp2.invoke(kp2PlanData, null);
            returnValueKp2 = methodKp2.invoke(kp2PlanData, null);
            methodLy.invoke(lyPlanData, null);
            returnValueLy = methodLy.invoke(lyPlanData, null);
            methodBuy.invoke(buyPlanData, null);
            returnValueBuy = methodBuy.invoke(buyPlanData, null);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        FiscalDate fetchedFiscalDateKp2 = (FiscalDate) returnValueKp2;
        fiscalDateKp2.setFiscalMonth(fetchedFiscalDateKp2.getFiscalMonth().getMonthName());
        fiscalDateKp2.setFiscalWeek(fetchedFiscalDateKp2.getFiscalWeek().getWeekName());
        fiscalDates.add(fiscalDateKp2);

        FiscalDate fetchedFiscalDateLy = (FiscalDate) returnValueLy;
        fiscalDateLy.setFiscalMonth(fetchedFiscalDateLy.getFiscalMonth().getMonthName());
        fiscalDateLy.setFiscalWeek(fetchedFiscalDateLy.getFiscalWeek().getWeekName());
        fiscalDates.add(fiscalDateLy);

        FiscalDate fetchedFiscalDateBuy = (FiscalDate) returnValueBuy;
        fiscalDateBuy.setFiscalMonth(fetchedFiscalDateBuy.getFiscalMonth().getMonthName());
        fiscalDateBuy.setFiscalWeek(fetchedFiscalDateBuy.getFiscalWeek().getWeekName());
        fiscalDates.add(fiscalDateBuy);

        fiscalDatePlan.setFiscalMonth(null);
        fiscalDatePlan.setFiscalWeek(null);
        fiscalDates.add(fiscalDatePlan);

        try {
            Method responseMethod = planDataResponse.getClass().getMethod("set" + value, fiscalDates.getClass());
            responseMethod.invoke(planDataResponse, fiscalDates);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public void getLongPlanData(PlanDataResponse planDataResponse, PlanData kp2PlanData, PlanData lyPlanData, PlanData buyPlanData, PlanDataLongColumns temp) {
        String value = temp.getValue();
        List<ChannelPlanResponse> channelPlanResponses = new ArrayList<>();

        ChannelPlanResponse channelPlanResponseKp2 = new ChannelPlanResponse();
        ChannelPlanResponse channelPlanResponseLy = new ChannelPlanResponse();
        ChannelPlanResponse channelPlanResponseBuy = new ChannelPlanResponse();
        ChannelPlanResponse channelPlanResponsePlan = new ChannelPlanResponse();

        channelPlanResponseKp2.setPlanName(ChannelPlanEnumResponse.KP2);
        channelPlanResponseLy.setPlanName(ChannelPlanEnumResponse.LY);
        channelPlanResponseBuy.setPlanName(ChannelPlanEnumResponse.BUY);
        channelPlanResponsePlan.setPlanName(ChannelPlanEnumResponse.PLAN);

        try {
            Method methodKp2 = kp2PlanData.getClass().getMethod("get" + value);
            Method methodLy = lyPlanData.getClass().getMethod("get" + value);
            Method methodBuy = buyPlanData.getClass().getMethod("get" + value);

            methodKp2.invoke(kp2PlanData, null);
            Object returnValueKp2 = methodKp2.invoke(kp2PlanData, null);
            methodLy.invoke(lyPlanData, null);
            Object returnValueLy = methodLy.invoke(lyPlanData, null);
            methodBuy.invoke(buyPlanData, null);
            Object returnValueBuy = methodBuy.invoke(buyPlanData, null);

            channelPlanResponseKp2.setValue((Long) returnValueKp2);
            channelPlanResponseLy.setValue((Long) returnValueLy);
            channelPlanResponseBuy.setValue((Long) returnValueBuy);
            channelPlanResponsePlan.setValue(null);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        channelPlanResponses.add(channelPlanResponseKp2);
        channelPlanResponses.add(channelPlanResponseLy);
        channelPlanResponses.add(channelPlanResponseBuy);
        channelPlanResponses.add(channelPlanResponsePlan);
        try {
            Method responseMethod = planDataResponse.getClass().getDeclaredMethod("set" + value, channelPlanResponses.getClass());
            responseMethod.invoke(planDataResponse, channelPlanResponses);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
