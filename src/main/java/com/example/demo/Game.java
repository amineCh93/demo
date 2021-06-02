package com.example.demo;

import com.example.demo.Carte.Couleur;
import com.example.demo.Carte.Rang;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Random;
/**
 * <p>Classe représentant un jeu de cartes.</p>
 *
 */
public class Game
{
    /** Paquet de cartes. */
    private Carte[] cartes;

    /** Nombre d'itérations pour mélanger les cartes. */
    private static final int NB_ITERATIONS = 3;


    /**
     * Constructeur.
     */
    public Game()
    {
        // Initialisation des cartes du paquet.
        this.cartes = new Carte[Rang.values().length * Couleur.values().length];
        for(int i = 0; i < Couleur.values().length; i++)
        {
            for(int j = 0; j < Rang.values().length; j++)
            {
                this.cartes[i * Rang.values().length + j] = new Carte(Rang.values()[j], Couleur
                        .values()[i]);
            }
        }

        // Mélange le jeu de cartes.
        melanger();
    }


    /**
     * <p>Mélange les cartes du paquet.</p>
     */
    private void melanger()
    {
        Random r = new Random();
        for(int i = 0; i < NB_ITERATIONS; i++)
        {
            for(int j = 0; j < this.cartes.length; j++)
            {
                echanger(r.nextInt(this.cartes.length), r.nextInt(this.cartes.length));
            }
        }
    }


    /**
     * <p>Echange deux cartes d'un paquet.</p>
     * @param i L'indice de la première carte à échanger.
     * @param j L'indice de la seconde carte à échanger.
     */
    private void echanger(int i, int j)
    {
        Carte temp;
        temp = this.cartes[i];
        this.cartes[i] = this.cartes[j];
        this.cartes[j] = temp;
    }


    /**
     * <p>Renvoie le nombre de cartes disponibles.</p>
     * @return Retourne le nombre de cartes disponibles.
     */
    public int getNombreDeCartes()
    {
        return this.cartes.length;
    }


    /**
     * <p>Renvoie un tableau des cartes piochées.</p>
     * @param n Le nombre de cartes piochées.
     * @return Retourne un tableau des cartes piochées ou null s'il n'y a plus assez de cartes dans
     *         le paquet.
     */
    public Carte[] piocher(int n)
    {
        if(n <= this.cartes.length)
        {
            Carte[] main = Arrays.copyOfRange(this.cartes, 0, n - 1);
            this.cartes = Arrays.copyOfRange(this.cartes, n, this.cartes.length - 1);

            return main;
        }

        return null;
    }
}

