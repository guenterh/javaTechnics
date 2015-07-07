package generics.chapter24;

/**
 * Created by swissbib on 01.07.15.
 */
public class NotInCatch<E extends RuntimeException> {

    public void wrong() {
        try {
            int i = 0 / 0;
            // not allowed: in catch ist keine Typvariable erlaubt
            //} catch (E e) {}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String args[]) {

        NotInCatch c = new NotInCatch();
        c.wrong();

        GenException<IllegalArgumentException> genEx = new GenException<>(new IllegalArgumentException("das war's"));
        try {
            genEx.thatIsOk();
        } catch (RuntimeException e){
            e.printStackTrace();
        }

    }

}


class GenException <E extends RuntimeException>  {
    E e;

    public GenException (E e) {
        this.e = e;
    }

    public void thatIsOk () throws E {
        throw e;
    }

}
