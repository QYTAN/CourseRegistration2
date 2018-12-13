package sa47.team11.caps.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sa47.team11.caps.model.Course;
import sa47.team11.caps.model.StudentEnrolment;
import sa47.team11.caps.service.LecturerService;

@Controller
@RequestMapping(value = "/lecturer")

public class LecturerController {
	@Autowired
	private LecturerService lservice;
	
/*	@RequestMapping(value="/lecturer", method = RequestMethod.GET)
	public ModelAndView lecturer() {
		//model.addAttribute("user", new User());
		return new ModelAndView("lecturer");
	}*/
	
	@RequestMapping(value="/viewstudent/{uid}", method = RequestMethod.GET)
	public ModelAndView viewStudentById(@PathVariable int uid, Model model) {
		ModelAndView mav = new ModelAndView("viewstudentbyid");
		ArrayList<StudentEnrolment> courses = lservice.FindCourseidCoursenameCreditById(uid);
		/*ArrayList<StudentEnrolment> scores = lservice.FindScoreById(uid);*/
		model.addAttribute("courses",courses);
		/*model.addAttribute("scores", scores);*/
		return mav;
	}
	
/*	@RequestMapping(value="/lecturer/viewstudent/edit/{uid}", method = RequestMethod.GET)
	public ModelAndView editScores() {
		//model.addAttribute("user", new User());
		return new ModelAndView("editscore");
	}*/
/*	public ModelAndView editScores(@PathVariable int uid) {
		ModelAndView mav = new ModelAndView("editscore");
		lservice.updateUser(user);
		ArrayList<Course> courses = lservice.FindCourseidCoursenameCreditById(uid);
		ArrayList<StudentEnrolment> scores = lservice.FindScoreById(uid);
		model.addAttribute("courses",courses);
		model.addAttribute("scores", scores);
		ModelAndView mav 
		return mav;
	}*/

	
	
/*	@RequestMapping(value="/lecturer/viewstudent", method = RequestMethod.GET)
	public ModelAndView viewstudent() {
		ModelAndView mav = new  ModelAndView("lecturer/viewstudent", "user", new User());
		return mav;
	}*/
	
	/*courseTaught*/
	@RequestMapping(value = "/coursetaught/{uid}", method = RequestMethod.GET)
	public ModelAndView listCoursesTaught(@PathVariable Integer uid) {
		ModelAndView mav = new ModelAndView("CourseTaught");
		ArrayList<Course> courses = lservice.findCourseByAssignedLecturerID(uid);
		mav.addObject("courses", courses);
		return mav;
	}
	
    //view course enrollment
	@RequestMapping(value = "/{cid}", method = RequestMethod.GET)
	public ModelAndView listEnrollments(@PathVariable Integer cid,Model model) {
		ModelAndView mav = new ModelAndView("CourseEnrollment");
		Course course=lservice.findCourseById(cid);
		model.addAttribute("studentEnrollments",course.getStudentEnrolments());
		mav.addObject(model);
		return mav;
	}
	//grade list
		@RequestMapping(value = "/gradelist/{courseId}", method = RequestMethod.GET)
		public ModelAndView listGrade(@PathVariable Integer courseId,Model model) {
			ModelAndView mav = new ModelAndView("GradeList");
			Course course=lservice.findCourseById(courseId);
			model.addAttribute("studentEnrollments",course.getStudentEnrolments());
			model.addAttribute("courseid",courseId);
			mav.addObject(model);
			return mav;
		}
		@RequestMapping(value = "/create/{seid}",method = RequestMethod.GET)
		public ModelAndView gradeStudentPage(@PathVariable Integer seid,Model model) {
			ModelAndView mav = new ModelAndView("GradeAStudent");
			if(seid>0) {
				StudentEnrolment studentEnrollment=lservice.findStudentEnrolment(seid);
				model.addAttribute("studentEnrollment",studentEnrollment);
			}	
			return mav;
		}

		@RequestMapping(value = "/create/{seid}", method = RequestMethod.POST)
		public ModelAndView editStudent(@ModelAttribute @Valid StudentEnrolment studentEnrollment, @PathVariable Integer seid,
				BindingResult result, final RedirectAttributes redirectAttributes){
			System.out.println("studentEnrollment"+studentEnrollment.toString());
			if (result.hasErrors())
				return new ModelAndView("GradeAStudent");
			lservice.updateStudent(studentEnrollment);
			int courseid =studentEnrollment.getCourse().getCourseid();
			System.out.println(courseid);
			ModelAndView mav = new ModelAndView("redirect:/lecturer/gradelist/"+courseid);
			String message = "Score was successfully input.";
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		
		}
		


	/*//edit grade
	@RequestMapping(value = "/editgrade", method = RequestMethod.GET)
	public ModelAndView editGrad(@PathVariable Integer seid) {
		ModelAndView mav = new ModelAndView("EditGrade");	
		StudentEnrolment se = lService.findStudentEnrolment(seid);
		mav.addObject("enrolment", se);
		return mav;
	}

	@RequestMapping(value = "/editgrade/{seid}", method = RequestMethod.POST)
	public ModelAndView reinputGrade(@ModelAttribute @Valid StudentEnrolment se, @PathVariable Integer seid,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		//System.out.println("student"+student.toString());
		if (result.hasErrors())
			return new ModelAndView("EditGrade");
		lService.updateStudent(se);
		ModelAndView mav = new ModelAndView("redirect:/lecturer/gradelist/"+String.format("{0}",se.getCourse().getCourseid())) ;
		String message = "Grade was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	*/

}
