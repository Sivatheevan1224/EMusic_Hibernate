package com.app.activity05.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tracks")
public class Track implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "track_id")
    private Integer trackid;
    
    @Column(name = "title")
    private String title;
    
    @ManyToOne  //many tracks in on album
    @JoinColumn(name="album_id")
    private Album album;

    public Track() {
    }

    public Integer getTrackid() {
        return trackid;
    }

    public void setTrackid(Integer trackid) {
        this.trackid = trackid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    

}
