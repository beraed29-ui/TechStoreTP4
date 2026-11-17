package techstore;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Element> articleList;

    public Stock() {
        this.articleList = new ArrayList<Element>();
    }

    public Stock(ArrayList<Element> articleList) {
        this.articleList = articleList;
    }

    public Stock(ArrayList<String> noms, ArrayList<Double> prix, ArrayList<Long> quantites) {
        this.articleList = new ArrayList<Element>();
        int n = Math.min(noms.size(), Math.min(prix.size(), quantites.size()));
        for (int i = 0; i < n; i++) {
            articleList.add(new Element(noms.get(i), prix.get(i), quantites.get(i)));
        }
    }

    public ArrayList<Element> getArticleList() {
        return articleList;
    }

    public int getArticleNb() {
        return articleList.size();
    }

    public void setArticleList(ArrayList<Element> articleList) {
        this.articleList = articleList;
    }

    public void ajouterArticle(Article article, long quantite) {
        articleList.add(new Element(article, quantite));
    }

    public void ajouterArticle(String nom, double prix, long quantite) {
        articleList.add(new Element(nom, prix, quantite));
    
    public Element trouverArticle(String reference) {
        for (Element e : articleList) {
            if (e.equals(reference)) {
                return e;
            }
        }
        return null;
    }

    public boolean modifierArticle(String reference, String nom, double prix, long quantite) {
        Element e = trouverArticle(reference);
        if (e == null || quantite < 0 || prix < 0) {
            return false;
        }
        e.modifier(nom, prix, quantite);
        return true;
    }

    public boolean supprimerArticle(String reference) {
        Element e = trouverArticle(reference);
        if (e == null) {
            return false;
        }
        return articleList.remove(e);
    }

    public boolean incrementerQuantiteArticle(String reference, long quantite) {
        Element e = trouverArticle(reference);
        return e != null && e.incrementerQuantite(quantite);
    }

    public boolean decrementerQuantiteArticle(String reference, long quantite) {
        Element e = trouverArticle(reference);
        return e != null && e.decrementerQuantite(quantite);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Element e : articleList) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }
}
