package dataaccess;

import java.io.*;
import java.util.*;
import business.*;


public class ContactInfoDataFile implements ContactInfoReader, ContactInfoWriter, ContactInfoConstants
{
    private HashMap<String,ContactInfo>contactInfos = null;
    private File contactInfosFile = null;

    private final String FIELD_SEP = "\t";

    public ContactInfoDataFile()
    {
        contactInfosFile = new File("contactInfo.txt");
        contactInfos= this.getContactInfos();
    }

    private void checkFile() throws IOException
    {
        // if the file doesn't exist, create it
        if (!contactInfosFile.exists())
            contactInfosFile.createNewFile();
    }

    private boolean saveContactInfos()
    {
        PrintWriter out = null;
        try
        {
            this.checkFile();

            // open output stream for overwriting
            out = new PrintWriter(
                  new BufferedWriter(
                  new FileWriter(contactInfosFile)));

            // write all computers in the array list
            // to the file
            for (HashMap.Entry<String,ContactInfo>entry:contactInfos.entrySet())
            {
                out.print(entry.getKey() + FIELD_SEP);
                ContactInfo cf= entry.getValue();
                out.print(cf.getAddress() + FIELD_SEP);
                out.println(cf.getPh_no());
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return false;
        }
        finally
        {
            this.close(out);
        }
        return true;
    }

    private void close(Closeable stream)
    {
        try
        {
            if (stream != null)
                stream.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public HashMap<String,ContactInfo> getContactInfos()
    {
        // if the computers hashmap has been created, don't create it again
        if (contactInfos != null)
            return copyContactInfos();

        BufferedReader in = null;
        try
        {
            this.checkFile();

            in = new BufferedReader(
                 new FileReader(contactInfosFile));

            contactInfos = new HashMap<String,ContactInfo>();

            // read all computers stored in the file
            // into the HashMap
            String line = in.readLine();
            while(line != null)
            {
                String[] columns = line.split(FIELD_SEP);                                
                
                if(columns.length==3)
                {
                String newname = columns[0];
                String address = columns[1];
                String ph_no = columns[2];                
                ContactInfo cf = new ContactInfo(
                newname, address, ph_no);
                contactInfos.put(newname,cf);
                }
                line = in.readLine();
                
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return null;
        }
        finally
        {
            this.close(in);
        }
        HashMap<String,ContactInfo>contactInfosCopy = new HashMap<String,ContactInfo>();
        for (HashMap.Entry<String,ContactInfo>entry:contactInfos.entrySet())
            contactInfosCopy.put(entry.getKey(),entry.getValue());
        return copyContactInfos();
    }

    private HashMap<String,ContactInfo> copyContactInfos()
    {
        HashMap<String,ContactInfo> contactInfosCopy = new HashMap<String,ContactInfo>();
        for (HashMap.Entry<String,ContactInfo>entry:contactInfos.entrySet())
            contactInfosCopy.put(entry.getKey(),entry.getValue());
        return contactInfosCopy;
    }

    
    public ContactInfo getContactInfo(String newname)
    {
        for (HashMap.Entry<String,ContactInfo>entry:contactInfos.entrySet())
        {
            if (entry.getKey().equals(newname))
                return entry.getValue();
        }
        return null;
    }

    public boolean addContactInfo(ContactInfo cf)
    {
         contactInfos.put(cf.getName(),cf);
        return this.saveContactInfos();
    }

    public boolean deleteContactInfo(ContactInfo cf)
    {
        contactInfos.remove(cf.getName());
        return this.saveContactInfos();
    }

}
