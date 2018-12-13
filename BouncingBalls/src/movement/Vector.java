package movement;

import javafx.geometry.Point2D;

public class Vector {

    private double  beginX,
                    beginY,
                    endX,
                    endY,
                    moduleX,
                    moduleY;

    public Vector(double beginX, double beginY, double endX, double endY){
        this.beginX = beginX;
        this.beginY = beginY;
        this.endX = endX;
        this.endY = endY;
        countModules();
    }
    public Vector(Point2D begin, Point2D end){
        this.beginX = begin.getX();
        this.beginY = begin.getY();
        this.endX = end.getX();
        this.endY = end.getY();
        countModules();
    }

    private void countModules(){
        this.moduleX = this.endX - this.beginX;
        this.moduleY = this.endY - this.beginY;
    }
    public void transfer(){
        this.beginX = this.endX;
        this.beginY = this.endY;
        this.endX += moduleX;
        this.endY += moduleY;
    }

    public void reverse() {
        double tmpX = this.beginX, tmpY = this.beginY;
        this.beginX = this.endX;
        this.beginY = this.endY;
        this.endX = tmpX;
        this.endY = tmpY;
        countModules();
    }
    public void reflectByX(){
        this.endY -= 2 * this.moduleY;
        countModules();
    }
    public void reflectByY(){
        this.endX -= 2 * this.moduleX;
        countModules();
    }
    public void oppose(){
        this.endX -= 2 * this.moduleX;
        this.endY -= 2 * this.moduleY;
        countModules();
    }
    public void add(Vector vector) {
        this.endX += vector.getModuleX();
        this.endY += vector.getModuleY();
        countModules();
    }
    public void multiply(double scalar){
        this.moduleX *= scalar;
        this.moduleY *= scalar;
        this.endX = this.beginX + this.moduleX;
        this.endY = this.beginY + this.moduleY;
    }

    /*public static Vector revert(Vector vector){
        return new Vector(vector.getBeginX(), vector.getBeginY(), vector.getEndX() - 2 * vector.getModuleX(), vector.getEndY() - 2 * vector.getModuleY());
    }
    public static Vector add(Vector vector1, Vector vector2){
        return new Vector(vector1.getBeginX(), vector1.getBeginY(), vector1.getEndX() + vector2.getModuleY(), vector1.getEndY() + vector2.getModuleY());
    }
    public static Vector multiply(Vector vector1, double scalar){
        return new Vector(vector1.getBeginX(), vector1.getBeginY(), vector1.getEndX() * scalar, vector1.getEndY() * scalar);
    }*/

    public double getBeginX() {
        return beginX;
    }
    public double getBeginY() {
        return beginY;
    }
    public double getEndX() {
        return endX;
    }
    public double getEndY() {
        return endY;
    }
    public double getModuleX() {
        return moduleX;
    }
    public double getModuleY() {
        return moduleY;
    }
    public Point2D getBeginPoint(){
        return new Point2D(this.beginX, this.beginY);
    }
    public Point2D getEndPoint(){
        return new Point2D(this.endX, this.endY);
    }
    public void setBeginX(double beginX) {
        this.beginX = beginX;
    }
    public void setBeginY(double beginY) {
        this.beginY = beginY;
    }
    public void setEndX(double endX) {
        this.endX = endX;
    }
    public void setEndY(double endY) {
        this.endY = endY;
    }
}
