package map.hazelcast.poc.model;

public enum PlanDataLongColumns {
	SALES_UNIT("SalesUnits"),
	SALES_DOLLAR("SalesDollars"),
	SELL_THRU_PERCENT("SellThruPercent"),
	RECIEPT_UNIT("ReceiptsUnits"),
	RECIEPT_DOLLAR("ReceiptsDollars"),
	BOP_UNITS("BopUnits"),
	DOOR_UNIT("DoorCount"),
	STYLE_COLOR_COUNT("StyleColorCount"),
	TICKET_AUR("TicketAUR"),
	COST("Cost");
	
	PlanDataLongColumns(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
