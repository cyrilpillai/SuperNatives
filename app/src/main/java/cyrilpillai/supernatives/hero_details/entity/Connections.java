package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class Connections {

    @SerializedName("group-affiliation")
    private String groupAffiliation;

    @SerializedName("relatives")
    private String relatives;

    public Connections(String groupAffiliation, String relatives) {
        this.groupAffiliation = groupAffiliation;
        this.relatives = relatives;
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
                "groupAffiliation='" + groupAffiliation + '\'' +
                ", relatives='" + relatives + '\'' +
                '}';
    }
}
