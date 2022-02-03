package com.nttdata.proyectoJRL.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * Clase NttDataUltra
 * 
 * @author jramlope
 *
 */
@Entity
@Table(name = "NTTDATA_ULTRA")
public class NttDataUltra implements Serializable {

	/** Atributo estático serial **/
	private static final long serialVersionUID = 1L;

	/** Ultra numericIdentifier **/
	private int idUltra;

	/** Ultra name **/
	private String name;

	/** Ultra firstSurname **/
	private String firstSurname;

	/** Ultra secondSurname **/
	private String secondSurname;

	/** Ultra team **/
	@JsonManagedReference
	private NttDataTeam team;

	/** Ultra figth **/
	@JsonBackReference
	private List<NttDataFight> fight;

	/**
	 * @return the idUltra
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdUltra() {
		return idUltra;
	}

	/**
	 * @param idUltra the idUltra to set
	 */
	public void setIdUltra(int idUltra) {
		this.idUltra = idUltra;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstSurname
	 */
	@Column(name = "FIRST_SURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * @param firstSurname the firstSurname to set
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * @return the secondSurname
	 */
	@Column(name = "SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param secondSurname the secondSurname to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return the team
	 */
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_TEAM_FK")
	public NttDataTeam getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(NttDataTeam team) {
		this.team = team;
	}

	/**
	 * @return the fight
	 */
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "TABLE_ULTRA_FIGHT", joinColumns = { @JoinColumn(name = "ID_ULTRA") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_FIGHT") })
	public List<NttDataFight> getFight() {
		return fight;
	}

	/**
	 * @param fight the fight to set
	 */
	public void setFight(List<NttDataFight> fight) {
		this.fight = fight;
	}

}
