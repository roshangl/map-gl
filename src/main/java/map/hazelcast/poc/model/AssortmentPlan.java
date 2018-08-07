package map.hazelcast.poc.model;

import map.hazelcast.poc.domain.ProgramRow;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "AssortmentPlan")
public class AssortmentPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long planId;
    private String planName;
    private String startFiscalDate;
    private String endFiscalDate;
    private String buyer;
    private String department;
    private List<String> classes;
    private List<String> subClasses;
    private List<ProgramRow> programRows;
    private String lineLevel;
    private String subTotal;
    private String total;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public List<ProgramRow> getProgramRows() {
        return programRows;
    }

    public void setProgramRows(List<ProgramRow> programRows) {
        this.programRows = programRows;
    }

    public String getLineLevel() {
        return lineLevel;
    }

    public void setLineLevel(String lineLevel) {
        this.lineLevel = lineLevel;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

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
