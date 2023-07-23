package com.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

	@Query(value = "SELECT * FROM comments WHERE cm_productID=?1",nativeQuery = true)
	List<Comment> cmFindByProductID(Integer productID);
	
}
