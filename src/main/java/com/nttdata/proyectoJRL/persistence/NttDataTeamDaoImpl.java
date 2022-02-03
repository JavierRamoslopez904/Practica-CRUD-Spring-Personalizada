package com.nttdata.proyectoJRL.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Clase NttDataTeamDaoImpl
 * 
 * @author jramlope
 *
 */
public class NttDataTeamDaoImpl implements NttDataTeamDaoI {

	/** Creación de un objeto de la clase EntityManager **/
	private EntityManager em;

	/**
	 * Método constructor
	 * 
	 * @param em
	 */
	public NttDataTeamDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<NttDataTeam> getYearsInCompetitonByCoachNameAndFirstSurname(String coachName, String firstSurname) {

		// Consulta Criteria
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<NttDataTeam> cquery = cb.createQuery(NttDataTeam.class);
		final Root<NttDataTeam> rootP = cquery.from(NttDataTeam.class);
		final Join<NttDataTeam, NttDataUltra> pJoinT = rootP.join("ultras");

		// Claúsula where
		final Predicate pr1 = cb.like(pJoinT.getParent().<String>get("coachName"), coachName);
		final Predicate pr2 = cb.like(pJoinT.<String>get("firstSurname"), firstSurname);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1, pr2));

		final List<NttDataTeam> results = em.createQuery(cquery).getResultList();

		return results;

	}

}
