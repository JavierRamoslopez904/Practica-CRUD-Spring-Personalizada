package com.nttdata.proyectoJRL.services;

import java.util.List;

import com.nttdata.proyectoJRL.persistence.NttDataUltra;

/**
 * Interfaz NttDataUltraServiceI
 * 
 * @author jramlope
 *
 */
public interface NttDataUltraServiceI {

	/**
	 * Añadido de ultra
	 * 
	 * @param ultra
	 */
	public void addUltra(final NttDataUltra ultra);

	/**
	 * Eliminación de ultra
	 * 
	 * @param ultra
	 */
	public void deleteUltra(final NttDataUltra ultra);

	/**
	 * Listado de ultra
	 * 
	 * @return
	 */
	public List<NttDataUltra> showUltra();

}
