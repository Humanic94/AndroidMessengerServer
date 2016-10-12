/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Domain;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Humanic
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable{
    @Id @GeneratedValue
    private Long uid;
    private String name;
    private String photoUri;
    
    
    protected User(){}
    
    public User(Long uid, String name, String photoUri){
        this.uid = uid;
        this.name = name;
        this.photoUri = photoUri;
    }
    
    public User(String name){
        this.name = name;
    }
    
    public User(Long uid, String name){
    this.uid = uid;
    this.name = name;
    }
    
    @GET
    public String getName(){
    return name;
    }
    
    @GET
    public Long getUid() {
        return uid;
    }
    
    @GET
    public String getPhotoUri() {
        return photoUri;
    }   
}
