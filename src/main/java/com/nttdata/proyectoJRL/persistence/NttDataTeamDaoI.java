package com.nttdata.proyectoJRL.persistence;

import java.util.List;

/**
 * Interfaz NttDataTeamDaoI
 * 
 * @author jramlope
 *
 */
public interface NttDataTeamDaoI {

	/**
	 * Método que devuelve los años en competición de un equipo a partir del nombre
	 * del entrenador y el primer apellido del ultra
	 * 
	 * @param coachName
	 * @param firstSurname
	 * @return
	 */
	public List<NttDataTeam> getYearsInCompetitonByCoachNameAndFirstSurname(final String coachName,
			final String firstSurname);

}
