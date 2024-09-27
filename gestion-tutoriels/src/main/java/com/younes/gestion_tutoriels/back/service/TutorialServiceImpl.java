package com.younes.gestion_tutoriels.back.service;

import com.younes.gestion_tutoriels.back.model.Tutorial;
import com.younes.gestion_tutoriels.back.repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService
{

    private final TutorialRepository tutorialRepository;

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public List<Tutorial> searchByPublished(boolean published) {
        return tutorialRepository.findByPublished(published);
    }

    @Override
    public List<Tutorial> searchByTitleContainingIgnoreCase(String title) {
        return tutorialRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Tutorial> getAllTutorials(String title) {
        List<Tutorial> tutorials = new ArrayList<Tutorial>();

        if (title == null)
            tutorialRepository.findAll().forEach(tutorials::add);
        else
            tutorialRepository.findByTitleContainingIgnoreCase(title).forEach(tutorials::add);
        return tutorials;
    }

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        Tutorial _tutorial = tutorialRepository
                .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
        return _tutorial;
    }

    @Override
    public Tutorial updateTutorial(long id,Tutorial tutorial) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            Tutorial tutoriale = tutorialData.get();
            tutoriale.setTitle(tutoriale.getTitle());
            tutoriale.setDescription(tutoriale.getDescription());
            tutoriale.setPublished(tutoriale.getPublished());
        }
        return tutorialRepository.save(tutorial);
    }

    @Override
    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }


}
