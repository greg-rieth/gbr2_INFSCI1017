package gbr2_Music;

import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManageSongs {

	public void createSong(String title, double length, String filePath, String releaseDate, String recordDate){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("gbr2_Music_JPA");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Song s = new Song();
		
		s.setSongID(UUID.randomUUID().toString());
		System.out.println("ID:" + s.getSongID());
		s.setTitle(title);
		s.setLength(length);
		s.setFilePath(filePath);
		s.setReleaseDate(releaseDate);
		s.setRecordDate(recordDate);
		
		// Add the Song object to the ORM object grid
		em.persist(s);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	
	public void updateSong(String songID, String title, double length, String filePath, String releaseDate, String recordDate){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song s = em.find(Song.class, songID);
		
		if(!title.equals("")){
			s.setTitle(title);
		}
		
		if(length != 0.0){
			s.setLength(length);
		}
		
		if(!filePath.equals("")){
			s.setFilePath(filePath);
		}
		
		if(!releaseDate.equals("")){
			s.setReleaseDate(releaseDate);
		}
		
		if(!recordDate.equals("")) {
			s.setRecordDate(recordDate);
		}
		
		em.persist(s);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteSong(String songID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song s = em.find(Song.class, songID);
		
		em.remove(s);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void findSong(String songID) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
		EntityManager em = emFactory.createEntityManager();
		
		Song s = em.find(Song.class, songID);
		
		String title = s.getTitle();
		double length = s.getLength();
		String filePath = s.getFilePath();
		String releaseDate = s.getReleaseDate();
		String recordDate = s.getRecordDate();
		
		System.out.println(title);
		System.out.println(length);
		System.out.println(filePath);
		System.out.println(releaseDate);
		System.out.println(recordDate);
		
		em.close();
		emFactory.close();
		
	}
}

