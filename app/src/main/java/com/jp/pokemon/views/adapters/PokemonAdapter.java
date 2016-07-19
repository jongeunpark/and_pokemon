package com.jp.pokemon.views.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jp.pokemon.R;
import com.jp.pokemon.model.Pokemon;

import com.jp.pokemon.model.comparator.PokemonCompare;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * Created by jp on 16. 7. 13..
 */
public class PokemonAdapter extends ArrayAdapter<Pokemon> {


    private final LayoutInflater mLayoutInflater;
    private final Random mRandom;


    private DisplayImageOptions options;


    private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();
    private ArrayList<Pokemon> mItmes;
    private ArrayList<Pokemon> mFiltedItems;

    public PokemonAdapter(final Context context, final int layoutId, ArrayList<Pokemon> items) {
        super(context, layoutId, items);
        mLayoutInflater = LayoutInflater.from(context);
        mRandom = new Random();
        this.mItmes = items;
        this.mFiltedItems = items;
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

    @Override
    public int getCount() {

        return mFiltedItems.size();
    }

    @Override
    public Pokemon getItem(int positon) {
        try {
            return mFiltedItems.get(positon);
        } catch (Exception e) {
            return mFiltedItems.get(mFiltedItems.size() - 1);
        }
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        final ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.grid_item_pokemon, parent, false);
            vh = new ViewHolder();
            vh.txtLineOne = (TextView) convertView.findViewById(R.id.grid_item_text_name);
            vh.textEngName = (TextView) convertView.findViewById(R.id.grid_item_text_engname);
            vh.textType1 = (TextView) convertView.findViewById(R.id.grid_item_text_type1);
            vh.textType2 = (TextView) convertView.findViewById(R.id.grid_item_text_type2);
            vh.imageView = (ImageView) convertView.findViewById(R.id.grid_item_text_image);
            vh.progressBar = (ProgressBar) convertView.findViewById(R.id.grid_item_text_progress);

            convertView.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }


