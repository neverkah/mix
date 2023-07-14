import java.time.LocalDate;


public class DateRange {

    private LocalDate beginDate;
    private LocalDate endDate;

    public DateRange(LocalDate beginDate, LocalDate endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
