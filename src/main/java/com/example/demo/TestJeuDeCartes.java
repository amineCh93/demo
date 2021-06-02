
package com.example.demo;

import javax.swing.*;
import java.awt.*;

public class TestJeuDeCartes extends JFrame {
    /**
     * <p>Serial version UID.</p>
     */
    private static final long serialVersionUID = 1L;


    /**
     * <p>Construction de l'application.</p>
     */
    public TestJeuDeCartes() {
        // Appel du constructeur de la classe JFrame.
        super("JeuDeCartes");

        // Ajoute les composants au conteneur.
        JTextArea zoneSortie = new JTextArea();
        zoneSortie.setEditable(false);
        getContentPane().add(new JScrollPane(zoneSortie), BorderLayout.CENTER);

        // Texte de sortie.
        StringBuilder sortie = new StringBuilder();

        // Construction du paquet de cartes.
        Game game = new Game();

        // Pioche 5 cartes.
        sortie.append("Pioche  cartes  : \n");
        Carte[] main = game.piocher(10);
        if (main != null) {
            for (int i = 0; i < main.length; i++) {
                sortie.append("- ").append(main[i]).append("\n");
            }
        } else {
            sortie.append("Le nombre de cartes dans le paquet est insuffisant!\n");
        }

        // Essaie de piocher 50 cartes.
        sortie.append("Pioche 50 cartes : \n");
        main = game.piocher(50);
        if (main != null) {
            for (int i = 0; i < main.length; i++) {
                sortie.append("- ").append(main[i]).append("\n");
            }
        } else {
            sortie.append("Le nombre de cartes dans le paquet est insuffisant!\n");
        }

        // Nombre de cartes.
        int nbCartes = game.getNombreDeCartes();
        sortie.append("Nombre de cartes restantes dans le paquet : ");
        sortie.append(nbCartes);

        // Met à jour la zone de sortie.
        zoneSortie.setText(sortie.toString());

        // Modifie les propriétés de la fenêtre.
        setSize(600, 200);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * <p>Débute l'exécution du test.</p>
     *
     * @param args Les paramètres de la ligne de commande.
     */
    public static void main(String[] args) {
        new TestJeuDeCartes();
    }
}
