import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Subject> subjects = new ArrayList<>();

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * @return average score at the moment
     */
    public float getAverageScore(){
        float marks = 0.0F;
        float count = 0.0F;
        for (int i = 0; i < subjects.size(); i++) {
            marks += subjects.get(i).getMark();
            count += 1;
        }
        if (count == 0){
            return 0.0F;
        }
        return marks/count;
    }

    private boolean isGreatMarksEnoughForDiploma(){
        ArrayList<Integer> listMarks = new ArrayList<>();
        ArrayList<Integer> listGreatMarks = new ArrayList<>();
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getIsLast() == true){
                listMarks.add(subjects.get(i).getMark());
            } //получаем все итоговые оценки
            if (subjects.get(i).getIsLast() == true && subjects.get(i).getMark() == 5){
                listGreatMarks.add(subjects.get(i).getMark());
            }//получаем все итоговые оценки, равные 5
        }
        if (listMarks.size()/ listGreatMarks.size()*1.0 >= 0.75){
            return true;
        }
        else
            return false;
    }

    private boolean doesHaveSatisfactory(){
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getMark() == 3){
                return true;
            }
        }
        return false;
    }

    public void SetDiploma(int mark){
        getSubjects().add(new Subject("diploma", 8, true, 5));
    }

    private boolean diplomaChecker(){
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getname().equals("diploma") && subjects.get(i).getMark() == 5){
                return true;
            }
        }
        return false;
    }

   public boolean canGetGreatDiploma(){
       return (diplomaChecker() && !doesHaveSatisfactory() && isGreatMarksEnoughForDiploma());
    }

    public boolean IncreasedScholarship(int semester) {
        if (semester<=1 || semester>=9){
            throw new IllegalArgumentException("Illegal semester");
        }
        else {
            for (Subject subject : subjects) {
                if (subject.getSemester() == semester - 1 && subject.getMark() != 5) {
                    return false;
                }
            }
        }
        return true;
    }

}
