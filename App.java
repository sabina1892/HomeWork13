package HomeWork6;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {
    private static FamilyController familyController = conf();

    public boolean starting_app() throws ParseException, IOException {
        commands();
        System.out.print("Enter command to run: ");
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        if (command.equalsIgnoreCase("exit")) {
            System.out.println("Application closed...");
            return false;
        } else {
            switch (command) {
                case "1" -> {
                    fillWithTestData();
                    System.out.println("Data saved successfully!");
                }
                case "2" -> {
                    familyController.displayAllFamilies();
                    System.out.println("Data displayed successfully!");
                }
                case "3" -> familyController.getFamiliesBiggerThan(requestNumber()).forEach(System.out::println);
                case "4" -> familyController.getFamiliesLessThan(requestNumber()).forEach(System.out::println);
                case "5" ->
                        System.out.printf("Result: %d\n", familyController.countFamiliesWithMemberNumber(requestNumber()));
                case "6" -> creatingFamily();
                case "7" -> deletingFamily();
                case "8" -> editFamily();
                default -> System.out.println("Command not exist, try again please!");
            }
        }
        return true;
    }

    private static String commands() throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\hp\\IdeaProjects\\lesson1\\src\\main\\java\\HomeWork6\\text1.txt"))) {
            StringBuilder sb = new StringBuilder();
            br.lines().forEach(line -> sb.append(line).append("\n"));
            return sb.toString();
        }
    }

    private void fillWithTestData() throws ParseException {
        Set<String> habits = new HashSet<>();
        habits.add("Eating");
        habits.add("sleeping");

        Pet1 pet = new Fish("Rock", 5, 25, habits);
        pet.respond();

        Human1 mother = new Human1("Jane", "Karleone", 1935);
        Human1 father = new Human1("Vito", "Karleone", 1932);
        // Human1 mother1 = new Human1("Marina", "Davidson", 1965);
        // Human1 father1 = new Human1("Tommy", "Davidson", 1960);

        Family family = new Family(mother, father);
        // Family family1 = new Family(mother1,father1);
        // System.out.println("-----");

        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY.name(), "do home work");
        mother.setSchedule(schedule);
        // mother1.setSchedule(schedule);
        Human1 child = new Human1("Michael", "Karleone", 2000,
                95, schedule, family);
        // Human1 child1 = new Human1("Sergio", "Davidson", 1992,
        //         93, schedule,family1);
        Set<Pet1> bezdim_pet = new HashSet<>();
        family.setPet(bezdim_pet);
        // family1.setPet(bezdim_pet);
        Men men = new Men();
        Women women = new Women();
        // family.addChild(child);
        // family.countFamily();
        // System.out.println(child.getFamily());
        // System.out.println(family);

        // family.deleteChild(child);
        // System.out.println(family);
        // family.countFamily();

        // family1.addChild(child1);
        // family1.countFamily();
        // System.out.println(child1.getFamily());
        // System.out.println(family1);


        FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));

        Family family01 = familyController.createNewFamily(mother, father);
        // Family family02 = familyController.createNewFamily(mother1,father1);
        // familyController.getFamilyByIndex(0);
        // familyController.addPet(0,pet);
        // familyController.adoptChild(child,family01);
        // familyController.adoptChild(child1,family02);
        // familyController.displayAllFamilies();
        // System.out.println(familyController.getFamiliesBiggerThan(1));
        // System.out.println(familyController.getFamiliesLessThan(10));
        // System.out.println(familyController.countFamiliesWithMemberNumber(2));
        // System.out.println("-----");

        // Date today = new Date();
        // DateFormat f = new SimpleDateFormat("dd MM yyyy");
        // Date year=null;
        // try {
        //     year=f.parse( "10 08 2022");
        // }catch (ParseException e){
        //     e.printStackTrace();
        // }

        // System.out.println(father.describeAge(today,year));


        // System.out.println(familyController.adoptChild(new Human1("Jack", "Tomson", "24/03/2001", 100),family01));


    }

    private Family creatingFamily() throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter mother's name: ");
        String mName = sc.nextLine();
        System.out.print("Enter mother's surname: ");
        String mSurname = sc.nextLine();
        System.out.print("Enter mother's birth year : ");
        String mBirthYear = sc.nextLine();
        System.out.print("Enter mother's birth month : ");
        String mBirthMonth = sc.nextLine();
        System.out.print("Enter mother's birthday : ");
        String mBirthDay = sc.nextLine();
        String mBirthDate = mBirthDay + "/" + mBirthMonth + "/" + mBirthYear;
        System.out.print("Enter mother's iq : ");
        int mIq = sc.nextInt();
        Women mother = new Women(mName, mSurname, mBirthDate, mIq);

        sc = new Scanner(System.in);
        System.out.print("Enter father's name: ");
        String fName = sc.nextLine();
        System.out.print("Enter father's surname: ");
        String fSurname = sc.nextLine();
        System.out.print("Enter father's birth year : ");
        String fBirthYear = sc.nextLine();
        System.out.print("Enter father's birth month : ");
        String fBirthMonth = sc.nextLine();
        System.out.print("Enter father's birthday : ");
        String fBirthDay = sc.nextLine();
        String fBirthDate = fBirthDay + "/" + fBirthMonth + "/" + fBirthYear;
        System.out.print("Enter father's iq : ");
        int fIq = sc.nextInt();
        Men father = new Men(fName, fSurname, fBirthDate, fIq);

        Family f = familyController.createNewFamily(mother, father);
        return f;

    }

    private void deletingFamily() {
        System.out.println("Family count in database:" + familyController.count());
        familyController.deleteFamilyByReference(getFamilyById());
    }

    private void editFamily() throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Available commands:\n- 1. Give birth to a baby\n- 2. Adopt a child\n- 3. Return to main menu");
        System.out.print("\nEnter command to run: ");
        String command = sc.nextLine();
        switch (command) {
            case "1":
                try {
                    familyController.adoptChild(adoptChild(), getFamilyById());
                } catch (NullPointerException npe) {
                    System.out.println("Null data");
                } catch (IndexOutOfBoundsException iob) {
                    System.out.println("Family not exist");
                }
                break;
            case "2":
                try {
                    familyController.adoptChild(adoptChild(), getFamilyById());
                } catch (NullPointerException npe) {
                    System.out.println("Null data");
                } catch (IndexOutOfBoundsException iob) {
                    System.out.println("Family not exist");
                }
                break;
            case "3":
                starting_app();
            default:
                System.out.println("Entered command not exist, try again!");
        }
    }

    private Family getFamilyById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Family ID: ");
        int id = sc.nextInt();
        return familyController.getFamilyByIndex(id);
    }

    private Human1 adoptChild() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter child's name: ");
        String name = sc.nextLine();
        System.out.print("Enter child's surname: ");
        String surname = sc.nextLine();
        System.out.print("Enter child's birthdate (dd/mm/yyyy): ");
        String birthDate = sc.nextLine();
        System.out.print("Enter child's IQ: ");
        int iq = sc.nextInt();
        Human1 childAdopt = new Human1(name, surname, birthDate, iq);
        return childAdopt;
    }
    private int requestNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter: ");
        int num;
        try {
            num = sc.nextInt();
            return num;
        } catch (InputMismatchException e) {
            System.out.println("False input, try again!");
            requestNumber();
        }
        return 0;
    }

    private static FamilyController conf() {
        FamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        return new FamilyController(service);
    }


}
