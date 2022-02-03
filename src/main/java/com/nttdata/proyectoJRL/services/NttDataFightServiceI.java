package com.nttdata.proyectoJRL.services;

import java.util.List;

import com.nttdata.proyectoJRL.persistence.NttDataFight;

/**
 * Interfaz NttDataFightServiceI
 * 
 * @author jramlope
 *
 */
public interface NttDataFightServiceI {

	/**
	 * Añadido de peleas
	 * 
	 * @param fight
	 */
	public void addFight(NttDataFight fight);

	/**
	 * Eliminación de peleas
	 * 
	 * @param fight
	 */
	public void deleteFight(NttDataFight fight);

	/**
	 * Muestra de todas las peleas
	 * 
	 * @return
	 */
	public List<NttDataFight> showFight();

}
