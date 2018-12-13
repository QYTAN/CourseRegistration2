package sa47.team11.caps.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team11.caps.model.Course;

/*@Repository
@Transactional*/
public interface CourseRepository extends JpaRepository<Course,Integer> {
	@Query("SELECT r.courseName FROM Course r")
	List<String> getCourseName();

	@Query(value = "SELECT * FROM caps_team11.course c where c.assigned_lecturerid=:uid",nativeQuery=true)
	ArrayList<Course> findCourseByAssignedLecturerID(@Param("uid") Integer uid);
	
/*	@Query(value = "SELECT * from Course c WHERE c.assigned_lecturerid=:uid",nativeQuery=true)
	ArrayList<Course> findCourseByAssignedLecturerID(@Param("uid") Integer uid);*/

}
