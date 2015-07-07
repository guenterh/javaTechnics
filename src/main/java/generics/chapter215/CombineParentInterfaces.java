package generics.chapter215;

/**
 * Created by swissbib on 30.06.15.
 */
public class CombineParentInterfaces implements InterfaceCombine1, InterfaceCombine2 {

    public String combineParentMethod1() {
        return "parentMethod1";
    }

    @Override
    public String getMethodInterface1() {
        return "getMethodInterface1";
    }

    @Override
    public String getMethodInterface2() {
        return "getMethodInterface2";
    }
}
