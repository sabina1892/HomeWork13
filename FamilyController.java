package HomeWork6;



import java.util.List;

public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return this.familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        this.familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return this.familyService.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return this.familyService.getFamiliesLessThan(count);
    }

    public List<Family> countFamiliesWithMemberNumber(int count) {
        return this.familyService.countFamiliesWithMemberNumber(count);
    }

    public Family createNewFamily(Human1 mother, Human1 father) {

        return this.familyService.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex(int index) {
        this.familyService.deleteFamilyByIndex(index);
    }
    public void deleteFamilyByReference(Family family) {
        familyService.deleteFamilyByReference(family);
    }
    public Family adoptChild(Human1 child,Family family) {
        return this.familyService.adoptChild(child, family);
    }

    public int count() {
        return this.familyService.count();
    }

    public Family getFamilyByIndex(int index) {
        return this.familyService.getFamilyByIndex(index);
    }

    public List<Pet1> getPets(Family family) {
        return this.familyService.getPets(family);
    }

    public void addPet(int index, Pet1 pet) {
        this.familyService.addPet(index, pet);
    }

}
