package global;

import shape.Shape;
import shape.Rectangle;


public class Constants {
	
	public enum EMainFrame {
		x(200),
		y(100),
		w(400),
		h(600),
		;
		
		private int value;
		private EMainFrame(int value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	public enum EToolBar {
		rectangle("�׸�", new Rectangle()),
		rectangle1("�׸�", new Rectangle()),
		rectangle2("�׸�", new Rectangle()),
		;
		
		private String text;
		private Shape shape;
		private EToolBar(String text, Shape shape) {
			this.text = text;
			this.shape = shape;
		}
		public String getText() {
			return this.text;
		}
		public Shape getShape() {
			return this.shape;
		}
		
	}
	
	public enum EMenu {
		fileMenu("File"),
		editMenu("Edit"),
		;
		
		private String text;
		private EMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		newItem("new"),
		openItem("open"),
		;
		
		private String text;
		private EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		
	}

}
