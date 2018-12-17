package movement;

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
    public void multiplyX(double scalar){
        this.moduleX *= scalar;
        this.endX = this.beginX + this.moduleX;
    }
    public void multiplyY(double scalar){
        this.moduleY *= scalar;
        this.endY = this.beginY + this.moduleY;
    }
    public void multiply(double scalar){
        multiplyX(scalar);
        multiplyY(scalar);
    }

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
