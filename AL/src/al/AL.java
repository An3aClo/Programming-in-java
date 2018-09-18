package al;

import java.util.ArrayList;

public class AL {

    public static void main(String[] args) {
        
        ArrayList myArray = new ArrayList();//Holding object can be anything from a String to a person
        myArray.add("Apples");
        myArray.add("Pears");
        myArray.add("Bannana");
        myArray.add("Orange");

        Person dave = new Person();
        dave.setLName("Van der Fruit");
        dave.setfName("Dave");
        myArray.add(dave);
             
        System.out.println(myArray);

       ArrayList people = new ArrayList();

        Person aPerson = new Person();
        aPerson.setfName("Andrea");
        aPerson.setLName("Cloete");

        people.add(aPerson);

        Person bPerson = new Person();
        bPerson.setfName("Zeldene");
        bPerson.setLName("Else");
        people.add(bPerson);

        System.out.println(people);
        
        String s1 = "ANDREA";
        int l = s1.length();//Counts how long the string is
        System.out.println("Length is: " + l);
        String s2 = s1.concat("Cloete");
        System.out.println(s2.toUpperCase());
         
    }

}

class Person {

    private String fName;
    private String LName;

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the LName
     */
    public String getLName() {
        return LName;
    }

    /**
     * @param LName the LName to set
     */
    public void setLName(String LName) {
        this.LName = LName;
    }

    @Override
    public String toString() {
        return "["+fName + " " + LName+"]" ;
    }
}
