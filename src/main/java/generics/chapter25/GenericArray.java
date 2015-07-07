package generics.chapter25;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by swissbib on 01.07.15.
 */
public class GenericArray <E /* Bounds ? */> {

    E[] nArr;

    public GenericArray(E... element) {
        nArr = element.clone();
        Arrays.sort(nArr);
    }

    public String toString() {
        return Arrays.toString(nArr);
    }

    public ByteArrayOutputStream writeToMemory() {
        //Serialisieren in ein Byte Array
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutput oout = new ObjectOutputStream(baos);
            oout.writeObject(nArr);
            oout.close();
            return baos;
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public E[] readFromMemory(ByteArrayOutputStream baos) {
        //Deserialisieren aus einem Byte Array
        try {
            ObjectInput oin = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            return (E[]) oin.readObject();

        } catch (Exception e) {
            return null;
        }
    }


    public static void main(String[] args) {
        GenericArray<Integer> iGA = new GenericArray<>(1,3,2);
        Integer[] arr = iGA.readFromMemory(iGA.writeToMemory());
        arr[0] = -1;

        System.out.println(Arrays.toString(arr));
        System.out.println(iGA);


        //shallow copy
        Date[] dArr =  {new Date(), new Date(0)};
        GenericArray<Date> dGa = new GenericArray<>(dArr);

        //sortierte Ausgabe
        System.out.println(dGa);
        // setzt Datum auf 1.1.1971
        dArr[1].setTime(24*3600*365*1000L);

        System.out.println(dGa);

    }

}
