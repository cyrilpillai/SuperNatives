package cyrilpillai.supernatives.heroes_list.entity;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

@Entity
public class SuperHero {

    @Id(assignable = true)
    @SerializedName("id")
    private long id;

    @SerializedName("character_name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return "SuperHeroDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
