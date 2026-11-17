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

    
    public boolean incrementerQuantite(long q) {
        if (q <= 0) {
            return false;
        }
        this.quantite += q;
        return true;
    }

    
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

    
    public boolean equals(String reference) {
        return article.getReference().equals(reference);
    }

    
    public boolean equals(Article autre) {
        return autre != null && article.getReference().equals(autre.getReference());
    }

    @Override
    public String toString() {
        return "Element [article=" + article + ", quantite=" + quantite + "]";
    }
}
