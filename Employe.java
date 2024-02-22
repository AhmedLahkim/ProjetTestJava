
class Employe {
    private String nom;
    private String role;
    private double salaireHoraire;
    private String DateEmbauche;
    private GestionnaireEmployes gestionnaireEmployes;

    public Employe(String nom, String role, String DateEmbauche, double salaireHoraire) {
        this.nom = nom;
        this.role = role;
        this.DateEmbauche = DateEmbauche;
        this.salaireHoraire = salaireHoraire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateEmbauche() {
        return DateEmbauche;
    }

    public void setDateEmbauche(String DateEmbauche) {
        this.DateEmbauche = DateEmbauche;
    }

    public double getSalaireHoraire() {
        return salaireHoraire;
    }

    public void setSalaireHoraire(double salaireHoraire) {
        this.salaireHoraire = salaireHoraire;
    }

    public void setGestionnaireEmployes(GestionnaireEmployes gestionnaireEmployes) {
        this.gestionnaireEmployes = gestionnaireEmployes;
    }

    public double calculerSalaire(int heuresTravaillees) {
        double salaire = salaireHoraire * heuresTravaillees;
        if (gestionnaireEmployes.RoleBonus.containsKey(role)) {
            salaire += gestionnaireEmployes.RoleBonus.get(role);
        }
        return salaire;
    }
}
