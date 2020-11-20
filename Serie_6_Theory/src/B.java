public class B extends A{
    public B(){ //constructor
        super ();//calls constuctor from parent, bla= Hello from A
        this .bla = " Hello from B"; //overwrites bla with this; calling constructor from parent was thus for nothing
    }
}