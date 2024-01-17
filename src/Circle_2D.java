
/** 
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex4: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle_2D implements GeoShape{
	private Point_2D _center;
	private double _radius;

	public Circle_2D(Point_2D cen, double rad) {
		this._center = new Point_2D(cen);
		this._radius = rad;
	}

	public double getRadius() {return this._radius;}

	public Point_2D getCenter(){ return _center;}

	@Override
	public String toString() {
		String circle = _center.toString() + " " + _radius;
		return circle;
	}

	@Override
	public boolean contains(Point_2D ot) {
		if(ot.distance(_center) < _radius){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public double area() {
		return Math.PI*_radius*_radius;

	}

	@Override
	public double perimeter() {
		return 2*Math.PI*_radius;
	}

	@Override
	public void translate(Point_2D vec) {
		Point_2D newC = new Point_2D(vec.x()+ _center.x() , vec.y()+ _center.y());
		this._center = newC;
	}

	@Override
	public GeoShape copy() {
		return new Circle_2D(this._center , this._radius);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this._center = center;
		this._radius = _radius*ratio;
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
     	_center.rotate(center, angleDegrees);
	}

}
