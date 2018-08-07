package map.hazelcast.poc.service.impl;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.EntryObject;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder;
import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.entryprocessor.DateIntializerEntryProcessor;
import map.hazelcast.poc.entryprocessor.ProgramRowDynamicEntryProcessor;
import map.hazelcast.poc.entryprocessor.ProgramRowMonthEntryProcessor;
import map.hazelcast.poc.domain.CacheType;
import map.hazelcast.poc.response.TimePeriodGroup;
import map.hazelcast.poc.service.BuyDataService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyDataServiceImpl implements BuyDataService {

    @Override
    public ProgramRow getBuyData(String tyProgram, TimePeriodGroup timePeriodGroup) {
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        //IMap<String, ProgramRow> map = hz.getMap(CacheType.BUY_CACHE_LOCAL.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.BUY_CACHE.getValue());

        EntryObject entryObject = new PredicateBuilder().getEntryObject();
        Predicate predicate = entryObject.get("tyProgram").equal(tyProgram);

        switch (timePeriodGroup) {
            case WEEK:
                break;
            case MONTH:
                Optional<String> any = map.keySet().parallelStream().filter(i -> map.get(i).getStoreChannelPlan().getMonthPlanData().isEmpty()).findAny();
                if(any.isPresent()){
                    map.executeOnEntries(new ProgramRowMonthEntryProcessor(), predicate);
                }
                break;
            case QUARTER:
                //TODO
                break;
            case DYNAMIC:
                Optional<String> any1 = map.keySet().parallelStream().filter(i -> map.get(i).getStoreChannelPlan().getDynamicPlanData() == null).findAny();
                if(any1.isPresent()){
                    map.executeOnEntries(new ProgramRowDynamicEntryProcessor(), predicate);
                }
                break;
        }

        return map.values(predicate).stream().findAny().orElse(null);
    }
}
