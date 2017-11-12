package cyrilpillai.supernatives.hero_details.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class Image {

    @SerializedName("url")
    private String url;

    public Image(String url) {
        this.url = url;
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
                "url='" + url + '\'' +
                '}';
    }
}
