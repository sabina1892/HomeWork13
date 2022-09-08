package HomeWork6;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private final List<Family> familyC = new ArrayList<>();
    @Override
    public List<Family> getAllFamilies() {
        return this.familyC;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if(familyC.get(index)!=null) return familyC.get(index);
        else return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if(familyC.remove(index)!=null) return true;
        else return false;
    }

    @Override
    public boolean deleteFamily(Family family) {

        try {
            this.familyC.remove(family);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Family saveFamily(Family family) {
        if(familyC.contains(family))  familyC.set(familyC.indexOf(family),family) ;
        else familyC.add(family);
        return family;
    }
}
