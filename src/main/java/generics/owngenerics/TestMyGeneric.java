package generics.owngenerics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by swissbib on 26.11.15
 *
 * .
 */
public class TestMyGeneric {

    public static void main (String[] args) {

        MyGenericType <String, Date> myT = new MyGenericType<>(new Date());

        Object o =  myT.getSomeThing(new Date());
        myT.add("hello");

        System.out.println(o);

        ArrayList rawL = new ArrayList();
        rawL.add("my string");


        List<Date> mD = rawL;

        //Date d = mD.get(0);

        System.out.print("");




    }

}
