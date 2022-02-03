package com.nttdata.proyectoJRL.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * Clase NttDataFight
 * 
 * @author jramlope
 *
 */
@Entity
@Table(name = "NTTDATA_FIGHT")
public class NttDataFight implements Serializable {

	/** Atributo estático Serial **/
	private static final long serialVersionUID = 1L;

	/** Fight idFight **/
	private int idFight;

	/** Fight placeOfFight **/
	private String placeOfFight;

	/** Fight numOfFighter **/
	private int numOfFighter;

	/** Fight ultra **/
	@JsonBackReference
	private List<NttDataUltra> ultra;

	/**
	 * @return the idFight
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdFight() {
		return idFight;
	}

	/**
	 * @param idFight the idFight to set
	 */
	public void setIdFight(int idFight) {
		this.idFight = idFight;
	}

	/**
	 * @return the placeOfFight
	 */
	@Column(name = "PLACE_OF_FIGHT")
	public String getPlaceOfFight() {
		return placeOfFight;
	}

	/**
	 * @param placeOfFight the placeOfFight to set
	 */
	public void setPlaceOfFight(String placeOfFight) {
		this.placeOfFight = placeOfFight;
	}

	/**
	 * @return the numOfFighter
	 */
	@Column(name = "NUM_OF_FIGHTER")
	public int getNumOfFighter() {
		return numOfFighter;
	}

	/**
	 * @param numOfFighter the numOfFighter to set
	 */
	public void setNumOfFighter(int numOfFighter) {
		this.numOfFighter = numOfFighter;
	}

	/**
	 * @return the ultra
	 */
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "fight")
	public List<NttDataUltra> getUltra() {
		return ultra;
	}

	/**
	 * @param ultra the ultra to set
	 */
	public void setUltra(List<NttDataUltra> ultra) {
		this.ultra = ultra;
	}

}
