package org.example.entities;

import jakarta.persistence.*;
import org.example.dtos.libroDto;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "libros")
public class libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private int id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "genero")
    private String genero;

    @Column(name = "publicacion")
    private int publicacion;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<valoracion> valoracionList;



    public libro(libroDto libroDto) {
        this.titulo = libroDto.getTitulo();
        this.autor = libroDto.getAutor();
        this.genero = libroDto.getGenero();
        this.publicacion = libroDto.getPublicacion();
    }

    public libro() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public List<valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }
}
