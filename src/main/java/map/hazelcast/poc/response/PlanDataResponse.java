package map.hazelcast.poc.response;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanDataResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<ChannelPlanResponse> salesUnits;
    private ArrayList<ChannelPlanResponse> salesDollars;
    private ArrayList<ChannelPlanResponse> sellThruPercent;
    private ArrayList<ChannelPlanResponse> receiptsUnits;
    private ArrayList<ChannelPlanResponse> receiptsDollars;
    private ArrayList<ChannelPlanResponse> bopUnits;
    private ArrayList<ChannelPlanResponse> doorCount;
    private ArrayList<ChannelPlanResponse> styleColorCount;
    private ArrayList<ChannelPlanResponse> ticketAUR;
    private ArrayList<ChannelPlanResponse> cost;
    private ArrayList<FiscalDateResponse> startFiscalDate;
    private ArrayList<FiscalDateResponse> endFiscalDate;

    public ArrayList<ChannelPlanResponse> getSalesUnits() {
        return salesUnits;
    }

    public void setSalesUnits(ArrayList<ChannelPlanResponse> salesUnits) {
        this.salesUnits = salesUnits;
    }

    public ArrayList<ChannelPlanResponse> getSalesDollars() {
        return salesDollars;
    }

    public void setSalesDollars(ArrayList<ChannelPlanResponse> salesDollars) {
        this.salesDollars = salesDollars;
    }

    public ArrayList<ChannelPlanResponse> getSellThruPercent() {
        return sellThruPercent;
    }

    public void setSellThruPercent(ArrayList<ChannelPlanResponse> sellThruPercent) {
        this.sellThruPercent = sellThruPercent;
    }

    public ArrayList<ChannelPlanResponse> getReceiptsUnits() {
        return receiptsUnits;
    }

    public void setReceiptsUnits(ArrayList<ChannelPlanResponse> receiptsUnits) {
        this.receiptsUnits = receiptsUnits;
    }

    public ArrayList<ChannelPlanResponse> getReceiptsDollars() {
        return receiptsDollars;
    }

    public void setReceiptsDollars(ArrayList<ChannelPlanResponse> receiptsDollars) {
        this.receiptsDollars = receiptsDollars;
    }

    public ArrayList<ChannelPlanResponse> getBopUnits() {
        return bopUnits;
    }

    public void setBopUnits(ArrayList<ChannelPlanResponse> bopUnits) {
        this.bopUnits = bopUnits;
    }

    public ArrayList<ChannelPlanResponse> getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(ArrayList<ChannelPlanResponse> doorCount) {
        this.doorCount = doorCount;
    }

    public ArrayList<ChannelPlanResponse> getStyleColorCount() {
        return styleColorCount;
    }

    public void setStyleColorCount(ArrayList<ChannelPlanResponse> styleColorCount) {
        this.styleColorCount = styleColorCount;
    }

    public ArrayList<ChannelPlanResponse> getTicketAUR() {
        return ticketAUR;
    }

    public void setTicketAUR(ArrayList<ChannelPlanResponse> ticketAUR) {
        this.ticketAUR = ticketAUR;
    }

    public ArrayList<ChannelPlanResponse> getCost() {
        return cost;
    }

    public void setCost(ArrayList<ChannelPlanResponse> cost) {
        this.cost = cost;
    }

    public ArrayList<FiscalDateResponse> getStartFiscalDate() {
        return startFiscalDate;
    }

    public void setStartFiscalDate(ArrayList<FiscalDateResponse> startFiscalDate) {
        this.startFiscalDate = startFiscalDate;
    }

    public ArrayList<FiscalDateResponse> getEndFiscalDate() {
        return endFiscalDate;
    }

    public void setEndFiscalDate(ArrayList<FiscalDateResponse> endFiscalDate) {
        this.endFiscalDate = endFiscalDate;
    }
}
