package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

@Entity
public class Image {

    @Id
    private long id;

    @SerializedName("url")
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
