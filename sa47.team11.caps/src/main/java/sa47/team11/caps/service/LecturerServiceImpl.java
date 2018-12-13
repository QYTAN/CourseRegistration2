package sa47.team11.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sa47.team11.caps.model.Course;
import sa47.team11.caps.model.StudentEnrolment;
import sa47.team11.caps.model.User;
import sa47.team11.caps.repository.CourseRepository;
import sa47.team11.caps.repository.LecturerRepository;
//import sa47.team11.caps.repository.LecturerRepository2;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Resource
	private CourseRepository crepo;
	

	@Resource
	LecturerRepository lecrepo;
	//LecturerRepository2 lecrepo2;
	
	@Override
	public ArrayList<StudentEnrolment> FindCourseidCoursenameCreditById(int uid) {
		// TODO Auto-generated method stub
		return lecrepo.FindCourseidCoursenameCreditById(uid);
	}

/*	@Override
	public ArrayList<StudentEnrolment> FindScoreById(int uid) {
		// TODO Auto-generated method stub
		return null; //lecrepo2.FindScoreById(uid);
	}*/

	@Override
	public int updateUser(User u) {
		return 0;//lecrepo.saveAndFlush(u);
		
	}
	
	@Override
	public User findUserById(Integer id) {
		//User student = lecrepo.findById(id).get();
		return null;// student;
	}
	
	@Override
	@Transactional
	public ArrayList<Course> findCourseByAssignedLecturerID(Integer uid) {
		return (ArrayList<Course>) crepo.findCourseByAssignedLecturerID(uid);
	}
	
	@Override
	@Transactional
	public Course findCourseById(Integer cid) {
		return crepo.findById(cid).get();
	}

	@Override
	@Transactional
	public int updateStudent(StudentEnrolment se) {
		return lecrepo.updateStudentEnrollment(se.getScore(),se.getStudentEnrolId());
	}

	@Override
	@Transactional
	public StudentEnrolment findStudentEnrolment(Integer seid) {
		StudentEnrolment se = lecrepo.findById(seid).get();
		return se;
	}

	@Override
	@Transactional
	public StudentEnrolment createStudentEnrolment(StudentEnrolment se) {
		return lecrepo.saveAndFlush(se);
	}


}