        vh.txtLineOne.setText(mFiltedItems.get(position).getNumber() + ". " + mFiltedItems.get(position).getName());
        vh.textEngName.setText("(" + mFiltedItems.get(position).getEngName() + ")");
        if (mFiltedItems.get(position).getType().size() == 1) {
            String type = mFiltedItems.get(position).getType().get(0);
            vh.textType1.setText(type);
            setColor(vh.textType1, type);
            vh.textType2.setVisibility(View.GONE);
        } else if (mFiltedItems.get(position).getType().size() == 2) {
            String type = mFiltedItems.get(position).getType().get(0);
            String type2 = mFiltedItems.get(position).getType().get(1);
            vh.textType1.setText(type);
            vh.textType2.setVisibility(View.VISIBLE);
            setColor(vh.textType1, type);
            vh.textType2.setText(type2);
            setColor(vh.textType2, type2);

        }
        ImageLoader.getInstance()
                .displayImage(mFiltedItems.get(position).getImageUrl(), vh.imageView, options, new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        vh.progressBar.setProgress(0);
                        vh.progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                        vh.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        vh.progressBar.setVisibility(View.GONE);
                    }
                }, new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view, int current, int total) {
                        vh.progressBar.setProgress(Math.round(100.0f * current / total));
                    }
                });


        return convertView;
    }

    private void setColor(TextView textView, String text) {

        if (text.equals(getContext().getString(R.string.type_grass))) {
            textView.setBackgroundResource(R.color.color_type_grass);
        } else if (text.equals(getContext().getString(R.string.type_poison))) {
            textView.setBackgroundResource(R.color.color_type_poison);
        } else if (text.equals(getContext().getString(R.string.type_fire))) {
            textView.setBackgroundResource(R.color.color_type_fire);
        } else if (text.equals(getContext().getString(R.string.type_flying))) {
            textView.setBackgroundResource(R.color.color_type_flying);
        } else if (text.equals(getContext().getString(R.string.type_water))) {
            textView.setBackgroundResource(R.color.color_type_water);
        } else if (text.equals(getContext().getString(R.string.type_bug))) {
            textView.setBackgroundResource(R.color.color_type_bug);
        } else if (text.equals(getContext().getString(R.string.type_normal))) {
            textView.setBackgroundResource(R.color.color_type_normal);
        } else if (text.equals(getContext().getString(R.string.type_electric))) {
            textView.setBackgroundResource(R.color.color_type_electric);
        } else if (text.equals(getContext().getString(R.string.type_ground))) {
            textView.setBackgroundResource(R.color.color_type_ground);
        } else if (text.equals(getContext().getString(R.string.type_fairy))) {
            textView.setBackgroundResource(R.color.color_type_fairy);
        } else if (text.equals(getContext().getString(R.string.type_fighting))) {
            textView.setBackgroundResource(R.color.color_type_fighting);
        } else if (text.equals(getContext().getString(R.string.type_psychic))) {
            textView.setBackgroundResource(R.color.color_type_psychic);
        } else if (text.equals(getContext().getString(R.string.type_rock))) {
            textView.setBackgroundResource(R.color.color_type_rock);
        } else if (text.equals(getContext().getString(R.string.type_steel))) {
            textView.setBackgroundResource(R.color.color_type_steel);
        } else if (text.equals(getContext().getString(R.string.type_ice))) {
            textView.setBackgroundResource(R.color.color_type_ice);
        } else if (text.equals(getContext().getString(R.string.type_ghost))) {
            textView.setBackgroundResource(R.color.color_type_ghost);
        } else if (text.equals(getContext().getString(R.string.type_dragon))) {
            textView.setBackgroundResource(R.color.color_type_dragon);
        } else if (text.equals(getContext().getString(R.string.type_drak))) {
            textView.setBackgroundResource(R.color.color_type_drak);
        }
    }

    private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        // if not yet done generate and stash the columns height
        // in our real world scenario this will be determined by
        // some match based on the known height and width of the image
        // and maybe a helpful way to get the column height!
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);

        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5 the width
    }

    public void sortBasic() {
        Collections.sort(mItmes, PokemonCompare.IdComparator);
        notifyDataSetChanged();
    }

    public void sortName() {
        Collections.sort(mItmes, PokemonCompare.NameComparator);
        notifyDataSetChanged();
    }

    public void sortWeightHigh() {
        Collections.sort(mItmes, PokemonCompare.WeightHighComparator);
        notifyDataSetChanged();
    }

    public void sortHeightHigh() {
        Collections.sort(mItmes, PokemonCompare.HeightHighComparator);
        notifyDataSetChanged();
    }

    public void sortWeightLow() {
        Collections.sort(mItmes, PokemonCompare.WeightLowComparator);
        notifyDataSetChanged();
    }

    public void sortHeightLow() {
        Collections.sort(mItmes, PokemonCompare.HeightLowComparator);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            /*
             * (non-Javadoc)
             *
             * @see
             * android.widget.Filter#performFiltering(java.lang.CharSequence)
             */

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults(); // Holds the

                List<Pokemon> filteredArrList = new ArrayList<Pokemon>();

                if (constraint == null || constraint.length() == 0) {

                    results.count = mItmes.size();
                    results.values = mItmes;
                } else {
                    Locale locale = Locale.getDefault();
                    constraint = constraint.toString().toLowerCase(locale);
                    for (int i = 0; i < mItmes.size(); i++) {
                        Pokemon model = mItmes.get(i);

                        String data = model.getName();
                        String data2 = model.getEngName();
                        if (data.toLowerCase(locale).contains(
                                constraint.toString())) {

                            filteredArrList.add(model);
                        }
                        if (data2.toLowerCase(locale).contains(
                                constraint.toString())) {

                            filteredArrList.add(model);
                        }
                    }
                    // set the Filtered result to return
                    results.count = filteredArrList.size();
                    results.values = filteredArrList;

                }
                return results;

            }

            /*
             * (non-Javadoc)
             *
             * @see android.widget.Filter#publishResults(java.lang.CharSequence,
             * android.widget.Filter.FilterResults)
             */
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {

                mFiltedItems = (ArrayList<Pokemon>) results.values; // has

                notifyDataSetChanged();
            }

        };
    }

    static class ViewHolder {
        TextView txtLineOne;
        TextView textEngName;
        TextView textType1;
        TextView textType2;
        ImageView imageView;
        ProgressBar progressBar;

    }


}