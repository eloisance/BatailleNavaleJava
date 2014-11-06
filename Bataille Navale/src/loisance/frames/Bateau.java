package loisance.frames;

import java.util.Random;

public class Bateau {
	
	private int taille;
	private int xStart, xEnd, yStart, yEnd;
	private String orientation;
	Random maSerie = new Random();
	
	// Constructeur
	public Bateau()
	{
		this.taille = 0;
	}
	
	
	// Accesseurs
	public int getxStart() {
		return xStart;
	}
	
	public void setxStart(int value) {
		this.xStart = value;
	}
	
	public int getxEnd() {
		return xEnd;
	}
	
	public void setxEnd(int value) {
		this.xEnd = value;
	}
	
	public int getyStart() {
		return yStart;
	}
	
	public void setyStart(int value) {
		this.yStart = value;
	}
	
	public int getyEnd() {
		return yEnd;
	}
	
	public void setyEnd(int value) {
		this.yEnd = value;
	}
	
	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String value) {
		this.orientation = value;
	}
	
	public int getTaille() {
		return taille;
	}

	public void setTaille(int value) {
		this.taille = value;
	}
	
	
	/**
	 * Créer un bateau à partir de sa taille
	 * @param taille
	 */
	public void createBateau(int taille)
	{
		
		setTaille(taille);
		
		orientation = (maSerie.nextInt(2) == 1) ? "H" : "V"; // H = 1 / V = 2
		
		// Horizontal
		if(orientation == "H")
		{
			
			int nb = 0;
			
			// ************** Calcul du X de début et de fin ************* //
			
			// calcul de xStart
			do
			{
				nb = maSerie.nextInt(11);
				xStart = nb - taille;
				
				
			} while ( nb == 0 || xStart <= 0 || xStart > 10 ); // doit être compris entre 1 et 10 compris
			
			
			// calcul de xEnd
			xEnd = xStart + taille - 1;

			
			
			// ************** Calcul du Y de début et de fin ************* //
			
			do
			{
				yStart = maSerie.nextInt(11);
				
			} while (yStart <= 0 || yStart > 10 ); // doit être compris entre 1 et 10 compris
			
			yEnd = yStart;
			
		}
		// Vertical
		else
		{
			
			int nb = 0;
			
			// ************** Calcul du X de début et de fin ************* //
			
			// calcul de xStart
			do
			{
				xStart = maSerie.nextInt(11);			
				
			} while (xStart <= 0 || xStart > 10 ); // doit être compris entre 1 et 10 compris
			
			
			// calcul de xEnd
			xEnd = xStart;

			
			
			// ************** Calcul du Y de début et de fin ************* //
			
			do
			{
				nb = maSerie.nextInt(11);
				yStart = nb - taille;
				
			} while ( nb == 0 || yStart <= 0 || yStart > 10 ); // doit être compris entre 1 et 10 compris
			
			yEnd = yStart + taille - 1;
						
		}
		
	}
	
	/**
	 * Compare deux bateaux pour savoir s'il se chevauchent ou pas
	 * @param bateau1
	 * @param bateau2
	 * @return
	 */
	public static boolean seChevauchent(Bateau bateau1, Bateau bateau2)
	{
		for(int x = bateau1.getxStart(); x <= bateau1.getxEnd(); x++)
		{
			for(int y = bateau1.getyStart(); y <= bateau1.getyEnd(); y++)
			{
				if(x >= bateau2.getxStart() && x <= bateau2.getxEnd() && y >= bateau2.getyStart() && y <= bateau2.getyEnd())
				{
					return true;
				}	
			}
		}

		return false;
	
	}
	
	/**
	 * Affiche les information du bateau
	 */
	public void afficher()
	{
		Outils.afficher(
			"Bateau de taille :" + Integer.toString(taille) + "\r\n" +
			"Orientation => " + orientation + "\r\n" +
			"xStart => " + Integer.toString(xStart) + "\r\n" +
			"xEnd => " + Integer.toString(xEnd) + "\r\n" +
			"yStart => " + Integer.toString(yStart) + "\r\n" +
			"yEnd => " + Integer.toString(yEnd)
		);
		
	}



}
