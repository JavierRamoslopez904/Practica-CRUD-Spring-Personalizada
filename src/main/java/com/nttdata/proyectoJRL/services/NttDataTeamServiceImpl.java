package com.nttdata.proyectoJRL.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.proyectoJRL.persistence.NttDataPlayer;
import com.nttdata.proyectoJRL.persistence.NttDataPlayerI;
import com.nttdata.proyectoJRL.persistence.NttDataTeam;
import com.nttdata.proyectoJRL.persistence.NttDataTeamDaoI;
import com.nttdata.proyectoJRL.persistence.NttDataTeamDaoImpl;
import com.nttdata.proyectoJRL.persistence.NttDataTeamI;
import com.nttdata.proyectoJRL.persistence.NttDataUltra;
import com.nttdata.proyectoJRL.persistence.NttDataUltraI;

@Service
/**
 * Clase NttDataTeamServiceImpl
 * 
 * @author jramlope
 *
 */
public class NttDataTeamServiceImpl implements NttDataTeamServiceI {
	/** Creación de un objeto LOGGER para trabajar con las trazas **/
	final static Logger LOGGER = LoggerFactory.getLogger(NttDataTeamServiceImpl.class);

	@Autowired
	/** Instanciación de la interfaz NttDataTeamI **/
	private NttDataTeamI teams;

	@Autowired
	/** Instanciación de la interfaz NttDataPlayerI **/
	private NttDataPlayerI players;

	@Autowired
	/** Instanciación de la interfaz NttDataUltraI **/
	private NttDataUltraI ultras;

	/** Creación de un objeto de la clase EntityManager **/
	private EntityManager em;

	/** Creación de un objeto de la interfaz NttDataPlayerDaoI **/
	private NttDataTeamDaoI teamDao;

	/**
	 * Método constructor
	 * 
	 * @param em
	 */
	public NttDataTeamServiceImpl(final EntityManager em) {
		this.teamDao = new NttDataTeamDaoImpl(em);
	}

	@Override
	public void addTeam(NttDataTeam team) {
		LOGGER.info("--- Añadir equipo ---");
		teams.save(team);
	}

	@Override
	public void deleteTeam(NttDataTeam team) {
		LOGGER.info("--- Eliminar equipo ---");
		List<NttDataPlayer> teamList = team.getPlayers();
		List<NttDataUltra> ultraList = team.getUltras();

		for (NttDataPlayer player : teamList) {
			player.setTeam(null);

			players.save(player);

		}

		for (NttDataUltra ultra : ultraList) {
			ultra.setTeam(null);

			ultras.save(ultra);

		}
		teams.delete(team);
	}

	@Override
	public List<NttDataTeam> showTeam() {
		LOGGER.info("--- Muestra de todos los equipos ---");
		return teams.findAll();
	}

	@Override
	public List<NttDataTeam> getYearsInCompetitionByCoachNameAndPlayerFirstSurname(String coachName,
			String firstSurname) {
		LOGGER.info(
				"--- Muestra de los años en competición a través del nombre del entrenador y el primer apellido del jugador --- ");
		List<NttDataTeam> playerList = new ArrayList<NttDataTeam>();

		playerList = teamDao.getYearsInCompetitonByCoachNameAndFirstSurname("Marcelino", "Ramos");

		return playerList;

	}

}
