package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;
import io.objectbox.relation.ToOne;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

@Entity
public class SuperHeroDetails {

    @Id(assignable = true)
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @Transient
    @SerializedName("powerstats")
    private PowerStats powerStats;

    @Transient
    @SerializedName("biography")
    private Biography biography;

    @Transient
    @SerializedName("appearance")
    private Appearance appearance;

    @Transient
    @SerializedName("work")
    private Work work;

    @Transient
    @SerializedName("connections")
    private Connections connections;

    @Transient
    @SerializedName("image")
    private Image image;

    private ToOne<PowerStats> powerStatsToOne;

    private ToOne<Biography> biographyToOne;

    private ToOne<Appearance> appearanceToOne;

    private ToOne<Work> workToOne;

    private ToOne<Connections> connectionsToOne;

    private ToOne<Image> imageToOne;

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

    public PowerStats getPowerStats() {
        return powerStats;
    }

    public void setPowerStats(PowerStats powerStats) {
        this.powerStats = powerStats;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ToOne<PowerStats> getPowerStatsToOne() {
        return powerStatsToOne;
    }

    public void setPowerStatsToOne(ToOne<PowerStats> powerStatsToOne) {
        this.powerStatsToOne = powerStatsToOne;
    }

    public ToOne<Biography> getBiographyToOne() {
        return biographyToOne;
    }

    public void setBiographyToOne(ToOne<Biography> biographyToOne) {
        this.biographyToOne = biographyToOne;
    }

    public ToOne<Appearance> getAppearanceToOne() {
        return appearanceToOne;
    }

    public void setAppearanceToOne(ToOne<Appearance> appearanceToOne) {
        this.appearanceToOne = appearanceToOne;
    }

    public ToOne<Work> getWorkToOne() {
        return workToOne;
    }

    public void setWorkToOne(ToOne<Work> workToOne) {
        this.workToOne = workToOne;
    }

    public ToOne<Connections> getConnectionsToOne() {
        return connectionsToOne;
    }

    public void setConnectionsToOne(ToOne<Connections> connectionsToOne) {
        this.connectionsToOne = connectionsToOne;
    }

    public ToOne<Image> getImageToOne() {
        return imageToOne;
    }

    public void setImageToOne(ToOne<Image> imageToOne) {
        this.imageToOne = imageToOne;
    }

    @Override
    public String toString() {
        return "SuperHeroDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", powerStats=" + powerStats +
                ", biography=" + biography +
                ", appearance=" + appearance +
                ", work=" + work +
                ", connections=" + connections +
                ", image=" + image +
                '}';
    }
}
