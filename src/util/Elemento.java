package util;

import java.awt.Color;
import java.awt.Graphics2D;

public class Elemento {

	private int x;
	private int y;
	private int largura;
	private int altura;
	private float velocidade;
	private boolean ativo = true;
	private Color cor;
	
	public Elemento(){
		this(0,0,0,0);
	}
	
	public Elemento(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.largura = width;
		this.altura = height;
		}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}	
	
	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public void atualiza() { }
	
	public void desenha(Graphics2D g) {
		if (cor != null) 
			g.setColor(cor);
		g.drawRect(x, y, largura, altura);
	}
	
	public void incX(int x) { this.x = this.x + x; }
	public void incY(int y) { this.y = this.y + y; }	
	
	
}
