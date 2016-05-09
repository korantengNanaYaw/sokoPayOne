package com.worldsoko.sokopay;

import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.worldsoko.sokopay.Models.HomeMenus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nana Safo aka Brudex on 5/6/16.
 */
public class MenuMaps {

    public Map<String,Integer> HomeMenusMap(){

        Map<String , Integer >BillersMap=new LinkedHashMap<>();
        //Billers billers=new Billers();

        List<String> ItemNames=new ArrayList<>();
        List<Integer>drawableIDs=new ArrayList<>();

        ItemNames.add("Money Transfer");
        ItemNames.add("Buy Airtime");
        ItemNames.add("Online Shopping");
        ItemNames.add("Pay Bill");
        ItemNames.add("Pay School Fees");
        ItemNames.add("Pay Transport Fare");
        ItemNames.add("Air Tickets");


        drawableIDs.add(R.drawable.ic_money_trans);
        drawableIDs.add(R.drawable.ic_buyairtime);
        drawableIDs.add(R.drawable.ic_onlineshopping);
        drawableIDs.add(R.drawable.ic_billl_pay);
        drawableIDs.add(R.drawable.ic_schoolfees);
        drawableIDs.add(R.drawable.ic_pay_car);
        drawableIDs.add(R.drawable.ic_airticket);



        for(int i=0;i<drawableIDs.size();i++){

            BillersMap.put(ItemNames.get(i),drawableIDs.get(i));
        }



        return BillersMap;
    }



    public void InitStaticTables(){


        if(HomeMenus.MenusSize()==0){


            ActiveAndroid.beginTransaction();

            try {


                ///Start Inserting HomeMenus

                for(Map.Entry<String,Integer> map:HomeMenusMap().entrySet()){

                    HomeMenus b =HomeMenus.getSigleHomeMenuByName(map.getKey());

                    if(b==null)
                        b=new HomeMenus();

                    b.setName(map.getKey());
                    b.setImageId(map.getValue());
                    b.setType("HM");

                    Log.d("Billers", "Map Key " + map.getKey() + " Map Value  " + map.getValue());
                    long intt =b.save();

                    Log.d("Billers",b.getName()+" ID "+intt);
                }




                ActiveAndroid.setTransactionSuccessful();


            }catch (Exception e) {


            } finally {
                ActiveAndroid.endTransaction();

            }






        }else{



        }



    }
}
