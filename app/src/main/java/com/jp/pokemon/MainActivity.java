package com.jp.pokemon;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.crashlytics.android.Crashlytics;
import com.etsy.android.grid.StaggeredGridView;
import com.jp.pokemon.activities.DetailActivity;
import com.jp.pokemon.activities.FillterActivity;
import com.jp.pokemon.model.DataStorage;
import com.jp.pokemon.views.adapters.PokemonAdapter;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DataStorage mDataStorage;
    public static boolean TYPE_1 = true;
    public static boolean TYPE_2 = true;
    public static boolean TYPE_3 = true;
    public static boolean TYPE_4 = true;
    public static boolean TYPE_5 = true;
    public static boolean TYPE_6 = true;

    public static boolean TYPE_GRASS = true;
    public static boolean TYPE_POISON = true;
    public static boolean TYPE_FIRE = true;
    public static boolean TYPE_FLYING = true;
    public static boolean TYPE_WATER = true;
    public static boolean TYPE_BUG = true;
    public static boolean TYPE_NORMAL = true;
    public static boolean TYPE_ELECTRIC = true;
    public static boolean TYPE_GROUND = true;
    public static boolean TYPE_FAIRY = true;
    public static boolean TYPE_FIGHTING = true;
    public static boolean TYPE_PSYCHIC = true;
    public static boolean TYPE_ROCK = true;
    public static boolean TYPE_STEEL = true;
    public static boolean TYPE_ICE = true;
    public static boolean TYPE_GHOST = true;
    public static boolean TYPE_DRAGON = true;
    public static boolean TYPE_DRAK = true;


    private TextView mTextTitle;
    private StaggeredGridView mGridView;
    private PokemonAdapter mAdapter;
    private TextView mBtnFilter, mBtnSort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        initData();
        initActionbar();
        initView();
        initEvent();
        drawAdapter();


    }

    private void initData() {
        mDataStorage = new DataStorage();
        mDataStorage.createDetail();
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }

    private void initActionbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        mTextTitle = (TextView) navigationView.getHeaderView(0).findViewById(R.id.nav_text_title);
    }

    private void initView() {
        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);

        mBtnFilter = (TextView) findViewById(R.id.main_btn_fillter);
        mBtnSort = (TextView) findViewById(R.id.main_btn_sort);
        mBtnSort.setText(String.format(getString(R.string.sort), "기본순"));

        try {
            mTextTitle.setText(getString(getApplicationInfo().labelRes)
                    + " "
                    + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);

        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            mTextTitle.setText(getString(getApplicationInfo().labelRes));
        }


    }

    private void initEvent() {
        mBtnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MainActivity.this)
                        .items(R.array.sort_type)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view,
                                                    int which, CharSequence text) {
                                if (text.toString() != null) {
                                    mBtnSort.setText(String.format(getString(R.string.sort), text.toString()));
                                    sortPokemon(which);
                                }
                            }
                        }).show();
            }
        });
        mBtnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, FillterActivity.class), 100);

            }
        });
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mAdapter != null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.POKEMON_IMAGE, mAdapter.getItem(i).getImageUrl());
                    intent.putExtra(DetailActivity.POKEMON_NAME, mAdapter.getItem(i).getName() + " (" + mAdapter.getItem(i).getEngName() + ")");
                    intent.putExtra(DetailActivity.POKEMON_HEIGHT, mAdapter.getItem(i).getHeight());
                    intent.putExtra(DetailActivity.POKEMON_WEIGHT, mAdapter.getItem(i).getWeight());
                    intent.putExtra(DetailActivity.POKEMON_BASIC, mAdapter.getItem(i).getStr());
                    mDataStorage.getEtcString(Integer.parseInt(mAdapter.getItem(i).getId()) - 1);
                    intent.putExtra(DetailActivity.POKEMON_ETC, mDataStorage.getEtcString(Integer.parseInt(mAdapter.getItem(i).getId()) - 1));
                    //public static final String POKEMON_ETC = "POKEMON_ETC";
                    startActivity(intent);
                }

            }
        });
    }

    private void drawAdapter() {
        mDataStorage = new DataStorage();
        mDataStorage.createDetail();

        mAdapter = new PokemonAdapter(this, R.layout.grid_item_pokemon, mDataStorage.getList());
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            mGridView.setAdapter(null);
        }
        View footer = getLayoutInflater().inflate(R.layout.grid_footer_pokemon, null, false);
        mGridView.addFooterView(footer);
        mGridView.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_main_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                if (mAdapter != null) {
                    mAdapter.getFilter().filter("", new Filter.FilterListener() {
                        @Override
                        public void onFilterComplete(int i) {

                        }
                    });
                }
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (mAdapter != null) {

                    mAdapter.getFilter().filter(newText, new Filter.FilterListener() {
                        @Override
                        public void onFilterComplete(int i) {

                        }
                    });
                }
                return false;
            }
        });
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_review) {
            openMarket();
        } else if (id == R.id.nav_share) {
            openShareApp();
        } else if (id == R.id.nav_send) {
            openEmailApp();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void sortPokemon(int type) {
        if (mAdapter != null) {
            if (type == 0) {
                mAdapter.sortBasic();
            } else if (type == 1) {
                mAdapter.sortName();
            } else if (type == 2) {
                mAdapter.sortWeightHigh();
            } else if (type == 3) {
                mAdapter.sortWeightLow();
            } else if (type == 4) {
                mAdapter.sortHeightHigh();
            } else if (type == 5) {
                mAdapter.sortHeightLow();
            }
        }
    }

    private void openMarket() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            intent.setData(Uri
                    .parse("market://details?id="
                            + getPackageManager().getPackageInfo(
                            getPackageName(), 0).packageName));
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        startActivity(intent);
    }

    private void openShareApp() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        try {
            sendIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "https://play.google.com/store/apps/details?id="
                            + getPackageManager().getPackageInfo(
                            getPackageName(), 0).packageName);
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void openEmailApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        String body = "\n\n\n\n\n--------------------\n아래 내용을 지우거나 수정하지 마세요.\n";
        try {
            body += "\nApp Name : " + getString(getApplicationInfo().labelRes);
            body += "\nApp Version : "
                    + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            body += "\nOS Version : " + android.os.Build.VERSION.RELEASE;
            body += "\nDevice : " + android.os.Build.MODEL;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[]{"jp.jongeun.park@gmail.com.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, body);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == 100) {
            drawAdapter();
        }
    }
}
