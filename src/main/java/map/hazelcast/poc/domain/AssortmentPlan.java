package map.hazelcast.poc.domain;

import java.io.Serializable;
import java.util.List;

public class AssortmentPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    private String planName;
    private String startFiscalDate;
    private String endFiscalDate;
    private String buyer;
    private String department;
    private List<String> classes;
    private List<String> subClasses;

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getStartFiscalDate() {
        return startFiscalDate;
    }

    public void setStartFiscalDate(String startFiscalDate) {
        this.startFiscalDate = startFiscalDate;
    }

    public String getEndFiscalDate() {
        return endFiscalDate;
    }

    public void setEndFiscalDate(String endFiscalDate) {
        this.endFiscalDate = endFiscalDate;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public List<String> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<String> subClasses) {
        this.subClasses = subClasses;
    }
}
