package com.vidisha.beltexam.services;

import org.springframework.stereotype.Service;

import com.vidisha.beltexam.repositories.LikeRepository;

@Service
public class LikeService {
	private final LikeRepository likerepo;
	
	public LikeService(LikeRepository likerepo) {
		this.likerepo = likerepo;
	}
	

}
