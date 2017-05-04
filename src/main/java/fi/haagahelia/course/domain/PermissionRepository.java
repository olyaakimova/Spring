// Spring PermissionRepository
package fi.haagahelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository <Permission, Long> {
	List<Permission> findByPermissionId(Long id);
}
