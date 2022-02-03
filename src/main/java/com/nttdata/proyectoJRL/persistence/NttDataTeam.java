package com.nttdata.proyectoJRL.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * Clase NttDataTeam
 * 
 * @author jramlope
 *
 */
@Entity
@Table(name = "NTTDATA_TEAM")
public class NttDataTeam implements Serializable {

	/** Atributo estático serial **/
	private static final long serialVersionUID = 1L;

	/** Team numericIdentifier (PK) **/
	private int idTeam;

	/** Team coachName **/
	private String coachName;

	/** Team yearsInCompetition **/
	private int yearsInCompetition;

	/** Team players **/
	@JsonBackReference
	private List<NttDataPlayer> players;

	/** Team ultras **/
	@JsonBackReference
	private List<NttDataUltra> ultras;

	/**
	 * @return the idTeam
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdTeam() {
		return idTeam;
	}

	/**
	 * @param idTeam the idTeam to set
	 */
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	/**
	 * @return the coachName
	 */
	@Column(name = "COACH_NAME")
	public String getCoachName() {
		return coachName;
	}

	/**
	 * @param coachName the coachName to set
	 */
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	/**
	 * @return the yearsInCompetition
	 */
	@Column(name = "YEARS_IN_COMPETITION")
	public int getYearsInCompetition() {
		return yearsInCompetition;
	}

	/**
	 * @param yearsInCompetition the yearsInCompetition to set
	 */
	public void setYearsInCompetition(int yearsInCompetition) {
		this.yearsInCompetition = yearsInCompetition;
	}

	/**
	 * @return the players
	 */
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "team")
	public List<NttDataPlayer> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<NttDataPlayer> players) {
		this.players = players;
	}

	/**
	 * @return the ultras
	 */
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "team")
	@Fetch(value = FetchMode.SUBSELECT)
	public List<NttDataUltra> getUltras() {
		return ultras;
	}

	/**
	 * @param ultras the ultras to set
	 */
	public void setUltras(List<NttDataUltra> ultras) {
		this.ultras = ultras;
	}

	@Override
	public String toString() {
		return "" + idTeam + "";
	}

}
