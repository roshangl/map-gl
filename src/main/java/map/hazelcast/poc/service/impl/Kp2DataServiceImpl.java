package map.hazelcast.poc.service.impl;

import com.hazelcast.query.EntryObject;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder;
import map.hazelcast.poc.domain.FiscalDate;
import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.entryprocessor.DateIntializerEntryProcessor;
import map.hazelcast.poc.entryprocessor.ProgramRowDynamicEntryProcessor;
import map.hazelcast.poc.entryprocessor.ProgramRowMonthEntryProcessor;
import map.hazelcast.poc.model.CacheType;
import map.hazelcast.poc.predicate.FiscalDatePredicate;
import map.hazelcast.poc.service.Kp2DataService;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import map.hazelcast.poc.ui.response.TimePeriodGroup;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class Kp2DataServiceImpl implements Kp2DataService {

    @Override
    public List<ProgramRow> getKp2Data(FiscalDate startDate, FiscalDate endDate, TimePeriodGroup timePeriodGroup) {
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.KP2CACHE.getValue());
        map.executeOnEntries(new DateIntializerEntryProcessor());

        Predicate datePredicate = new FiscalDatePredicate(startDate, endDate);

        switch (timePeriodGroup) {
            case WEEK:
                break;
            case MONTH:
                map.executeOnEntries(new ProgramRowMonthEntryProcessor(), datePredicate);
                break;
            case QUARTER:
                //TODO
                break;
            case DYNAMIC:
                map.executeOnEntries(new ProgramRowDynamicEntryProcessor(), datePredicate);
                break;
        }
        return new ArrayList<>(map.values(datePredicate));
    }

    @Override
    public List<ProgramRow> getAggregateData() {
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.KP2CACHE.getValue());
        StopWatch st = new StopWatch();
        st.start();
        map.executeOnEntries(new ProgramRowDynamicEntryProcessor());
        st.stop();
        System.out.println(st.getTotalTimeMillis());
        Collection<ProgramRow> values = map.values();

        return new ArrayList<>(values);
    }
}
