package learningjava.generics.wildcards;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


class Person {

}


/**
 * Created by swissbib on 20.11.15.
 */
public class Ex1Wildcards {


    public static void main (String[] args) {

        List<? extends Person> someList = new ArrayList<Person>();



        //someList.add(new Person());
        //someList = new ArrayList<Integer>();

        Person p = (Person) someList.get(0);

        //someList = new ArrayList<>();

        System.out.println()    ;



    }
}
