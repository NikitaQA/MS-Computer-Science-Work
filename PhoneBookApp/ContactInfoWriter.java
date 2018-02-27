package dataaccess;

import business.*;

public interface ContactInfoWriter 
{
    boolean addContactInfo(ContactInfo c);
    boolean deleteContactInfo(ContactInfo c);     
}
