package com.nttdata.proyectoJRL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.proyectoJRL.persistence.NttDataPlayer;
import com.nttdata.proyectoJRL.services.NttDataPlayerServiceI;

@Controller
@RequestMapping("/player/")
/**
 * Clase NttDataPlayerController -- Controlador de la clase Player
 * 
 * @author jramlope
 *
 */
public class NttDataPlayerController {

	/** Instanciación del servicio **/
	@Autowired
	private NttDataPlayerServiceI servicePlayer;

	@GetMapping("/addNewPlayer")
	/**
	 * Método que lleva al fichero html addNewPlayer.html
	 * 
	 * @return
	 */
	public String newPlayerForm() {
		return "addNewPlayer";
	}

	@PostMapping("/aniadir")
	/**
	 * Método de añadido de jugadores
	 * 
	 * @param player
	 * @return
	 */
	public String addPlayer(@ModelAttribute("newPlayer") NttDataPlayer player, Model model) {

		model.addAttribute("newPlayer", player);

		servicePlayer.addPlayer(player);

		return "/showPlayer";

	}

	@PostMapping("/delete")
	/**
	 * Método de eliminación de jugadores
	 * 
	 * @param player
	 * @return
	 */
	public String deletePlayer(@ModelAttribute("newPlayer") NttDataPlayer player, Model model) {

		servicePlayer.deletePlayer(player);

		return "redirect:./show";
	}

	@GetMapping("/show")
	/**
	 * Método que lista los clientes
	 * 
	 * @return
	 */
	public String listPlayer(Model model) {

		List<NttDataPlayer> players = servicePlayer.showPlayer();

		model.addAttribute("player", players);

		return "listOfPlayers";
	}
}
