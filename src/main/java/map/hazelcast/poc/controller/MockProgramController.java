package map.hazelcast.poc.controller;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import map.hazelcast.poc.domain.CacheType;
import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.entryprocessor.DateIntializerEntryProcessor;
import map.hazelcast.poc.service.MapDataGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
public class MockProgramController {

    @Autowired
    private MapDataGeneratorService mapDataGeneratorService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/kp2/{numberOfPrograms}/{numberOfWeeks}")
    public List<ProgramRow> getKp2DataPlanWise(@PathVariable("numberOfPrograms") int numberOfPrograms,
                                               @PathVariable("numberOfWeeks") int numberOfWeeks) {
        return mapDataGeneratorService.getKp2Data(numberOfPrograms, numberOfWeeks);
    }

    @GetMapping("/ly/{numberOfPrograms}/{numberOfWeeks}")
    public List<ProgramRow> getLyDataPlanWise(@PathVariable("numberOfPrograms") int numberOfPrograms,
                                              @PathVariable("numberOfWeeks") int numberOfWeeks) {
        return mapDataGeneratorService.getLyData(numberOfPrograms, numberOfWeeks);
    }

    @GetMapping("/buy/{numberOfPrograms}/{numberOfWeeks}")
    public List<ProgramRow> getBuyDataPlanWise(@PathVariable("numberOfPrograms") int numberOfPrograms,
                                               @PathVariable("numberOfWeeks") int numberOfWeeks) {
        return mapDataGeneratorService.getBuyData(numberOfPrograms, numberOfWeeks);
    }


    @PostMapping("/kp2")
    public void cacheKp2Data(@RequestBody List<ProgramRow> programRows) {
        //Cache cache = cacheManager.getCache(CacheType.KP2_CACHE_LOCAL.getValue());
        Cache cache = cacheManager.getCache(CacheType.KP2_CACHE.getValue());
        programRows.forEach(p -> cache.put(p.getTyProgram(), p));
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        //IMap<String, ProgramRow> map = hz.getMap(CacheType.KP2_CACHE_LOCAL.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.KP2_CACHE.getValue());
        map.executeOnEntries(new DateIntializerEntryProcessor());
    }

    @PostMapping("/ly")
    public void cacheLyData(@RequestBody List<ProgramRow> programRows) {
        //Cache cache = cacheManager.getCache(CacheType.LY_CACHE_LOCAL.getValue());
        Cache cache = cacheManager.getCache(CacheType.LY_CACHE.getValue());
        programRows.forEach(p -> cache.put(p.getTyProgram(), p));
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        //IMap<String, ProgramRow> map = hz.getMap(CacheType.LY_CACHE_LOCAL.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.LY_CACHE.getValue());
        map.executeOnEntries(new DateIntializerEntryProcessor());
    }

    @PostMapping("/buy")
    public void cacheBuyData(@RequestBody List<ProgramRow> programRows) {
        //Cache cache = cacheManager.getCache(CacheType.BUY_CACHE_LOCAL.getValue());
        Cache cache = cacheManager.getCache(CacheType.BUY_CACHE.getValue());
        programRows.forEach(p -> cache.put(p.getTyProgram(), p));
        HazelcastInstance hz = Hazelcast.getHazelcastInstanceByName(CacheType.HAZELCAST_CACHE.getValue());
        //IMap<String, ProgramRow> map = hz.getMap(CacheType.BUY_CACHE_LOCAL.getValue());
        IMap<String, ProgramRow> map = hz.getMap(CacheType.BUY_CACHE.getValue());
        map.executeOnEntries(new DateIntializerEntryProcessor());
    }

    /*programRows.forEach(p -> {
            ChannelPlanResponse omniChannelPlan = p.getOmniChannelPlan();
            IntStream.rangeClosed(0, omniChannelPlan.getKp2PlanDatas().size() - 1).forEach(i -> {
                Cache omniChannelKp2Cache = cacheManager.getCache("omniChannelKp2");
                String key = p.getTyProgram().concat("-omni").concat("-kp2").concat("-" + i);
                PlanDataResponse planData = omniChannelPlan.getKp2PlanDatas().get(i);
                omniChannelKp2Cache.put(key, planData);
            });
            IntStream.rangeClosed(0, omniChannelPlan.getLyPlanDatas().size() - 1).forEach(i -> {
                Cache omniChannelLyCache = cacheManager.getCache("omniChannelLy");
                String key = p.getTyProgram().concat("-omni").concat("-ly").concat("-" + i);
                PlanDataResponse planData = omniChannelPlan.getLyPlanDatas().get(i);
                omniChannelLyCache.put(key, planData);
            });
            ChannelPlanResponse storeChannelPlan = p.getStoreChannelPlan();
            IntStream.rangeClosed(0, storeChannelPlan.getKp2PlanDatas().size() - 1).forEach(i -> {
                Cache storeChannelKp2Cache = cacheManager.getCache("storeChannelKp2");
                String key = p.getTyProgram().concat("-store").concat("-kp2").concat("-" + i);
                PlanDataResponse planData = storeChannelPlan.getKp2PlanDatas().get(i);
                storeChannelKp2Cache.put(key, planData);
            });
            IntStream.rangeClosed(0, storeChannelPlan.getLyPlanDatas().size() - 1).forEach(i -> {
                Cache storeChannelLyCache = cacheManager.getCache("storeChannelLy");
                String key = p.getTyProgram().concat("-store").concat("-ly").concat("-" + i);
                PlanDataResponse planData = storeChannelPlan.getLyPlanDatas().get(i);
                storeChannelLyCache.put(key, planData);
            });
            ChannelPlanResponse digitalChannelPlan = p.getDigitalChannelPlan();
            IntStream.rangeClosed(0, digitalChannelPlan.getKp2PlanDatas().size() - 1).forEach(i -> {
                Cache digitalChannelKp2Cache = cacheManager.getCache("digitalChannelKp2");
                String key = p.getTyProgram().concat("-digital").concat("-kp2").concat("-" + i);
                PlanDataResponse planData = digitalChannelPlan.getKp2PlanDatas().get(i);
                digitalChannelKp2Cache.put(key, planData);
            });
            IntStream.rangeClosed(0, digitalChannelPlan.getLyPlanDatas().size() - 1).forEach(i -> {
                Cache digitalChannelLyCache = cacheManager.getCache("digitalChannelLy");
                String key = p.getTyProgram().concat("-digital").concat("-ly").concat("-" + i);
                PlanDataResponse planData = digitalChannelPlan.getLyPlanDatas().get(i);
                digitalChannelLyCache.put(key, planData);
            });
        });*/
}
