package generics.chapter215;

/**
 * Created by swissbib on 30.06.15.
 */

//NumberService benutzt Typ T und nicht enthält Typ T
public class NumberService <T> {

    private T t;

    public NumberService(T t) {
        this.t = t;
    }

    public boolean equalIntVal1 (T arg) {

        return ((Number)t).intValue() == ((Number)arg).intValue();

    }

    public boolean equalIntVal2 (T arg) {

        if (t instanceof Number) {
            return ((Number)t).intValue() == ((Number)arg).intValue();
        }
        throw new IllegalArgumentException("Typ Number erwartet");

    }


    public static void main (String[] args) {

        NumberService<String> ns1 = new NumberService<>("hello");
        System.out.println(ns1.equalIntVal2("so nicht"));
    }

}
