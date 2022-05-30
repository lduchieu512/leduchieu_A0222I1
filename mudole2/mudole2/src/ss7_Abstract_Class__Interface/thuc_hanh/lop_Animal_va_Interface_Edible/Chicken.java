package ss7_Abstract_Class__Interface.thuc_hanh.lop_Animal_va_Interface_Edible;

public class Chicken extends Animal implements Edible{

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
