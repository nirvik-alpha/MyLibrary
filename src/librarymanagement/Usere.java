/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

/**
 *
 * @author Lenovo
 */
public class Usere {
    
       private int ReturnId , StudentId, BookId;
        
    private String StudentName , BookName , IssueDate ,ReturnDate;
    
      public Usere(int ReturnId ,int StudentId ,String StudentName,int BookId,String BookName,String IssueDate,String ReturnDate)
    {
        this.ReturnId=ReturnId;
        this.StudentId=StudentId;
        this.StudentName=StudentName;
        this.BookId = BookId;
        this.BookName=BookName;
        this.IssueDate = IssueDate;
        this.ReturnDate = ReturnDate;
    }
    
        
      public int getReturnId()
    {
        return ReturnId;
    }
    public int getStudentId()
    {
        return StudentId;
    }
    public int getBookId()
    {
        return BookId;
    }
     public String getStudentName()
    {
        return StudentName;
    }
    
     public String getBookName()
    {
        return BookName;
    }
     public String getIssueDate()
    {
        return IssueDate;
    } 
       public String getReturnDate()
    {
        return ReturnDate;
    } 
    
}
