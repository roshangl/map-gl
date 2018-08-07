package map.hazelcast.poc.model;

public enum CacheType {
    KP2CACHE("kp2Cache"),
    LYCACHE("lyCache"),
    BUYCACHE("buyCache"),
    HAZELCAST_CACHE("hazelcast-cache");

    CacheType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
