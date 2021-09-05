package schoolmanagement.schoolmanagement.Sort;
import java.util.Comparator;

import schoolmanagement.schoolmanagement.Student;

public class SortByName implements Comparator
{
    @Override
    public int compare(Object o1, Object o2) {
        Student s2=(Student)o2;
        Student s1=(Student)o1;
        return s1.getName().compareTo(s2.getName());
    }
}
