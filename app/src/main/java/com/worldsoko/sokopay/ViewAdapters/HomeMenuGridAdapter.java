package com.worldsoko.sokopay.ViewAdapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.worldsoko.sokopay.Models.HomeMenus;
import com.worldsoko.sokopay.R;
import com.worldsoko.sokopay.Utility.Typefacer;

import java.util.Collections;
import java.util.List;

public class HomeMenuGridAdapter  extends RecyclerView.Adapter<HomeMenuGridAdapterViewHolderNew>{

    private Context context;
    private LayoutInflater inflater;
    List<HomeMenus> data= Collections.emptyList();
    Typefacer typefacer;
    private String[] mKeys;
    // private  String layoutType="Grid";
    View view=null;




    public HomeMenuGridAdapter(Context context, List<HomeMenus> data) {
        inflater= LayoutInflater.from(context);
        this.data=data;
        this.context=context;

    }

    @Override
    public HomeMenuGridAdapterViewHolderNew onCreateViewHolder(ViewGroup parent, int viewType) {
        // if(Application.BillersRecycleViewLayoutType.equalsIgnoreCase("Grid")) {
        view = inflater.inflate(R.layout.menu_grid_item, parent, false);
        // } else if(Application.BillersRecycleViewLayoutType.equalsIgnoreCase("List")){
        // view= inflater.inflate(R.layout.list_item_layout_billers,parent,false);}

        HomeMenuGridAdapterViewHolderNew holder = new HomeMenuGridAdapterViewHolderNew(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(final HomeMenuGridAdapterViewHolderNew holder, int position) {
        typefacer=new Typefacer();
        final HomeMenus items=data.get(position);
        holder.textView.setTypeface(typefacer.squareRegular());
        holder.textView.setText(items.getName());

        // holder.imageView.setImageBitmap(entry.getValue());
        holder.imageView.post(new Runnable() {
            @Override
            public void run() {
                holder.imageView.setImageResource(items.getImageId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class HomeMenuGridAdapterViewHolderNew extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public HomeMenuGridAdapterViewHolderNew(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.grid_item_text);
        imageView = (ImageView) itemView.findViewById(R.id.grid_item_image);
    }
}