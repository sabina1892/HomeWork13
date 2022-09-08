package HomeWork6;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Human1 {
    //private static final SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy ");
    private String name;
    private String surname;
    private long dateOfBirthyear;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    
    public Human1() {
    }

    public Human1(
            String name,
            String surname,
            long dateOfBirthyear
    ) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirthyear = dateOfBirthyear;

    }
    public Human1(String name, String surname, String dateOfBirthyear, int iq) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirthyear = convert(dateOfBirthyear);
        this.iq = iq;
    }


    public Human1(
            String name,
            String surname,
            long dateOfBirthyear,
            int iq,
            Map<String, String> schedule,
            Family family
    ) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirthyear = dateOfBirthyear;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirthyear(long dateOfBirthyear) {
        this.dateOfBirthyear = dateOfBirthyear;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getDateOfBirthyear() {
        return dateOfBirthyear;
    }

    public int getIq() {
        return iq;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public Family getFamily() {
        return family;
    }


    void greetPet() {
        System.out.println("Hello");
    }

    Long describeAge(Date today, Date year) {
        Long day = (today.getTime() - year.getTime()) / (1000 * 60 * 60 * 24);
        return day;
    }

    private long convert(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .atStartOfDay().toInstant(ZoneId.systemDefault().getRules().getOffset(LocalDateTime.now()))
                .toEpochMilli();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human1 human1 = (Human1) o;
        return dateOfBirthyear == human1.dateOfBirthyear && iq == human1.iq && name.equals(human1.name) && surname.equals(human1.surname) && family.equals(human1.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirthyear, iq, family);
    }


    @Override
    public String toString() {
        return prettyFormat();
    }

    private String prettyFormat() {
        if (iq == 0 && schedule == null) {
            String s = String.format("{name='%s', surname='%s', dateOfBirthyear=%s}\n"
                    ,name, surname,dateOfBirthyear);
            return s;
        } else if (schedule == null) {
            String s = String.format("{name='%s', surname='%s', dateOfBirthyear=%s, iq=%d}\n"
                    ,name, surname,dateOfBirthyear, iq);
            return s;
        }
        String s = String.format("{name='%s', surname='%s', dateOfBirthyear=%s, iq=%d, schedule=%s}\n"
                ,name, surname,dateOfBirthyear, iq, iq, schedule);
        return s;
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Remove human");
    }
}

