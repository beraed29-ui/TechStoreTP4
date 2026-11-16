package techstore;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        partie1();
        partie2();
    }

    // ---------- Partie 1 : classes Adresse et Personne ----------
    private static void partie1() {
        System.out.println("La création des personnes commence :");
        Adresse a1 = new Adresse("Monastir", 5000);
        Adresse a2 = new Adresse("Ben Arous", 1133);
        Adresse a3 = new Adresse("Ben Arous", 1145);
        System.out.println("L'adresse a1 : " + a1);
        System.out.println("L'adresse a2 : " + a2);
        System.out.println("L'adresse a3 : " + a3);

        Personne p1 = new Personne("01111111", "Kbayer", "Jasser", new Adresse("Jendouba", 8160));
        Personne p2 = new Personne("02222222", "Smida", "Ghayth", "Monastir", 5000);
        System.out.println("La personne p1 : " + p1);
        System.out.println("La personne p2 : " + p2);

        p1.setNom("Ben Kbayer");
        p2.setPrenom("Ghaith");
        p2.setAdresse(a2);
        System.out.println("\nAprès modification :");
        System.out.println("La personne p1 : " + p1);
        System.out.println("La personne p2 : " + p2);
        System.out.println();
    }

    // ---------- Partie 2 : gestion du stock ----------
    private static long lireLong(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Long.parseLong(sc.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Valeur invalide, veuillez saisir un entier.");
            }
        }
    }

    private static double lireDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException ex) {
                System.out.println("Valeur invalide, veuillez saisir un nombre.");
            }
        }
    }

    private static void partie2() {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> noms = new ArrayList<String>();
        ArrayList<Double> prix = new ArrayList<Double>();
        ArrayList<Long> quantites = new ArrayList<Long>();

        noms.add("Apple iPad");
        prix.add(1269.0);
        quantites.add(8L);

        noms.add("Micro Casque 588 Filaire");
        prix.add(89.0);
        quantites.add(15L);

        noms.add("Clavier Logitech K120");
        prix.add(45.5);
        quantites.add(20L);

        Stock stock = new Stock(noms, prix, quantites);

        int choix;
        do {
            System.out.println("========== GESTION DU STOCK TECHSTORE ==========");
            System.out.println("0 - Ajouter un article");
            System.out.println("1 - Augmenter la quantité d’un article");
            System.out.println("2 - Modifier un article");
            System.out.println("3 - Supprimer un article");
            System.out.println("4 - Consulter le stock");
            System.out.println("5 - Quitter");
            choix = (int) lireLong(sc, "Votre choix : ");

            switch (choix) {
            case 0: {
                System.out.print("Nom de l'article : ");
                String nom = sc.nextLine().trim();
                double p = lireDouble(sc, "Prix (TND) : ");
                long q = lireLong(sc, "Quantité : ");
                if (nom.isEmpty() || p < 0 || q < 0) {
                    System.out.println("Erreur : nom vide, prix ou quantité invalide.");
                } else {
                    stock.ajouterArticle(nom, p, q);
                    System.out.println("Article ajouté avec succès.");
                }
                break;
            }
            case 1: {
                System.out.print("Référence de l'article : ");
                String ref = sc.nextLine().trim();
                long q = lireLong(sc, "Quantité à ajouter : ");
                if (stock.trouverArticle(ref) == null) {
                    System.out.println("Erreur : article introuvable.");
                } else if (stock.incrementerQuantiteArticle(ref, q)) {
                    System.out.println("Quantité augmentée avec succès.");
                } else {
                    System.out.println("Erreur : quantité invalide.");
                }
                break;
            }
            case 2: {
                System.out.print("Référence de l'article à modifier : ");
                String ref = sc.nextLine().trim();
                if (stock.trouverArticle(ref) == null) {
                    System.out.println("Erreur : article introuvable.");
                    break;
                }
                System.out.print("Nouveau nom : ");
                String nom = sc.nextLine().trim();
                double p = lireDouble(sc, "Nouveau prix (TND) : ");
                long q = lireLong(sc, "Nouvelle quantité : ");
                if (nom.isEmpty() || !stock.modifierArticle(ref, nom, p, q)) {
                    System.out.println("Erreur : données invalides, article non modifié.");
                } else {
                    System.out.println("Article modifié avec succès (la référence a été recalculée, consultez le stock).");
                }
                break;
            }
            case 3: {
                System.out.print("Référence de l'article à supprimer : ");
                String ref = sc.nextLine().trim();
                if (stock.supprimerArticle(ref)) {
                    System.out.println("Article supprimé avec succès.");
                } else {
                    System.out.println("Erreur : article introuvable.");
                }
                break;
            }
            case 4:
                if (stock.getArticleNb() == 0) {
                    System.out.println("Le stock est vide.");
                } else {
                    System.out.println("Stock (" + stock.getArticleNb() + " articles) :");
                    System.out.print(stock);
                }
                break;
            case 5:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Choix invalide.");
            }
            System.out.println();
        } while (choix != 5);

        sc.close();
    }
}
