package map.hazelcast.poc.domain;

public enum CacheType {
    KP2_CACHE("kp2Cache"),
    LY_CACHE("lyCache"),
    BUY_CACHE("buyCache"),
    KP2_CACHE_LOCAL("kp2CacheLocal"),
    LY_CACHE_LOCAL("lyCacheLocal"),
    BUY_CACHE_LOCAL("buyCacheLocal"),
    HAZELCAST_CACHE("hazelcast-cache");

    CacheType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
