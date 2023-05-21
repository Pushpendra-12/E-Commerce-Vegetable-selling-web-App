package org.vegetableApp.contact.service;

import org.vegetableApp.contact.model.Feedback;

public interface FeedbackService {
	public Feedback addFeedback(Feedback feedback);
	public Feedback updateFeedback(Feedback feedback);
	public Feedback deleteFeedback(Integer feedbackId);

}
