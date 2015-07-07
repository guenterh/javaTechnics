package generics.chapter24;

/**
 * Created by swissbib on 01.07.15.
 */
public class NoStaticGenVar <T> {

    //statische Methoden können nicht auf Typvariablen zugreifen
    //static T t;

    //statische Methoden können nicht auf Typvariablen zugreifen
    //static void foo(T t){}



}



//Eine Klasse kann keine Typvariable als Supertyp haben
//class DoBotExtend<T> extends T {

//}