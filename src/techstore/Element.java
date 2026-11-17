package techstore;

public class Element {
    private Article article;
    private long quantite;

    public Element(Article article, long quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négative.");
        }
        this.article = article;
        this.quantite = quantite;
    }

    public Element(String nom, double prix, long quantite) {
        this(new Article(nom, prix), quantite);
    }

    public Article getArticle() {
        return article;
    }

    public long getQuantite() {
        return quantite;
    }

    public String getReferenceArticle() {
        return article.getReference();
    }

    public String getNomArticle() {
        return article.getNom();
    }

    public double getPrixArticle() {
        return article.getPrix();
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setQuantite(long quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négative.");
        }
        this.quantite = quantite;
    }

    /** Augmente la quantité. Retourne false si la valeur est invalide (<= 0). */
    public boolean incrementerQuantite(long q) {
        if (q <= 0) {
            return false;
        }
        this.quantite += q;
        return true;
    }

    /** Diminue la quantité. Retourne false si q <= 0 ou q > quantité disponible. */
    public boolean decrementerQuantite(long q) {
        if (q <= 0 || q > this.quantite) {
            return false;
        }
        this.quantite -= q;
        return true;
    }

    public void modifier(String nom, double prix, long quantite) {
        if (quantite < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négative.");
        }
        this.article = new Article(nom, prix);
        this.quantite = quantite;
    }

    /** Vrai si la référence de l'article correspond à la chaîne fournie. */
    public boolean equals(String reference) {
        return article.getReference().equals(reference);
    }

    /** Deux articles sont identiques s'ils ont la même référence. */
    public boolean equals(Article autre) {
        return autre != null && article.getReference().equals(autre.getReference());
    }

    @Override
    public String toString() {
        return "Element [article=" + article + ", quantite=" + quantite + "]";
    }
}
