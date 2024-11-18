package br.com.joaovictor.medicalconsult.consulta.repositores;

import br.com.joaovictor.medicalconsult.consulta.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
