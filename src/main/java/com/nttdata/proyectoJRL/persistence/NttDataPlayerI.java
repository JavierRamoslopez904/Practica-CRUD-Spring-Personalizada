package com.nttdata.proyectoJRL.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * Interfaz NttDataPlayerI
 * 
 * @author jramlope
 *
 */
@Repository
public interface NttDataPlayerI extends JpaRepository<NttDataPlayer, Integer> {

}
