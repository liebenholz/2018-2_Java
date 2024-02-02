package w14.lambda; 
 
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person {
  
    public enum Sex {
        MALE, FEMALE
    }
  
    String name; 
    LocalDate birthday;
    Sex gender;
    String emailAddress;
  
    Person(String nameArg, LocalDate birthdayArg,
        Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }  

    public int getAge() {
        return birthday
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
    }

    public void printPerson() {
      System.out.println(name + ", " + this.getAge());
    }
    
    public Sex getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> createRoster() {
        
        List<Person> roster = new ArrayList<>();
        roster.add(
            new Person(
            "³ª¿¬",
            IsoChronology.INSTANCE.date(1999, 6, 20),
            Person.Sex.FEMALE,
            "nayun@example.com"));
        roster.add(
            new Person(
            "Á¤¿¬",
            IsoChronology.INSTANCE.date(1998, 7, 15),
            Person.Sex.FEMALE, "jungyun@example.com"));
        roster.add(
            new Person(
            "½´°¡",
            IsoChronology.INSTANCE.date(2001, 8, 13),
            Person.Sex.MALE, "sugar@example.com"));
        roster.add(
            new Person(
            "Áö¹Î",
            IsoChronology.INSTANCE.date(1998, 9, 12),
            Person.Sex.MALE, "jimin@example.com"));
        
        return roster;
    }
    
}