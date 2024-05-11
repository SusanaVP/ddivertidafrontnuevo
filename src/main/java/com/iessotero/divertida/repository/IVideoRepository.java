package com.iessotero.divertida.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iessotero.divertida.model.Videos;

@Repository
public interface IVideoRepository extends JpaRepository<Videos, Long> {

	@Query("SELECT v FROM Videos v WHERE v.recommended = true")
	List<Videos> recommendedVideos();

	@Query("SELECT v FROM Videos v WHERE v.categoriesVideo.nameCategory  like %:category%")
	List<Videos> findVideosByCategory(@Param("category") String category);

}