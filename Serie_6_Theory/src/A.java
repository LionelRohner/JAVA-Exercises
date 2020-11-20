public class A{
    protected String bla;
    public A(){ this .bla = " Hello from A"; } //constructor
    public void bla (){ System .out . println ( this .bla ); } //prints var bla
    public void foo (){ System .out . println ("A.foo "); }
    public void bar (){ this .foo (); } //calls again the method foo, through the same reference var as bar is called
}
