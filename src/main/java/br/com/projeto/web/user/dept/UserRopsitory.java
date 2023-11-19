package br.com.projeto.web.user.dept;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projeto.web.user.dept.entities.Users;

public interface UserRopsitory extends JpaRepository<Users, Long> {

}
