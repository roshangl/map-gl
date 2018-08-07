package map.hazelcast.poc.domain;

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
