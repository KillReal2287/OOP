


import java.util.Date;

public class Note{
    private final String name;
    private final String note;
    private final Date time;

    Note(String title, String note, Date time){
        this.name = title;
        this.note = note;
        this.time = time;
    }

    public Date getTime(){
        return time;
    }
    public String getNote(){
        return note;
    }
    public String getTitle(){
        return name;
    }
}
