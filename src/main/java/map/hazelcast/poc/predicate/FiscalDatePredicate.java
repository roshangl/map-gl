package map.hazelcast.poc.predicate;

import com.hazelcast.query.Predicate;
import map.hazelcast.poc.domain.FiscalDate;
import map.hazelcast.poc.domain.ProgramRow;

import java.util.Map;

public class FiscalDatePredicate implements Predicate<String, ProgramRow> {

    private FiscalDate inputStartFiscalDate;
    private FiscalDate inputEndFiscalDate;

    public FiscalDatePredicate() {
    }

    public FiscalDatePredicate(FiscalDate comparableStartFiscalDate, FiscalDate comparableEndFiscalDate) {
        this.inputStartFiscalDate = comparableStartFiscalDate;
        this.inputEndFiscalDate = comparableEndFiscalDate;
    }

    @Override
    public boolean apply(Map.Entry<String, ProgramRow> mapEntry) {
        ProgramRow value = mapEntry.getValue();
        FiscalDate startFiscalDate = value.getStartFiscalDate();
        FiscalDate endFiscalDate = value.getEndFiscalDate();

        if (startFiscalDate.getFiscalYear() > inputStartFiscalDate.getFiscalYear()) {
            if (endFiscalDate.getFiscalYear() < inputEndFiscalDate.getFiscalYear()) {
                return true;
            } else if (endFiscalDate.getFiscalYear() == inputEndFiscalDate.getFiscalYear()) {
                if(endFiscalDate.getFiscalMonth().getMonthNumber() < inputEndFiscalDate.getFiscalMonth().getMonthNumber()){
                    return true;
                }else if(endFiscalDate.getFiscalMonth().getMonthNumber() == inputEndFiscalDate.getFiscalMonth().getMonthNumber()){
                    if(endFiscalDate.getFiscalWeek().getWeekNumber() <= inputEndFiscalDate.getFiscalWeek().getWeekNumber()){
                        return true;
                    }
                }
            }
        } else if (startFiscalDate.getFiscalYear() == inputStartFiscalDate.getFiscalYear()) {
            if (startFiscalDate.getFiscalMonth().getMonthNumber() > inputStartFiscalDate.getFiscalMonth().getMonthNumber()) {
                if (endFiscalDate.getFiscalMonth().getMonthNumber() < inputEndFiscalDate.getFiscalMonth().getMonthNumber()) {
                    return true;
                } else if (endFiscalDate.getFiscalMonth().getMonthNumber() == inputEndFiscalDate.getFiscalMonth().getMonthNumber()) {
                    if (endFiscalDate.getFiscalWeek().getWeekNumber() <= inputEndFiscalDate.getFiscalWeek().getWeekNumber()) {
                        return true;
                    }
                }
            }else if(startFiscalDate.getFiscalMonth().getMonthNumber() == inputStartFiscalDate.getFiscalMonth().getMonthNumber()){
                if(startFiscalDate.getFiscalWeek().getWeekNumber() >= inputStartFiscalDate.getFiscalWeek().getWeekNumber()){
                    if (endFiscalDate.getFiscalYear() < inputEndFiscalDate.getFiscalYear()) {
                        return true;
                    } else if (endFiscalDate.getFiscalYear() == inputEndFiscalDate.getFiscalYear()) {
                        if(endFiscalDate.getFiscalMonth().getMonthNumber() < inputEndFiscalDate.getFiscalMonth().getMonthNumber()){
                            return true;
                        }else if(endFiscalDate.getFiscalMonth().getMonthNumber() == inputEndFiscalDate.getFiscalMonth().getMonthNumber()){
                            if(endFiscalDate.getFiscalWeek().getWeekNumber() <= inputEndFiscalDate.getFiscalWeek().getWeekNumber()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
