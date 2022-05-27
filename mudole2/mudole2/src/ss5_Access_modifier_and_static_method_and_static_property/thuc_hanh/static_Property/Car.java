package ss5_Access_modifier_and_static_method_and_static_property.thuc_hanh.static_Property;

public class Car {
    private String name;
    private String engine;

    public static int numberOfCars;

    public Car(String name,String engine ){
        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }


}
