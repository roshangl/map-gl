package map.hazelcast.poc.service;

import java.util.List;

import map.hazelcast.poc.domain.FiscalDate;
import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.ui.response.TimePeriodGroup;

public interface Kp2DataService {

    List<ProgramRow> getKp2Data(FiscalDate startDate, FiscalDate endDate, TimePeriodGroup timePeriodGroup);

    List<ProgramRow> getAggregateData();
}
