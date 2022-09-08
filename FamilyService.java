package HomeWork6;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }


    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies(){
        this.familyDao
                .getAllFamilies()
                .forEach(family ->
                        System.out.printf("%d %s \n", getAllFamilies()
                                .indexOf(family), family));
    }
    public List<Family> getFamiliesBiggerThan(int count){
        return getAllFamilies()
                .stream()
                .filter(x->x.countFamily()>count)
                .collect(Collectors.toList());
    }
    public List<Family> getFamiliesLessThan(int count){
        return getAllFamilies()
                .stream()
                .filter(x->x.countFamily()<count)
                .collect(Collectors.toList());

    }
    public List<Family> countFamiliesWithMemberNumber(int count){
        return getAllFamilies()
                .stream()
                .filter(x->x.countFamily()==count)
                .collect(Collectors.toList());
    }
    public Family createNewFamily(Human1 mother, Human1 father)
    {
        Family family = new Family(mother,father);
        familyDao.saveFamily(family);
        return family;
    }
    public void deleteFamilyByIndex(int index) {
       if(familyDao.deleteFamily(index)){
           System.out.println("Deleted");
       }
       else {
           System.out.println("not exist");
       }
    }
    public void deleteFamilyByReference(Family family) {
        if (familyDao.deleteFamily(family)) System.out.println("Deleted");
        else System.out.println("Family not exist");
    }
    public Family adoptChild(Human1 child, Family family){
        family.addChild(child);
        return familyDao.saveFamily(family);
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }


    public Family getFamilyByIndex(int index) {
        return familyDao.getFamilyByIndex(index);
    }
    public List<Pet1> getPets(Family family){
        List<Pet1> pet = new ArrayList<>();
        getAllFamilies().stream().forEach(x->pet.addAll(family.getPet()));
        return pet;
    }
    public void addPet(int index, Pet1 pet1){
        this.familyDao.getAllFamilies().get(index).getPet().add(pet1);
        this.familyDao.saveFamily(familyDao.getAllFamilies().get(index));
    }


}
