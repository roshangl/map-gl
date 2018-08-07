package map.hazelcast.poc.service.impl;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.entryprocessor.DateIntializerEntryProcessor;
import map.hazelcast.poc.entryprocessor.ProgramRowDynamicEntryProcessor;
import map.hazelcast.poc.entryprocessor.ProgramRowMonthEntryProcessor;
import map.hazelcast.poc.model.CacheType;
import map.hazelcast.poc.service.BuyDataService;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.EntryObject;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder;
import map.hazelcast.poc.ui.response.TimePeriodGroup;
import org.springframework.stereotype.Service;

@Service
public class BuyDataServiceImpl implements BuyDataService {

    @Override
    public ProgramRow getBuyData(String tyProgram, TimePeriodGroup timePeriodGroup) {
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.BUYCACHE.getValue());
        map.executeOnEntries(new DateIntializerEntryProcessor());
        EntryObject entryObject = new PredicateBuilder().getEntryObject();
        Predicate predicate = entryObject.get("tyProgram").equal(tyProgram);

        switch (timePeriodGroup) {
            case WEEK:
                break;
            case MONTH:
                map.executeOnEntries(new ProgramRowMonthEntryProcessor(), predicate);
                break;
            case QUARTER:
                //TODO
                break;
            case DYNAMIC:
                map.executeOnEntries(new ProgramRowDynamicEntryProcessor(), predicate);
                break;
        }

        return map.values(predicate).stream().findAny().orElse(null);
    }
}
