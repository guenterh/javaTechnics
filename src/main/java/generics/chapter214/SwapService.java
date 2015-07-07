package generics.chapter214;

/**
 * Created by swissbib on 30.06.15.
 */
public class SwapService <T>{

    private T t;


    public SwapService(T t) {

        setT(t);
    }

    public void setT(T t) {
        this.t = t;
    }


    public T getT () {
        return this.t;
    }


    public T swap (T withArg) {
        T tmp = withArg;

        withArg = this.getT();
        setT(tmp);
        return withArg;
    }


    public static void main (String [] args) {

        SwapService<String> ss1 = new SwapService<>("Hallo ");

        System.out.println(ss1.swap("Welt") + ss1.getT());

        SwapService<Double> ss2 = new SwapService<>(1.23);;
        System.out.println(ss2.swap(-1.23) + ss2.getT());

        StringBuffer sb = new StringBuffer("Welt");
        SwapService<CharSequence> ss3 = new SwapService<CharSequence>("Hallo ");
        System.out.println(ss3.swap(sb) + " " + ss3.getT());




    }


}


