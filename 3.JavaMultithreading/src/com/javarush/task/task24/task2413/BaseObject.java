package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double x,y,radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    abstract void draw(Canvas canvas);
    abstract void move();
    boolean isIntersec(BaseObject baseObject){
        double dist = Math.sqrt(Math.pow(this.x -baseObject.getX(),2) +
                Math.pow(this.y - baseObject.getY(),2));
        return (dist <= this.radius || dist <= baseObject.getRadius());
    }
}
