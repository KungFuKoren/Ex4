
/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{
	private Point_2D _p1;
	private Point_2D _p2;


	public Segment_2D(Point_2D a, Point_2D b) {
		this._p1 = a;
		this._p2 = b;
	}

	public Segment_2D(Segment_2D t1) {
		this._p1 = t1.get_p1();
		this._p2 = t1.get_p2();
	}

	public Point_2D get_p1() {
		return this._p1;
	}

	public Point_2D get_p2() {
		return this._p2;
	}

	@Override
	public boolean contains(Point_2D ot) {
		return false;
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		double ans = _p1.distance() * 2;
		return ans;
	}
	@Override
	public void translate(Point_2D vec) {
     double x1 = _p1.x();
		Point_2D pVec1 = new Point_2D(_p1.x()+ vec.x() , _p1.y()+vec.y());
		Point_2D pVec2 = new Point_2D(_p2.x()+ vec.x() , _p2.y()+vec.y());
       this._p1 = pVec1;
		this._p2 = pVec2;
	}

	@Override
	public GeoShape copy() {
		return new Segment_2D(_p1 , _p2);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
        this._p1.scale(center , ratio);
		this._p2.scale(center , ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this._p1.rotate(center , angleDegrees);
		this._p2.rotate(center , angleDegrees);
	}
}