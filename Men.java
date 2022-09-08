package HomeWork6;

import java.text.ParseException;

public class Men extends Human1 {
    public Men(String fName, String fSurname, String fBirthDate, int fIq) throws ParseException {
        super(fName,fSurname,fBirthDate,fIq);
    }
    public Men() {

    }

    @Override
    void greetPet() {
        System.out.println("You are cute");
    }
    void repairCar(){
        System.out.println("I can repair car");
    }
}
