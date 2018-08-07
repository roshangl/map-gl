package map.hazelcast.poc.domain;

import java.io.Serializable;

public class FiscalDate implements Serializable {

    private Months fiscalMonth;
    private Weeks fiscalWeek;
    private int fiscalYear;

    public Months getFiscalMonth() {
        return fiscalMonth;
    }

    public void setFiscalMonth(Months fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
    }

    public Weeks getFiscalWeek() {
        return fiscalWeek;
    }

    public void setFiscalWeek(Weeks fiscalWeek) {
        this.fiscalWeek = fiscalWeek;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    @Override
    public String toString() {
        return fiscalMonth + " " + fiscalWeek + " " + fiscalYear;
    }
}
