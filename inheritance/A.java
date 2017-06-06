package inheritance;

/**
 * Created by swapn on 2/7/2017.
 */
class Z {
    public int v = 0;
    public int value(){
        return v;
    }
}

class Y extends Z{
    public int v = 1;
    public int value(){
        return v;
    }

    public int value2(){
        return 224;
    }
}

class X extends Y{
    //public int v = 2;
    public int v2 = 3;
    public int value(){
        return v2;
    }

    public int value3(){
        return 339;
    }
}
public class A {
    public static void main(String[] args){
        Z z = new X();
        int ans = z.v;
        System.out.println(ans); // 0
        ans = z.value();
        System.out.println(ans); // 2
        // ans = z.value2();
        Y y = (Y)z;
        ans = y.v;
        System.out.println(ans); // 1
        ans = y.value();
        System.out.println(ans); // 2
        ans = y.value2();
        System.out.println(ans); // 224
        X x = (X)z;
        ans = x.v;
        System.out.println(ans); // 2
        ans = x.value();
        System.out.println(ans); // 2
        ans = x.value2();

        System.out.println(ans); // 224
        Z z1 = (Z)x;
        ans = z1.value();
        System.out.println(ans);

        // reference of parent type can refer to child object but not vice versa.
        // child object can be type casted to parent object ? yes
        //instance variables CANNOT be overridden in Java. In Java only methods can be overridden.

        // When you declare a field with the same name as an existing field in a superclass,
        // the new field hides the existing field.
        // The existing field from the superclass is still present in the subclass,
        // and can even be used ... subject to the normal Java access rules.

        //in java,the compiler goes by the reference,not by the instance.
        // To get over this compiler uses Runtime polymorphism
        // ,but it is for the methods,not the instance variables.
        // So variables cannot be accessed without type-casting and the methods unless
        // ,overridden(Runtime polymoprhism),cannot be accessed without type-casting.
    }
}
