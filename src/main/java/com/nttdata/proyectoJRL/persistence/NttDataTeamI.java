package com.nttdata.proyectoJRL.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * Interfaz NttDataTeamI
 * 
 * @author jramlope
 *
 */
@Repository
public interface NttDataTeamI extends JpaRepository<NttDataTeam, Integer> {

}
