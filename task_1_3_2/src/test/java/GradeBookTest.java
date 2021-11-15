import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GradeBookTest {
    @Test
    void TestAllMine() {
        GradeBook gradeBook = new GradeBook();
        gradeBook.getSubjects().add(new Subject("discrete math", 1, false, 5));
        gradeBook.getSubjects().add(new Subject("history", 1, true, 5));
        gradeBook.getSubjects().add(new Subject("Declarative programming", 1, false, 4));
        gradeBook.getSubjects().add(new Subject("OKR", 1, true, 5));
        gradeBook.getSubjects().add(new Subject("math", 1, false, 4));
        gradeBook.getSubjects().add(new Subject("imperative programming", 1, false, 3));
        gradeBook.getSubjects().add(new Subject("math", 2, true, 4));
        gradeBook.getSubjects().add(new Subject("imperative programming", 2, true, 4));
        gradeBook.getSubjects().add(new Subject("digital platforms", 2, true, 4));
        gradeBook.getSubjects().add(new Subject("discrete math", 2, true, 5));
        gradeBook.getSubjects().add(new Subject("foreign language", 2, false, 3));
        gradeBook.getSubjects().add(new Subject("Declarative programming", 2, true, 4));

        assertEquals(4.1666665, gradeBook.getAverageScore(), 0.0000001);
        assertFalse(gradeBook.canGetGreatDiploma());
        assertFalse(gradeBook.IncreasedScholarship(2));
    }

    @Test
    void TestAllExcellent() {
        GradeBook gradeBook = new GradeBook();
        gradeBook.getSubjects().add(new Subject("math", 1, false, 5));
        gradeBook.getSubjects().add(new Subject("discrete math", 1, false, 5));
        gradeBook.getSubjects().add(new Subject("history", 1, true, 5));
        gradeBook.getSubjects().add(new Subject("Declarative programming", 1, false, 5));
        gradeBook.getSubjects().add(new Subject("OKR", 1, true, 5));
        gradeBook.getSubjects().add(new Subject("imperative programming", 1, false, 5));
        gradeBook.getSubjects().add(new Subject("math", 2, true, 5));
        gradeBook.getSubjects().add(new Subject("imperative programming", 2, true, 5));
        gradeBook.getSubjects().add(new Subject("digital platforms", 2, true, 5));
        gradeBook.getSubjects().add(new Subject("discrete math", 2, true, 5));
        gradeBook.getSubjects().add(new Subject("foreign language", 2, false, 5));
        gradeBook.getSubjects().add(new Subject("Declarative programming", 2, true, 5));
        gradeBook.SetDiploma(5);

        assertEquals(5.0, gradeBook.getAverageScore());
        assertTrue(gradeBook.canGetGreatDiploma());
        assertTrue(gradeBook.IncreasedScholarship(2));
    }

    @Test
    void ExceptionsMarksCheck() throws Exception {
        GradeBook gradeBook = new GradeBook();
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.getSubjects().add(
                        new Subject("Imperative programming", 2, true, 6)
                )
        );
        assertEquals("Illegal mark", e.getMessage());
    }

    @Test
    void ExceptionsSemestersCheck() throws Exception {
        GradeBook gradeBook = new GradeBook();
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.getSubjects().add(new Subject("Imperative programming", 20, true, 5)
                )
        );
        assertEquals("Illegal number of semester", e.getMessage());
    }

    @Test
    void ExceptionsIncreasedScholarShipCheck() throws Exception {
        GradeBook gradeBook = new GradeBook();
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> gradeBook.IncreasedScholarship(1)
        );
        assertEquals("Illegal semester", e.getMessage());
    }

}
