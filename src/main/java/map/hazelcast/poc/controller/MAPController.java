package map.hazelcast.poc.controller;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.service.MAPService;
import map.hazelcast.poc.ui.response.ProgramRowResponse;
import map.hazelcast.poc.ui.response.TimePeriodGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
public class MAPController {

    @Autowired
    private MAPService mapService;

    @GetMapping
    public List<ProgramRowResponse> findProgramRowsForDates(@RequestParam("startDate") String startDate,
                                                            @RequestParam("endDate") String endDate,
                                                            @RequestParam("timePeriodGroup") TimePeriodGroup timePeriodGroup) {
        return mapService.findProgramRows(startDate, endDate, timePeriodGroup);
    }

    @GetMapping("/aggregate")
    public List<ProgramRow> aggregatePrograms() {
        return mapService.findAggregatePrograms();
    }
}
