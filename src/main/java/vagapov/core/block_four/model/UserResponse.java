package vagapov.core.block_four.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Задайте необходимые аннотации, поля и геттеры
 */

@XmlRootElement(name = "UserResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserResponse  {
    @XmlAttribute(name = "Status")
    public String status;
    @XmlElement(name = "UserId")
    public String userId;
    @XmlElement(name = "FirstName")
    public String firstName;
    @XmlElement(name = "LastName")
    public String lastName;
    @XmlElement(name = "MiddleName")
    public String middleName;
    @XmlElement(name = "FullName")
    public String fullName;
    @XmlElementWrapper(name = "Documents")
    @XmlElement(name = "Document")
    public List<Documents> documents;
    @XmlElementWrapper (name = "Addresses")
    @XmlElement(name = "Address")
    public List<Addresses> addresses;

    public String getStatus(){
        return status;
    }

    public String getUserId(){
        return userId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }
}

