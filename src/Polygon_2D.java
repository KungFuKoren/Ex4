import java.util.ArrayList;

public class Polygon_2D implements GeoShape{
	////// add your code here //////
	private ArrayList<Point_2D>  points = new ArrayList<>();


	////////////////////////////////
	public Polygon_2D() {
		points = new ArrayList<>();
	}

	public Polygon_2D(Polygon_2D po) {
		Point_2D[] polyPoints = po.getAllPoints();
		for (int i = 0; i < polyPoints.length; i++) {
			this.points.add(polyPoints[i]);
		}

	}

	public Polygon_2D(ArrayList<Point_2D> poi) {
		points = new ArrayList<>();
		for (int i = 0; i < poi.size() ; i++) {
			points.add(poi.get(i));
		}
	}

	public Point_2D[] getAllPoints() {
		Point_2D [] polyPoints = new Point_2D[points.size()];
		for (int i = 0; i < points.size() ; i++) {
             polyPoints[i] = points.get(i);
		}
		return polyPoints;
	}

	public void add(Point_2D p) {
		points.add(p);
	}

	@Override
	public String toString() {
		Point_2D[] polyPoints = getAllPoints();
		String str ="";

		for (int i = 0; i <polyPoints.length ; i++) {
			str += polyPoints[i].toString();
		}
		return str;
	}

	@Override
	public boolean contains(Point_2D ot) {
		int count = 0;
		for (int i = 0; i < points.size(); i++) {
			double currX = ot.x();
			double currY = ot.y();
			Point_2D firstEdge = points.get(i);
			double x1 = firstEdge.x();
			double y1 = firstEdge.y();
			Point_2D secondEdge = points.get((i+1)% points.size());
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
		double ans = 0;
		for (int i = 0; i < points.size() ; i++) {
			Point_2D currP = points.get(i);
			Point_2D nextP = points.get(i+1);
			int x1 = currP.ix();
			int y1 = currP.iy();
			int x2 = nextP.ix();
			int y2 = nextP.iy();
            ans += (x1*y2 - x2*y1);
		}

		return ans;

	}

	@Override
	public double perimeter() {
		double distance = 0;
		for (int i = 0; i < points.size()-1; i++) {
			distance =points.get(i).distance(points.get(i+1));
		}
		distance += points.get(0).distance(points.get(points.size()-1));
		return distance;

	}

	@Override
	public void translate(Point_2D vec) {
		int size = points.size();
		for (int i = 0; i < size ; i++) {
			double y1 = vec.y();
			double x1 = vec.x();
			double x2 = points.get(i).x();
			double y2 = points.get(i).y();
			Point_2D point = new Point_2D(x1+x2 , y1+y2);

			points.set(i,point);
		}
	}

	@Override
	public GeoShape copy() {
		return new Polygon_2D(this.points);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		for (int i = 0; i < points.size() ; i++) {
			points.get(i).scale(center , ratio);
		}
	}


	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i < points.size() ; i++) {
			points.get(i).rotate(center , angleDegrees);
		}
	}

}
