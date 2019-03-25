package drawingPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import global.Constants.EToolBar;
import shape.Shape;

public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
 
	
	private MouseHandler mouseHander;
	
	private Shape currentTool;
	public void setCurrentTool(EToolBar currentTool) {
		this.currentTool = currentTool.getShape();
		
	}
	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		
		this.mouseHander = new MouseHandler();
		this.addMouseListener(this.mouseHander);
		this.addMouseMotionListener(this.mouseHander);
		
		currentTool = EToolBar.rectangle.getShape();
	}
	
	private void drawShape() {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentTool.draw(graphics);		
	}
	
	private void initDrawing(int x, int y) {
		// �ʱ�ȭ
		this.currentTool.setOrigin(x, y);
		this.drawShape();
	}
	
	private void keepDrawing(int x, int y) {
		this.drawShape();
		// �ٽ� �׸���
		this.currentTool.setPoint(x, y);
		this.drawShape();
	}
	
	// �߰� ���� ��� �Լ�
	private void continueDrawing(int x, int y) {
		this.currentTool.addPoint(x, y);
	}
	
	private void finishDrawing(int x, int y) {
		this.drawShape();
		// �ٽ� �׸���
		this.currentTool.setPoint(x, y);
		this.drawShape();
	}
	
	
	private class MouseHandler implements MouseListener, MouseMotionListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1) {
				initDrawing(e.getX(), e.getY());
			} else if (e.getClickCount() == 2) {
				finishDrawing(e.getX(), e.getY());
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			initDrawing(e.getX(), e.getY());
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			finishDrawing(e.getX(), e.getY());
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
			keepDrawing(e.getX(), e.getY());
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
		
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			keepDrawing(e.getX(), e.getY());
			
		}
		
	}

	
	
}
