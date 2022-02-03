package com.nttdata.proyectoJRL.services;

import java.util.List;

import com.nttdata.proyectoJRL.persistence.NttDataPlayer;

/**
 * 
 * Interfaz NttDataPlayerServiceI
 * 
 * @author jramlope
 *
 */
public interface NttDataPlayerServiceI {

	/**
	 * Añadido de jugadores
	 * 
	 * @param player
	 */
	public NttDataPlayer addPlayer(final NttDataPlayer player);

	/**
	 * Eliminado de jugadores
	 * 
	 * @param player
	 */
	public void deletePlayer(final NttDataPlayer player);

	/**
	 * Muestra de todos los jugadores
	 * 
	 * @return
	 */
	public List<NttDataPlayer> showPlayer();

	/**
	 * Muestra de los goles encajados dados el nombre del jugador y el nombre de su
	 * entrenador
	 * 
	 * @param playerName
	 * @param coachName
	 * @return
	 */
	public List<NttDataPlayer> getScoredGoalsByPlayerNameAndCoachName(String playerName, String coachName);

}
