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
class Userp {
    
        private int PublisherId;
    private String PublisherName , PublisherAddress , PublisherContact;
    
    
      public Userp(int PublisherId ,String PublisherName ,String PublisherAddress,String PublisherContact)
    {
        this.PublisherId=PublisherId;
        this.PublisherName=PublisherName;
        this.PublisherAddress=PublisherAddress;
        this.PublisherContact = PublisherContact;
    }

       
      public int getPublisherId()
    {
        return PublisherId;
    }
    
    public String getPublisherName()
    {
        return PublisherName;
    }
    
     public String getPublisherAddress()
    {
        return PublisherAddress;
    }
     public String getPublisherContact()
    {
        return PublisherContact;
    } 
     
    
}
