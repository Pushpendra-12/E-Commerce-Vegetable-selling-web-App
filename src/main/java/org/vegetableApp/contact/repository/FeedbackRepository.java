package org.vegetableApp.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegetableApp.contact.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}
