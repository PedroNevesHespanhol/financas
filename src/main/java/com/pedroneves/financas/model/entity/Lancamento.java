package com.pedroneves.financas.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
@Getter @Setter
@ToString
public class Lancamento {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private String descricao;

    @Column
    private Integer mes;

    @Column
    private Integer ano;

    @Column
    private BigDecimal valor;

    @Column
    private Character tipo;

    @Column
    private Character status;

    @Column(name = "data_cadastro")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDate dataCadastro;

}
