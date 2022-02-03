package com.nttdata.proyectoJRL.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Clase NttDataPlayer
 * 
 * @author jramlope
 *
 */
@Entity
@Table(name = "NTTDATA_PLAYER")
public class NttDataPlayer implements Serializable {

	/** Atributo estático serial **/
	private static final long serialVersionUID = 1L;

	/** Player numericIdentifier (PK) **/
	private int idPlayer;

	/** Player name **/
	private String name;

	/** Player firstSurname **/
	private String firstSurname;

	/** Player secondSurname **/
	private String secondSurname;

	/** Player scoredGoals **/
	private int scoredGoals;

	/** Player age **/
	private int age;

	/** Player team **/
	private NttDataTeam team;

	/**
	 * @return the idPlayer
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdPlayer() {
		return idPlayer;
	}

	/**
	 * @param idPlayer the idPlayer to set
	 */
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
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
	 * @return the scoredGoals
	 */
	@Column(name = "SCORED_GOALS")
	public int getScoredGoals() {
		return scoredGoals;
	}

	/**
	 * @param scoredGoals the scoredGoals to set
	 */
	public void setScoredGoals(int scoredGoals) {
		this.scoredGoals = scoredGoals;
	}

	/**
	 * @return the age
	 */
	@Column(name = "AGE")
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the team
	 */
	@ManyToOne
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

	@Override
	public String toString() {
		return "NttDataPlayer [idPlayer=" + idPlayer + ", name=" + name + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + ", scoredGoals=" + scoredGoals + ", age=" + age + ", team="
				+ team + "]";
	}

}
