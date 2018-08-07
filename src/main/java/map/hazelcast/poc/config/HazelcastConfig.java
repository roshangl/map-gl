package map.hazelcast.poc.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import map.hazelcast.poc.domain.CacheType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    public Config hazelCastConfig() {

        Config config = new Config();
        config.setInstanceName(CacheType.HAZELCAST_CACHE.getValue());

        MapConfig kp2Cache = new MapConfig();
        kp2Cache.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put(CacheType.KP2_CACHE.getValue(), kp2Cache);

        MapConfig lyCache = new MapConfig();
        lyCache.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put(CacheType.LY_CACHE.getValue(), lyCache);

        MapConfig buyCache = new MapConfig();
        buyCache.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put(CacheType.BUY_CACHE.getValue(), buyCache);

        MapConfig kp2CacheLocal = new MapConfig();
        kp2CacheLocal.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put(CacheType.KP2_CACHE_LOCAL.getValue(), kp2CacheLocal);

        MapConfig lyCacheLocal = new MapConfig();
        lyCacheLocal.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put(CacheType.LY_CACHE_LOCAL.getValue(), lyCacheLocal);

        MapConfig buyCacheLocal = new MapConfig();
        buyCacheLocal.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put(CacheType.BUY_CACHE_LOCAL.getValue(), buyCacheLocal);

        return config;
    }

}