package model;

public class User {
    private int id;
    private int cmnn;
    private String name;
    private int date;

    public User(int cmnn, String name, int date) {
        this.cmnn = cmnn;
        this.name = name;
        this.date = date;
    }

    public User(int id, int cmnn, String name, int date) {
        this.id = id;
        this.cmnn = cmnn;
        this.name = name;
        this.date = date;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCmnn() {
        return cmnn;
    }

    public void setCmnn(int cmnn) {
        this.cmnn = cmnn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
