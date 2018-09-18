package arraylist2;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
import java.util.*;

public class ArrayList2 {

    public static void main(String[] args) {
        //Dimond operators
        ArrayList<String> myArray = new ArrayList();
        ///Now it can hold just Strings and not any objects
        myArray.add("Apples");
        myArray.add("Pears");
        myArray.add("Bannana");
        myArray.add("Orange");

        Iterator<String> myIterator = myArray.iterator();
        while (myIterator.hasNext()) {
            String currentString = myIterator.next();
            System.out.println(currentString);
        }
        //Collections.sort(myArray); //---way to sort the array list
       myArray.sort(null);//another way to sort an array list
        System.out.println(myArray.toString());
        
        ArrayList<Person> people= new ArrayList();

        Person aPerson = new Person();
        aPerson.setfName("Andrea");
        aPerson.setLName("Cloete");

        people.add(aPerson);

        Person bPerson = new Person();
        bPerson.setfName("Zeldene");
        bPerson.setLName("Els");
        people.add(bPerson);
        
        Person dave = new Person();
        dave.setLName("Van der Fruit");
        dave.setfName("Dave");
        people.add(dave);

        System.out.println(people.toString());
    }

}

class Person {//implements Comparable {

    private String fName;
    private String LName;

   /*public int compareTo(Object other) {
        int returnValue = 0;
        Person otherPerson = (Person) other;
        if (LName.compareToIgnoreCase(otherPerson.LName) < 0) {
            returnValue = -1;
        } else if (LName.compareToIgnoreCase(otherPerson.LName) > 0) {
            returnValue = 1;
        }
        return returnValue;
    }

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
        return "[" + fName + " " + LName + "]";
    }
}
