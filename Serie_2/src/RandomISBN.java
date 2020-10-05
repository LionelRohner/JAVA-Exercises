/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 2 Aufgabe 1                 *
\* ************************************************************************* */

import java.text.DecimalFormat;
import java.util.Random;

public class RandomISBN
{
    // Lionel Rohner (09-123-696)

    public static void main( String args[] )
    {
        System.out.println(makeISBN());
    }

    /** generates and returns a random ISBN in the format XX-XXX-XX-C */
    public static String makeISBN()
    {
        // Do NOT change the declaration of the following variables!
        String laendercode;
        String bandnr;
        String verlagsnr;
        String checksum;

        Random generator = new Random();
        int L1L2, B1B2B3, V1V2, C;

        L1L2 = generator.nextInt(98)+1;
        laendercode = String.format("%02d", L1L2);

        B1B2B3 = generator.nextInt(899)+100;
        bandnr = String.format("%03d", B1B2B3);

        V1V2 = generator.nextInt(98)+1;
        verlagsnr = String.format("%02d", V1V2);

        C = (L1L2+B1B2B3+V1V2)%10;
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
