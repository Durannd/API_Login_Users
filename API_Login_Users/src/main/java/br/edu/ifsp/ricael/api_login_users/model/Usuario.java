package br.edu.ifsp.ricael.api_login_users.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String  password;

    @Column(name = "credits")
    private Integer credits;

    @Column(name = "eteps")
    private Integer eteps;
}
