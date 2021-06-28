
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

/**
 *
 * @author lenovo
 */
class User {
    private int qno,questions;
    private String question,option1,option2,option3,option4,correct,test,password;
    private String rollNo,date;
    private int marks;
    
    public User(int qno,String question,String option1,String option2,String option3,String option4,String correct)
    {
        this.qno = qno;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct = correct;
    }
    public User(String test,int questions)
    {
        this.test = test;
        this.questions = questions;
    }
    public User(String test,int questions,String password)
    {
        this.test = test;
        this.questions = questions;
        this.password = password;
    }
    public User(String rollNo,String date,int marks)
    {
        this.rollNo = rollNo;
        this.date = date;
        this.marks = marks;
    }
    
    public int getQuestionNo()
    {
        return qno;
    }
    public String getQuestion()
    {
        return question;
    }
    public String getOption1()
    {
        return option1;
    }
    public String getOption2()
    {
        return option2;
    }
    public String getOption3()
    {
        return option3;
    }
    public String getOption4()
    {
        return option4;
    }
    public String getCorrect()
    {
        return correct;
    }
    public String getTest()
    {
        return test;
    }
    public int getQuestions()
    {
        return questions;
    }
    public String getTestPass()
    {
        return password;
    }
    public String getRollNo()
    {
        return rollNo;
    }
    public String getDate()
    {
        return date;
    }
    public int getMarks()
    {
        return marks;
    }
}
