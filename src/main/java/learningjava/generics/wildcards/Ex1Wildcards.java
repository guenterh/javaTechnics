package learningjava.generics.wildcards;

import javax.jnlp.PersistenceService;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


class Person {

}

class SubPerson extends Person{

}


/**
 * Created by swissbib on 20.11.15.
 */
public class Ex1Wildcards {


    public static void main (String[] args) {

        List<? super SubPerson> someList = new ArrayList<Person>();

        someList.add(new SubPerson());
        //someList.add(new Person());
        SubPerson tsP = (SubPerson) someList.get(0);



        //someList.add(new Person());
        //someList = new ArrayList<Integer>();

        Person p = (Person) someList.get(0);


        someList = new ArrayList<SubPerson>();

        //someList.add(new Person())
        //someList.add(new SubPerson())

        //someList = new ArrayList<>();

        System.out.println();

        List<Integer> intList = new ArrayList<>();
        Collection<Number>  collList = new ArrayList<Number>();
        //collList = intList; // not possible

        List<? extends Integer> wildUpperInlist = new ArrayList<>();
        Collection<? extends Number> wildUpperColllist = new ArrayList<>();

        wildUpperColllist = intList;




    }
}
