
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionnaireEmployes gestionnaireEmployes = new GestionnaireEmployes();

        boolean continuer = true;
        while (continuer) {
            System.out.println("\nMenu :");
            System.out.println("1. Ajouter un employé");
            System.out.println("2. Calculer les salaires");
            System.out.println("3. Afficher la liste des employés");
            System.out.println("4. Modifier les données d'un employé");
            System.out.println("5. Supprimer un employé");
            System.out.println("6. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'employé : ");
                    String nom = scanner.nextLine();
                    System.out.print("Rôle de l'employé : ");
                    String role = scanner.nextLine();
                    System.out.print("Date d'embauche : ");
                    String DateEmbauche = scanner.nextLine();
                    System.out.print("Salaire horaire de l'employé : ");
                    double salaireHoraire = scanner.nextDouble();
                    gestionnaireEmployes.ajouterEmploye(new Employe(nom, role, DateEmbauche, salaireHoraire));
                    break;
                case 2:
                    gestionnaireEmployes.calculerSalaires();
                    break;
                case 3:
                    gestionnaireEmployes.afficherListeEmployes();
                    break;
                case 4:
                    System.out.println("Modifier les données d'un employé :");
                    System.out.print("Nom de l'employé à modifier : ");
                    String nomEmployeModifier = scanner.nextLine();
                    Employe employeAModifier = null;
                    for (Employe employe : gestionnaireEmployes.getListeEmployes()) {
                        if (employe.getNom().equals(nomEmployeModifier)) {
                            employeAModifier = employe;
                            break;
                        }
                    }
                    if (employeAModifier != null) {
                        System.out.println("Que voulez-vous modifier pour " + employeAModifier.getNom() + "?");
                        System.out.println("1. Nom");
                        System.out.println("2. Rôle");
                        System.out.println("3. Date d'embauche");
                        System.out.println("4. Salaire horaire");
                        System.out.print("Choix : ");
                        int choixModification = scanner.nextInt();
                        scanner.nextLine();

                        switch (choixModification) {
                            case 1:
                                System.out.print("Nouveau nom : ");
                                String nouveauNom = scanner.nextLine();
                                employeAModifier.setNom(nouveauNom);
                                break;
                            case 2:
                                System.out.print("Nouveau rôle : ");
                                String nouveauRole = scanner.nextLine();
                                employeAModifier.setRole(nouveauRole);
                                break;
                            case 3:
                                System.out.print("Nouvelle date d'embauche : ");
                                String nouvelleDateEmbauche = scanner.nextLine();
                                employeAModifier.setDateEmbauche(nouvelleDateEmbauche);
                                break;
                            case 4:
                                System.out.print("Nouveau salaire horaire : ");
                                double nouveauSalaireHoraire = scanner.nextDouble();
                                employeAModifier.setSalaireHoraire(nouveauSalaireHoraire);
                                break;
                            default:
                                System.out.println("Choix invalide !");
                        }
                    } else {
                        System.out.println("Employé non trouvé !");
                    }
                    break;
                case 5:
                    System.out.println("Supprimer un employé :");
                    System.out.print("Nom de l'employé à supprimer : ");
                    String nomEmployeSupprimer = scanner.nextLine();
                    gestionnaireEmployes.supprimerEmploye(nomEmployeSupprimer);
                    break;
                case 6:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}
