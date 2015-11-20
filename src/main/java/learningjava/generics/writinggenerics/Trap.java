package learningjava.generics.writinggenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swissbib on 20.11.15.
 */
public class Trap <T> {

    T trapped;
    List<T> trappedList = new ArrayList<>();
    public void snare (T trapped) {
        //this.trapped = trapped;
        trappedList.add(trapped);
    }

    public T release () {
        return trapped;
    }

    public List<T> releaseAll() {
        return this.trappedList;
    }


    public static void main (String[] args) {
        Trap<Mouse> mouseTrap = new Trap<>();
        mouseTrap.snare(new Mouse());

        Mouse mouse = mouseTrap.release();


        Trap<Mouse> mT = new Trap<>();
        mT.snare(new Mouse());
        mT.snare(new Mouse());

        List<Mouse> mouseList = mT.releaseAll();

        //Object m = mT.release();

        System.out.print("");
    }

}
