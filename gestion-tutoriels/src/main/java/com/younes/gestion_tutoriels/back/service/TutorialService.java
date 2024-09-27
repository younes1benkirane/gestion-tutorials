package com.younes.gestion_tutoriels.back.service;

import com.younes.gestion_tutoriels.back.model.Tutorial;

import java.util.List;

public interface TutorialService {

    List<Tutorial> searchByPublished(boolean published);

    List<Tutorial> searchByTitleContainingIgnoreCase(String title);

    List<Tutorial> getAllTutorials ( String title);

    Tutorial createTutorial(Tutorial tutorial);

    Tutorial updateTutorial(long id,Tutorial tutorial);

    void deleteTutorial(long id);

    void deleteAllTutorials();

}
