package lfa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import util.Elemento;
import util.Texto;
import util.Util;

public class Tela extends JPanel {
	
	private float inc = 0.5f;
	
	private Janela janela;
	private Bola bola;
	private Elemento esquerda;
	private Elemento direita;
	private Ponto pontoA;
	private Ponto pontoB;
	private boolean reiniciarJogo;
	private Texto textoPausa = new Texto(Ponto.fonte);
	
	public Tela(Janela janela, int largura, int algura) {
		this.janela = janela;
		
		bola = new Bola();
		esquerda = new Elemento();
		direita = new Elemento();
		
		pontoA = new Ponto();
		pontoB = new Ponto();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(janela.buffer, 0, 0, null);
	}

	public void atualizaJogo() {
		if (janela.fimDoJogo) {
			return;
		}
		if (janela.pausado) {
			return;
		}
		bola.incPX();
		bola.incPY();
		
		if (janela.controlaTecla[0]) {
			esquerda.incY((int) esquerda.getVelocidade() * -1);
		}
		else if (janela.controlaTecla[1]) {
			esquerda.incY((int) esquerda.getVelocidade());
		}
		
		if (direita.getY() + direita.getAltura() / 2 > janela.mouseY + direita.getVelocidade()) {
			direita.incY((int) direita.getVelocidade() * -1);
		}
		else if (direita.getY() + direita.getAltura() / 2 < janela.mouseY - direita.getVelocidade()) {
			direita.incY((int) direita.getVelocidade());
		}
		
		validaPosicao(esquerda);
		validaPosicao(direita);
		
		if (reiniciarJogo) {
			reiniciarJogo = false;
			bola.inverteX();
			bola.setVelocidade(janela.velocidade);
			Util.centraliza(bola, janela.JANELA_LARGURA, janela.JANELA_ALTURA);
		}
		else {
			reiniciarJogo = validaColisao(bola);
		}
		
		validaPosicao(bola);
	}
	
	private boolean validaColisao(Bola bola) {
		boolean saiu = false;
		
		if (Util.colide(esquerda, bola)) {
			rebate(esquerda, bola);
		}
		else if (Util.colide(direita, bola)) {
			rebate(direita, bola);
		}
		else if (bola.getX() < 0 || bola.getX() + bola.getLargura() > janela.JANELA_LARGURA) {
			saiu = true;
			if (bola.getX() < 0) {
				pontoB.add();
			}
			else {
				pontoA.add();
			}
		}
		else if (bola.getY() < 0 || bola.getY() + bola.getAltura() > janela.JANELA_LARGURA) {
			bola.inverteY();
		}
		return saiu;
	}

	private void rebate(Elemento raquete, Bola bola) {
		float vx = bola.getVeloX();
		float vy = bola.getVeloY();
		
		//parte de cima da raquete;
		if (bola.getY() < (raquete.getY() + raquete.getAltura()) / 3) {
			bola.setDirY(-1);
			vx += inc;
			vy += inc;
			if (bola.getY() < raquete.getY()) {
				vy += inc;
			}			
		}
		//parde de baixo da raquete
		else if (bola.getY() > raquete.getY() + raquete.getAltura() - raquete.getAltura() / 3) {
			bola.setDirY(1);
			vx += inc;
			vy += inc;
			if (bola.getY() + bola.getAltura() > raquete.getY() + raquete.getAltura()) {
				vy += inc;
			}		
		}
		else {
			vx += inc;
			vy = 1;
		}
		
		bola.inverteX();
		bola.incVelocidade(vx, vy);
	}
	

	private void validaPosicao(Elemento el) {
		if (el.getY() < 0) {
			el.setY(0);
		}
		else if (el.getY() + el.getAltura() > janela.JANELA_ALTURA) {
			el.setY(janela.JANELA_ALTURA - el.getAltura());
		}
	}

	public void carregaJogo() {
		bola.setVelocidade(janela.velocidade);
		pontoA.setX(janela.JANELA_LARGURA / 2 - 120);
		pontoA.setY(Ponto.TAM_FONTE);
		
		pontoB.setX(janela.JANELA_LARGURA / 2 + 120);
		pontoB.setY(Ponto.TAM_FONTE);
		
		esquerda.setVelocidade(5);
		esquerda.setAltura(70);
		esquerda.setLargura(5);
		esquerda.setCor(Color.WHITE);
		
		
		direita.setVelocidade(5);
		direita.setAltura(70);
		direita.setLargura(5);
		direita.setCor(Color.WHITE);
		direita.setX(janela.JANELA_LARGURA - direita.getLargura());
		
		Util.centraliza(bola, janela.JANELA_LARGURA, janela.JANELA_ALTURA);
		Util.centraliza(esquerda, 0, janela.JANELA_ALTURA);
		Util.centraliza(direita, 0, janela.JANELA_ALTURA);
		
		bola.setAtivo(true);
		esquerda.setAtivo(true);
		direita.setAtivo(true);
	}

	public void desenhar(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, janela.getWidth(), janela.getHeight());
		
		for (int i = 0; i < janela.JANELA_ALTURA; i += 20) {
			g.setColor(Color.WHITE);
			g.drawRect(janela.getWidth() / 2 - 2, i, 4, 10);
		}
		
		pontoA.desenha(g);
		pontoB.desenha(g);
		
		bola.desenha(g);
		
		esquerda.desenha(g);
		direita.desenha(g);
		
		if (janela.pausado) {
			textoPausa.desenha(g, "PAUSA", janela.JANELA_LARGURA / 2 - Ponto.TAM_FONTE, janela.JANELA_ALTURA / 2);
		}
	}
	
}