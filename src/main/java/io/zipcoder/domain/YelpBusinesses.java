package io.zipcoder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)



/**
 * Created by nicholaswebb on 3/28/16.
 */
public class YelpBusinesses {
    private String name;
    private String image_url;
    private String rating_img_url;
    private String snippet_text;
    private String url;
    private YelpLocation location;

    public String getSnippet_text(){
        return snippet_text;
    }
    public String getUrl(){
        return url;
    }
    public void setSnippet_text(String snippet_text){
        this.snippet_text = snippet_text;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public String getRating_img_url(){
        return rating_img_url;
    }

    public void setRating_img_url(String rating_img_url){
        this.rating_img_url = rating_img_url;
    }
    public String getImage_url(){
        return image_url;
    }
    public void setImage_url(String image_url){
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YelpLocation getLocation() {
        return location;
    }

    public void setLocation(YelpLocation location) {
        this.location = location;
    }
}
