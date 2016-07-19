package com.jp.pokemon.model;

/**
 * Created by jp on 16. 7. 18..
 */
public class PokemonDetail {
    private String id;
    private int hp;
    private int attack;
    private int depend;
    private int sAttack;
    private int sDepend;
    private int speed;
    private String str;

    public PokemonDetail(String csvStr){
        this.str = csvStr;
        String[] split = csvStr.trim().split(",");
        id = split[0];
        hp = Integer.parseInt(split[2]);
        attack = Integer.parseInt(split[3]);
        depend = Integer.parseInt(split[4]);
        sAttack= Integer.parseInt(split[5]);
        sDepend= Integer.parseInt(split[6]);
        speed = Integer.parseInt(split[7]);

    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getsDepend() {
        return sDepend;
    }

    public void setsDepend(int sDepend) {
        this.sDepend = sDepend;
    }

    public int getsAttack() {
        return sAttack;
    }

    public void setsAttack(int sAttack) {
        this.sAttack = sAttack;
    }

    public int getDepend() {
        return depend;
    }

    public void setDepend(int depend) {
        this.depend = depend;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
