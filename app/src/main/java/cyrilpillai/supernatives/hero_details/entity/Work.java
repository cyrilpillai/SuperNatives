package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

@Entity
public class Work {

    @Id
    private long id;

    @SerializedName("occupation")
    private String occupation;

    @SerializedName("base")
    private String base;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", occupation='" + occupation + '\'' +
                ", base='" + base + '\'' +
                '}';
    }
}
