package shape;

import java.awt.Graphics;

public abstract class Shape {
	// 자식들이 사용해야함 private -> protected
	protected int x1, y1, x2, y2, x3, y3;
	
	
	// 원점 함수
	public void setOrigin(int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}
	
	// 좌표 함수
	public void setPoint(int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}
	
	public void addPoint(int x, int y) {
		this.x3 = x;
		this.y3 = y;
	}
	
	
	abstract public void draw(Graphics graphics);

}
