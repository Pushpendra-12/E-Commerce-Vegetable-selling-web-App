package org.vegetableApp.contact.FeedbackController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vegetableApp.contact.model.Feedback;
import org.vegetableApp.contact.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/addfeedback")
	public String addFeedback(Model model) {
		Feedback feedback = new Feedback();
		model.addAttribute("feedback",feedback);
		return "feedback/addfeedback";
	}
	
	@PostMapping("/addfeedbackprocess")
	public String addFeedbackProcess(@ModelAttribute("feedback") Feedback feedback) {
		Feedback feed = feedbackService.addFeedback(feedback);
		if(feed == null ) {
			return "feedback/feedbackaddunsuccess";
		}else {
			return "feedback/feedbackaddsuccess";
		}
	}

}
