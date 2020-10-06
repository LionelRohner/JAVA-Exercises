/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 2 Aufgabe 1                 *
\* ************************************************************************* */


import java.util.Random;

public class RandomISBN
{
    // Lionel Rohner (09-123-696)

    enum ordinals {First, Second, Third;}

    public static void main( String args[] )
    {
        for (ordinals items : ordinals.values()){
        System.out.println(items + " ISBN : " + makeISBN());
        }
    }

    /** generates and returns a random ISBN in the format XX-XXX-XX-C */
    public static String makeISBN()
    {
        // Do NOT change the declaration of the following variables!
        String laendercode;
        String bandnr;
        String verlagsnr;
        String checksum;

        // Intialize random generator
        Random generator = new Random();

        // Define integer variables
        int L1L2, B1B2B3, V1V2, C;

        // Generate random integers and 0 pad numbers
        L1L2 = generator.nextInt(98)+1;
        laendercode = String.format("%02d", L1L2);

        B1B2B3 = generator.nextInt(899)+100;
        bandnr = String.format("%03d", B1B2B3);

        V1V2 = generator.nextInt(98)+1;
        verlagsnr = String.format("%02d", V1V2);

        // I extracted the first index of the string and converted it to an integer
        // This step could have been done mathematically with modulo operations

        // L1L2 block
        char L1 = laendercode.charAt(0);
        int L1_1 = Character.getNumericValue(L1); //int L2 = L1L2%10;
        char L2 = laendercode.charAt(1);
        int L2_1 = Character.getNumericValue(L1);

        // B1B2B3 block
        char B1 = bandnr.charAt(0);
        int B1_1 = Character.getNumericValue(B1);
        char B2 = bandnr.charAt(1);
        int B2_1 = Character.getNumericValue(B2); //int B2 = B1B2B3%100/10;
        char B3 = bandnr.charAt(2);
        int B3_1 = Character.getNumericValue(B3);

        // V1V2 block
        char V1 = verlagsnr.charAt(0);
        int V1_1 = Character.getNumericValue(V1); //int V1 = V1V2/10;
        char V2 = verlagsnr.charAt(1);
        int V2_1 = Character.getNumericValue(V2);

        // Calculate C
        C = (hashOp(L1_1) + L2_1 + hashOp(B1_1) + B2_1 + hashOp(B3_1) + V1_1 + hashOp(V2_1)) % 10;

        // Transform to string
        checksum = String.valueOf(C);

        // Do not change the following line
        return laendercode + "-" + bandnr + "-" + verlagsnr + "-" + checksum;
    }

    /** multiplies i with 2 and subtracts 9 if result is >= 10 */
    public static int hashOp(int i)
    {
        // Do NOT change this method!
        int doubled = 2 * i;
        if (doubled >= 10) {
            doubled = doubled - 9;
        }
        return doubled;
    }
}
