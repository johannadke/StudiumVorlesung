package Pogrammieren.chapter11;

public class Person {
    private String name;
    private String familyName;
    private String fullName;

    public Person(String name, String familyName){
        this.name = name;
        this.familyName = familyName;
        setFullName();
    }

    @Override
    public String toString(){
        return this.fullName;
    }

    private void setFullName(){
        this.fullName = this.name + " " + this.familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
