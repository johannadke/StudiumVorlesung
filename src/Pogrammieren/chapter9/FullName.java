package Pogrammieren.chapter9;

public class FullName implements Comparable<FullName>{

    private String name;
    private String familyName;

    public FullName(String name, String familyName){
        this.name = name;
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return this.familyName + ", " + this.name;
    }

    @Override
    public int compareTo(FullName o) {
        System.out.println("Compare To Methode: " + this.name + this.familyName + " wird mit " + o.name + o.familyName + " verglichen.");
        if(!this.familyName.equals(o.familyName)){
            return this.familyName.compareTo(o.familyName);
        }

        return this.name.compareTo(o.name);
    }
}
