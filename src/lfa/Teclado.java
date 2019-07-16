package lfa;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private Janela janela;
	
	public Teclado(Janela janela) {
		this.janela = janela;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		setTecla(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		setTecla(e.getKeyCode(), false);
	}

	private void setTecla(int tecla, boolean pressionada) {
		switch (tecla) {
		case KeyEvent.VK_UP: janela.controlaTecla[0] = pressionada;
			break;
		case KeyEvent.VK_DOWN: janela.controlaTecla[1] = pressionada;
		break;
		case KeyEvent.VK_LEFT: janela.controlaTecla[2] = pressionada;
		break;
		case KeyEvent.VK_RIGHT: janela.controlaTecla[3] = pressionada;
		break;
		case KeyEvent.VK_ESCAPE: janela.controlaTecla[4] = pressionada;
		break;
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE: 
			janela.controlaTecla[5] = pressionada;
		break;	
		}
	}
	
	
	
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
	}

	
	
}
