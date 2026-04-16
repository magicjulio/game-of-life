package data;

import java.lang.Math;

// This class is representing a cartesian coordinate in a 2d space with double coordinates.
public class DebugData {
    private double x;
    private double y;
    
    public DebugData(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double distance(DebugData other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.x;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public String toString() {
        return String.format("(%g, %g)", this.x, this.y);
    }
}