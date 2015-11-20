package learningjava.generics.exceptiontester;

import learningjava.generics.entergenerics.Ex1;

import java.io.IOException;

/**
 * Created by swissbib on 20.11.15.
 */
public class ExceptionTester <T extends Throwable> {

    public void test (T exception ) throws T {
        throw exception;
    }


    public void betterTest (Class<T> t ) throws T {
        try {
            T exception = t.newInstance();
            exception.setStackTrace(new StackTraceElement[]{new StackTraceElement(
                    "meine Klasse","methiodName","fileName",10) });
            throw exception;
        } catch (IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }



    public static void main (String[] args) {


        try {
            ExceptionTester<IOException> et = new ExceptionTester<>();
            //et.test(new IOException("dies ist ein Test"));
            et.betterTest(IOException.class);
        } catch (Throwable t) {
            t.printStackTrace();
        }


    }



}
