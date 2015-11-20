package learningjava.generics.entergenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by swissbib on 20.11.15.
 */
public class Ex1<T> {

    T myVar;

    public Ex1(T m) {
        this.myVar = m;
    }

    public T getMyVar() {
        return this.myVar;
    }

    public static void main (String[] args) {

        List<Date> dateList = new ArrayList<>();
        System.out.println(dateList instanceof  List);

        dateList.add(new Date());



        Ex1<Date> ex1 = new Ex1<>(new Date());

        Date d = ex1.getMyVar();

        System.out.println(d.getTime());

        List<Date> unsafeList = new ArrayList();

        ArrayList tricky = new ArrayList();
        tricky.add("hello");

        unsafeList = tricky;

        //this throws an exception
        //unsafeList.get(0).getTime();

        Collection<Date> cd = new ArrayList<Date>( );
        List<Date> ld = (List<Date>)cd; // Ok!

        Object o = new ArrayList<String>( );
        ((ArrayList<String>)o).add("hello");
        List<Date> ldfo = (List<Date>)o; // unchecked warning, ineffective
        //Date dd = ldfo.get(0); // unsafe at runtime, implicit cast may fail

        System.out.print("kk");


    }


}
