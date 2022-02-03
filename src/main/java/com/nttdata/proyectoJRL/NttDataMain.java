package com.nttdata.proyectoJRL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.proyectoJRL.persistence.NttDataFight;
import com.nttdata.proyectoJRL.persistence.NttDataPlayer;
import com.nttdata.proyectoJRL.persistence.NttDataTeam;
import com.nttdata.proyectoJRL.persistence.NttDataUltra;
import com.nttdata.proyectoJRL.services.NttDataFightServiceI;
import com.nttdata.proyectoJRL.services.NttDataPlayerServiceI;
import com.nttdata.proyectoJRL.services.NttDataTeamServiceI;
import com.nttdata.proyectoJRL.services.NttDataUltraServiceI;

@SpringBootApplication
/**
 * Clase Main
 * 
 * @author jramlope
 *
 */
public class NttDataMain implements CommandLineRunner {

	/** Instanciación del servicio de players **/
	@Autowired
	private NttDataPlayerServiceI playerService;

	/** Instanciación del servicio de teams **/
	@Autowired
	private NttDataTeamServiceI teamService;

	/** Instanciación del servicio de ultras **/
	@Autowired
	private NttDataUltraServiceI ultraService;

	/** Instanciación del servicio de fights **/
	@Autowired
	private NttDataFightServiceI fightService;

	public static void main(String[] args) {
		SpringApplication.run(NttDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<NttDataPlayer> players = new ArrayList<>();
		List<NttDataUltra> ultras = new ArrayList<>();
		List<NttDataFight> fights = new ArrayList<>();

		NttDataTeam team1 = new NttDataTeam();
		team1.setCoachName("Marcelino");
		team1.setYearsInCompetition(3);
		team1.setPlayers(players);
		team1.setUltras(ultras);

		teamService.addTeam(team1);

		NttDataTeam team2 = new NttDataTeam();
		team2.setCoachName("Lopetegui");
		team2.setYearsInCompetition(6);
		team2.setPlayers(players);
		team2.setUltras(ultras);

		teamService.addTeam(team2);

		NttDataPlayer player1 = new NttDataPlayer();
		player1.setName("Javier");
		player1.setFirstSurname("Ramos");
		player1.setSecondSurname("Lopez");
		player1.setAge(19);
		player1.setScoredGoals(6);
		player1.setTeam(team1);

		players.add(player1);

		playerService.addPlayer(player1);

		NttDataPlayer player2 = new NttDataPlayer();
		player2.setName("Alonso");
		player2.setFirstSurname("Ramos");
		player2.setSecondSurname("Lopez");
		player2.setAge(10);
		player2.setScoredGoals(98);
		player2.setTeam(team2);

		players.add(player2);

		playerService.addPlayer(player2);

		List<NttDataPlayer> playerss = playerService.getScoredGoalsByPlayerNameAndCoachName("Javier", "Marcelino");

		for (NttDataPlayer p : playerss) {
			System.out.println("Los goles encajados por el jugador son : " + p.getScoredGoals() + " goles");
		}

		NttDataPlayer player3 = new NttDataPlayer();
		player3.setName("Francisco");
		player3.setFirstSurname("Ramos");
		player3.setSecondSurname("Lopez");
		player3.setAge(50);
		player3.setScoredGoals(54);
		player3.setTeam(team2);

		players.add(player3);

		playerService.addPlayer(player3);

		NttDataUltra ultra1 = new NttDataUltra();
		ultra1.setName("Alonso");
		ultra1.setFirstSurname("Ramos");
		ultra1.setSecondSurname("López");
		ultra1.setTeam(team1);

		ultras.add(ultra1);

		ultraService.addUltra(ultra1);

		List<NttDataTeam> teamss = teamService.getYearsInCompetitionByCoachNameAndPlayerFirstSurname("Marcelino",
				"Ramos");

		for (NttDataTeam t : teamss) {
			System.out.println("Los años que ha estado en competición el equipo han sido de "
					+ t.getYearsInCompetition() + " años");
		}

		NttDataFight fight1 = new NttDataFight();
		fight1.setNumOfFighter(6);
		fight1.setPlaceOfFight("Real Arena");
		fight1.setUltra(ultras);

		fights.add(fight1);

		fightService.addFight(fight1);

		fightService.deleteFight(fight1);

	}

}