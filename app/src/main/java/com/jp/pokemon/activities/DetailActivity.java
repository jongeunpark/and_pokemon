package com.jp.pokemon.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jp.pokemon.R;
import com.jp.pokemon.model.Pokemon;
import com.jp.pokemon.model.PokemonDetail;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class DetailActivity extends AppCompatActivity {
    public static final String POKEMON_IMAGE = "POKEMON_IMAGE";
    public static final String POKEMON_NAME = "POKEMON_NAME";
    public static final String POKEMON_HEIGHT = "POKEMON_HEIGHT";
    public static final String POKEMON_WEIGHT = "POKEMON_WEIGHT";
    public static final String POKEMON_BASIC = "POKEMON_BASIC";
    public static final String POKEMON_ETC = "POKEMON_ETC";

    private ImageView mImage;
    private DisplayImageOptions options;
    private TextView mTextHeight;
    private TextView mTextWeight;
    private TextView mTextType1, mTextType2;
    private Pokemon mPokemon;
    private PokemonDetail mPokemonDetail;
    private TextView mTextSkill, mTextSkill2;
    private TextView mTextNum, mTextLocation;

    private TextView mTextHp, mTextAttack, mTextDefend;
    private TextView mTextSpeed, mTextSattack, mTextSdefend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initData();
        initActionbar();
        initView();
        initEvent();
        drawView();


    }

    private void initData() {
        mPokemon = new Pokemon(getIntent().getStringExtra(DetailActivity.POKEMON_BASIC));
        mPokemonDetail = new PokemonDetail(getIntent().getStringExtra(DetailActivity.POKEMON_ETC));
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_timer_black_48dp)
                .showImageForEmptyUri(R.drawable.ic_hourglass_empty_black_48dp)
                .showImageOnFail(R.drawable.ic_cancel_black_48dp)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    private void initActionbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra(DetailActivity.POKEMON_NAME));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


    }

    private void initView() {
        mImage = (ImageView) findViewById(R.id.detail_image);
        mTextHeight = (TextView) findViewById(R.id.detail_text_height);
        mTextWeight = (TextView) findViewById(R.id.detail_text_weight);

        mTextType1 = (TextView) findViewById(R.id.detail_text_type1);
        mTextType2 = (TextView) findViewById(R.id.detail_text_type2);
        mTextSkill = (TextView) findViewById(R.id.detail_text_skill1);
        mTextSkill2 = (TextView) findViewById(R.id.detail_text_skill2);
        mTextNum = (TextView) findViewById(R.id.detail_text_number);
        mTextLocation = (TextView) findViewById(R.id.detail_text_location);

        mTextHp = (TextView) findViewById(R.id.detail_text_hp);
        mTextAttack = (TextView) findViewById(R.id.detail_text_attack);
        mTextDefend = (TextView) findViewById(R.id.detail_text_defend);
        mTextSpeed = (TextView) findViewById(R.id.detail_text_speed);
        mTextSattack = (TextView) findViewById(R.id.detail_text_sattack);
        mTextSdefend = (TextView) findViewById(R.id.detail_text_sdefend);
    }

    private void initEvent() {

    }


    private void drawView() {
        BigDecimal weight = new BigDecimal(getIntent().getStringExtra(DetailActivity.POKEMON_WEIGHT));
        BigDecimal height = new BigDecimal(getIntent().getStringExtra(DetailActivity.POKEMON_HEIGHT));


        mTextHeight.setText(height.movePointLeft(1).toPlainString() + " m");
        mTextWeight.setText(weight.movePointLeft(1).toPlainString() + " kg");
        mTextNum.setText(mPokemon.getNumber());
        drawLocation(Integer.parseInt(mPokemon.getId()));
        if (mPokemon.getType().size() == 1) {
            mTextType1.setVisibility(View.VISIBLE);
            mTextType2.setVisibility(View.GONE);
            mTextType1.setText(mPokemon.getType().get(0));
            setColor(mTextType1, mPokemon.getType().get(0));
        } else if (mPokemon.getType().size() == 2) {
            mTextType1.setVisibility(View.VISIBLE);
            mTextType2.setVisibility(View.VISIBLE);
            mTextType1.setText(mPokemon.getType().get(0));
            mTextType2.setText(mPokemon.getType().get(1));
            setColor(mTextType1, mPokemon.getType().get(0));
            setColor(mTextType2, mPokemon.getType().get(1));
        }
        if (mPokemon.getSkill().size() == 2) {

            mTextSkill.append(mPokemon.getSkill().get(0) + ", " + mPokemon.getSkill().get(1));

        } else if (mPokemon.getSkill().size() == 1) {

            mTextSkill.append(mPokemon.getSkill().get(0));

        }

        if (mPokemon.getHiddenSkill().size() == 2) {
            mTextSkill2.append(mPokemon.getHiddenSkill().get(0) + ", " + mPokemon.getHiddenSkill().get(1));
        } else if (mPokemon.getHiddenSkill().size() == 1) {
            mTextSkill2.append(mPokemon.getHiddenSkill().get(0));
        }

        mTextAttack.setText(""+mPokemonDetail.getAttack());
        mTextDefend.setText(""+mPokemonDetail.getDepend());
        mTextHp.setText(""+mPokemonDetail.getHp());
        mTextSpeed.setText(""+mPokemonDetail.getSpeed());
        mTextSdefend.setText(""+mPokemonDetail.getsDepend());
        mTextSattack.setText(""+mPokemonDetail.getsAttack());
        ImageLoader.getInstance()
                .displayImage(getIntent().getStringExtra(DetailActivity.POKEMON_IMAGE), mImage, options, new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {

                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                    }
                }, new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view, int current, int total) {

                    }
                });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void drawLocation(int id) {
        if (id >= 1 && id <= 151) {
            mTextLocation.setText(getString(R.string.detail_location1));

        } else if (id >= 152 && id <= 251) {
            mTextLocation.setText(getString(R.string.detail_location2));
        } else if (id >= 252 && id <= 386) {
            mTextLocation.setText(getString(R.string.detail_location3));
        } else if (id >= 387 && id <= 493) {
            mTextLocation.setText(getString(R.string.detail_location4));
        } else if (id >= 494 && id <= 649) {
            mTextLocation.setText(getString(R.string.detail_location5));
        } else if (id >= 650 && id <= 721) {
            mTextLocation.setText(getString(R.string.detail_location6));
        }
    }

    private void setColor(TextView textView, String text) {

        if (text.equals(getString(R.string.type_grass))) {
            textView.setBackgroundResource(R.color.color_type_grass);
        } else if (text.equals(getString(R.string.type_poison))) {
            textView.setBackgroundResource(R.color.color_type_poison);
        } else if (text.equals(getString(R.string.type_fire))) {
            textView.setBackgroundResource(R.color.color_type_fire);
        } else if (text.equals(getString(R.string.type_flying))) {
            textView.setBackgroundResource(R.color.color_type_flying);
        } else if (text.equals(getString(R.string.type_water))) {
            textView.setBackgroundResource(R.color.color_type_water);
        } else if (text.equals(getString(R.string.type_bug))) {
            textView.setBackgroundResource(R.color.color_type_bug);
        } else if (text.equals(getString(R.string.type_normal))) {
            textView.setBackgroundResource(R.color.color_type_normal);
        } else if (text.equals(getString(R.string.type_electric))) {
            textView.setBackgroundResource(R.color.color_type_electric);
        } else if (text.equals(getString(R.string.type_ground))) {
            textView.setBackgroundResource(R.color.color_type_ground);
        } else if (text.equals(getString(R.string.type_fairy))) {
            textView.setBackgroundResource(R.color.color_type_fairy);
        } else if (text.equals(getString(R.string.type_fighting))) {
            textView.setBackgroundResource(R.color.color_type_fighting);
        } else if (text.equals(getString(R.string.type_psychic))) {
            textView.setBackgroundResource(R.color.color_type_psychic);
        } else if (text.equals(getString(R.string.type_rock))) {
            textView.setBackgroundResource(R.color.color_type_rock);
        } else if (text.equals(getString(R.string.type_steel))) {
            textView.setBackgroundResource(R.color.color_type_steel);
        } else if (text.equals(getString(R.string.type_ice))) {
            textView.setBackgroundResource(R.color.color_type_ice);
        } else if (text.equals(getString(R.string.type_ghost))) {
            textView.setBackgroundResource(R.color.color_type_ghost);
        } else if (text.equals(getString(R.string.type_dragon))) {
            textView.setBackgroundResource(R.color.color_type_dragon);
        } else if (text.equals(getString(R.string.type_drak))) {
            textView.setBackgroundResource(R.color.color_type_drak);
        }
    }


}
