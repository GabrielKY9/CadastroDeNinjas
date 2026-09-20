package dev.java10x.CadastroDeNinjas.Carros;

import dev.java10x.CadastroDeNinjas.Controller.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_carros")

public class CarrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String dificuladadeDirigir;
    private NinjaModel ninja;


}
