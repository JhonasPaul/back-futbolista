package com.ortiz.jonathan.repository;


import com.ortiz.jonathan.entity.BaseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean /*para que no se intancie*/
public interface BaseRepositorio<E extends BaseId, ID >  extends JpaRepository<E, ID> {
}
