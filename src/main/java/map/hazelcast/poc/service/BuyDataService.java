package map.hazelcast.poc.service;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.response.TimePeriodGroup;

public interface BuyDataService {
    ProgramRow getBuyData(String tyProgram, TimePeriodGroup timePeriodGroup);
}
