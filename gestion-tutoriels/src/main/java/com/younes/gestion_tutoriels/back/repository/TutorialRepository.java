package com.younes.gestion_tutoriels.back.repository;

import com.younes.gestion_tutoriels.back.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContainingIgnoreCase(String title);

}
