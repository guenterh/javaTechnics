package generics.owngenerics;

import generics.chapter217.TestInference;

import java.util.Date;

/**
 * Created by swissbib on 26.11.15.
 */
public class TestLeftBound{


    public static void main (String[] args) {


        TestLeftBound tl = new TestLeftBound();
        TestLeftBound t2 = new TestLeftBound();
        Interface1 ii = (Interface1) t2;
        ii.machwas();

    }


    public void machwas() {
        String hierGehtEsAb = "";
    }

}





class MyClass implements Interface1 {

    @Override
    public void machwas() {

    }
}
