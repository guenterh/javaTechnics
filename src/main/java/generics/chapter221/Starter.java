package generics.chapter221;

import java.util.Arrays;
import java.util.List;

/**
 * Created by swissbib on 19.11.15.
 */
public class Starter {


    public static void main (String[] args) {
        Person [] pArr = {
                new Person ("Hans"),
                new Person ("Paul"),
                new Person ("Anna")
        };

        List<Person> pList = Arrays.asList(pArr);
        pArr = pList.toArray(new Person[0]);

        System.out.println(pArr);
        System.out.println(pList);

    }
}
