package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Course;
import com.example.springbootjpa.entity.Review;
import com.example.springbootjpa.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public Course findById(Long id)
    {
        return em.find(Course.class,id);

    }
    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

   public void deleteById(Long id){
        Course course=findById(id);
        em.remove(course);
   }

   public void playWithEntityManager() {
       Course course1 = new Course("Web Service in 100 steps");
       em.persist(course1);
       em.flush();
       course1.setName("Web Service in 100 steps - updated");
       em.flush();
       Course course2 = new Course("Angular JS Service in 100 steps");
       em.persist(course2);

       /*important*/
       em.clear();

       /*important*/
       em.flush();
       em.detach(course2);

       course2.setName("Angularjs  Service in 100 steps - updated");
       em.flush();

       /*important*/
       em.refresh(course1);

   }

    public void playWithEntityManager2() {
        Course course1 = new Course("Web Service in 100 steps");
        em.persist(course1);

        Course course2 = findById(10001L);
        course2.setName("JPA in 200 steps - updated");


    }

    public  void addHardcodedReviewsForCourses() {
        Course course = findById(10001L);
        //get the course
        logger.info("course.getReviews()->{}", course.getReviews());
        //add 2 reviews to it
        Review review1 = new Review("5", "Great Hands-on Stuff.");
        Review review2 = new Review("5", "Hatts off.");
        //setting the relationship
        course.addReview(review1);
        review1.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);
        //save it to database
        em.persist(review1);
        em.persist(review2);

    }

    public  void addReviewsForCourse(Long courseId,List<Review> reviews) {
        Course course = findById(courseId);
        //get the course
        logger.info("course.getReviews()->{}", course.getReviews());
        //add 2 reviews to it
        for(Review review:reviews) {
            //setting the relationship
            course.addReview(review);
            review.setCourse(course);
            //save it to database
            em.persist(review);
        }

    }

    public void  retrieveReviewsForCourse(){
        Course course = findById(10001L);
        //get the course
        logger.info("course.getReviews()->{}", course.getReviews());
    }

    public void  retrieveCourseForReview(){
        Review review = em.find(Review.class,6L);
        //get the course
        logger.info("review.getCourse()->{}", review.getCourse());
    }
   public void findById_basic(){
        List resultList=em.createQuery("select c from Course c").getResultList();
        logger.info("select c from Course c->{}",resultList);

   }
    public void findById_NamedQuery(){
        List resultList=em.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("select c from Course c->{}",resultList);

    }

    public void findById_basic2(){
        Query query=em.createQuery("select c from Course c");
        List resultList=query.getResultList();
        logger.info("select c from Course c->{}",resultList);

    }

    public void findById_typed(){
        TypedQuery<Course> query=em.createQuery("select c from Course c",Course.class);
        List<Course> resultList=query.getResultList();
        logger.info("select c from Course c->{}",resultList);

    }


    public void jpql_where(){
        TypedQuery<Course> query=em.createQuery("select c from Course c where name like '%100 steps'",Course.class);
        List<Course> resultList=query.getResultList();
        logger.info("select c from Course c where name like '%100 steps'->{}",resultList);

    }


    public void jpql_courses_without_students(){
        TypedQuery<Course> query=em.createQuery("select c from Course c where c.students is empty",Course.class);
        List<Course> resultList=query.getResultList();
        logger.info("Results->{}",resultList);

    }


    public void jpql_courses_with_aleast_2_students(){
        TypedQuery<Course> query=em.createQuery("select c from Course c where size(c.students) >= 2",Course.class);
        List<Course> resultList=query.getResultList();
        logger.info("Results->{}",resultList);

    }


    public void jpql_courses_with_ordered_by_students(){
        TypedQuery<Course> query=em.createQuery("select c from Course c order by size(c.students) desc ",Course.class);
        //TypedQuery<Course> query=em.createQuery("select c from Course c order by 1 ",Course.class);
        List<Course> resultList=query.getResultList();
        logger.info("Results->{}",resultList);

    }



    public void jpql_courses_with_ordered_by_students2(){
        TypedQuery<Student> query=em.createQuery("select s from Student  s where s.passport.number like '%1234%' ",Student.class);
        //TypedQuery<Course> query=em.createQuery("select c from Course c order by 1 ",Course.class);
        List<Student> resultList=query.getResultList();
        logger.info("Results->{}",resultList);

    }


    public void join(){
        Query query=em.createQuery("Select c, s from Course c JOIN c.students  s ");
        //TypedQuery<Course> query=em.createQuery("select c from Course c order by 1 ",Course.class);
        List<Object []> resultList=query.getResultList();
        logger.info("Results->{}",resultList.size());


        for(Object[] result:resultList){

            logger.info("Course {} Student{}",result[0],result[1]);
        }



    }


    public void left_join(){
        Query query=em.createQuery("select c, s from Course c LEFT JOIN c.students  s ");
        //TypedQuery<Course> query=em.createQuery("select c from Course c order by 1 ",Course.class);
        List<Object []> resultList=query.getResultList();
        logger.info("Results->{}",resultList.size());


        for(Object[] result:resultList){

            logger.info("Course {} Student{}",result[0],result[1]);
        }



    }


    public void cross_join(){
        Query query=em.createQuery("select c, s from Course c, Student  s ");
        //TypedQuery<Course> query=em.createQuery("select c from Course c order by 1 ",Course.class);
        List<Object []> resultList=query.getResultList();
        logger.info("Results->{}",resultList.size());


        for(Object[] result:resultList){

            logger.info("Course {} Student{}",result[0],result[1]);
        }



    }

    /*
    JPQL Function
    like
    BETWEEN 100 AND 10000
    IS NULL
    upper, lower, trim, length


    JOIN ==> slect c,s from Course c JOIN c.students s
    LEFT JOIN ==> select c,s from Course c Left join c.students s
    CROSS JOIN ==> select c,s from Course c, students s
    //3 *4 => 3*4 ==12
     */



    public void criteria_query(){

        //select c from Course c

        //step #1
        //use criteria builder to create a criteria query returning the expected result object
        CriteriaBuilder cb =em.getCriteriaBuilder();
        CriteriaQuery<Course> cq=cb.createQuery(Course.class);

        //step #2
        //defines root for tables which are involved in the query
        Root<Course> courseRoot=cq.from(Course.class);

        //step #3
        //defines predicates etc using criteria builder

        //step #4
        //add predicates etc to the criteria builder

        //step #5
        //build the TypedQuery using the entity manager and criteria builder
        TypedQuery<Course> query=em.createQuery(cq.select(courseRoot));
        List<Course> resultList=query.getResultList();
        logger.info("TypedQuery -> {}",resultList);

    }


    public void all_courses_having_100steps() {

        //select c from Course c where name like '%100 Steps'

        //step #1
        //use criteria builder to create a criteria query returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //step #2
        //defines root for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        //step #3
        //defines predicates etc using criteria builder
        Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");

        //step #4
        //add predicates etc to the criteria builder
        cq.where(like100Steps);

        //step #5
        //build the TypedQuery using the entity manager and criteria builder
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("TypedQuery -> {}", resultList);

    }


    public void all_courses_without_students() {

        //select c from Course c where c.students is empty

        //step #1
        //use criteria builder to create a criteria query returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //step #2
        //defines root for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        //step #3
        //defines predicates etc using criteria builder
        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));

        //step #4
        //add predicates etc to the criteria builder
        cq.where(studentsIsEmpty);

        //step #5
        //build the TypedQuery using the entity manager and criteria builder
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("TypedQuery -> {}", resultList);

    }


    public void joinCriteriaQuery() {

        //select c from Course c join c.students s

        //step #1
        //use criteria builder to create a criteria query returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //step #2
        //defines root for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        //step #3
        //defines predicates etc using criteria builder
        Join<Object, Object> join = courseRoot.join("students");

        //step #4
        //add predicates etc to the criteria builder


        //step #5
        //build the TypedQuery using the entity manager and criteria builder
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("TypedQuery -> {}", resultList);

    }


    public void leftJoinCriteriaQuery() {

        //select c from Course c join c.students s

        //step #1
        //use criteria builder to create a criteria query returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //step #2
        //defines root for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        //step #3
        //defines predicates etc using criteria builder
        Join<Object, Object> join = courseRoot.join("students",JoinType.LEFT);

        //step #4
        //add predicates etc to the criteria builder


        //step #5
        //build the TypedQuery using the entity manager and criteria builder
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("TypedQuery -> {}", resultList);

    }
}
