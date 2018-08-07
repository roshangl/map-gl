package map.hazelcast.poc.ui.response;

public enum TimePeriodGroup {
    WEEK("Week Wise"),
    MONTH("Month Wise"),
    QUARTER("Quarter Wise"),
    DYNAMIC("Complete Period");

    private String value;

    TimePeriodGroup() {
    }

    TimePeriodGroup(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
