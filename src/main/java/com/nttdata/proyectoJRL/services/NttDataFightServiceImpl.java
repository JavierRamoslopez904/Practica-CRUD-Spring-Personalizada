package com.nttdata.proyectoJRL.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.proyectoJRL.persistence.NttDataFight;
import com.nttdata.proyectoJRL.persistence.NttDataFightI;

@Service
/**
 * Clase NttDataFightServiceImpl
 * 
 * @author jramlope
 *
 */
public class NttDataFightServiceImpl implements NttDataFightServiceI {

	/** Creación de un objeto LOGGER para trabajar con las trazas **/
	final static Logger LOGGER = LoggerFactory.getLogger(NttDataFightServiceImpl.class);

	@Autowired
	/** Instanciación de la interfaz NttDataFightI **/
	private NttDataFightI fights;

	@Override
	public void addFight(NttDataFight fight) {
		LOGGER.info("--- Añadir pelea ---");
		fights.save(fight);
	}

	@Override
	public void deleteFight(NttDataFight fight) {
		LOGGER.info("--- Eliminar pelea ---");
		fights.delete(fight);
	}

	@Override
	public List<NttDataFight> showFight() {
		LOGGER.info("--- Muestra de las peleas ---");
		return fights.findAll();
	}

}
