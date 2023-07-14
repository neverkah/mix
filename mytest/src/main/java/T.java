import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class T {

    public static void main(String[] args) {


    }

    @Test
    public void test() {
        DateRange dateRange = new DateRange(LocalDate.of(2023, 3, 1), LocalDate.of(2023, 2, 23));
        List<DateRange> dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 0;
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 3, 1), LocalDate.of(2023, 4, 1));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 2;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 3, 1), LocalDate.of(2023, 5, 23));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 3;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 3, 1), LocalDate.of(2023, 6, 30));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 4;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 2, 16), LocalDate.of(2023, 4, 1));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 3;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 1, 13), LocalDate.of(2023, 5, 23));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 5;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 3, 18), LocalDate.of(2023, 6, 30));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 4;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 2, 28), LocalDate.of(2023, 4, 1));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 3;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 4, 30), LocalDate.of(2023, 8, 23));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 5;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2023, 4, 30), LocalDate.of(2023, 6, 30));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 3;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

        dateRange = new DateRange(LocalDate.of(2022, 8, 30), LocalDate.of(2023, 3, 17));
        dateRangeList = splitMonth(dateRange);
        assert dateRangeList.size() == 8;
        assert CollectionUtils.lastElement(dateRangeList).getEndDate().equals(dateRange.getEndDate());
        print(dateRangeList);

    }

    static List<DateRange> splitMonth(DateRange range) {
        return splitMonth(range.getBeginDate(), range.getEndDate());
    }

    static void print(List<DateRange> dateRanges) {
        for (DateRange dateRange : dateRanges) {
            System.out.println(dateRange);
        }
        System.out.println("-----------");
    }


    static List<DateRange> splitMonth(LocalDate beginDate, LocalDate endDate) {
        List<DateRange> dateRanges = new ArrayList<>();
        if (beginDate.isAfter(endDate)) {
            return dateRanges;
        }
        LocalDate leftBound = beginDate.withDayOfMonth(1);
        LocalDate rightBound = endDate.withDayOfMonth(1);
        for (LocalDate monthBegin = leftBound; !monthBegin.isAfter(rightBound); monthBegin = monthBegin.plusMonths(1)) {
            LocalDate monthEnd = monthBegin.plusMonths(1).minusDays(1);
            dateRanges.add(new DateRange(monthBegin, monthEnd));
        }
        if (!CollectionUtils.isEmpty(dateRanges)) {
            CollectionUtils.lastElement(dateRanges).setEndDate(endDate);
        }
        return dateRanges;
    }
}
