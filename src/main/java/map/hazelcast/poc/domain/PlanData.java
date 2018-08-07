package map.hazelcast.poc.domain;

import java.io.Serializable;

public class PlanData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long salesUnits;
    private Long salesDollars;
    private Long sellThruPercent;
    private Long receiptsUnits;
    private Long receiptsDollars;
    private Long bopUnits;
    private Long doorCount;
    private Long styleColorCount;
    private Long ticketAUR;
    private Long cost;
    private FiscalDate startFiscalDate;
    private FiscalDate endFiscalDate;
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getSalesUnits() {
        return salesUnits;
    }

    public void setSalesUnits(Long salesUnits) {
        this.salesUnits = salesUnits;
    }

    public Long getSalesDollars() {
        return salesDollars;
    }

    public void setSalesDollars(Long salesDollars) {
        this.salesDollars = salesDollars;
    }

    public Long getSellThruPercent() {
        return sellThruPercent;
    }

    public void setSellThruPercent(Long sellThruPercent) {
        this.sellThruPercent = sellThruPercent;
    }

    public Long getReceiptsUnits() {
        return receiptsUnits;
    }

    public void setReceiptsUnits(Long receiptsUnits) {
        this.receiptsUnits = receiptsUnits;
    }

    public Long getReceiptsDollars() {
        return receiptsDollars;
    }

    public void setReceiptsDollars(Long receiptsDollars) {
        this.receiptsDollars = receiptsDollars;
    }

    public Long getBopUnits() {
        return bopUnits;
    }

    public void setBopUnits(Long bopUnits) {
        this.bopUnits = bopUnits;
    }

    public Long getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(Long doorCount) {
        this.doorCount = doorCount;
    }

    public Long getStyleColorCount() {
        return styleColorCount;
    }

    public void setStyleColorCount(Long styleColorCount) {
        this.styleColorCount = styleColorCount;
    }

    public Long getTicketAUR() {
        return ticketAUR;
    }

    public void setTicketAUR(Long ticketAUR) {
        this.ticketAUR = ticketAUR;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public FiscalDate getStartFiscalDate() {
        return startFiscalDate;
    }

    public void setStartFiscalDate(FiscalDate startFiscalDate) {
        this.startFiscalDate = startFiscalDate;
    }

    public FiscalDate getEndFiscalDate() {
        return endFiscalDate;
    }

    public void setEndFiscalDate(FiscalDate endFiscalDate) {
        this.endFiscalDate = endFiscalDate;
    }
}
