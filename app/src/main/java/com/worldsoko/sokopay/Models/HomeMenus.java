package com.worldsoko.sokopay.Models;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;


@Table(name = "HomeMenus")
public class HomeMenus extends Model {


    @Column(name = "Name")
    private String Name;

    @Column(name = "ImageId")
    private Integer ImageId;


    @Column(name = "type")
    private String type;


    public Integer getImageId() {
        return ImageId;
    }

    public void setImageId(Integer imageId) {
        ImageId = imageId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static int MenusSize(){



        return new Select().from(HomeMenus.class).count();


    }


    public static List<HomeMenus> HomeMenus(){



        return new Select().from(HomeMenus.class).execute();


    }


    public static List<HomeMenus> HomeMenus(String name){



        return new Select().from(HomeMenus.class)
                .where("Name = ?", name)
                .execute();


    }



    public static List<HomeMenus> HomeMenus(String name,String type){



        return new Select().from(HomeMenus.class)
                .where("Name = ?", name)
                .where("type = ?", type)
                .execute();


    }


    public static List<HomeMenus> HomeMenusByType(String type){



        return new Select().from(HomeMenus.class)
                .where("type = ?", type)
                .execute();


    }



    public static HomeMenus getSigleHomeMenuByName(String name){

// return new Select().from(Account.class).where("customer_id = ?",customer_id).executeSingle();

        return new Select().from(HomeMenus.class).where("Name = ?", name).executeSingle();


    }

    public static HomeMenus getMenuByNameAndType(String name,String type){

// return new Select().from(Account.class).where("customer_id = ?",customer_id).executeSingle();

        return new Select().from(HomeMenus.class)
                .where("Name = ?", name)
                .where("type = ?", type)
                .executeSingle();


    }


}
