package dpunkt.javabook.kap3;

/**
 * Created by swissbib on 21.11.15.
 */
public class AccessTests1 {

    public static void main (String[] args) {


        AccessTests at = new AccessTests();
        at.packagePrivate = "ja ich sehe Dich";


        AcccessTests2 at2 = new AcccessTests2();
        at2.myAttr = "Attribut von 2";
        System.out.println(at2.myAttr);

        at.myAttr = "nun Attribut von 1";
        System.out.println(at.myAttr);

        at = at2;

        System.out.println(at.myAttr);
        System.out.println(at.getMyAttr());


    }

}
