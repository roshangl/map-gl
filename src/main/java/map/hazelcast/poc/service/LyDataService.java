package map.hazelcast.poc.service;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.response.TimePeriodGroup;

import java.util.List;

public interface LyDataService {
    ProgramRow getLyData(List<String> lyProgram, TimePeriodGroup timePeriodGroup);
}
