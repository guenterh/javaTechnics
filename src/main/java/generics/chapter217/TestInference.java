package generics.chapter217;

import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;

/**
 * Created by swissbib on 19.11.15.
 */
public class TestInference {
    static <T extends Object> void inference(T... args) {
        System.out.println(args.getClass());
    }


    public static void main (String[] args) {


        ReadableByteChannel rbc  = null;
        WritableByteChannel wbc = null;
        inference(rbc, wbc);

        inference (1,10l);

        TestInference.<CharSequence> inference (new String(), new StringBuffer());

    }




}
