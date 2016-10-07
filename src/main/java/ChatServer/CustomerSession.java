/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer;

import ChatServer.Domain.Message;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Humanic
 */
//Message = Customer
@Stateless
@Path("myservice")
public class CustomerSession {
    @PersistenceContext
    EntityManager em;
    
    @GET
    public List<Message> getAllMessages(){
       return em.createQuery("SELECT c from Customer c").getResultList();
        
    }
    
    @GET
    public boolean createCustomer(Message customer){
        em.persist(customer);
        return true;
    }
}
