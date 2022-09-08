package HomeWork6;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

abstract class Pet1 {
    private Species species;
    private String nickname;
    private Set <String> habits;
    private int age;
    private int trickLevel;


    public Pet1(
            String nickname,
            int age,
            int trickLevel,
            Set <String> habits
    ) {
        this.nickname = nickname;
        this.habits = habits;
        this.age = age;
        this.trickLevel = trickLevel;
        this.setSpecies(Species.UNKNOWN);
    }


    public Pet1() {
    }

    public Pet1(Species species,
                String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public void setHabits(Set <String> habits) {
        this.habits = habits;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public Set <String> getHabits() {
        return habits;
    }

    @Override
    public String toString() {
       return prettyFormat();
    }
    private String prettyFormat() {
      String s = String.format("Pet1{ species:%s nickname:%s habits:%s age:%s trickLevel:%s\n}",
              species,nickname,habits,age,trickLevel);
        return s;
    }
    void eat(){
        System.out.println("I am eating");

    };
    abstract void respond();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet1 pet1 = (Pet1) o;
        return age == pet1.age && trickLevel == pet1.trickLevel && species == pet1.species && nickname.equals(pet1.nickname) && habits.equals(pet1.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, habits, age, trickLevel);
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("Remove pet");
        super.finalize();
    }
}








