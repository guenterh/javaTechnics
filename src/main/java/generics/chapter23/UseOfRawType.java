package generics.chapter23;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by swissbib on 01.07.15.
 */
public class UseOfRawType {

    public static void main (String[] main) {


        List rawList = new ArrayList<String>();
        rawList.add("Hallo");

        List<String> sList = new ArrayList<>();

        sList.add("1");

        rawList = sList;

        rawList.add(2);

        System.out.println(rawList.get(0) + "," + rawList.get(1));
        System.out.print(sList);
        Object o = rawList.get(1);

        //String s1 = rawList.get(1);

        String s = sList.get(1);


    }

}
