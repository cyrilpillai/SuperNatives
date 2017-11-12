package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class Biography {

    @SerializedName("full-name")
    private String fullName;

    @SerializedName("alter-egos")
    private String alterEgos;

    @SerializedName("aliases")
    private List<String> aliases;

    @SerializedName("place-of-birth")
    private String placeOfBirth;

    @SerializedName("first-appearance")
    private String firstAppearance;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("alignment")
    private String alignment;

    public Biography(String fullName, String alterEgos, List<String> aliases, String placeOfBirth,
                     String firstAppearance, String publisher, String alignment) {
        this.fullName = fullName;
        this.alterEgos = alterEgos;
        this.aliases = aliases;
        this.placeOfBirth = placeOfBirth;
        this.firstAppearance = firstAppearance;
        this.publisher = publisher;
        this.alignment = alignment;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlterEgos() {
        return alterEgos;
    }

    public void setAlterEgos(String alterEgos) {
        this.alterEgos = alterEgos;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    @Override
    public String toString() {
        return "Biography{" +
                "fullName='" + fullName + '\'' +
                ", alterEgos='" + alterEgos + '\'' +
                ", aliases=" + aliases +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", firstAppearance='" + firstAppearance + '\'' +
                ", publisher='" + publisher + '\'' +
                ", alignment='" + alignment + '\'' +
                '}';
    }
}
