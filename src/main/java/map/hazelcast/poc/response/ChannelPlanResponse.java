package map.hazelcast.poc.response;

import java.io.Serializable;

public class ChannelPlanResponse implements Serializable {
  	private static final long serialVersionUID = 1L;
	private ChannelPlanEnumResponse planName;
    private Long value;

    public ChannelPlanEnumResponse getPlanName() {
        return planName;
    }

    public void setPlanName(ChannelPlanEnumResponse planName) {
        this.planName = planName;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
