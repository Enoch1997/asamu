package com.asamu.plmp.dao;



import org.springframework.data.jpa.repository.JpaRepository;



import com.asamu.plmp.pojo.entity.DeclarationRule;
import com.asamu.plmp.pojo.entity.Material;


public interface MaterialDAO extends JpaRepository<Material, Integer> {

	



}
