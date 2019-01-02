package com.asamu.plmp.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.asamu.plmp.pojo.entity.DeclarationRule;


public interface DeclarationDAO extends JpaRepository<DeclarationRule, Integer> {

	List<DeclarationRule> findByType(Integer type);

	/*@Modifying
	@Query("update DeclarationRule as c set c.deadline = :deadline where c.id = :id")
	void update(Integer id, Date deadline);*/

	
	/*@Modifying
	@Query("update t_declaration_rule as c set c.rule_content = :ruleContent where c.id = :id")
	void updateRuleContentById(Integer id, String ruleContent);*/



}
