import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class GestionnaireEmployes {
    private List<Employe> listeEmployes;
    public final Map<String, Double> RoleBonus;

    public GestionnaireEmployes() {
        this.listeEmployes = new ArrayList<>();
        RoleBonus = new HashMap<>();
        RoleBonus.put("Manager", 500.0);
        RoleBonus.put("Vendeur", 300.0);
        RoleBonus.put("Caissier", 200.0);
    }

    public List<Employe> getListeEmployes() {
        return listeEmployes;
    }

    public void ajouterEmploye(Employe employe) {
        employe.setGestionnaireEmployes(this);
        listeEmployes.add(employe);
    }

    public void supprimerEmploye(String nom) {
        listeEmployes.removeIf(employe -> employe.getNom().equals(nom));
    }

    public void calculerSalaires() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCalcul du salaire pour chaque employé :");

        // Afficher la liste des employés avec un numéro d'identification
        for (int i = 0; i < listeEmployes.size(); i++) {
            Employe employe = listeEmployes.get(i);
            System.out.println((i+1) + ". " + employe.getNom());
        }

        // Demander à l'utilisateur de choisir l'employé
        System.out.print("Choisissez le numéro de l'employé pour calculer son salaire : ");
        int choixEmploye = scanner.nextInt();
        scanner.nextLine();

        // Vérifier si le numéro saisi est valide
        if (choixEmploye >= 1 && choixEmploye <= listeEmployes.size()) {
            Employe employeChoisi = listeEmployes.get(choixEmploye - 1);

            System.out.print("Entrez le nombre d'heures travaillées par " + employeChoisi.getNom() + ": ");
            int heuresTravaillees = scanner.nextInt();
            double salaire = employeChoisi.calculerSalaire(heuresTravaillees);
            System.out.println("Le salaire de " + employeChoisi.getNom() + " est de : " + salaire);
        } else {
            System.out.println("Numéro d'employé invalide !");
        }
    }

    public void afficherListeEmployes() {
        System.out.println("\nListe des employés :");
        for (Employe employe : listeEmployes) {
            System.out.println("Nom: " + employe.getNom() + ", Rôle: " + employe.getRole() + ", Date d'Embauche: " + employe.getDateEmbauche() + ", Salaire horaire: " +
                    employe.getSalaireHoraire());
        }
    }
}
