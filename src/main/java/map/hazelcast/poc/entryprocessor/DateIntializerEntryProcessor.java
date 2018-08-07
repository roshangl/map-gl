package map.hazelcast.poc.entryprocessor;

import com.hazelcast.map.AbstractEntryProcessor;
import map.hazelcast.poc.domain.ProgramRow;

import java.util.Map;

public class DateIntializerEntryProcessor extends AbstractEntryProcessor<String, ProgramRow> {

    @Override
    public Object process(Map.Entry<String, ProgramRow> entry) {
        ProgramRow value = entry.getValue();
        int noOfWeeks = value.getStoreChannelPlan().getWeekPlanData().size();
        value.setStartFiscalDate(value.getStoreChannelPlan().getWeekPlanData().get(0).getStartFiscalDate());
        value.setEndFiscalDate(value.getStoreChannelPlan().getWeekPlanData().get(noOfWeeks-1).getEndFiscalDate());
        entry.setValue(value);
        return null;
    }
}
