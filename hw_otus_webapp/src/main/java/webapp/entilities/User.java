package webapp.entilities;

import webapp.exceptions.IllegalInputException;

import java.io.Serializable;
import java.sql.Date;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class User implements Serializable {
    private final String name;
    private Date birthDateSQL;
    private Calendar birthDateCalendar;
    private String birthDateString;
    private final String sex;
    private int age;
    public User(String name, Date date, String sex, int age){
        this.name = name;
        this.birthDateSQL = date;
        this.sex = sex;
        this.age = age;
        this.birthDateString = getStringFromSqlDate();
    }
    public User(String name, String birthDate, String sex) throws IllegalInputException {
        checkName(name);
        this.name = name;
        setBirthDateCalendarAndSQL(birthDate);
        setAge();
        checkDate(this.getBirthDateCalendar());
        this.sex = sex;
        this.birthDateString = birthDate;
    }

    public String getStringFromSqlDate(){
        StringBuilder builder = new StringBuilder("");
        builder.append(this.birthDateSQL.getYear()+1900);
        builder.append("-");
        int month = this.birthDateSQL.getMonth()+1;
        if(month /10 ==0) {
            builder.append(0);
            builder.append(month);
        }else {
            builder.append(month);
        }
        builder.append("-");
       int day = this.birthDateSQL.getDate();
        if(day / 10==0){
            builder.append("0");
            builder.append(day);
        }else{
            builder.append(day);
        }
        return builder.toString();
    }

    private void setBirthDateCalendarAndSQL(String birthDateCalendar) throws IllegalInputException {
        String[] parts = birthDateCalendar.split("-");
        Calendar dateCalendar = new GregorianCalendar(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[2]));
        java.sql.Date date = new Date(dateCalendar.getTimeInMillis());
        if(checkDate(dateCalendar)) {
            this.birthDateCalendar = dateCalendar;
            this.birthDateSQL = date;
        }
    }
    private void setAge() {
        Calendar currentDate = new GregorianCalendar();
        int diff = (int) (Duration.between(this.birthDateCalendar.toInstant(), currentDate.toInstant()).toDays()) / 365;
        this.age = diff;
    }

    public int getAge() {
        return age;
    }

    public boolean checkDate(Calendar date) throws IllegalInputException{
        Calendar calendar = new GregorianCalendar();
        if(date.after(calendar))
            throw new IllegalInputException();
        return true;
    }
    public boolean checkName(String name) throws IllegalInputException{
        if(name.equals(""))
            throw new IllegalInputException();
        return true;
    }

    public Calendar getBirthDateCalendar() {
        return birthDateCalendar;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDateSQL() {
        return birthDateSQL;
    }

    public String getBirthDateString() {
        return birthDateString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(birthDateCalendar, user.birthDateCalendar) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDateCalendar, sex);
    }


}
