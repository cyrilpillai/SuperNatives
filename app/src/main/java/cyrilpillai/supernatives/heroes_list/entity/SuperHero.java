package cyrilpillai.supernatives.heroes_list.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

@Entity
public class SuperHero implements Parcelable {

    @Id(assignable = true)
    @SerializedName("id")
    private long id;

    @SerializedName("character_name")
    private String name;

    public SuperHero() {
    }

    protected SuperHero(Parcel in) {
        id = in.readLong();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SuperHero> CREATOR = new Creator<SuperHero>() {
        @Override
        public SuperHero createFromParcel(Parcel in) {
            return new SuperHero(in);
        }

        @Override
        public SuperHero[] newArray(int size) {
            return new SuperHero[size];
        }
    };

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
