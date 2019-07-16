package lfa;

import java.awt.Color;
import java.awt.Graphics2D;

import util.Elemento;

public class Bola extends Elemento {
	
	private static final int VEL_INICIAL = 3;
	private int dirX = -1;
	private int dirY = -1;	
	private float veloX;
	private float veloY;
	
	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public float getVeloX() {
		return veloX;
	}

	public void setVeloX(float veloX) {
		this.veloX = veloX;
	}

	public float getVeloY() {
		return veloY;
	}

	public void setVeloY(float veloY) {
		this.veloY = veloY;
	}
	
	public void incVelocidade(float vx, float vy) {
		veloX = vx;
		veloY = vy;
	}
	
	public void inverteX() {
		dirX *= -1;
	}
	
	public void inverteY() {
		dirY *= -1;
	}
	
	public void incPX() {
		super.incX((int) veloX * dirX);
	}
	
	public void incPY() {
		super.incY((int) veloY * dirY);
	}
	
	public Bola() {
		veloX = veloY = VEL_INICIAL;
		setAltura(10);
		setLargura(10);
		setCor(Color.WHITE);
	}
	
	@Override
	public void desenha(Graphics2D g) {
		if (!isAtivo()) {
			return;
		}
		g.setColor(getCor());
		g.fillOval(getX(), getY(), getLargura(), getAltura());
	}

}
