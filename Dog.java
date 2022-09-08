package HomeWork6;

import java.util.Set;

class Dog extends Pet1 implements Foul {
    public Dog(
            String nickname,
            int age,
            int trickLevel,
            Set<String> habits
    ) {
        super(nickname,age,trickLevel,habits);
        super.setSpecies(Species.DOG);
    }
    void respond() {
        System.out.println("Dog food");
    }

    @Override
    public void foul() {

    }
}
