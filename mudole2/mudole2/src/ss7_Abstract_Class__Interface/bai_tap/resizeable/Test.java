package ss7_Abstract_Class__Interface.bai_tap.resizeable;

public class Test {
    public static void main(String[] args) {
        Resizeable[] resizeable= new Resizeable[3];
        resizeable[0]= new Circle("red",  true,5);
        resizeable[1]= new Rectangle("yellow", false, 5, 9);
        resizeable[2]= new Square("blue", false,15);

        for (Resizeable e: resizeable){
            if(e instanceof Circle){
                e.resize(50);
                System.out.println(e);
            }
            else if(e instanceof Rectangle){
                e.resize(50);
                System.out.println(e);
            }
            else if(e instanceof Square){
                e.resize(50);
                System.out.println(e);
            }
        }
    }
}
