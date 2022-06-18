package riskMatrixMuni.restapi.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import riskMatrixMuni.restapi.Models.CompositeKeyFirst;
import riskMatrixMuni.restapi.Models.Cat1Position;

public interface Cat1PositionRepository extends JpaRepository<Cat1Position, CompositeKeyFirst> {

	public Optional<Cat1Position> findByName(String name);
	
	public List<Cat1Position> findByNameContaining(String name);
	public List<Cat1Position> findByNameIsContaining(String name);
	public List<Cat1Position> findByNameLike(String name);
	
	
	@Query(value= "SELECT 	position_muni_id, position_id, position_name "
			+ "		FROM 	tbl_cat1_positions  "
			+ "		WHERE  	position_muni_id = :muni_id"
			+ "		AND 	position_name like :name ",nativeQuery = true)
    List<Cat1Position> buscarxnombre(@Param("name") String name, long muni_id);
}
