package com.app.activity05.service;

import com.app.activity05.entity.Album;
import com.app.activity05.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AlbumDAO {
    
    public List<Album> getAllAlbums(){
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tr = session.beginTransaction();
            String hql="from Album";
            Query<Album> query = session.createQuery(hql, Album.class);
            List<Album> albumlist = query.getResultList();
            tr.commit();
            return albumlist;
            // without transation also we can retrive the  date, but cant modify
        } catch (Exception e) {
            if(tr != null){
                tr.rollback();
            }
        }
        return null;
    }
    
    public Album getAlbumById(int album_id){
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tr = session.beginTransaction();
            Album album = session.get(Album.class, album_id);
            tr.commit();
            return album;
        } catch (Exception e) {
            if(tr != null){
                tr.rollback();
            }
        }
        return null;
    }
    
}
