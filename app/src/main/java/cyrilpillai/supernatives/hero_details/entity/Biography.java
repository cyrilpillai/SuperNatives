package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import cyrilpillai.supernatives.utils.DatabaseHelper;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

@Entity
public class Biography {

    @Id
    private long id;

    @SerializedName("full-name")
    private String fullName;

    @SerializedName("alter-egos")
    private String alterEgos;

    @SerializedName("aliases")
    @Convert(converter = DatabaseHelper.StringListConverter.class, dbType = String.class)
    private List<String> aliases;

    @SerializedName("place-of-birth")
    private String placeOfBirth;

    @SerializedName("first-appearance")
    private String firstAppearance;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("alignment")
    private String alignment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", alterEgos='" + alterEgos + '\'' +
                ", aliases=" + aliases +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", firstAppearance='" + firstAppearance + '\'' +
                ", publisher='" + publisher + '\'' +
                ", alignment='" + alignment + '\'' +
                '}';
    }
}
