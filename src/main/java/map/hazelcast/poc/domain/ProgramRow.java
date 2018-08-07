package map.hazelcast.poc.domain;

import java.io.Serializable;
import java.util.List;

public class ProgramRow implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tyProgram;
    private List<String> lyProgram;
    private ChannelPlan omniChannelPlan;
    private ChannelPlan digitalChannelPlan;
    private ChannelPlan storeChannelPlan;
    private FiscalDate startFiscalDate;
    private FiscalDate endFiscalDate;

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

    public String getTyProgram() {
        return tyProgram;
    }

    public void setTyProgram(String tyProgram) {
        this.tyProgram = tyProgram;
    }

    public List<String> getLyProgram() {
        return lyProgram;
    }

    public void setLyProgram(List<String> lyProgram) {
        this.lyProgram = lyProgram;
    }

    public ChannelPlan getOmniChannelPlan() {
        return omniChannelPlan;
    }

    public void setOmniChannelPlan(ChannelPlan omniChannelPlan) {
        this.omniChannelPlan = omniChannelPlan;
    }

    public ChannelPlan getDigitalChannelPlan() {
        return digitalChannelPlan;
    }

    public void setDigitalChannelPlan(ChannelPlan digitalChannelPlan) {
        this.digitalChannelPlan = digitalChannelPlan;
    }

    public ChannelPlan getStoreChannelPlan() {
        return storeChannelPlan;
    }

    public void setStoreChannelPlan(ChannelPlan storeChannelPlan) {
        this.storeChannelPlan = storeChannelPlan;
    }
}
