package map.hazelcast.poc.util;

import map.hazelcast.poc.domain.FiscalDate;
import map.hazelcast.poc.domain.Months;
import map.hazelcast.poc.domain.Weeks;

import java.util.Arrays;

public class MapUtility {

    public static FiscalDate convertToFiscalDate(String startDate) {
        String[] split = startDate.split(" ");
        FiscalDate fiscalDate = new FiscalDate();

        Months month = Arrays.stream(Months.values())
                .filter(m -> m.getMonthName().equalsIgnoreCase(split[0])).findFirst().orElse(null);
        Weeks week = Arrays.stream(Weeks.values())
                .filter(w -> w.getWeekName().equalsIgnoreCase(split[1])).findFirst().orElse(null);

        fiscalDate.setFiscalMonth(month);
        fiscalDate.setFiscalWeek(week);
        fiscalDate.setFiscalYear(Integer.parseInt(split[2]));
        return fiscalDate;
    }
}
