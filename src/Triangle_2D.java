
/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape{
	private Point_2D _p1;
	private Point_2D _p2;
	private Point_2D _p3;

	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this._p1 = p1;
		this._p3 = p3;
		this._p2 = p2;
	}

	public Triangle_2D(Triangle_2D t1) {
		this._p2 = t1._p2;
		this._p1 = t1._p1;
		this._p3 = t1._p3;
	}

	public Point_2D[] getAllPoints() {
		Point_2D[] points = {this._p2 , this._p3 , this._p1};
		return points;
	}

	@Override
	public boolean contains(Point_2D ot) {
		Point_2D [] points = {this._p1 , this._p2 , this._p3};
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			double currX = ot.x();
			double currY = ot.y();
			Point_2D firstEdge = points[i];
			double x1 = firstEdge.x();
			double y1 = firstEdge.y();
			Point_2D secondEdge = points[(i+1)% points.length];
			double x2 = secondEdge.x();
			double y2 = secondEdge.y();
			if(currY < y2 && currY > y1){
				double xAdd = x1 + (currY - y1)/(y2-y1)*(x2-x1);
				if(x1>x2){
					if(currX > xAdd){
						count ++;
						continue;
					}
				}
				if(x2>x1){
					if (currX < xAdd) {
						count ++;
						continue;
					}
				}
				else{
					count ++;
					continue;
				}
			}
			if(currY < y1 && currY > y2){
				double xAdd = x1 + (currY - y2)/(y1-y2)*(x2-x1);
				if(x1>x2){
					if(currX > xAdd){
						count ++;
						continue;
					}
				}
				if(x2>x1){
					if (currX < xAdd) {
						count ++;
						continue;
					}
				}
				else{
					count ++;
					continue;
				}
			}
		}
		return count%2 == 1;
	}

	@Override
	public double area() {
		double per = (_p1.distance(_p2) + _p2.distance(_p3) + _p3.distance(_p1))/2;
		double a = _p1.distance(_p2);
		double b = _p2.distance(_p3);
		double c = _p3.distance(_p1);
		double area = Math.sqrt(per*(per-a)*(per-b)*(per-c));

		return area;
	}

	@Override
	public double perimeter() {
		double per = _p1.distance(_p2) + _p2.distance(_p3) + _p3.distance(_p1);
		return per;
	}

	@Override
	public void translate(Point_2D vec) {
		this._p1 = new Point_2D(_p1.x()+ vec.x() , _p1.y() + vec.y());
		this._p2 = new Point_2D(_p2.x()+ vec.x() , _p2.y() + vec.y());
		this._p3 = new Point_2D(_p3.x()+ vec.x() , _p3.y() + vec.y());

	}

	@Override
	public GeoShape copy() {
		Point_2D newP1 = this._p1;
		Point_2D newP2 = this._p2;
		Point_2D newP3 = this._p3;
		Triangle_2D newTri = new Triangle_2D(newP1 , newP2 , newP3);
		return newTri;
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this._p1.scale(center , ratio);
		this._p2.scale(center , ratio);
		this._p3.scale(center , ratio);

	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
 		this._p1.rotate(center , angleDegrees);
		this._p2.rotate(center , angleDegrees);
		this._p3.rotate(center , angleDegrees);

	}
}
