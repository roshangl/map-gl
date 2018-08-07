package map.hazelcast.poc.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import map.hazelcast.poc.domain.FiscalDate;
import map.hazelcast.poc.domain.Months;
import map.hazelcast.poc.domain.Weeks;
import map.hazelcast.poc.ui.response.TimePeriodGroup;
import map.hazelcast.poc.util.MapUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.mapper.ModelMapper;
import map.hazelcast.poc.service.BuyDataService;
import map.hazelcast.poc.service.Kp2DataService;
import map.hazelcast.poc.service.LyDataService;
import map.hazelcast.poc.service.MAPService;
import map.hazelcast.poc.ui.response.ProgramRowResponse;

@Service
public class MAPServiceImpl implements MAPService {

    @Autowired
    private Kp2DataService kp2DataService;

    @Autowired
    private LyDataService lyDataService;

    @Autowired
    private BuyDataService buyDataService;

    private ModelMapper mapper;

    @Override
    public List<ProgramRowResponse> findProgramRows(String startDate, String endDate, TimePeriodGroup timePeriodGroup) {
        FiscalDate startFiscalDate = MapUtility.convertToFiscalDate(startDate);
        FiscalDate endFiscalDate = MapUtility.convertToFiscalDate(endDate);
        List<ProgramRowResponse> programRowsResult = new ArrayList<>();
        mapper = new ModelMapper();
        List<ProgramRow> kp2DataList = kp2DataService.getKp2Data(startFiscalDate, endFiscalDate, timePeriodGroup);
        kp2DataList.forEach(kp2Data -> {
            ProgramRow lyData = lyDataService.getLyData(kp2Data.getLyProgram(), timePeriodGroup);
            ProgramRow buyData = buyDataService.getBuyData(kp2Data.getTyProgram(), timePeriodGroup);

            List<ProgramRowResponse> programRowResponse = mapper.transformProgramRow(kp2Data, lyData, buyData, timePeriodGroup);
            programRowsResult.addAll(programRowResponse);
        });
        System.out.println("Total: " + programRowsResult.size());
        return programRowsResult;
    }



    @Override
    public List<ProgramRow> findAggregatePrograms() {
        return kp2DataService.getAggregateData();
    }
}
