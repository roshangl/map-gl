package map.hazelcast.poc.model;

public enum PlanDataDateColumns {
	START_FISCAL_DATE("StartFiscalDate"),
	END_FISCAL_DATE("EndFiscalDate");
	
	PlanDataDateColumns(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
