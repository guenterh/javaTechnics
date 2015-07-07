package generics.chapter24;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swissbib on 01.07.15.
 */
public class RestrictionsGenerics {


    //Probleme mit new und instanceof

    public static <T> T makeT (T t) {

        //return new T();
        //return new T[10];
        return t;

    }


    public static void noGenericArrayCreation() {

        //direkte Arrays von parametrisierten Klassen nicht erlaubt
        //List<String>[] sListArray = new ArrayList<String>[5];
    }

    public static <T> T checkType(Object o) {

        //kein instanceof Test auf T erlaubt
        //if (o instanceof T) {
        //    return (T)o
        //}

        return null;
    }

    public static void checkGenClass() {
        List<Double> dList = new ArrayList<>();
        //Prüfen mit instanceof auf einen parametrisierten Typ nicht möglich

        //System.out.println(dList instanceof List<Double>);
        //instanceof nur auf rawTypen
        System.out.println(dList instanceof List); // => true

    }


    //Probleme mit static, extends und catch

    public static void main(String[] args) {

        String s = makeT("hello");
        System.out.println(s);
        checkGenClass();



    }



}
