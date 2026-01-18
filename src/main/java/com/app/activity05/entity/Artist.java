package com.app.activity05.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="artists")
public class Artist implements Serializable {
    @Id 
    @GeneratedValue
    @Column(name="artist_id")
    private Integer artistId;
    
    @Column(name="name")
    private String name;
    
    @OneToMany(mappedBy = "artist" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Album> albums;

    public Artist() {
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
    
    
}
