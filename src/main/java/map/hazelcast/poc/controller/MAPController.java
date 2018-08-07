package map.hazelcast.poc.controller;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.response.ProgramRowResponse;
import map.hazelcast.poc.response.TimePeriodGroup;
import map.hazelcast.poc.service.MAPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
public class MAPController {

    @Autowired
    private MAPService mapService;

    @CrossOrigin(origins = "http://172.16.34.142:4200")
    @GetMapping
    public List<ProgramRowResponse> findProgramRowsForDates(@RequestParam(name = "startDate", required = false, defaultValue = "JAN WK1 2000") String startDate,
                                                            @RequestParam(name = "endDate", required = false, defaultValue = "JAN WK1 2030") String endDate,
                                                            @RequestParam(name = "timePeriodGroup", required = false) TimePeriodGroup timePeriodGroup) {
        if (timePeriodGroup == null) {
            timePeriodGroup = TimePeriodGroup.DYNAMIC;
        }
        return mapService.findProgramRows(startDate, endDate, timePeriodGroup);
    }

    @GetMapping("/aggregate")
    public List<ProgramRow> aggregatePrograms() {
        return mapService.findAggregatePrograms();
    }
}
