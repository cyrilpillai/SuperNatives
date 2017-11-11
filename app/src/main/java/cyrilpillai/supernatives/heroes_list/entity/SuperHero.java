package cyrilpillai.supernatives.heroes_list.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class SuperHero {
    @SerializedName("id")
    private int id;
    @SerializedName("character_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
