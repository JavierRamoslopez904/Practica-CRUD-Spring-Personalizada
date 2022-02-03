package com.nttdata.proyectoJRL.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.proyectoJRL.persistence.NttDataPlayer;
import com.nttdata.proyectoJRL.persistence.NttDataPlayerDaoI;
import com.nttdata.proyectoJRL.persistence.NttDataPlayerDaoImpl;
import com.nttdata.proyectoJRL.persistence.NttDataPlayerI;

@Service
/**
 * Clase NttDataPlayerServiceImpl
 * 
 * @author jramlope
 *
 */
public class NttDataPlayerServiceImpl implements NttDataPlayerServiceI {

	/** Creación de un objeto LOGGER para trabajar con las trazas **/
	final static Logger LOGGER = LoggerFactory.getLogger(NttDataPlayerServiceImpl.class);

	@Autowired
	/** Instanciación de la interfaz NttDataPlayerI **/
	private NttDataPlayerI players;

	/** Creación de un objeto de la clase EntityManager **/
	private EntityManager em;

	/** Creación de un objeto de la interfaz NttDataPlayerDaoI **/
	private NttDataPlayerDaoI playerDao;

	/**
	 * Método constructor
	 * 
	 * @param em
	 */
	public NttDataPlayerServiceImpl(final EntityManager em) {
		this.playerDao = new NttDataPlayerDaoImpl(em);
	}

	@Override
	public NttDataPlayer addPlayer(NttDataPlayer player) {
		LOGGER.info("--- Añadir pelea ---");
		return players.save(player);

	}

	@Override
	public void deletePlayer(NttDataPlayer player) {
		LOGGER.info("--- Eliminar pelea ---");
		players.delete(player);

	}

	@Override
	public List<NttDataPlayer> showPlayer() {
		LOGGER.info("--- Muestra de los jugadores ---");
		return players.findAll();
	}

	@Override
	public List<NttDataPlayer> getScoredGoalsByPlayerNameAndCoachName(String playerName, String coachName) {
		LOGGER.info("--- Muestra de los goles a través del nombre del jugador y del nombre del entrenador ---");
		List<NttDataPlayer> playerList = new ArrayList<NttDataPlayer>();

		playerList = playerDao.getScoredGoalsByPlayerNameAndCoachName(playerName, coachName);

		return playerList;

	}

}
