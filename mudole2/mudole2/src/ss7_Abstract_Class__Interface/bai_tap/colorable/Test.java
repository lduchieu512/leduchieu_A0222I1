package ss7_Abstract_Class__Interface.bai_tap.colorable;

public class Test {
    public static void main(String[] args) {
        Shape[] arr = new Shape[3];
        arr[0]= new Circle( "red", true,5);
        arr[1]= new Rectangle("yellow", false, 5, 9);
        arr[2]= new Square("blue", false,15);

        for(Shape s : arr){
            System.out.println(s.getClass().getSimpleName() + " with perimeter: " + s.getPerimeter());

            if(s instanceof Square){
                ((Square) s).howToColor();
            }
        }
    }


}
