public class Subject {
    private String name;
    private int mark;
    private boolean isLast;
    private int semester;
    Subject(String name, int semester, boolean isLast, int mark) throws IllegalArgumentException{
        this.name = name;
        this.isLast = isLast;
        if (mark>=2 && mark<=5){
            this.mark = mark;
        }
        else{
            throw new IllegalArgumentException("Illegal mark");
        }
        if (semester>=1 && semester<=8){
            this.semester = semester;
        }
        else{
            throw new IllegalArgumentException("Illegal number of semester");
        }
    }
    String getname(){
        return name;
    }
    int getMark(){
        return mark;
    }
    int getSemester(){
        return semester;
    }
    boolean getIsLast(){
        return isLast;
    }

    @Override
    public String toString() {
        // Override the default toString() method and return a custom String instead.
        return String.format("%s\t%d\t%s %d", name, semester, isLast, mark);
    }
}
