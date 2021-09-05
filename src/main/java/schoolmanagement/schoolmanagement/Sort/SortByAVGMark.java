package schoolmanagement.schoolmanagement.Sort;
import java.util.Comparator;

import schoolmanagement.schoolmanagement.Student;

public class SortByAVGMark implements Comparator
{
    @Override
    public int compare(Object o1, Object o2) {
        Student s2=(Student)o2;
        Student s1=(Student)o1;
        if(s1.getAvgMark() > s2.getAvgMark())
        return -1;
        else if (s1.getAvgMark() < s2.getAvgMark())
            return 1;
        return 0;
    }
}