package dev.java10x.CadastroDeNinjas.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity trasnforma uma Classe em uma entidade do BD
// JPA = Java Persistence API

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    // @ManyToOne muitos ninjas para a mesma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreign Key (Chave-estrangeira)
    private MissoesModel missoes;

}
