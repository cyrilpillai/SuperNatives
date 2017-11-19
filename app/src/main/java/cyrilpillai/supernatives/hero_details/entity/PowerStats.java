package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

@Entity
public class PowerStats {

    @Id
    private long id;

    @SerializedName("intelligence")
    private String intelligence;

    @SerializedName("strength")
    private String strength;

    @SerializedName("speed")
    private String speed;

    @SerializedName("durability")
    private String durability;

    @SerializedName("power")
    private String power;

    @SerializedName("combat")
    private String combat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }

    @Override
    public String toString() {
        return "PowerStats{" +
                "id=" + id +
                ", intelligence='" + intelligence + '\'' +
                ", strength='" + strength + '\'' +
                ", speed='" + speed + '\'' +
                ", durability='" + durability + '\'' +
                ", power='" + power + '\'' +
                ", combat='" + combat + '\'' +
                '}';
    }
}
