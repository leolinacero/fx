package org.example.examenfx;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data

public class Usuario {

    private String correo;
    private String plataforma;
    private String version;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean Admin;

    public Usuario(String correo, String plataforma, String version, LocalDate fecha, LocalTime hora, boolean admin) {
        this.correo = correo;
        this.plataforma = plataforma;
        this.version = version;
        this.fecha = fecha;
        this.hora = hora;
        this.Admin = admin;
    }

    public Usuario(){};




}
