package com.example.demo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class Carte
{
    /** Rang de la carte. */
    @SuppressWarnings("all")
    public enum Rang
    {
        DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS
    }

    /** Couleur de la carte. */
    @SuppressWarnings("all")
    public enum Couleur
    {
        PIQUE, COEUR, CARREAU, TREFLE
    }

    /** Le rang de la carte. */
    private final Rang rang;

    /** La couleur de la carte. */
    private final Couleur couleur;


    /**
     * <p>Constructeur de carte.</p>
     * @param rang Le rang de la carte.
     * @param couleur La couleur de la carte.
     */
    public Carte(Rang rang, Couleur couleur)
    {
        this.rang = rang;
        this.couleur = couleur;
    }


    /**
     * <p>Retourne le rang de la carte.</p>
     * @return Renvoie le rang de la carte.
     */
    public Rang getRang()
    {
        return this.rang;
    }


    /**
     * <p>Retourne la couleur de la carte.</p>
     * @return Renvoie la couleur de la carte.
     */
    public Couleur getCouleur()
    {
        return this.couleur;
    }


    /**
     * <p>Retourne une représentation de la carte.</p>
     * @return Renvoie une représentation de la carte.
     */
    @Override
    public String toString()
    {
        return this.rang + " de " + this.couleur;
    }
}
