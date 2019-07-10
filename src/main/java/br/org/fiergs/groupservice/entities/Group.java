package br.org.fiergs.groupservice.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "CAD_GROUP")
@SequenceGenerator(name = "seqCad_Group", sequenceName = "SEQCAD_GROUP", allocationSize = 1)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_Group")
    private Long id;

    @NotEmpty(message = "Código é obrigatório!")
    private String code;

    @NotEmpty(message = "Descrição é obrigatória!")
    private String description;

    private String parentCnpj;

    private String branch;

    private String digit;

    private String zeusCode;

    private String healthNetworkCode;

    private String rhUniversalCode;

    private boolean belongFiergsSystem;

}
