import java.util.Random;
public class tester
{
    public static void main(String[] args) {

        Random r=new Random();
        int[][] a=new int[4][4];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                a[i][j]=r.nextInt(20);
                System.out.print(a[i][j]+"\t");
            }

            System.out.print("\n");
        }

    }
}