package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class PowerStats {
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

    public PowerStats(String intelligence, String strength, String speed, String durability, String power, String combat) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
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
                "intelligence='" + intelligence + '\'' +
                ", strength='" + strength + '\'' +
                ", speed='" + speed + '\'' +
                ", durability='" + durability + '\'' +
                ", power='" + power + '\'' +
                ", combat='" + combat + '\'' +
                '}';
    }
}
