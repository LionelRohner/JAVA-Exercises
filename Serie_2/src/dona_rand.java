import java.text.DecimalFormat;
import java.util.Random;
public class dona_rand
{

    public static void main( String args[])
    {
        // TODO: Insert your code here!
        // for loop to execute the method makeISBN 3 times and print result
        for (int i = 0; i < 3; i++){
            System.out.println("ISBN no." + (i+1) + ": " + makeISBN());
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

        // TODO: Insert your code here!

        // Initialize new instance of random class
        Random rand = new Random();

        // Initialize 3 random Integers
        // L > 0 and format = LL
        int randL = rand.nextInt(98)+1;
        // B ≥ 100 and format = BBB
        int randB = rand.nextInt(899)+100;
        // V > 0 and format = VV
        int randV = rand.nextInt(98)+1;

        // convert int to string of correct length
        laendercode = String.format("%02d", randL); // 2 digits are printed; if int would only have 1 digit, a zero is written before.
        bandnr = String.format("%03d", randB);
        verlagsnr = String.format("%02d", randV);

        // split the digits (by modulo and int-division) and store the results
        int Ldig2 = randL % 10;
        randL = randL / 10;
        int Ldig1 = randL % 10;

        int Bdig3 = randB % 10;
        randB = randB / 10;
        int Bdig2 = randB % 10;
        randB = randB / 10;
        int Bdig1 = randB % 10;

        int Vdig2 = randV % 10;
        randV = randV / 10;
        int Vdig1 = randV % 10;

        // calculate checksum
        checksum = Integer.toString((hashOp(Ldig1) +Ldig2 +hashOp(Bdig1) +Bdig2 +hashOp(Bdig3) +Vdig1 +hashOp(Vdig2)) % 10);

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