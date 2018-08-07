package map.hazelcast.poc.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;

import map.hazelcast.poc.model.CacheType;

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
        config.getMapConfigs().put(CacheType.KP2CACHE.getValue(), kp2Cache);

        MapConfig lyCache = new MapConfig();
        lyCache.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put(CacheType.LYCACHE.getValue(), lyCache);

        MapConfig buyCache = new MapConfig();
        buyCache.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put(CacheType.BUYCACHE.getValue(), buyCache);

        return config;
    }

}