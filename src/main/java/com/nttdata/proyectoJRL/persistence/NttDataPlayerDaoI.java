package com.nttdata.proyectoJRL.persistence;

import java.util.List;

/**
 * Interfaz NttDataPlayerDaoI
 * 
 * @author jramlope
 *
 */
public interface NttDataPlayerDaoI {

	/**
	 * Método para obtener los goles que ha metido un jugador dado su nombre y el
	 * nombre de su entrenador
	 * 
	 * @param playerName
	 * @param coachName
	 * @return
	 */
	public List<NttDataPlayer> getScoredGoalsByPlayerNameAndCoachName(final String playerName, final String coachName);

}
