package bean;

import java.util.Date;

public class Person {
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "date=" + date +
                '}';
    }
}
