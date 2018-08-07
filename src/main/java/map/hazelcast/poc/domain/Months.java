package map.hazelcast.poc.domain;

public enum Months {
    JAN("JAN", 1),
    FEB("FEB", 2),
    MAR("MAR", 3),
    APR("APR", 4),
    MAY("MAY", 5),
    JUN("JUN", 6),
    JUL("JUL", 7),
    AUG("AUG", 8),
    SEP("SEP", 9),
    OCT("OCT", 10),
    NOV("NOV", 11),
    DEC("DEC", 12);

    private String monthName;
    private int monthNumber;

    Months(String monthName, int monthNumber) {
        this.monthName = monthName;
        this.monthNumber = monthNumber;
    }

    public String getMonthName() {
        return monthName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }
}
