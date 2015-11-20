package generics.chapter221;

/**
 * Created by swissbib on 19.11.15.
 */
public class Person {

    private String name;
    public Person (String name) {
        setName(name);
    }

    public void setName (String name) {
        if (name == null || name.length() <2) {
            throw new IllegalArgumentException("Name muss aus mindestens zwei Buchstaben bestehen");
        }

        this.name = name;
    }

    public String getName () {
        return this.getName();
    }


    @Override
    public String toString() {
        return "<Person>\n <name>"+name+"</name>\n</Person>\n";
    }
}
