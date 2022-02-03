package com.nttdata.proyectoJRL.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Clase NttDataPlayerDaoImpl
 * 
 * @author jramlope
 *
 */
public class NttDataPlayerDaoImpl implements NttDataPlayerDaoI {

	/** Creación de un objeto de la clase EntityManager **/
	private EntityManager em;

	/**
	 * Método constructor
	 * 
	 * @param em
	 */
	public NttDataPlayerDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<NttDataPlayer> getScoredGoalsByPlayerNameAndCoachName(String playerName, String coachName) {

		// Consulta Criteria
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<NttDataPlayer> cquery = cb.createQuery(NttDataPlayer.class);
		final Root<NttDataPlayer> rootP = cquery.from(NttDataPlayer.class);
		final Join<NttDataPlayer, NttDataTeam> pJoinT = rootP.join("team");

		// Claúsula where
		final Predicate pr1 = cb.like(pJoinT.getParent().<String>get("name"), playerName);
		final Predicate pr2 = cb.like(pJoinT.<String>get("coachName"), coachName);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1, pr2));

		final List<NttDataPlayer> results = em.createQuery(cquery).getResultList();

		return results;
	}

}
