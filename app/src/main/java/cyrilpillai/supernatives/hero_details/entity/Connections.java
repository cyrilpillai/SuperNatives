package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

@Entity
public class Connections {

    @Id
    private long id;

    @SerializedName("group-affiliation")
    private String groupAffiliation;

    @SerializedName("relatives")
    private String relatives;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupAffiliation() {
        return groupAffiliation;
    }

    public void setGroupAffiliation(String groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    @Override
    public String toString() {
        return "Connections{" +
                "id=" + id +
                ", groupAffiliation='" + groupAffiliation + '\'' +
                ", relatives='" + relatives + '\'' +
                '}';
    }
}
