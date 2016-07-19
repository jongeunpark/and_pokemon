package com.jp.pokemon.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jp.pokemon.MainActivity;
import com.jp.pokemon.R;

public class FillterActivity extends AppCompatActivity {
    private TextView mBtnType1, mBtnType2, mBtnType3, mBtnType4, mBtnType5, mBtnType6;
    private TextView mBtnTypeGrass, mBtnTypePoison, mBtnTypeFire, mBtnTypeFlying, mBtnTypeWater, mBtnTypeBug;
    private TextView mBtnTypeNormal, mBtnTypeElectric, mBtnTypeGround, mBtnTypeFairy, mBtnTypeFighting, mBtnTypePsychic;
    private TextView mBtnTypeRock, mBtnTypeSteel, mBtnTypeIce, mBtnTypeGhosh, mBtnTypeDragon, mBtnTypeDark;
    private TextView mBtnAllSelect, mBtnAllUnSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillter);
        initData();
        initActionbar();
        initView();
        initEvent();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData() {

    }

    private void initActionbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.title_activity_fillter));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


    }

    private void initView() {
        mBtnType1 = (TextView) findViewById(R.id.fillter_btn_type_1);
        mBtnType2 = (TextView) findViewById(R.id.fillter_btn_type_2);
        mBtnType3 = (TextView) findViewById(R.id.fillter_btn_type_3);
        mBtnType4 = (TextView) findViewById(R.id.fillter_btn_type_4);
        mBtnType5 = (TextView) findViewById(R.id.fillter_btn_type_5);
        mBtnType6 = (TextView) findViewById(R.id.fillter_btn_type_6);
        mBtnAllSelect = (TextView) findViewById(R.id.fillter_btn_type_select);
        mBtnAllUnSelect = (TextView) findViewById(R.id.fillter_btn_type_unselect);

        mBtnTypeGrass = (TextView) findViewById(R.id.fillter_btn_type_grass);
        mBtnTypePoison = (TextView) findViewById(R.id.fillter_btn_type_poison);
        mBtnTypeFire = (TextView) findViewById(R.id.fillter_btn_type_fire);
        mBtnTypeFlying = (TextView) findViewById(R.id.fillter_btn_type_flying);
        mBtnTypeWater = (TextView) findViewById(R.id.fillter_btn_type_water);
        mBtnTypeBug = (TextView) findViewById(R.id.fillter_btn_type_bug);
        mBtnTypeNormal = (TextView) findViewById(R.id.fillter_btn_type_normal);
        mBtnTypeElectric = (TextView) findViewById(R.id.fillter_btn_type_electric);
        mBtnTypeGround = (TextView) findViewById(R.id.fillter_btn_type_ground);
        mBtnTypeFairy = (TextView) findViewById(R.id.fillter_btn_type_fairy);
        mBtnTypeFighting = (TextView) findViewById(R.id.fillter_btn_type_fighting);
        mBtnTypePsychic = (TextView) findViewById(R.id.fillter_btn_type_psychic);
        mBtnTypeRock = (TextView) findViewById(R.id.fillter_btn_type_rock);
        mBtnTypeSteel = (TextView) findViewById(R.id.fillter_btn_type_steel);
        mBtnTypeIce = (TextView) findViewById(R.id.fillter_btn_type_ice);
        mBtnTypeGhosh = (TextView) findViewById(R.id.fillter_btn_type_ghost);
        mBtnTypeDragon = (TextView) findViewById(R.id.fillter_btn_type_dragon);
        mBtnTypeDark = (TextView) findViewById(R.id.fillter_btn_type_dark);
        setColor();

    }
    private void setColor(){
        if(MainActivity.TYPE_1){
            selectBtn(mBtnType1);
        }else{
            unselectBtn(mBtnType1);
        }
        if(MainActivity.TYPE_2){
            selectBtn(mBtnType2);
        }else{
            unselectBtn(mBtnType2);
        }
        if(MainActivity.TYPE_3){
            selectBtn(mBtnType3);
        }else{
            unselectBtn(mBtnType3);
        }
        if(MainActivity.TYPE_4){
            selectBtn(mBtnType4);
        }else{
            unselectBtn(mBtnType4);
        }
        if(MainActivity.TYPE_5){
            selectBtn(mBtnType5);
        }else{
            unselectBtn(mBtnType5);
        }
        if(MainActivity.TYPE_6){
            selectBtn(mBtnType6);
        }else{
            unselectBtn(mBtnType6);
        }



        if(MainActivity.TYPE_GRASS){
            selectBtn(mBtnTypeGrass);
        }else{
            unselectBtn(mBtnTypeGrass);
        }
        if(MainActivity.TYPE_POISON){
            selectBtn(mBtnTypePoison);
        }else{
            unselectBtn(mBtnTypePoison);
        }
        if(MainActivity.TYPE_FIRE){
            selectBtn(mBtnTypeFire);
        }else{
            unselectBtn(mBtnTypeFire);
        }
        if(MainActivity.TYPE_FLYING){
            selectBtn(mBtnTypeFlying);
        }else{
            unselectBtn(mBtnTypeFlying);
        }
        if(MainActivity.TYPE_WATER){
            selectBtn(mBtnTypeWater);
        }else{
            unselectBtn(mBtnTypeWater);
        }
        if(MainActivity.TYPE_BUG){
            selectBtn(mBtnTypeBug);
        }else{
            unselectBtn(mBtnTypeBug);
        }

        if(MainActivity.TYPE_NORMAL){
            selectBtn(mBtnTypeNormal);
        }else{
            unselectBtn(mBtnTypeNormal);
        }
        if(MainActivity.TYPE_ELECTRIC){
            selectBtn(mBtnTypeElectric);
        }else{
            unselectBtn(mBtnTypeElectric);
        }
        if(MainActivity.TYPE_GROUND){
            selectBtn(mBtnTypeGround);
        }else{
            unselectBtn(mBtnTypeGround);
        }
        if(MainActivity.TYPE_FAIRY){
            selectBtn(mBtnTypeFairy);
        }else{
            unselectBtn(mBtnTypeFairy);
        }
        if(MainActivity.TYPE_FIGHTING){
            selectBtn(mBtnTypeFighting);
        }else{
            unselectBtn(mBtnTypeFighting);
        }
        if(MainActivity.TYPE_PSYCHIC){
            selectBtn(mBtnTypePsychic);
        }else{
            unselectBtn(mBtnTypePsychic);
        }


        if(MainActivity.TYPE_ROCK){
            selectBtn(mBtnTypeRock);
        }else{
            unselectBtn(mBtnTypeRock);
        }
        if(MainActivity.TYPE_STEEL){
            selectBtn(mBtnTypeSteel);
        }else{
            unselectBtn(mBtnTypeSteel);
        }
        if(MainActivity.TYPE_ICE){
            selectBtn(mBtnTypeIce);
        }else{
            unselectBtn(mBtnTypeIce);
        }
        if(MainActivity.TYPE_GHOST){
            selectBtn(mBtnTypeGhosh);
        }else{
            unselectBtn(mBtnTypeGhosh);
        }
        if(MainActivity.TYPE_DRAGON){
            selectBtn(mBtnTypeDragon);
        }else{
            unselectBtn(mBtnTypeDragon);
        }
        if(MainActivity.TYPE_DRAK){
            selectBtn(mBtnTypeDark);
        }else{
            unselectBtn(mBtnTypeDark);
        }

    }
    private void initEvent() {
        mBtnAllSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.TYPE_GRASS = true;
                MainActivity.TYPE_POISON = true;
                MainActivity.TYPE_FIRE = true;
                MainActivity.TYPE_FLYING = true;
                MainActivity.TYPE_WATER = true;
                MainActivity.TYPE_BUG = true;
                MainActivity.TYPE_NORMAL = true;
                MainActivity.TYPE_ELECTRIC = true;
                MainActivity.TYPE_GROUND = true;
                MainActivity.TYPE_FAIRY = true;
                MainActivity.TYPE_FIGHTING = true;
                MainActivity.TYPE_PSYCHIC = true;
                MainActivity.TYPE_ROCK = true;
                MainActivity.TYPE_STEEL = true;
                MainActivity.TYPE_ICE = true;
                MainActivity.TYPE_GHOST = true;
                MainActivity.TYPE_DRAGON = true;
                MainActivity.TYPE_DRAK = true;
                setColor();
            }
        });
        mBtnAllUnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.TYPE_GRASS = false;
                MainActivity.TYPE_POISON = false;
                MainActivity.TYPE_FIRE = false;
                MainActivity.TYPE_FLYING = false;
                MainActivity.TYPE_WATER = false;
                MainActivity.TYPE_BUG = false;
                MainActivity.TYPE_NORMAL = false;
                MainActivity.TYPE_ELECTRIC = false;
                MainActivity.TYPE_GROUND = false;
                MainActivity.TYPE_FAIRY = false;
                MainActivity.TYPE_FIGHTING = false;
                MainActivity.TYPE_PSYCHIC = false;
                MainActivity.TYPE_ROCK = false;
                MainActivity.TYPE_STEEL = false;
                MainActivity.TYPE_ICE = false;
                MainActivity.TYPE_GHOST = false;
                MainActivity.TYPE_DRAGON = false;
                MainActivity.TYPE_DRAK = false;
                setColor();
            }
        });
        mBtnType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(MainActivity.TYPE_1){
                   unselectBtn(mBtnType1);

               }else{
                   selectBtn(mBtnType1);
               }
                MainActivity.TYPE_1 = !MainActivity.TYPE_1;
            }
        });
        mBtnType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_2){
                    unselectBtn(mBtnType2);

                }else{

                    selectBtn(mBtnType2);

                }
                MainActivity.TYPE_2 = !MainActivity.TYPE_2;
            }
        });
        mBtnType3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_3){
                    unselectBtn(mBtnType3);
                }else{
                    selectBtn(mBtnType3);

                }
                MainActivity.TYPE_3 = !MainActivity.TYPE_3;
            }
        });
        mBtnType4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_4){

                    unselectBtn(mBtnType4);
                }else{
                    selectBtn(mBtnType4);
                }
                MainActivity.TYPE_4 = !MainActivity.TYPE_4;
            }
        });
        mBtnType5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_5){

                    unselectBtn(mBtnType5);
                }else{
                    selectBtn(mBtnType5);
                }
                MainActivity.TYPE_5 = !MainActivity.TYPE_5;
            }
        });
        mBtnType6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_6){

                    unselectBtn(mBtnType6);
                }else{
                    selectBtn(mBtnType6);
                }
                MainActivity.TYPE_6 = !MainActivity.TYPE_6;
            }
        });


        mBtnTypeGrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_GRASS){

                    unselectBtn(mBtnTypeGrass);
                }else{
                    selectBtn(mBtnTypeGrass);
                }
                MainActivity.TYPE_GRASS = !MainActivity.TYPE_GRASS;
            }
        });

        mBtnTypePoison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_POISON){

                    unselectBtn(mBtnTypePoison);
                }else{
                    selectBtn(mBtnTypePoison);
                }
                MainActivity.TYPE_POISON = !MainActivity.TYPE_POISON;
            }
        });

        mBtnTypeFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_FIRE){

                    unselectBtn(mBtnTypeFire);
                }else{
                    selectBtn(mBtnTypeFire);
                }
                MainActivity.TYPE_FIRE = !MainActivity.TYPE_FIRE;
            }
        });

        mBtnTypeFlying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_FLYING){

                    unselectBtn(mBtnTypeFlying);
                }else{
                    selectBtn(mBtnTypeFlying);
                }
                MainActivity.TYPE_FLYING = !MainActivity.TYPE_FLYING;
            }
        });

        mBtnTypeWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_WATER){

                    unselectBtn(mBtnTypeWater);
                }else{
                    selectBtn(mBtnTypeWater);
                }
                MainActivity.TYPE_WATER = !MainActivity.TYPE_WATER;
            }
        });
        mBtnTypeBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_BUG){

                    unselectBtn(mBtnTypeBug);
                }else{
                    selectBtn(mBtnTypeBug);
                }
                MainActivity.TYPE_BUG = !MainActivity.TYPE_BUG;
            }
        });
        mBtnTypeNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_NORMAL){

                    unselectBtn(mBtnTypeNormal);
                }else{
                    selectBtn(mBtnTypeNormal);
                }
                MainActivity.TYPE_NORMAL = !MainActivity.TYPE_NORMAL;
            }
        });

        mBtnTypeElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_ELECTRIC){

                    unselectBtn(mBtnTypeElectric);
                }else{
                    selectBtn(mBtnTypeElectric);
                }
                MainActivity.TYPE_ELECTRIC = !MainActivity.TYPE_ELECTRIC;
            }
        });
        mBtnTypeGround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_GROUND){

                    unselectBtn(mBtnTypeGround);
                }else{
                    selectBtn(mBtnTypeGround);
                }
                MainActivity.TYPE_GROUND = !MainActivity.TYPE_GROUND;
            }
        });

        mBtnTypeFairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_FAIRY){

                    unselectBtn(mBtnTypeFairy);
                }else{
                    selectBtn(mBtnTypeFairy);
                }
                MainActivity.TYPE_FAIRY = !MainActivity.TYPE_FAIRY;
            }
        });

        mBtnTypeFighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_FIGHTING){

                    unselectBtn(mBtnTypeFighting);
                }else{
                    selectBtn(mBtnTypeFighting);
                }
                MainActivity.TYPE_FIGHTING = !MainActivity.TYPE_FIGHTING;
            }
        });
        mBtnTypePsychic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_PSYCHIC){

                    unselectBtn(mBtnTypePsychic);
                }else{
                    selectBtn(mBtnTypePsychic);
                }
                MainActivity.TYPE_PSYCHIC = !MainActivity.TYPE_PSYCHIC;
            }
        });

        mBtnTypeRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_ROCK){

                    unselectBtn(mBtnTypeRock);
                }else{
                    selectBtn(mBtnTypeRock);
                }
                MainActivity.TYPE_ROCK = !MainActivity.TYPE_ROCK;
            }
        });

        mBtnTypeSteel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_STEEL){

                    unselectBtn(mBtnTypeSteel);
                }else{
                    selectBtn(mBtnTypeSteel);
                }
                MainActivity.TYPE_STEEL = !MainActivity.TYPE_STEEL;
            }
        });

        mBtnTypeIce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_ICE){

                    unselectBtn(mBtnTypeIce);
                }else{
                    selectBtn(mBtnTypeIce);
                }
                MainActivity.TYPE_ICE = !MainActivity.TYPE_ICE;
            }
        });

        mBtnTypeGhosh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_GHOST){

                    unselectBtn(mBtnTypeGhosh);
                }else{
                    selectBtn(mBtnTypeGhosh);
                }
                MainActivity.TYPE_GHOST = !MainActivity.TYPE_GHOST;
            }
        });
        mBtnTypeDragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_DRAGON){

                    unselectBtn(mBtnTypeDragon);
                }else{
                    selectBtn(mBtnTypeDragon);
                }
                MainActivity.TYPE_DRAGON = !MainActivity.TYPE_DRAGON;
            }
        });

        mBtnTypeDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.TYPE_DRAK){

                    unselectBtn(mBtnTypeDark);
                }else{
                    selectBtn(mBtnTypeDark);
                }
                MainActivity.TYPE_DRAK = !MainActivity.TYPE_DRAK;
            }
        });


    }
    private void selectBtn(TextView v){
        v.setBackgroundResource(R.drawable.round_btn);
        v.setTextColor(Color.parseColor("#ffffff"));
    }
    private void unselectBtn(TextView v){
        v.setBackgroundResource(R.drawable.round_btn_unsel);
        v.setTextColor(getResources().getColor(R.color.divider));
    }


}
