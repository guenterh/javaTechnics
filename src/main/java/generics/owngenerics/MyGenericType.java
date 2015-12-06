package generics.owngenerics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Created by swissbib on 26.11.15.
 */
public class MyGenericType <E, T> extends ArrayList<E> implements MyInterface{


    private T myParam;


    public MyGenericType (T paramInConstructor) {
        this.myParam = paramInConstructor;
        Collection<E> tempCollection = new ArrayList<>();

        DoWeHaveGenericException dd = new DoWeHaveGenericException();
        try {
            dd.isThisPossible(new IOException());
        } catch (Throwable r) {
            //r.printStackTrace();
        }
    }

    @Override
    public <V, R> R getSomeThing(V  myParam) {
        return null;
    }
}


class DoWeHaveGenericException<T extends IOException> {

    void isThisPossible (T myException) throws T {

        throw myException;

    }

}
