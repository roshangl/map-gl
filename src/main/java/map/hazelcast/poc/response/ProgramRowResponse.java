package map.hazelcast.poc.response;

import java.io.Serializable;
import java.util.List;

public class ProgramRowResponse implements Serializable {
    private String tyProgram;
    private List<String> lyProgram;
    private PlanDataResponse omniChannelPlan;
    private PlanDataResponse digitalChannelPlan;
    private PlanDataResponse storeChannelPlan;

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

    public PlanDataResponse getOmniChannelPlan() {
        return omniChannelPlan;
    }

    public void setOmniChannelPlan(PlanDataResponse omniChannelPlan) {
        this.omniChannelPlan = omniChannelPlan;
    }

    public PlanDataResponse getDigitalChannelPlan() {
        return digitalChannelPlan;
    }

    public void setDigitalChannelPlan(PlanDataResponse digitalChannelPlan) {
        this.digitalChannelPlan = digitalChannelPlan;
    }

    public PlanDataResponse getStoreChannelPlan() {
        return storeChannelPlan;
    }

    public void setStoreChannelPlan(PlanDataResponse storeChannelPlan) {
        this.storeChannelPlan = storeChannelPlan;
    }
}
