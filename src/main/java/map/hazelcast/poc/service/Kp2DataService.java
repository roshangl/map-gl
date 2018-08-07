package map.hazelcast.poc.service;

import map.hazelcast.poc.domain.FiscalDate;
import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.response.TimePeriodGroup;

import java.util.List;

public interface Kp2DataService {

    List<ProgramRow> getKp2Data(FiscalDate startDate, FiscalDate endDate, TimePeriodGroup timePeriodGroup);

    List<ProgramRow> getAggregateData();
}
