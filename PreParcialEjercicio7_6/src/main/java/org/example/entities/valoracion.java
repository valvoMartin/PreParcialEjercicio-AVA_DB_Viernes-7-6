package org.example.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "valoraciones")
public class valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "valoracion_id")
    private int id;

    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "fecha_valoracion", nullable = false)
    private LocalDate fechaValoracion;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private libro libro;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(LocalDate fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public org.example.entities.libro getLibro() {
        return libro;
    }

    public void setLibro(org.example.entities.libro libro) {
        this.libro = libro;
    }
}
