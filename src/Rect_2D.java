
/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {
	private Point_2D _p1;
	private Point_2D _p2;
	private Point_2D _p3;
	private Point_2D _p4;

	public Rect_2D(Point_2D p1, Point_2D p2) {
		this._p1 = p1;
		this._p2 = p2;
		double x1 = p1.x();
		double y1 = p1.y();
		double x2 = p2.x();
		double y2 = p2.y();
		Point_2D point1 = new Point_2D(x1 ,y2);
		Point_2D point2 = new Point_2D(x2 , y1);
		this._p3 = point1;
		this._p4 = point2;
	}

    public Rect_2D(Rect_2D t1) {
		this._p2 = t1._p2;
		this._p1 = t1._p1;

	}

	@Override
	public boolean contains(Point_2D ot) {
    Point_2D [] points = {this._p1 , this._p2 , this._p3 , this._p4};
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
		double x1 = this._p1.x();
		double x2 = this._p2.x();
		double y1 = this._p1.y();
		double y2 = this._p2.y();
		double yDis = Math.abs(y1-y2);
		double xDis = Math.abs(x1-x2);
		return xDis*yDis;
	}

	@Override
	public double perimeter() {
		double x1 = this._p1.x();
		double x2 = this._p2.x();
		double y1 = this._p1.y();
		double y2 = this._p2.y();
		double yDis = Math.abs(y1-y2);
		double xDis = Math.abs(x1-x2);
		return xDis*2 + yDis*2;
	}

	@Override
	public void translate(Point_2D vec) {
        double x1 = _p1.x() + vec.x();
		double y1 = _p1.y() + vec.y();
		double x2 = _p2.x() + vec.x();
		double y2 = _p2.y() + vec.y();
		this._p1 = new Point_2D(x1 , y1);
		this._p2 = new Point_2D(x2,y2);
	}

	@Override
	public GeoShape copy() {
		return new Rect_2D(this._p1 ,this._p2);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this._p1.scale(center , ratio);
		this._p2.scale(center , ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
	this._p2.rotate(center , angleDegrees);
	this._p1.rotate(center, angleDegrees);
	}
}
