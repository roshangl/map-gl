package map.hazelcast.poc.ui.response;

import java.io.Serializable;

public class FiscalDateResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fiscalMonth;
    private String fiscalWeek;
    private ChannelPlanEnumResponse planName;
    
    public FiscalDateResponse(){ }

    public FiscalDateResponse(String fiscalMonth, String fiscalWeek) {
        this.fiscalMonth = fiscalMonth;
        this.fiscalWeek = fiscalWeek;
    }

    public String getFiscalMonth() {
        return fiscalMonth;
    }

    public void setFiscalMonth(String fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
    }

    public String getFiscalWeek() {
        return fiscalWeek;
    }

    public void setFiscalWeek(String fiscalWeek) {
        this.fiscalWeek = fiscalWeek;
    }

	public ChannelPlanEnumResponse getPlanName() {
		return planName;
	}

	public void setPlanName(ChannelPlanEnumResponse planName) {
		this.planName = planName;
	}
}
