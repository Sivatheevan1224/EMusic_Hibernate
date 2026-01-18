package com.app.activity05.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="albums")
public class Album implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="album_id")
    private Integer albumid;
    
    //many  albums for one artist
    @ManyToOne
    @JoinColumn(name="artist_id")  // for this use as foreign key from another entity
    private Artist artist;
    
    @Column(name="name")
    private String name;
    
    @Column(name="image_file")
    private String imagefile;
    
    @OneToMany(mappedBy = "album" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Track> tracks;

    public Album() {
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
    
    
    
}
