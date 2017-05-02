package com.example.jorge.adaptable;

/**
 * Clase que representa la existencia de una promo
 */
public class Promo {

    private String nombre;
    private int idDrawable;

    public Promo (String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Promo[] ITEMS = {
            new Promo("Lacoste -60%", R.drawable.promo1),
            new Promo("Nike -10%", R.drawable.promo2),
            new Promo("Adidas -20%", R.drawable.promo3),
            new Promo("Adidas 2x1", R.drawable.promo4),
            new Promo("Adidas 3x2", R.drawable.promo5),
            new Promo("Adidas 3x2", R.drawable.promo5),
            new Promo("Adidas 2x1", R.drawable.promo4),
            new Promo("Adidas -20%", R.drawable.promo3),
            new Promo("Nike -10%", R.drawable.promo2),
            new Promo("Lacoste -60%", R.drawable.promo1),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Promo
     */
    public static Promo getItem(int id) {
        for (Promo item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
