package com.nttdata.proyectoJRL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.proyectoJRL.persistence.NttDataUltra;
import com.nttdata.proyectoJRL.services.NttDataUltraServiceI;

@RestController
@RequestMapping("/ultra")
/**
 * Clase NttDataUltraController -- Controlador de la clase Ultra
 * 
 * @author jramlope
 *
 */
public class NttDataUltraController {

	/** Instanciación del servicio **/
	@Autowired
	private NttDataUltraServiceI ultraService;

	@PostMapping("/aniadir")
	/**
	 * Añadido de ultra
	 * 
	 * @param ultra
	 * @return
	 */
	public String addUltra(@RequestBody NttDataUltra ultra) {
		ultraService.addUltra(ultra);
		return "Ultra añadido";
	}

	@PostMapping("/delete")
	/**
	 * Eliminado de ultra
	 * 
	 * @param ultra
	 * @return
	 */
	public String deleteUltra(@RequestBody NttDataUltra ultra) {
		ultraService.deleteUltra(ultra);
		return "Ultra eliminado";
	}

	@GetMapping("/show")
	/**
	 * Muestra de todos los ultras
	 * 
	 * @return
	 */
	public List<NttDataUltra> showUltra() {
		return ultraService.showUltra();
	}

}
