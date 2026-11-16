package techstore;

public class Article {
    private static int compteur = 0; // sert à générer des identifiants uniques

    private int id;
    private String nom;
    private String reference;
    private double prix;

    public Article(String nom, double prix) {
        compteur++;
        this.id = compteur;
        this.nom = nom;
        this.prix = prix;
        genererReference();
    }

    /**
     * Référence = lettres du nom (espaces ignorés) dont l'indice est divisible
     * par 5 (0, 5, 10, ...), suivies de l'identifiant de l'article.
     */
    private void genererReference() {
        String sansEspaces = nom.replace(" ", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sansEspaces.length(); i += 5) {
            sb.append(sansEspaces.charAt(i));
        }
        sb.append(id);
        this.reference = sb.toString();
    }

    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setNom(String nom) {
        this.nom = nom;
        genererReference();
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void modifier(String nom) {
        setNom(nom); // met à jour aussi la référence
    }

    public void modifier(String nom, double prix) {
        setNom(nom);
        setPrix(prix);
    }

    @Override
    public String toString() {
        return "id=" + id + ", nom=" + nom + ", reference=" + reference + ", prix=" + prix;
    }
}
