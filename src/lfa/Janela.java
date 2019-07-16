package lfa;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

import javax.swing.JFrame;

public class Janela extends JFrame {

	public BufferedImage buffer;
	public Graphics2D g2d;
	public int mouseY;
	
	public Boolean fimDoJogo = false;
	public Boolean pausado = false;
	
	private final int fps = 50;
	public static final int JANELA_LARGURA = 540;
	public static final int JANELA_ALTURA = 680;
	public float velocidade = 3;
	
	private Tela tela;
	private Boolean jogando = true;	
	public boolean[] controlaTecla = new boolean[6];	
	
	public Janela() {
		
		Teclado teclado = new Teclado(this);
		addKeyListener(teclado);
		
		Mouse mouse = new Mouse(this);
		addMouseMotionListener(mouse);	
		
		buffer = new BufferedImage(JANELA_LARGURA, JANELA_ALTURA, BufferedImage.TYPE_INT_RGB);
		g2d = buffer.createGraphics();
		
		tela = new Tela(this, JANELA_LARGURA, JANELA_ALTURA);
		add(tela);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(JANELA_LARGURA, JANELA_ALTURA);
		setResizable(false);
		setVisible(true);
				
		tela.carregaJogo();
		iniciaAnimacao();
		
	}

	private void iniciaAnimacao() {
		long atualiza = 0;
		
		while (jogando) {
			if (System.currentTimeMillis() >= atualiza) {
				tela.atualizaJogo();
				
				tela.desenhar(g2d);
				
				this.repaint();
				atualiza = System.currentTimeMillis() + fps;
			} 
		}
	}
	
	public static void main(String[] args) {
		new Janela();
	}
	
}
