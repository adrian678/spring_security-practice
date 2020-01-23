package ca.mcgill.quora.demo.data;

import ca.mcgill.quora.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.openmbean.OpenType;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public OpenType<Role> findRoleByRid(int id);


}
