package lfa;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener{

	private Janela janela;
	
	public Mouse(Janela janela) {
		this.janela = janela;
	}	

	@Override
	public void mouseMoved(MouseEvent e) {
		janela.mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	
	
}
