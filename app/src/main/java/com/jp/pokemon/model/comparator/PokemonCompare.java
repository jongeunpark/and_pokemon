package com.jp.pokemon.model.comparator;

import com.jp.pokemon.model.Pokemon;

import java.util.Comparator;

/**
 * Created by jp on 16. 7. 13..
 */
public class PokemonCompare {
    public static Comparator<Pokemon> NameComparator = new Comparator<Pokemon>() {

        public int compare(Pokemon app1, Pokemon app2) {



            return app1.getName().compareTo(app2.getName());
        }
    };
    public static Comparator<Pokemon> IdComparator = new Comparator<Pokemon>() {

        public int compare(Pokemon app1, Pokemon app2) {

            Integer a = Integer.parseInt(app1.getId());
            Integer b = Integer.parseInt(app2.getId());

            return a.compareTo(b);
        }
    };
    public static Comparator<Pokemon> WeightHighComparator = new Comparator<Pokemon>() {

        public int compare(Pokemon app1, Pokemon app2) {

            Integer a = Integer.parseInt(app1.getWeight());
            Integer b = Integer.parseInt(app2.getWeight());

            return b.compareTo(a);

        }
    };
    public static Comparator<Pokemon> HeightHighComparator = new Comparator<Pokemon>() {

        public int compare(Pokemon app1, Pokemon app2) {


            Integer a = Integer.parseInt(app1.getHeight());
            Integer b = Integer.parseInt(app2.getHeight());

            return b.compareTo(a);
        }
    };
    public static Comparator<Pokemon> WeightLowComparator = new Comparator<Pokemon>() {

        public int compare(Pokemon app1, Pokemon app2) {

            Integer a = Integer.parseInt(app1.getWeight());
            Integer b = Integer.parseInt(app2.getWeight());

            return a.compareTo(b);

        }
    };
    public static Comparator<Pokemon> HeightLowComparator = new Comparator<Pokemon>() {

        public int compare(Pokemon app1, Pokemon app2) {


            Integer a = Integer.parseInt(app1.getHeight());
            Integer b = Integer.parseInt(app2.getHeight());

            return a.compareTo(b);
        }
    };
}
