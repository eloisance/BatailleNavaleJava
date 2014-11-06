package loisance.frames;

public class Jeu {
	
	public static void main(String[] args) {
		
		ListeBateaux laListeBateaux = new ListeBateaux();
	
		for(int i = 1; i <= 5; i++)
		{
			Bateau unBateau = new Bateau();
			
			unBateau.createBateau(i);
			// unBateau.afficher();
			
			if(laListeBateaux.estAccepte(unBateau))
			{
				laListeBateaux.ajouter(unBateau);	
			}
			else
			{
				i--;
			}
			
			unBateau = null;
		}
		
		System.out.println(laListeBateaux.toString());
	}
	

	
}
