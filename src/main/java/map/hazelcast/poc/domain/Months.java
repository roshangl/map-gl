package map.hazelcast.poc.domain;

public enum Months {

    JAN("Jan", 1),
    FEB("Feb", 2),
    MAR("Mar", 3),
    APR("Apr", 4),
    MAY("May", 5),
    JUN("Jun", 6),
    JUL("Jul", 7),
    AUG("Aug", 8),
    SEP("Sep", 9),
    OCT("Oct", 10),
    NOV("Nov", 11),
    DEC("Dec", 12);

    private String monthName;
    private int monthNumber;

    Months() {
    }

    Months(String monthName, int monthNumber) {
        this.monthName = monthName;
        this.monthNumber = monthNumber;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }
}
