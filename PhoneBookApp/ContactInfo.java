package business;

public class ContactInfo 
{
    private String name;
    private String address;
    private String ph_no;

    public ContactInfo()
    {
        this(null,null,null);
    }

    public ContactInfo(String name, String address, String ph_no)
    {
        this.name = name;
        this.address = address;
        this.ph_no = ph_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
      
}

 

