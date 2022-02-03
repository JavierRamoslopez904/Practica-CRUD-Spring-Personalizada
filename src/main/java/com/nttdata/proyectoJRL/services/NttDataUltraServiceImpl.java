package com.nttdata.proyectoJRL.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.proyectoJRL.persistence.NttDataUltra;
import com.nttdata.proyectoJRL.persistence.NttDataUltraI;

@Service
/**
 * Clase NttDataUltraServiceImpl
 * 
 * @author jramlope
 *
 */
public class NttDataUltraServiceImpl implements NttDataUltraServiceI {

	/** Creación de un objeto LOGGER para trabajar con las trazas **/
	final static Logger LOGGER = LoggerFactory.getLogger(NttDataUltraServiceImpl.class);

	@Autowired
	/** Instanciación de la interfaz NttDataUltraI **/
	private NttDataUltraI ultras;

	@Override
	public void addUltra(NttDataUltra ultra) {
		LOGGER.info("-- Añadir ultra --");
		ultras.save(ultra);
	}

	@Override
	public void deleteUltra(NttDataUltra ultra) {
		LOGGER.info("-- Eliminar ultra --");
		ultras.delete(ultra);
	}

	@Override
	public List<NttDataUltra> showUltra() {
		LOGGER.info("-- Muestra de todos los ultras --");
		return ultras.findAll();
	}

}
