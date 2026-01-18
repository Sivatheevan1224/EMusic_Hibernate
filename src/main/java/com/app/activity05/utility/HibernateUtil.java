package com.app.activity05.utility;

import com.app.activity05.entity.Album;
import com.app.activity05.entity.Artist;
import com.app.activity05.entity.Track;
import com.app.activity05.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySetting("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/emusic?allowPublicKeyRetrieval=true&useSSL=false")
                    .applySetting("hibernate.connection.username", "root")
                    .applySetting("hibernate.connection.passwords", "")
                    .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                    .build();

            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(User.class);
            sources.addAnnotatedClass(Album.class);
            sources.addAnnotatedClass(Artist.class);
            sources.addAnnotatedClass(Track.class);

            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        }

        return sessionFactory;
    }
}
