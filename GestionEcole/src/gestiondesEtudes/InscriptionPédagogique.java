package gestiondesEtudes;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InscriptionP�dagogique {
		protected int anneePromo;
		//protected Promotion p;
		protected int filierechoisie;
		//protected Student et;
		protected Ecole ec;
		protected Class c;
		protected Filiere f;
		
		Scanner sc = new Scanner(System.in);
		
		public InscriptionP�dagogique(Ecole ec) throws ParseException {
			this.ec = ec;
			
			System.out.println("Vous vous inscrivez au titre de la :\n 1) Premi�re ann�e\n 2) Deuxi�me ann�e\n 3) Troisi�me ann�e");
			anneePromo = sc.nextInt();
			sc.nextLine();
			gestion();
		}
		
		public void firstYear() throws ParseException {
			if (anneePromo == 1) {
				InscriptionAdministrative ia = new InscriptionAdministrative(ec);
				System.out.println("choisir la classe");
				ia.f.choisirClassFilere().addStud(ia.e);
				ia.e.anneePromo=1;
				}
			}
		
		
		public void secondYear() {
			System.out.println("choisir fili�re :");
			ec.affichefiliereEcole();
			filierechoisie=sc.nextInt();
			f=ec.choisirFiliere(filierechoisie);
			
			c=f.choisirClassFilere();
			System.out.println("choisir votre nom");
			c.affichestudClass();
			int studchoisie=sc.nextInt();
			int i=1;
			for(Student s:c.stud) {
				if(i==studchoisie) {
					if (s.getDecision().equalsIgnoreCase("Passage")) {
						s.setAnneePromo(2);	
						c.stud.remove(s);
							System.out.println("F�licitations, vos notes et discipline vous ont permis de r�ussir. \nBienvenu dans cette nouvelle ann�e !");
							System.out.println("\n----------------------\n");
							
							/*System.out.println("choisir la nouvelle promotion");
							f.afficheClassFiliere();
							int promo=sc.nextInt();*/
							c=f.choisirClassFilere();
							c.addStud(s);
							System.out.println("\n----------------------\n");
							
					}
					else {
							System.out.println("D�sol�, vous allez redoubler. Bon courage !");
					}
					break;
				}
				else i++;
			}
						
					
				}				
	
				
		
		
		public void thirdYear() {
			System.out.println("choisir fili�re :");
			ec.affichefiliereEcole();
			filierechoisie=sc.nextInt();
			f=ec.choisirFiliere(filierechoisie);
			c=ec.choisirFiliere(filierechoisie).choisirClassFilere();
			System.out.println("choisir votre nom");
			c.affichestudClass();
			int studchoisie=sc.nextInt();
						if (ec.choisirFiliere(filierechoisie).choisirClassFilere().choisirStud(studchoisie).getDecision().equalsIgnoreCase("Passage")) {
							ec.choisirFiliere(filierechoisie).choisirClassFilere().choisirStud(studchoisie).setAnneePromo(3);	
							ec.choisirFiliere(filierechoisie).choisirClassFilere().stud.remove(ec.choisirFiliere(filierechoisie).choisirClassFilere().choisirStud(studchoisie));
								System.out.println("F�licitations, vos notes et discipline vous ont permis de r�ussir. \nBienvenu dans cette nouvelle ann�e !");
								System.out.println("\n----------------------\n");
								
								System.out.println("choisir la nouvelle promotion");
								ec.choisirFiliere(filierechoisie).afficheClassFiliere();
								ec.choisirFiliere(filierechoisie).choisirClassFilere().addStud(ec.choisirFiliere(filierechoisie).choisirClassFilere().choisirStud(studchoisie));
								System.out.println("\n----------------------\n");
								
						}
						else {
								System.out.println("D�sol�, vous allez redoubler. Bon courage !");
						}
		}
		
		public void gestion() throws ParseException {
			switch (anneePromo) {
			case 1 : firstYear(); break;
			case 2 : secondYear(); break;
			case 3 : thirdYear(); break;
			default : System.out.println("R�essayer"); anneePromo = sc.nextInt(); gestion(); break;
			}
		}
	
}
