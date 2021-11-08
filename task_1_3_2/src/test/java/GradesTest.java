import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class GradesTest {

    @Test
    public void AverageTest() throws IOException {
        Gradebook real = new Gradebook(18212, "K.V. Bronnikov", "FIT", "CS", 5);
        real.add(1, "DM", 5);
        real.add(1, "Geometry", 4);
        real.add(1, "History", 5);
        real.add(1, "Mathematical analysis", 4);
        real.add(2, "History", 5);
        real.add(2, "Higher algebra", 4);
        real.add(3, "Math. logic", 4);
        real.add(3, "Comp. methods of lin. algebra", 4);
        ArrayList<Integer> grades = real.getAllGrades(); //Here we can calculate the average score not only for the entire period.
        Assert.assertEquals(4.375, Grades.AverageScore(grades), 0);
    }
    @Test
    public void DiplomaTest() throws IOException {
        Gradebook real = new Gradebook(18212, "K.V. Bronnikov", "FIT", "CS", 5);
        real.add(1, "DM", 5);
        real.add(1, "Geometry", 4);
        real.add(1, "History", 5);
        real.add(1, "Mathematical analysis", 5);
        real.add(2, "History", 5);
        //Provided that the student potentially writes a qualifying work with "excellent" mark.
        Assert.assertTrue(Grades.DiplomaWithHonors(real));
        //Provided that the student potentially does not write a qualifying work with "excellent" mark.
        real.setQualifyingWorkGrade(3);
        Assert.assertFalse(Grades.DiplomaWithHonors(real));
        //Assume that a student closed the session with a bad grade.
        real.setQualifyingWorkGrade(5);
        real.add(2, "Some discpline", 3);
        Assert.assertFalse(Grades.DiplomaWithHonors(real));
    }
    @Test
    public void ScholarshipTest() throws IOException {
        Gradebook real = new Gradebook(18212, "K.V. Bronnikov", "FIT", "CS", 5);
        real.add(1, "DM", 5);
        real.add(1, "Geometry", 4);
        real.add(1, "History", 5);
        real.add(1, "Mathematical analysis", 5);
        Assert.assertTrue(Grades.scholarship(real, 1));
        //Assume that a student closed the session with a bad grade.
        real.add(1, "Some discpline", 3);
        Assert.assertFalse(Grades.scholarship(real, 1));
    }
}