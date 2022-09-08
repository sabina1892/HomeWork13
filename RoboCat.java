package HomeWork6;

import java.util.Set;

class RoboCat extends Pet1 implements Foul{
    public RoboCat(
            String nickname,
            int age,
            int trickLevel,
            Set<String> habits
    ) {
        super(nickname,age,trickLevel,habits);
        super.setSpecies(Species.RoboCat);
    }

    @Override
    void respond() {

    }

    @Override
    public void foul() {

    }
}