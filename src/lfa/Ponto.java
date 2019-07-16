package lfa;

import java.awt.Font;
import java.awt.Graphics2D;

import util.Texto;

public class Ponto extends Texto {
	
	public static final int TAM_FONTE = 60;
	public static final Font fonte = new Font("Consolas", Font.PLAIN, TAM_FONTE);
	
	private short ponto;

	public short getPonto() {
		return ponto;
	}

	public void setPonto(short ponto) {
		this.ponto = ponto;
	}
	
	public void add() {
		ponto++;
	}
	
	@Override
	public void desenha(Graphics2D g) {
		super.desenha(g, Short.toString(ponto), getX(), getY());
	}

}
