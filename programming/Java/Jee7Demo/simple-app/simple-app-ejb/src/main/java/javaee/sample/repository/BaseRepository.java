package javaee.sample.repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

import javaee.sample.model.Tune;

/**
 * Common interface for all application repositories that provides auxiliary
 * methods.
 */
public interface BaseRepository {

	/**
	 * Mapping function that maps list of {@link Pair} objects into parameter
	 * map {@link Map}
	 */
	Function<List<Pair<String, Object>>, Map<String, Object>> ARG_MAPPER = x -> Optional.ofNullable(x)
			.orElse(Lists.newArrayList()).stream().collect(Collectors.toMap(Pair::getLeft, Pair::getRight));

	/**
	 * Retrieves list of objects of given type by supplied query and entity
	 * manager.
	 * 
	 * @param <T>
	 *            result object type
	 * 
	 * @param entityManager
	 *            entity manager that will be used to retrieve persistent
	 *            objects
	 * @param queryName
	 *            Named query name.
	 * @param resultType
	 *            result object type
	 * 
	 * @return collection of matching objects.
	 */
	default <T> List<T> listResults(EntityManager entityManager, String queryName, Class<T> resultType) {
		return listResults(entityManager, queryName, resultType, Collections.emptyList());
	}

	/**
	 * Retrieves list of objects of given type by supplied query and entity
	 * manager.
	 * 
	 * 
	 * @param <T>
	 *            result object type
	 * 
	 * @param entityManager
	 *            entity manager that will be used to retrieve persistent
	 *            objects
	 * @param queryName
	 *            Named query name.
	 * @param resultType
	 *            result object type
	 * @param queryArgs
	 *            {@link List} of query arguments used
	 * 
	 * @return collection of matching objects.
	 */
	default <T> List<T> listResults(EntityManager entityManager, String queryName, Class<T> resultType,
			List<Pair<String, Object>> queryArgs) {

		TypedQuery<T> preparedQuery = entityManager.createNamedQuery(queryName, resultType);
		ARG_MAPPER.apply(queryArgs).entrySet().forEach(x -> preparedQuery.setParameter(x.getKey(), x.getValue()));
		return preparedQuery.getResultList();
	}

	/**
	 * Retrieves list of objects of given type by supplied query and entity
	 * manager.
	 * 
	 * @param <T>
	 *            result object type
	 * 
	 * @param entityManager
	 *            entity manager that will be used to retrieve persistent
	 *            objects
	 * @param queryName
	 *            Named query name.
	 * @param resultType
	 *            result object type
	 * @param arg
	 *            single query argument
	 * 
	 * @return collection of matching objects.
	 */
	default <T> List<T> listResults(EntityManager entityManager, String queryName, Class<T> resultType,
			Pair<String, Object> arg) {
		List<Pair<String, Object>> params = Lists.newArrayList();
		params.add(arg);
		return listResults(entityManager, queryName, resultType, params);
	}

	/**
	 * Retrieves list of objects of given type by supplied query and entity
	 * manager.
	 * 
	 * @param <T>
	 *            result object type
	 * 
	 * @param entityManager
	 *            entity manager that will be used to retrieve persistent
	 *            objects
	 * @param queryName
	 *            Named query name.
	 * @param resultType
	 *            result object type
	 * @param queryArgs
	 *            query argument
	 * 
	 * @return collection of matching objects.
	 */
	default <T> T singleResult(EntityManager entityManager, String queryName, Class<T> resultType,
			Map<String, Object> queryArgs) {
		TypedQuery<T> preparedQuery = entityManager.createNamedQuery(queryName, resultType);
		Optional.ofNullable(queryArgs).orElse(Collections.emptyMap()).entrySet()
				.forEach(x -> preparedQuery.setParameter(x.getKey(), x.getValue()));
		return preparedQuery.getSingleResult();
	}

	/**
	 * Retrieves single matching object.
	 * 
	 * @param <T>
	 *            result object type
	 * 
	 * @param entityManager
	 *            entity manager that will be used to retrieve persistent
	 *            objects
	 * @param queryName
	 *            Named query name.
	 * @param resultType
	 *            result object type
	 * 
	 * @return collection of matching objects.
	 */
	default <T> T singleResult(EntityManager entityManager, String queryName, Class<T> resultType) {
		return singleResult(entityManager, queryName, resultType, Collections.emptyMap());
	}

	/**
	 * Retrieves single matching object.
	 * 
	 * @param <T>
	 *            result object type
	 * 
	 * @param entityManager
	 *            entity manager that will be used to retrieve persistent
	 *            objects
	 * @param queryName
	 *            Named query name.
	 * @param resultType
	 *            result object type
	 * @param queryArgs
	 *            query arguments
	 * 
	 * @return collection of matching objects.
	 */
	default <T> T singleResult(EntityManager entityManager, String queryName, Class<T> resultType,
			List<Pair<String, Object>> queryArgs) {
		return singleResult(entityManager, queryName, resultType, ARG_MAPPER.apply(queryArgs));
	}

	/**
	 * Retrieves single matching object.
	 * 
	 * @param <T>
	 *            result object type
	 * 
	 * @param entityManager
	 *            entity manager that will be used to retrieve persistent
	 *            objects
	 * @param queryName
	 *            Named query name.
	 * @param resultType
	 *            result object type
	 * @param queryArgs
	 *            query argument
	 * 
	 * @return collection of matching objects.
	 */
	default <T> T singleResult(EntityManager entityManager, String queryName, Class<T> resultType,
			Pair<String, Object> queryArgs) {
		List<Pair<String, Object>> params = Lists.newArrayList();
		params.add(queryArgs);
		return singleResult(entityManager, queryName, resultType, params);
	}

	/**
	 * Safely removed entity object from database, additionall performs session
	 * merging if required.
	 * 
	 * @param entityManager
	 *            entity manager instance used to delete object
	 * 
	 * @param obj
	 *            persistent object being removed.
	 */
	default void remove(EntityManager entityManager, Object obj) {
		entityManager.remove(entityManager.contains(obj) ? obj : entityManager.merge(obj));
	}

	/**
	 * Stores persistent object using supplied {@link EntityManager} instance.
	 * 
	 * @param entityManager
	 *            entity manger used to store object.
	 * @param obj
	 *            object to be stored
	 */
	default void store(EntityManager entityManager, Object obj) {
		// XXX: upsert operation may be implemented here
		entityManager.persist(obj);
	}

	/**
	 * Returns persistent object by primary key.
	 * 
	 * @param <T> tupe of entity
	 * 
	 * @param entityManager
	 * @param objId
	 *            object primary key
	 * @param resultType
	 *            result type
	 * @return existing object
	 */
	default <T> T get(EntityManager entityManager, Long objId, Class<T> resultType) {
		return entityManager.find(resultType, objId);
	}

}
