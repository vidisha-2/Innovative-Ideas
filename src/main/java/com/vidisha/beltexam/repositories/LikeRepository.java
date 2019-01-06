package com.vidisha.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vidisha.beltexam.models.Like;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
	List<Like> findAll();
}
