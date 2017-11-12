package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class Work {

    @SerializedName("occupation")
    private String occupation;

    @SerializedName("base")
    private String base;

    public Work(String occupation, String base) {
        this.occupation = occupation;
        this.base = base;
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

    @Override
    public String toString() {
        return "Work{" +
                "occupation='" + occupation + '\'' +
                ", base='" + base + '\'' +
                '}';
    }

    public void setBase(String base) {
        this.base = base;
    }
}
