package ss6_Ke_thua.bai_tap.lop_Point_va_MoveablePoint;

public class MoveblePoint extends Point2D {
    private float xSpeed , ySpeed ;


    public MoveblePoint() {
    }

    public MoveblePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveblePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        return new float[]{xSpeed,ySpeed};
    }
    public void setSpeed(float ySpeed,float xSpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveblePoint move(){
        setX(getX()+ xSpeed);
        setY(getY()+ ySpeed);
        return this;
    }

    @Override
    public String toString() {
        String res= String.format("(x= %f, y= %f), speed= (xSpeed= %f, xSpeed= %f)", getX(), getY(), getxSpeed(), getySpeed());
        return res;
    }

}
