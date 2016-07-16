package com.worldsoko.sokopay.Activities;

import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import com.worldsoko.sokopay.Application.SokoApp;
import com.worldsoko.sokopay.Models.HomeMenus;
import com.worldsoko.sokopay.R;
import com.worldsoko.sokopay.Utility.Typefacer;
import com.worldsoko.sokopay.ViewAdapters.HomeMenuGridAdapter;


public class FirstActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    TextView toolbarTitle;
    Typefacer typefacer;
    RecyclerView homeMenusRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

         coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinate);
        typefacer=new Typefacer();
        setBottomNavigation(savedInstanceState);
        setToolBar("SokoPay");
        setRecycleViewer("");

        //BlurLayout.setGlobalDefaultDuration(450);



    }


    private void setBottomNavigation( Bundle savedInstanceState){

        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.three_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.recent_item:
                        // Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.favorite_item:
                        //Snackbar.make(coordinatorLayout, "Favorite Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.location_item:
                        // Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;

                    case R.id.sgutdown:
                        // Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                }
            }
        });
        bottomBar.setDefaultTabPosition(0);
        //  bottomBar.setActiveTabColor("#C2185B");
    }
    private void setToolBar(String title){
        toolbar=(Toolbar)findViewById(R.id.app_bar);
        toolbarTitle= (TextView) findViewById(R.id.toolbarTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbarTitle.setText(title);
        toolbarTitle.setTypeface(typefacer.squareLight());
        TextView toolbarnotify=(TextView)findViewById(R.id.toolbarnotify);
        toolbarnotify.setVisibility(View.GONE);


    }
    private void setRecycleViewer(String type){

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        // Create a custom SpanSizeLookup where the first item spans both columns
       layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });




                homeMenusRecycler=(RecyclerView)findViewById(R.id.favItemsList);
                RecyclerView.LayoutManager mlyout2=new GridLayoutManager(SokoApp.getAppContext(),2,GridLayoutManager.VERTICAL,false);
                HomeMenuGridAdapter billersAdapter=new HomeMenuGridAdapter(SokoApp.getAppContext(), HomeMenus.HomeMenusByType("HM"));
                homeMenusRecycler.setAdapter(billersAdapter);
                homeMenusRecycler.setLayoutManager(layoutManager);



        }



}
class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) { // top edge
                outRect.top = spacing;
            }
            outRect.bottom = spacing; // item bottom
        } else {
            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
    }
}