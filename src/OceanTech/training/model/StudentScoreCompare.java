package OceanTech.training.model;

import java.util.Comparator;

public class StudentScoreCompare implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        Double d1 = o1.getDiem();
        Double d2 = o2.getDiem();
        return d2.compareTo(d1);
    }
}
