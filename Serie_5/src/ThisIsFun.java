public class ThisIsFun {

    int a;
    int b;

    public void setData(int a, int b){
        this.a = a;
        this.b = b;
    }

    public static void main (String[] arg){


        ThisIsFun t = new ThisIsFun();

        t.setData(3,4);

        System.out.println(t.a);
        System.out.println(t.b);
    }
}
