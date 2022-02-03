package com.nttdata.proyectoJRL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.proyectoJRL.persistence.NttDataFight;
import com.nttdata.proyectoJRL.services.NttDataFightServiceI;

@RestController
@RequestMapping("/fight")
/**
 * Clase NttDataFightController -- Controlador de la entidad Fight
 * 
 * @author jramlope
 *
 */
public class NttDataFightController {

	/** Instanciación del servicio **/
	@Autowired
	private NttDataFightServiceI fightService;

	@PostMapping("/aniadir")
	/**
	 * Añadido de peleas
	 * 
	 * @param fight
	 * @return
	 */
	public String addFight(@RequestBody NttDataFight fight) {
		fightService.addFight(fight);
		return "Pelea añadida";
	}

	@PostMapping("/delete")
	/**
	 * Eliminado de peleas
	 * 
	 * @param fight
	 * @return
	 */
	public String deleteFight(@RequestBody NttDataFight fight) {
		fightService.deleteFight(fight);
		return "Pelea eliminada";
	}

	@GetMapping("/show")
	/**
	 * Muestra de peleas
	 * 
	 * @return
	 */
	public List<NttDataFight> showFight() {
		return fightService.showFight();
	}

}
