package com.etiennelawlor.loop.network.models.response;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by etiennelawlor on 5/23/15.
 */
public class AuthorizedUser implements Parcelable {

    // region Fields
    @SerializedName("uri")
    private String uri;
    @SerializedName("name")
    private String name;
    @SerializedName("link")
    private String link;
    @SerializedName("location")
    private String location;
    @SerializedName("bio")
    private String bio;
    @SerializedName("created_time")
    private String createdTime;
    @SerializedName("account")
    private String account;
    @SerializedName("pictures")
    private List<Picture> pictures;
    // endregion

    // region Constructors
    public AuthorizedUser() {
    }

    protected AuthorizedUser(Parcel in) {
        this.uri = in.readString();
        this.name = in.readString();
        this.link = in.readString();
        this.location = in.readString();
        this.bio = in.readString();
        this.createdTime = in.readString();
        this.account = in.readString();
        this.pictures = in.createTypedArrayList(Picture.CREATOR);
    }
    // endregion

    // region Getters
    public String getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getAccount() {
        return account;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public long getId() {
        long id = -1L;
        String uri = getUri();
        if (!TextUtils.isEmpty(uri)) {
            String lastPathSegment = Uri.parse(uri).getLastPathSegment();
            id = Long.parseLong(lastPathSegment);
        }
        return id;
    }
    // endregion

    // region Setters
    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    // endregion

    // region Parcelable Methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uri);
        dest.writeString(this.name);
        dest.writeString(this.link);
        dest.writeString(this.location);
        dest.writeString(this.bio);
        dest.writeString(this.createdTime);
        dest.writeString(this.account);
        dest.writeTypedList(this.pictures);
    }
    // endregion

    public static final Parcelable.Creator<AuthorizedUser> CREATOR = new Parcelable.Creator<AuthorizedUser>() {
        @Override
        public AuthorizedUser createFromParcel(Parcel source) {
            return new AuthorizedUser(source);
        }

        @Override
        public AuthorizedUser[] newArray(int size) {
            return new AuthorizedUser[size];
        }
    };
}