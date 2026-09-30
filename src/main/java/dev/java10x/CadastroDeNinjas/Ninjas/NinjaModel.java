package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

//Entity trasnforma uma Classe em uma entidade do BD
// JPA = Java Persistence API

@Entity
@Table(name = "tb_cadastro")
@Data
/*
* @Data = @Getter @Setter @EqualsAndHashCode @ToString
* */
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "imgURL")
    private String imgURL;

    @Column(name = "idade")
    private int idade;

    // @ManyToOne muitos ninjas para a mesma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreign Key (Chave-estrangeira)
    private MissoesModel missoes;

}
