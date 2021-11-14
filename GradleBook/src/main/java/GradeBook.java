import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Subject> list = new ArrayList<>();
    private ArrayList<Integer> listMarks = new ArrayList<>();
    private ArrayList<Integer> listGreatMarks = new ArrayList<>();


    public ArrayList<Subject> getList() {
        return list;
    }

    public void setList(ArrayList<Subject> list) {
        this.list = list;
    }

    public ArrayList<Integer> getListMarks() {
        return listMarks;
    }

    public void setListMarks(ArrayList<Integer> listMarks) {
        this.listMarks = listMarks;
    }

    public ArrayList<Integer> getListGreatMarks() {
        return listGreatMarks;
    }

    public void setListGreatMarks(ArrayList<Integer> listGreatMarks) {
        this.listGreatMarks = listGreatMarks;
    }

    /**
     * @return average score at the moment
     */
    public float getAverageScore(){
        float marks = 0.0F;
        float count = 0.0F;
        for (int i = 0; i < list.size(); i++) {
            marks += list.get(i).getMark();
            count += 1;
        }
        if (count == 0){
            return 0.0F;
        }
        return marks/count;
    }

    public boolean isGreatMarksEnoughForDiploma(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIsLast() == true){
                listMarks.add(list.get(i).getMark());
            } //получаем все итоговые оценки
            if (list.get(i).getIsLast() == true && list.get(i).getMark() == 5){
                listGreatMarks.add(list.get(i).getMark());
            }//получаем все итоговые оценки, равные 5
        }
        if (listMarks.size()/ listGreatMarks.size()*1.0 >= 0.75){
            return true;
        }
        else
            return false;
    }

    public boolean doesHaveSatisfactory(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMark() == 3){
                return true;
            }
        }
        return false;
    }

    public boolean diplomaChecker(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getname().equals("diploma") && list.get(i).getMark() == 5){
                return true;
            }
        }
        return false;
    }

   public boolean canGetGreatDiploma(){
       return (diplomaChecker() && !doesHaveSatisfactory() && isGreatMarksEnoughForDiploma());

    }

    public boolean IncreasedScholarship(int semester){
        for (Subject subject : list) {
            if (subject.getSemester() == semester && subject.getMark() != 5) {
                return false;
            }
        }
        return true;
    }

}
