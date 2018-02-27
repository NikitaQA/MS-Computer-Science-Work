package dataaccess;

import java.util.HashMap;
import business.*;

public interface ContactInfoReader 
{
    ContactInfo getContactInfo(String name);
    HashMap<String,ContactInfo> getContactInfos();    
}
