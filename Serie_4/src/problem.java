public class problem {

    public static void main (String[] args){

        int limit = 90;
        String result = "";
        if (limit%3 == 0){

            for(int counter = 3; counter != limit ; counter += 3){
                result = result + counter + " ";}}
        else {
            result = "Upper limit is not divisible by 3";}

        System.out.println(result);
    }
}
