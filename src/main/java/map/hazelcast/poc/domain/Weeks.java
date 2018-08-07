package map.hazelcast.poc.domain;

public enum Weeks {
    WK1("WK1", 1),
    WK2("WK2", 2),
    WK3("WK3", 3),
    WK4("WK4", 4);

    private String weekName;
    private int weekNumber;

    Weeks() {
    }

    Weeks(String weekName, int weekNumber) {
        this.weekName = weekName;
        this.weekNumber = weekNumber;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }
}
