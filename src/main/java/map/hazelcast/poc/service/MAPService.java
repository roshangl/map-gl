package map.hazelcast.poc.service;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.ui.response.ProgramRowResponse;
import map.hazelcast.poc.ui.response.TimePeriodGroup;

import java.util.List;

public interface MAPService {

    List<ProgramRowResponse> findProgramRows(String startDate, String endDate, TimePeriodGroup timePeriodGroup);

    List<ProgramRow> findAggregatePrograms();
}
