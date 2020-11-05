interface WaterBottleInterface{

    // basically an outline

    String color = "Blue";

    void fillUp();
}


public class InterfacesRFun implements WaterBottleInterface {

        public static void main (String[] args){

            System.out.println(color);

            InterfacesRFun example = new InterfacesRFun();

            example.fillUp();
    }

    // everything in the interface must be in the class
    public void fillUp() {
        System.out.println("It got filled");
    }
}
