package map.hazelcast.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import map.hazelcast.poc.domain.ProgramRow;
import map.hazelcast.poc.service.MapDataGeneratorService;

@RestController
@RequestMapping("/map")
public class MockProgramController {

    @Autowired
    private MapDataGeneratorService mapDataGeneratorService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/kp2")
    public List<ProgramRow> getKp2DataPlanWise() {
        return mapDataGeneratorService.getKp2Data();
    }

    @GetMapping("/ly")
    public List<ProgramRow> getLyDataPlanWise() {
        return mapDataGeneratorService.getLyData();
    }

    @GetMapping("/buy")
    public List<ProgramRow> getBuyDataPlanWise() {
        return mapDataGeneratorService.getBuyData();
    }


    @PostMapping("/kp2")
    public void cacheKp2Data(@RequestBody List<ProgramRow> programRows) {
        Cache cache = cacheManager.getCache("kp2Cache");
        programRows.forEach(p -> cache.put(p.getTyProgram(), p));
    }

    @PostMapping("/ly")
    public void cacheLyData(@RequestBody List<ProgramRow> programRows) {
        Cache cache = cacheManager.getCache("lyCache");
        programRows.forEach(p -> cache.put(p.getTyProgram(), p));
    }

    @PostMapping("/buy")
    public void cacheBuyData(@RequestBody List<ProgramRow> programRows) {
        Cache cache = cacheManager.getCache("buyCache");
        programRows.forEach(p -> cache.put(p.getTyProgram(), p));
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
