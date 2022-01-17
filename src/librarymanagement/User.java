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
class User {
    
    private int CategoryId;
    private String CategoryName , CategoryStatus;
    
    private int AuthorId;
    private String AuthorName , AuthorAddress , AuthorContact;
    
    private int BookId;
    private String BookName,Category , Author,Publisher,Contents,Pages,Edition;
    
    
    
    
    public User(int CategoryId ,String CategoryName ,String CategoryStatus)
    {
        this.CategoryId=CategoryId;
        this.CategoryName=CategoryName;
        this.CategoryStatus=CategoryStatus;
        
    }
    
     public User(int AuthorId ,String AuthorName ,String AuthorAddress,String AuthorContact)
    {
        this.AuthorId=AuthorId;
        this.AuthorName=AuthorName;
        this.AuthorAddress=AuthorAddress;
        this.AuthorContact = AuthorContact;
    }
     
      public User(int BookId ,String BookName ,String Category,String Author,String Publisher ,String Contents ,String Pages ,String Edition)
    {
        this.BookId=BookId;
        this.BookName=BookName;
        this.Category=Category;
        this.Author = Author;
        this.Publisher=Publisher;
        this.Contents=Contents;
        this.Pages=Pages;
        this.Edition = Edition;
    }
     
       
    public int getCategoryId()
    {
        return CategoryId;
    }
    
    public String getCategoryName()
    {
        return CategoryName;
    }
    
     public String getCategoryStatus()
    {
        return CategoryStatus;
    }
    
      public int getAuthorId()
    {
        return AuthorId;
    }
    
    public String getAuthorName()
    {
        return AuthorName;
    }
    
     public String getAuthorAddress()
    {
        return AuthorAddress;
    }
     public String getAuthorContact()
    {
        return AuthorContact;
    }
    
     
      public int getBookId()
    {
        return BookId;
    }
     public String getBookName()
    {
        return BookName;
    }
      
    public String getCategory()
    {
        return Category;
    }
    
     public String getAuthor()
    {
        return Author;
    }
     public String getPublisher()
    {
        return Publisher;
    }
     
     
    public String getContents()
    {
        return Contents;
    }
    
     public String getPages()
    {
        return Pages;
    }
     public String getEdition()
    {
        return Edition;
    }

     
     
}
