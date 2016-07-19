package com.jp.pokemon.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jp on 16. 7. 13..
 */
public class Pokemon {

    private String id;

    private String name;
    private String engName;
    private String height;
    private String weight;
    private String imageUrl;
    private List<String> type;
    private String str;
    private List<String> skill;
    private List<String> hiddenSkill;
    private String number;

    public Pokemon(String csvStr){
        this.str = csvStr;
        String[] split = csvStr.trim().split(",");
        id = split[0];
        number = String.format("%03d", Integer.parseInt(id));
        imageUrl = split[1];
        height = split[3];
        weight = split[4];
        name = split[2];
        type = Arrays.asList(split[5].split(";"));
        skill = Arrays.asList(split[6].split(";"));
        if(split.length == 8) {
            hiddenSkill = Arrays.asList(split[7].split(";"));
        }else{
            hiddenSkill = new ArrayList<String>();
        }
        engName =imageUrl;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getImageUrl() {
        return "http://img.pokemondb.net/artwork/" + imageUrl + ".jpg";

    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }


    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public List<String> getHiddenSkill() {
        return hiddenSkill;
    }

    public void setHiddenSkill(List<String> hiddenSkill) {
        this.hiddenSkill = hiddenSkill;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
