package learningjava.generics.bounds;

import java.util.Date;

/**
 * Created by swissbib on 20.11.15.
 */


interface Listable {
    public void machWasDummer();
}

class MyClass implements Listable {

    @Override
    public void machWasDummer() {

    }
}

class MyClass1 extends MyClass {

}


public class BoundEx <E extends Object & Listable>  {


    E boundedVariable;

    public BoundEx(E bounded) {
        boundedVariable = bounded;
    }

    public E getBoundedElement () {
        return boundedVariable;
    }


    public static void main (String[] args) {
        BoundEx<MyClass>  b = new BoundEx<>(new MyClass1());
        b.getBoundedElement().machWasDummer();

    }

}
