package learningjava.generics.subclassing;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by swissbib on 20.11.15.
 */
public class ExtendedArrayList extends ArrayList<Date>{


    public static void main (String[] args) {

        ExtendedArrayList exAl = new ExtendedArrayList();
        exAl.add(new Date());

        Date d = exAl.get(0);

        System.out.println();


    }


}
