package generics.chapter216;

import java.util.ArrayList;

/**
 * Created by swissbib on 30.06.15.
 */
public class TypeTest {


    public <T> ArrayList<T> giveMe(T arg) {

        ArrayList<T> aL = new ArrayList<>();
        aL.add(arg);
        return aL;

    }


    public static void main (String[] args) {

        TypeTest t = new TypeTest();

        ArrayList<String> sL = t.giveMe("hello");
        sL.add("noch was");

        for (String s: sL) {
            System.out.println(s);
        }
    }

}
