package com.example.springbootjpa;

import com.example.springbootjpa.entity.Course;
import com.example.springbootjpa.entity.Review;
import com.example.springbootjpa.entity.Student;
import com.example.springbootjpa.repository.CourseRepository;
import com.example.springbootjpa.repository.ReviewRepository;
import com.example.springbootjpa.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner
{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseRepository repository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Course course = repository.findById(10001L);
        logger.info("course 10001 {}", course);
        // repository.deleteById(10002L);
        // repository.save(new Course("Microservice in 100 steps"));
        //    repository.playWithEntityManager();
        //    repository.findById_basic();
        //    repository.playWithEntityManager2();

        //repository.addHardcodedReviewsForCourses();
        /*List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("5", "Great Hands-on Stuff. --"));
        reviews.add(new Review("5", "Hatts off. --"));
        repository.addReviewsForCourse(10001L, reviews);*/

        //repository.retrieveReviewsForCourse();
        //repository.retrieveCourseForReview();

        //studentRepository.retrieveStudentAndCourse();

        //studentRepository.insertStudentAndCourse2(new Student("Jack 2"),new Course("Microservice in 100 steps"));

        //repository.jpql_courses_without_students();

       // repository.jpql_courses_with_aleast_2_students();
       // repository.jpql_courses_with_ordered_by_students();

        // repository.join();
        // repository.left_join();
        //repository.criteria_query();
        //repository.all_courses_having_100steps();
       // repository.all_courses_without_students();

       // repository.joinCriteriaQuery();
       // repository.leftJoinCriteriaQuery();

        /*Gson gson = new Gson();
        String myJson = "my string json array";
        List<Object> list= gson.fromJson(myJson,new TypeToken<List<Object>>(){}.getType());*/

       // Map<String, Object> retMap = new HashMap<String, Object>();
        String jsonString=Json_text();

        ObjectMapper mapper = new ObjectMapper();
        String studentJsonData
                = "{\"studentId\":\"1\", \"studentFirstName\":\"AAA\",\"studentLastName\":\"BBB\",\"studentStream\":\"PCMB\",\"studentMarks\":\"480\"}";

        //String jsonString="{'Name' : 'Donal','Mobile' : '89346724','Designation' : 'Sr. Salesforce Developer','Pet' : 'Dog','Address' : 'AMERICA'     }";
       // Map<String, Object> mapping = new ObjectMapper().readValue(jsonString, HashMap.class);
        Map<String, String> studentMapData
                = mapper.readValue(studentJsonData,
                Map.class);

       /* Map<String, Object> retMap = new Gson().fromJson(
                jsonString, new TypeToken<HashMap<String, Object>>() {}.getType()
        );*/

        jsonString="";
    }


    private String Json_text(){

        String json="";
        String json2="";

        String fileName = "C:\\JsonFile\\setup.json";

      //  String content = new String(Files.readAllLines((Paths.get(fileName)));


       // json2=Files.readAllLines(Paths.get(fileName));
       // List<String> list = new ArrayList<>();

       // try (Stream<String> stream = Files.lines(Paths.get(fileName))) {




        json="{\n" +
                "   \"service\":[\n" +
                "      {\n" +
                "         \"baseURL\":\"https://qs.colgate-palmolive.com.pk/BIInquiries\",\n" +
                "         \"endPoint\":\"/kpi/biinquiries/DSRKPIS/DSR\",\n" +
                "         \"headerMap\":{\n" +
                "            \"TokenId\":\"123\",\n" +
                "            \"TokenValue\":\"abc\"\n" +
                "         }\n" +
                "      }\n" +
                "   ],\n" +



                "}";

         json2="{\n" +
                "   \"service\":[\n" +
                "      {\n" +
                "         \"baseURL\":\"https://qs.colgate-palmolive.com.pk/BIInquiries\",\n" +
                "         \"endPoint\":\"/kpi/biinquiries/DSRKPIS/DSR\",\n" +
                "         \"headerMap\":{\n" +
                "            \"TokenId\":\"123\",\n" +
                "            \"TokenValue\":\"abc\"\n" +
                "         }\n" +
                "      }\n" +
                "   ],\n" +
                "   \"table\":[\n" +
                "      {\n" +
                "         \"tableType\":\"aggregated\",\n" +
                "         \"columns\":[\n" +
                "            {\n" +
                "               \"aggregationFunction\":\"sum\",\n" +
                "               \"alias\":\"sumProductiveTime\",\n" +
                "               \"condition\":{\n" +
                "                  \"leftOperand\":\"date2\",\n" +
                "                  \"operator\":\"-\",\n" +
                "                  \"rightOperand\":{\n" +
                "                     \"columnName\":\"date1\",\n" +
                "                     \"session\"\n" +
                "                  },\n" +
                "                  \"castType\":\"java.sql.Time\"\n" +
                "               },\n" +
                "               \"where\":[\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"organizationCode\",\n" +
                "                     \"operator\":\"=\",\n" +
                "                     \"rightOperand\":\"organizationCode\",\n" +
                "                     \"type=\"\"session\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"gMapCode\",\n" +
                "                     \"operator\":\"=\",\n" +
                "                     \"rightOperand\":\"gMapCode\",\n" +
                "                     \"type=\"\"entityRepo\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"codeField\",\n" +
                "                     \"operator\":\"=\",\n" +
                "                     \"rightOperand\":\"codeField\",\n" +
                "                     \"type=\"\"entityRepo\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"gMapCode\",\n" +
                "                     \"deviceId\":\"=\",\n" +
                "                     \"rightOperand\":\"deviceId\",\n" +
                "                     \"type=\"\"entityRepo\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"serialNo\",\n" +
                "                     \"operator\":\"=\",\n" +
                "                     \"rightOperand\":\"serialNo\",\n" +
                "                     \"type=\"\"entityRepo\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"gMapCodeRef\",\n" +
                "                     \"operator\":\"=\",\n" +
                "                     \"rightOperand\":\"gMapCodeRef\",\n" +
                "                     \"type=\"\"entityRepo\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"codeFieldRef\",\n" +
                "                     \"operator\":\"=\",\n" +
                "                     \"rightOperand\":\"codeFieldRef\",\n" +
                "                     \"type=\"\"entityRepo\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"isVisible\",\n" +
                "                     \"deviceId\":\"=\",\n" +
                "                     \"rightOperand\":\"Y\",\n" +
                "                     \"type=\"\"fixed\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"leftOperand\":\"entityStatus\",\n" +
                "                     \"operator\":\"=\",\n" +
                "                     \"rightOperand\":\"01~ORDER\",\n" +
                "                     \"type=\"\"fixed\"\n" +
                "                  }\n" +
                "               ],\n" +
                "               \"where\":{\n" +
                "                  \"operator\":\"AND\",\n" +
                "                  \"conditionArray\":[\n" +
                "                     {\n" +
                "                        \"operator\":\"AND\",\n" +
                "                        \"conditionArray\":[\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"organizationCode\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"orgaCode\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"gMapCode\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"gMapCode\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"codeField\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"codeField\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"serialNo\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"serialNo\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"gMapCodeRef\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"gMapCodeRef\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"codeFieldRef\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"codeFieldRef\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"isVisible\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"value\":\"Y\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"entityStatus\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"value\":\"01~ORDER\"\n" +
                "                              }\n" +
                "                           }\n" +
                "                        ]\n" +
                "                     },\n" +
                "                     {\n" +
                "                        \"operator\":\"AND\",\n" +
                "                        \"conditionArray\":[\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"organizationCode\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"orgaCode\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"gMapCode\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"gMapCode\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"codeField\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"codeField\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"serialNo\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"serialNo\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"gMapCodeRef\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"gMapCodeRef\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"codeFieldRef\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"columnName\":\"codeFieldRef\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"isVisible\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"value\":\"Y\"\n" +
                "                              }\n" +
                "                           },\n" +
                "                           {\n" +
                "                              \"leftOperand\":\"entityStatus\",\n" +
                "                              \"operator\":\"=\",\n" +
                "                              \"rightOperand\":{\n" +
                "                                 \"value\":\"01~ORDER\"\n" +
                "                              }\n" +
                "                           }\n" +
                "                        ]\n" +
                "                     }\n" +
                "                  ]\n" +
                "               }\n" +
                "            }[\n" +
                "               {\n" +
                "                  \"leftOperand\":\"organizationCode\",\n" +
                "                  \"operator\":\"=\",\n" +
                "                  \"rightOperand\":\"organizationCode\",\n" +
                "                  \"type=\"\"session\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"leftOperand\":\"gMapCode\",\n" +
                "                  \"operator\":\"=\",\n" +
                "                  \"rightOperand\":\"gMapCode\",\n" +
                "                  \"type=\"\"entityRepo\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"leftOperand\":\"codeField\",\n" +
                "                  \"operator\":\"=\",\n" +
                "                  \"rightOperand\":\"codeField\",\n" +
                "                  \"type=\"\"entityRepo\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"leftOperand\":\"gMapCode\",\n" +
                "                  \"deviceId\":\"=\",\n" +
                "                  \"rightOperand\":\"deviceId\",\n" +
                "                  \"type=\"\"entityRepo\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"leftOperand\":\"serialNo\",\n" +
                "                  \"operator\":\"=\",\n" +
                "                  \"rightOperand\":\"serialNo\",\n" +
                "                  \"type=\"\"entityRepo\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"leftOperand\":\"gMapCodeRef\",\n" +
                "                  \"operator\":\"=\",\n" +
                "                  \"rightOperand\":\"gMapCodeRef\",\n" +
                "                  \"type=\"\"entityRepo\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"leftOperand\":\"codeFieldRef\",\n" +
                "                  \"operator\":\"=\",\n" +
                "                  \"rightOperand\":\"codeFieldRef\",\n" +
                "                  \"type=\"\"entityRepo\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"leftOperand\":\"isVisible\",\n" +
                "                  \"deviceId\":\"=\",\n" +
                "                  \"rightOperand\":\"Y\",\n" +
                "                  \"type=\"\"fixed\"\n" +
                "               },\n" +
                "               {\n" +
                "                  \"leftOperand\":\"entityStatus\",\n" +
                "                  \"operator\":\"=\",\n" +
                "                  \"rightOperand\":\"01~ORDER\",\n" +
                "                  \"type=\"\"fixed\"\n" +
                "               }\n" +
                "            ]\n" +
                "         },\n" +
                "         {\n" +
                "            \"aggregationFunction\":\"min\",\n" +
                "            \"columnName\":\"workingDate\",\n" +
                "            \"alias\":\"minWorkingDate\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"aggregationFunction\":\"max\",\n" +
                "            \"columnName\":\"workingDate\",\n" +
                "            \"alias\":\"maxWorkingDate\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"aggregationFunction\":\"sum\",\n" +
                "            \"columnName\":\"num1\",\n" +
                "            \"alias\":\"sumNum1\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"aggregationFunction\":\"sum\",\n" +
                "            \"columnName\":\"num2\",\n" +
                "            \"alias\":\"netSales\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"aggregationFunction\":\"sum\",\n" +
                "            \"alias\":\"mGpsComp\",\n" +
                "            \"condition\":{\n" +
                "               \"leftOperand\":\"bool3\",\n" +
                "               \"operator\":\"=\",\n" +
                "               \"rightOperand\":{\n" +
                "                  \"value\":\"Y\"\n" +
                "               },\n" +
                "               \"true\":1,\n" +
                "               \"false\":0\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"aggregationFunction\":\"sum\",\n" +
                "            \"alias\":\"countNum2\",\n" +
                "            \"condition\":{\n" +
                "               \"leftOperand\":\"num2\",\n" +
                "               \"operator\":\">\",\n" +
                "               \"rightOperand\":{\n" +
                "                  \"value\":0\n" +
                "               },\n" +
                "               \"true\":1,\n" +
                "               \"false\":0\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"aggregationFunction\":\"sum\",\n" +
                "            \"alias\":\"countNum1\",\n" +
                "            \"condition\":{\n" +
                "               \"leftOperand\":\"num1\",\n" +
                "               \"operator\":\">\",\n" +
                "               \"rightOperand\":{\n" +
                "                  \"value\":0\n" +
                "               },\n" +
                "               \"true\":1,\n" +
                "               \"false\":0\n" +
                "            }\n" +
                "         }\n" +
                "      ]\n" +
                "   },\n" +
                "   {\n" +
                "      \"tableType\":\"non-aggregated\",\n" +
                "      \"columns\":[\n" +
                "         {\n" +
                "            \"columnName\":\"date1\",\n" +
                "            \"alias\":\"date1\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"columnName\":\"date2\",\n" +
                "            \"alias\":\"date2\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"columnName\":\"entityStatus\",\n" +
                "            \"alias\":\"entityStatus\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"columnName\":\"num6\",\n" +
                "            \"alias\":\"num6\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"columnName\":\"num7\",\n" +
                "            \"alias\":\"num7\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"columnName\":\"num1\",\n" +
                "            \"alias\":\"num1\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"columnName\":\"num2\",\n" +
                "            \"alias\":\"num2\"\n" +
                "         }\n" +
                "      ]\n" +
                "   }\n" +
                "]\n" +
                "}";

        return json2;

    }



}
