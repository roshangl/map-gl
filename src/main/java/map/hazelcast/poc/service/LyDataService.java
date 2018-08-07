package map.hazelcast.poc.service;

import java.util.List;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.ui.response.TimePeriodGroup;

public interface LyDataService {
    ProgramRow getLyData(List<String> lyProgram, TimePeriodGroup timePeriodGroup);
}
