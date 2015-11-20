package generics.chapter24;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swissbib on 01.07.15.
 */
public class NoStaticGenVar <T> {

    //statische Methoden können nicht auf Typvariablen zugreifen
    //static  T t;

    //statische Methoden können nicht auf Typvariablen zugreifen
    //static void foo(T t){}

    //direct generic Array Creation not possible
    //List<String>[] sListArr = new ArrayList<String>[7];

}



//Eine Klasse kann keine Typvariable als Supertyp haben
//class DoBotExtend<T> extends T {

//}