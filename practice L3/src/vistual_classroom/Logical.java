package vistual_classroom;

import java.util.ArrayList;
import java.util.HashMap;

public class Logical {

    String studentSignup(StudentInfo info){
        Cache.OBJECT.setStudentMap(info);
        return "student Account created successfully";
    }

    HashMap<Long,StudentInfo> getStudentDetails(){
        return Cache.OBJECT.getStudentMap();
    }
    HashMap<Integer,FacultyInfo> getFacultyDetails(){
        return Cache.OBJECT.getFacultySignupMap();
    }
    String studentLogin(StudentInfo info){
        HashMap<Long,StudentInfo> map =Cache.OBJECT.getStudentMap();
        if(map.containsKey(info.getRegisterNo())){
            StudentInfo data = map.get(info.getRegisterNo());
            if(data.getPassword().equals(info.getPassword())){
                return "Login Successfully";
            }
            else
                return "invalid password...Enter valid Password";
        }
        else
          return "invalid register No...Enter valid register No" +
                  " or signup to create account";
    }

    String studentProfileUpdation(StudentInfo info){
        Cache.OBJECT.setStudentMap(info);
        return "Profile Updated Successfully";
    }
    void studentDoubts(String question,StudentInfo info){
        Cache.OBJECT.setQuestionMap(question,info);
    }

    HashMap<Long,String> getDoubtMap(){
        return Cache.OBJECT.getQuestionMap();
    }
    String facultySignup(FacultyInfo info){
        Cache.OBJECT.setFacultySignupMap(info);
        return "faculty Account created successfully";
    }

    String facultyLogin(FacultyInfo info){
        HashMap<Integer,FacultyInfo> map =Cache.OBJECT.getFacultySignupMap();
        if(map.containsKey(info.getFacultyId())){
            FacultyInfo data = map.get(info.getFacultyId());
            if(data.getPassword().equals(info.getPassword())){
                return "Login Successfully";
            }
            else
                return "invalid password...Enter valid Password";
        }
        else
            return "invalid Faculty id...Enter valid faculty id" +
                    "or signup to create account";
    }

    String facultyProfileUpdation(FacultyInfo info){
        Cache.OBJECT.setFacultySignupMap(info);
        return "Profile Updated Successfully";
    }
    String lecturesPost(LectureInfo lecinfo,FacultyInfo facinfo) {
        HashMap<Integer,ArrayList<String>> map = new HashMap<>();
        ArrayList<String> list = Cache.OBJECT.getLectureMap().getOrDefault
                (facinfo.getFacultyId(), new ArrayList<>());
        String temp = lecinfo.getType()+"\t-\t"+lecinfo.getLectureName();
        list.add(temp);
        map.put(facinfo.getFacultyId(),list);
        Cache.OBJECT.setLectureMap(map);
        return "lecture posted successfully";
    }
    HashMap<Integer, ArrayList<String>> getFacultyLectures(){
        return Cache.OBJECT.getLectureMap();
    }

    HashMap<Long,String> getFacultyAnswers(){
        return Cache.OBJECT.getAnswerMap();
    }
    String  lectureRemove(FacultyInfo info,int number){
        HashMap<Integer,ArrayList<String>>map =Cache.OBJECT.getLectureMap();
        if(map.containsKey(info.getFacultyId())){
            map.get(info.getFacultyId()).remove(number);
            Cache.OBJECT.setLectureMap(map);
            return "lecture removed....";
        }
        else{
            return "No lectures Available...";
        }
    }

    String facultyAnswer(long regNo, String answer){
        Cache.OBJECT.setAnswerMap(regNo,answer);
        String question = Cache.OBJECT.getQuestionMap().get(regNo);
        question+="\t"+"Answerd";
        StudentInfo info = new StudentInfo();
        info.setRegisterNo(regNo);
        Cache.OBJECT.setQuestionMap(question,info);
        return "Answers posted Successfully";
    }


}
