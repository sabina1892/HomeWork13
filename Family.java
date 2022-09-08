package HomeWork6;

import java.util.*;

public class Family {
    private Human1 mother;
    private Human1 father;
    private List<Human1> children;
    private Set<Pet1> pet;


    public Family(Human1 mother, Human1 father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pet = new HashSet<>();
        father.setFamily(this);
        mother.setFamily(this);

    }

    public void setMother(Human1 mother) {
        this.mother = mother;
    }

    public void setPet(Set<Pet1> pet) {
        this.pet = pet;
    }

    public void setFather(Human1 father) {
        this.father = father;
    }

    public void setChildren(List<Human1> children) {
        this.children = children;
    }


    public Human1 getMother() {
        return mother;
    }

    public Human1 getFather() {
        return father;
    }

    public List<Human1> getChildren() {
        return children;
    }

    public Set<Pet1> getPet() {
        return  pet;
    }
    @Override
    public String toString() {
        return prettyFormat();
    }

    private String prettyFormat() {
         String s = String.format("Family:\n \t mother:%s \t father:%s \t pet:%s \n\t children:%s \t",
               mother,father,pet,children);
        return s;

    }

    public void addChild(Human1 child) {
        if (child != null) {
            children.add(child) ;
            setChildren(children);
            child.setFamily(this);
        }
    }


    public void deleteChild(Human1 child) {
        if (child != null) {
            children.remove(child);
            setChildren(children);
            child.setFamily(this);
        }
    }
   public int countFamily(){
        return (2 + getChildren().size());
    }





    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Remove family");
    }


}
