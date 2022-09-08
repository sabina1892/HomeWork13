package HomeWork6;

import java.text.ParseException;

public class Women extends Human1 {
    public Women(String mName, String mSurname, String mBirthDate, int mIq) throws ParseException {
        super(mName,mSurname,mBirthDate,mIq);
    }
    public Women() {

    }

    @Override
    void greetPet() {
      //  super.greetPet();
        System.out.println("You are wonderful");
    }
    void makeUp(){
        System.out.println("I am ready, I did makeup");
    }
}
