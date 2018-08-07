package map.hazelcast.poc.ui.response;

public enum ChannelPlanEnumResponse {
    KP2("KP2"), BUY("Buy"), PLAN("Plan"), LY("Ly") ;

    private String value;

    private ChannelPlanEnumResponse(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
