package org.example.dtos;

import org.example.entities.libro;

import java.time.Year;

public class libroDto {
    private String titulo;
    private String autor;
    private String genero;
    private int publicacion;


    public libroDto(String titulo, String autor, String genero, int publicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publicacion = publicacion;
    }





    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }
}
