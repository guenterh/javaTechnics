package generics.chapter215;

/**
 * Created by swissbib on 30.06.15.
 */
public class BetterNumberService <T extends Number> {

    private T t;

    public BetterNumberService(T t) {
        this.t = t;
    }

    public boolean equalVal1 (T t) {

        return this.t.intValue() == t.intValue();
    }


    public static void main (String[] args) {

        BetterNumberService<Double> bns = new BetterNumberService<>(10.0);
        System.out.println(bns.equalVal1(11d));

    }

}
