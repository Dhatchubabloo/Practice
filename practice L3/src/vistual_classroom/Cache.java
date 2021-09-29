package vistual_classroom;

import java.util.ArrayList;
import java.util.HashMap;

public enum Cache {
    OBJECT;
    HashMap<Long,StudentInfo> studentSignupMap = new HashMap<>();
    HashMap<Long,String>questionMap = new HashMap<>();
    HashMap<Integer,FacultyInfo> facultySignupMap = new HashMap<>();
    HashMap<Integer, ArrayList<String>> lectureMap = new HashMap<>();
    HashMap<Long,String>answerMap = new HashMap<>();

    void setAnswerMap(long regNo,String answer){
        answerMap.put(regNo,answer);
    }
    HashMap<Long,String> getAnswerMap(){
        return answerMap;
    }

    void setLectureMap(HashMap<Integer, ArrayList<String>> map){
        lectureMap = map;
    }

    HashMap<Integer, ArrayList<String>> getLectureMap(){
        return lectureMap;
    }

    public HashMap<Integer, FacultyInfo> getFacultySignupMap() {
        return facultySignupMap;
    }

    public void setFacultySignupMap(FacultyInfo info) {
        facultySignupMap.put(info.getFacultyId(),info);
    }

    void setStudentMap(StudentInfo info){
        studentSignupMap.put(info.getRegisterNo(),info);
    }
    HashMap<Long,StudentInfo> getStudentMap(){
        return studentSignupMap;
    }

    void setQuestionMap(String question,StudentInfo info){
        questionMap.put(info.getRegisterNo(),question);
    }
    HashMap<Long,String> getQuestionMap(){
        return questionMap;
    }
}
