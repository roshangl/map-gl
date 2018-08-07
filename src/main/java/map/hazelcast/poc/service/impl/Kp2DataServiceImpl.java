package map.hazelcast.poc.service.impl;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicate;
import map.hazelcast.poc.domain.FiscalDate;
import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.entryprocessor.DateIntializerEntryProcessor;
import map.hazelcast.poc.entryprocessor.ProgramRowDynamicEntryProcessor;
import map.hazelcast.poc.entryprocessor.ProgramRowMonthEntryProcessor;
import map.hazelcast.poc.domain.CacheType;
import map.hazelcast.poc.predicate.FiscalDatePredicate;
import map.hazelcast.poc.response.TimePeriodGroup;
import map.hazelcast.poc.service.Kp2DataService;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class Kp2DataServiceImpl implements Kp2DataService {

    @Override
    public List<ProgramRow> getKp2Data(FiscalDate startDate, FiscalDate endDate, TimePeriodGroup timePeriodGroup) {
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        //IMap<String, ProgramRow> map = hz.getMap(CacheType.KP2_CACHE_LOCAL.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.KP2_CACHE.getValue());
        Predicate datePredicate = new FiscalDatePredicate(startDate, endDate);

        switch (timePeriodGroup) {
            case WEEK:
                break;
            case MONTH:
                Optional<String> any = map.keySet().parallelStream().filter(i -> map.get(i).getStoreChannelPlan().getMonthPlanData().isEmpty()).findAny();
                if(any.isPresent()){
                    map.executeOnEntries(new ProgramRowMonthEntryProcessor(), datePredicate);
                }
                break;
            case QUARTER:
                //TODO
                break;
            case DYNAMIC:
                Optional<String> any1 = map.keySet().parallelStream().filter(i -> map.get(i).getStoreChannelPlan().getDynamicPlanData() == null).findAny();
                if(any1.isPresent()){
                    map.executeOnEntries(new ProgramRowDynamicEntryProcessor(), datePredicate);
                }
                break;
        }
        return new ArrayList<>(map.values(datePredicate));
    }

    @Override
    public List<ProgramRow> getAggregateData() {
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.KP2_CACHE.getValue());
        StopWatch st = new StopWatch();
        st.start();
        map.executeOnEntries(new ProgramRowDynamicEntryProcessor());
        st.stop();
        System.out.println(st.getTotalTimeMillis());
        Collection<ProgramRow> values = map.values();

        return new ArrayList<>(values);
    }
}
