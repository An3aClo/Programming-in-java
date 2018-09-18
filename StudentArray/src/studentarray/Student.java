package studentarray;

public class Student {
    // two data member/instance variables

    private String fName;
    private String lName;

    //Accessors and mutators method will be creted for our instance variables
    //Mutator
    public void setFName(String fn) {
        fName = fn;
    }

    //Mutator
    public void setLName(String ln) {
        lName = ln;
    }

    //Accesser
    public String getFName() {
        return fName;
    }

    //Accesser
    public String getLName() {
        return lName;
    }
}
