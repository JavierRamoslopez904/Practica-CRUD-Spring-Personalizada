package com.nttdata.proyectoJRL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.proyectoJRL.persistence.NttDataTeam;
import com.nttdata.proyectoJRL.services.NttDataTeamServiceI;

@RestController
@RequestMapping("/team")
/**
 * Clase NttDataTeamController -- Controlador de la clase Team
 * 
 * @author jramlope
 *
 */
public class NttDataTeamController {

	/** Instanciación del servicio **/
	@Autowired
	private NttDataTeamServiceI teamService;

	@PostMapping("/aniadir")
	/**
	 * Añadido de equipos
	 * 
	 * @param team
	 * @return
	 */
	public String addTeam(@RequestBody NttDataTeam team) {
		teamService.addTeam(team);
		return "Equipo añadido";
	}

	@PostMapping("/delete")
	/**
	 * Eliminado de equipos
	 * 
	 * @param team
	 * @return
	 */
	public String deleteTeam(@RequestBody NttDataTeam team) {
		teamService.deleteTeam(team);
		return "Equipo eliminado";
	}

	@GetMapping("/show")
	/**
	 * Muestra de todos los equipos
	 * 
	 * @return
	 */
	public List<NttDataTeam> showTeam() {
		return teamService.showTeam();
	}

}
