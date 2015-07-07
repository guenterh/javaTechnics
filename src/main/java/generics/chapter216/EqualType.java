package generics.chapter216;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by swissbib on 30.06.15.
 */
public class EqualType {

    public static <K,V> Map<K,V> emptyMap () {

        return new HashMap<>();

    }


    public static boolean equalType (Number... num) {

        if (num == null) {
            throw new IllegalArgumentException("Kein null erlaubt");
        }

        Class clazz = null;
        for (Number n: num) {
            if (clazz == null) {
                clazz = n.getClass();
            } else if (n.getClass() != clazz){
                return false;
            }
        }
        return true;
    }


    public static <N extends Number> boolean equalGenType (N... num) {
        if (num == null) {
            throw new IllegalArgumentException("Kein null erlaubt");
        }
        return num.getClass() != Number[].class;
    }

    public static void main (String[] args) {


        Map<String, String> myMap = emptyMap();
        Map<Double,String> myMap1 = emptyMap();

        myMap.put("eins", "zwei");
        myMap1.put(10.1, "hello");

        System.out.println();

        System.out.println(equalType(1,6,7,9));

        System.out.println(equalType(1,6.4,7,9));

        System.out.println(equalGenType(1, 6.4, 7, 9));
        System.out.println(equalGenType(1, 6, 7, 9));


    }
}
