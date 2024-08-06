package org.example.services;


import jakarta.persistence.criteria.*;

import org.example.Responses.Response;
import org.example.dtos.libroDto;
import org.example.entities.libro;
import org.hibernate.Session;
import org.example.connections.HibernateUtil;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class libroServices {

//    public Response getLibrosByGeneroDespues2010PuntMayorATres(String genero) {
//        try (Session session = HibernateUtil.getSession()) {
//
//            session.beginTransaction();
//            String hql = "SELECT libro FROM libro l JOIN l.valoracionList v WHERE l.genero = :genero AND l.publicacion > :year2010 AND v.puntuacion > 3";
//            Query<libro> query = session.createQuery(hql, libro.class);
//            query.setParameter("genero", genero);
//            query.setParameter("year2010", 2010);
//
//            List<libro> libros = query.getResultList();
//            session.getTransaction().commit();
//
//            return new Response("Transaccion Exitosa", true, libros.stream()
//                    .map(libro -> new libroDto(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getPublicacion()))
//                    .collect(Collectors.toList()));
//
//        } catch (Exception ex) {
//            return new Response("Error en la transacción", false, null);
//        }
//    }





    public Response getLibrosByGeneroDespues2010PuntMayorATres(String genero){
        try(Session session = HibernateUtil.getSession()){

            session.beginTransaction();
            String hql = "SELECT l FROM libro l JOIN l.valoracionList v WHERE l.genero = :genero AND l.publicacion > :year2010 AND v.puntuacion > 3";;
            Query<libro> query = session.createQuery(hql, libro.class);
            query.setParameter("genero", genero);
            //query.setParameter("year2010", 2010);

            List<libro> libros = query.getResultList();
            session.getTransaction().commit();


            return new Response("Transaccion Exitosa", true, libros.stream()
                    .map(libro -> new libroDto(libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getPublicacion()))
                    .collect(Collectors.toList()));

        }
        catch (Exception ex){
            return new Response("Error en la transacción", false, null);
        }

    }


    public Response getAll() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            String hql = "SELECT l FROM libro l";
            Query<libro> query = session.createQuery(hql, libro.class);


            List<libro> libros = query.getResultList();
            session.getTransaction().commit();

            return new Response("Transaccion Exitosa", true, libros.stream()
                    .map(libro -> new libroDto(libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getPublicacion()))
                    .collect(Collectors.toList()));

        } catch (Exception ex) {
            return new Response("Error en la transacción", false, null);
        }

//

    }


    public Response getLibrosConPuntuacionPromedioMayorIgualCuatroYMinCuatroValoracion() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            String hql = "SELECT l FROM libro l " +
                    "JOIN l.valoracionList v " +
                    "GROUP BY l.id " +
                    "HAVING AVG(v.puntuacion) >= 4 AND COUNT(v.id) >= 4";
            Query<libro> query = session.createQuery(hql, libro.class);

            List<libro> libros = query.getResultList();
            session.getTransaction().commit();

            return new Response("Transaccion Exitosa", true, libros.stream()
                    .map(libro -> new libroDto(libro.getTitulo(), libro.getAutor(), libro.getGenero(),  libro.getPublicacion()))
                    .collect(Collectors.toList()));

        } catch (Exception ex) {
            return new Response("Error en la transacción", false, null);
        }
    }


//    public Response getLibrosByAutorOAñoConPuntuacionCinco(String autor, Integer año) {
//        try (Session session = HibernateUtil.getSession()) {
//            session.beginTransaction();
//            String hql = "SELECT l FROM libro l JOIN l.valoracionList v " +
//                    "WHERE (l.autor = :autor OR l.publicacion < :año) AND v.puntuacion = 5";
//            Query<libro> query = session.createQuery(hql, libro.class);
//            query.setParameter("autor", autor);
//            query.setParameter("año", año);
//
//            List<libro> libros = query.getResultList();
//            session.getTransaction().commit();
//
//            return new Response("Transaccion Exitosa", true, libros.stream()
//                    .map(libro -> new libroDto(libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getPublicacion().getValue()))
//                    .collect(Collectors.toList()));
//        } catch (Exception ex) {
//            return new Response("Error en la transacción", false, null);
//        }
//    }

}
