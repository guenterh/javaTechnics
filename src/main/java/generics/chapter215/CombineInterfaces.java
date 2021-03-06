package generics.chapter215;


class Myclass extends CombineParentInterfaces
{

    @Override
    public String getMethodInterface1() {
        return null;
    }
}



/**
 * Created by swissbib on 30.06.15.
 */
public class CombineInterfaces <T extends CombineParentInterfaces  & InterfaceCombine1 & InterfaceCombine2> {


    private T t;

    public CombineInterfaces (T t) {
        this.t = t;
    }


    public String getCombineInterfaces() {

        String test = this.t.combineParentMethod1();
        //return ((CombineChildInterfaces)this.t).combineChildMethod1();
        return this.t.combineParentMethod1();

    }


    public static void main(String[] args) {

        CombineInterfaces<CombineParentInterfaces> combineChild = new CombineInterfaces<>(new CombineChildInterfaces());
        System.out.println(combineChild.getCombineInterfaces());


        CombineInterfaces<CombineParentInterfaces> combineChild1 = new CombineInterfaces<>(new Myclass());
        System.out.println(combineChild1.getCombineInterfaces());


    }


}
