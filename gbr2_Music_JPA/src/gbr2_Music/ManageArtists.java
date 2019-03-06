package gbr2_Music;

import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManageArtists {

	public void createArtist(String firstName, String lastName, String bandName, String bio){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("gbr2_Music_JPA");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Artist ar = new Artist();
		
		ar.setArtistID(UUID.randomUUID().toString());
		System.out.println("ID:" + ar.getArtistID());
		ar.setFirstName(firstName);
		ar.setLastName(lastName);
		ar.setBandName(bandName);
		ar.setBio(bio);
		
		// Add the Artist object to the ORM object grid
		em.persist(ar);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	
	public void updateArtist(String artistID, String firstName, String lastName, String bandName, String bio){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist ar = em.find(Artist.class, artistID);
		
		if(!firstName.equals("")){
			ar.setFirstName(firstName);
		}
		
		if(!lastName.equals("")){
			ar.setLastName(lastName);
		}
		
		if(!bandName.equals("")){
			ar.setBandName(bandName);
		}
		
		if(!bio.equals("")){
			ar.setBio(bio);
		}
		
		em.persist(ar);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteArtist(String artistID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist ar = em.find(Artist.class, artistID);
		
		em.remove(ar);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void findArtist(String artistID) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
		EntityManager em = emFactory.createEntityManager();
			
		Artist ar = em.find(Artist.class, artistID);
		
		String firstName = ar.getFirstName();
		String lastName = ar.getLastName();
		String bandName = ar.getBandName();
		String bio = ar.getBio();
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(bandName);
		System.out.println(bio);
		
		em.close();
		emFactory.close();
	}
}

