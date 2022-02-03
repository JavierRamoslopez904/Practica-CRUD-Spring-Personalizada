package com.nttdata.proyectoJRL.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Interfaz NttDataFightI
 * 
 * @author jramlope
 *
 */
public interface NttDataFightI extends JpaRepository<NttDataFight, Integer> {

}
