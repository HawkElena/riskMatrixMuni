package riskMatrixMuni.restapi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import riskMatrixMuni.restapi.Models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	public Optional<Usuarios> findByEmail(String email);
	public Optional<Usuarios> findByUsernameOrEmail(String username, String email);
	public Optional<Usuarios> findByUsername(String username);
	public Boolean existsByUsername(String username);
	public Boolean existsByEmail(String email);

	
}
