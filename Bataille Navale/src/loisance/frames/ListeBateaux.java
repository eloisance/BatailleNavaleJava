package loisance.frames;

import java.util.ArrayList;

public class ListeBateaux {
	
	final static int LMAX = 10;	
	final static int CMAX = 10;

	private ArrayList<Bateau> listeBateaux;
	
	/**
	 * Constructeur instancie l'ArrayList contenant les bateaux
	 */
	public ListeBateaux()
	{
		this.listeBateaux = new ArrayList<Bateau>();
	}
	
	/**
	 * Ajoute le bateau à l'ArrayList
	 * @param unBateau
	 */
	public void ajouter(Bateau unBateau)
	{
		this.listeBateaux.add(unBateau);
	}
	
	/**
	 * 
	 * @return ArrayList des bateaux
	 */
	public ArrayList<Bateau> getListe()
	{
		return this.listeBateaux;
	}
	
	/**
	 * 
	 * @param nouveauBateau
	 * @return true ou false
	 */
	public boolean estAccepte(Bateau nouveauBateau)
	{
		for(Bateau bateauExistant : this.listeBateaux)
		{
			if(Bateau.seChevauchent(nouveauBateau, bateauExistant))
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	public String toString()
	{
		String[][] grille = new String[LMAX + 1][CMAX + 1];
		
		// Remplit la grille de ~
		for(int lig = 1; lig <= LMAX; lig++)
		{
			for(int col = 1; col <= CMAX; col++)
			{
				grille[lig][col] = " ~ ";
			}
		}
		
		// Ajoute les bateaux dans la grille 
		for(Bateau unBateau : this.listeBateaux)
		{
			for(int x = unBateau.getxStart(); x <= unBateau.getxEnd(); x++)
			{
				for(int y = unBateau.getyStart(); y <= unBateau.getyEnd(); y++)
				{
					grille[x][y] = " " + Integer.toString(unBateau.getTaille()) + " ";
				}
			}
		}
		
		// Affiche la grille
		String msg = "    1  2  3  4  5  6  7  8  9  10" + "\r\n";
		for(int lig = 1; lig <= LMAX; lig++)
		{
			msg += Outils.formaterNombre(lig, "00") + " ";
			for(int col = 1; col <= CMAX; col++)
			{
				msg += grille[lig][col];
			}
			msg += "\r\n";
		}
		
		return msg;
		
	}
	
}
