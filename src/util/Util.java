package util;

public class Util {

	public static boolean colide(Elemento a, Elemento b) {
		
		if (!a.isAtivo() || !b.isAtivo())
			return false;

		// posição no eixo X + largura do elemento A e B
		final int plA = a.getX() + a.getLargura();
		final int plB = b.getX() + b.getLargura();
		
		// posição no eixo Y + altura do elemento A e B
		final int paA = a.getY() + a.getAltura();
		final int paB = b.getY() + b.getAltura();
		
		if (plA > b.getX() && a.getX() < plB && 
			paA > b.getY() && a.getY() < paB) {
			return true;
		}
		return false;
	}	
	
	public static boolean colideX(Elemento a, Elemento b) {
		if (!a.isAtivo() || !b.isAtivo())
			return false;

		if (a.getX() + a.getLargura() >= b.getX() && a.getX() <= b.getX() + b.getLargura()) {
			return true;
		}

		return false;
	}
	
	public static void centraliza(Elemento el, int larg, int alt) {
		if (alt > 0)
			el.setY(alt / 2 - el.getAltura() / 2);

		if (larg > 0)
			el.setX(larg / 2 - el.getLargura() / 2);
	}
	
	
	public static boolean saiu(Elemento e, int largura, int altura) {
		if (e.getX() < 0 || e.getX() + e.getLargura() > largura)
			return true;

		if (e.getY() < 0 || e.getY() + e.getAltura() > altura)
			return true;

		return false;
	}	
	
}
