package com.nttdata.proyectoJRL.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Clase NttDataUltraI
 * 
 * @author jramlope
 *
 */
public interface NttDataUltraI extends JpaRepository<NttDataUltra, Integer> {

}
