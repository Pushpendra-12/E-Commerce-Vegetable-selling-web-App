package org.vegetableApp.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetableApp.contact.model.Feedback;
import org.vegetableApp.contact.repository.FeedbackRepository;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(feedback);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback deleteFeedback(Integer feedbackId) {
		// TODO Auto-generated method stub
		return null;
	}

}
