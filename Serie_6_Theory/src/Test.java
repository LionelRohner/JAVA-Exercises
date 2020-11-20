
public class Test {
    public static void main ( String [] args ) {
        new A(). bla ();//calls bla method from A: prints "Hello from A"
        new A(). foo ();//calls foo method from A: prints "A.foo"
        new A(). bar ();//calls bar method from A, which calls the foo method
        new B(). bla ();//object of class B has var bla= Hello from B"
        //calls     bla method from A (not overriden in B): prints "Hello from B"

        new B(). foo ();//calls foo method from A: prints "A.foo"; this is
        //cause the child class B does not override the foo method of parent A

        new B(). bar ();//calls bar method from A (not overridden in child B),
        //which calls through same reference var (type B) the foo method;
        //however, this calls the foo method of A as foo is not overridden in child B
        new C(). bla ();//C is child of B; as its constructor is the constructor of B, calling
        //the bla method (from A) prints "Hello from B"
        new C(). foo ();//calls foo method of C: prints "C.foo"
        new C(). bar ();//calls bar method from A (not overridden in any of the 2 derived classes),
        //which calls through same reference var (type C) the foo method;
        //i.e. the overriden foo version of C is called; prints "C.foo"
    }
}

