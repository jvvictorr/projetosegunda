package br.com.joaovictor.medicalconsult.consulta.domain;

import br.com.joaovictor.medicalconsult.usuario.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "CONSULTAS")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Long idconsulta;
@JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "DATA_CONSULTA")
    private Date dataConsulta;

    @Column(name = "PROFISSIONAL")
    private String profissional;

    @Column(name = "ESPECIALIDADE")
    private String especialidade;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Consulta(long idConsulta, Date dataConsulta, String especialidade, String profissional, Usuario usuario) {
        this.idconsulta = idConsulta;
        this.dataConsulta = dataConsulta;
        this.especialidade = especialidade;
        this.profissional = profissional;
        this.usuario = usuario;
    }
    public Consulta(){}
}
    



