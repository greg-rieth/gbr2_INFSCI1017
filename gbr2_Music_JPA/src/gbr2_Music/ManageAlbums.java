package gbr2_Music;

import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManageAlbums {
	
		public void createAlbum(String title, String releaseDate, String recordingCompanyName, int numberOfTracks, String pmrcRating, double length){
			EntityManagerFactory emFactory = 
					Persistence.createEntityManagerFactory("gbr2_Music_JPA");
			
			EntityManager em = emFactory.createEntityManager();
			
			em.getTransaction().begin();
			Album al = new Album();
			
			al.setAlbumID(UUID.randomUUID().toString());
			System.out.println("ID:" + al.getAlbumID());
			al.setTitle(title);
			al.setReleaseDate(releaseDate);
			al.setRecordingCompanyName(recordingCompanyName);
			al.setNumberOfTracks(numberOfTracks);
			al.setPmrcRating(pmrcRating);
			al.setLength(length);
			
			// Add the Album object to the ORM object grid
			em.persist(al);
			
			// Commit transaction
			em.getTransaction().commit();
			
			// Close connection to persistence manager
			em.close();
			emFactory.close();
		}
		
		
		public void updateAlbum(String albumID, String title, String releaseDate, String recordingCompanyName, int numberOfTracks, String pmrcRating, double length){
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
			EntityManager em = emFactory.createEntityManager();
			em.getTransaction().begin();
			
			Album al = em.find(Album.class, albumID);
			
			if(!title.equals("")){
				al.setTitle(title);
			}
			
			if(!releaseDate.equals("")){
				al.setReleaseDate(releaseDate);
			}
			
			if(!recordingCompanyName.equals("")){
				al.setRecordingCompanyName(recordingCompanyName);
			}
			
			if(numberOfTracks != 0){
				al.setNumberOfTracks(numberOfTracks);
			}
			
			if(!pmrcRating.equals("")){
				al.setPmrcRating(pmrcRating);
			}
			
			if(length != 0.0){
				al.setLength(length);
			}
			
			em.persist(al);
			em.getTransaction().commit();
			
			em.close();
			emFactory.close();
		}
		
		public void deleteAlbum(String albumID){
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
			EntityManager em = emFactory.createEntityManager();
			em.getTransaction().begin();
			
			Album al = em.find(Album.class, albumID);
			
			em.remove(al);
			em.getTransaction().commit();
			
			em.close();
			emFactory.close();
		}
		
		public void findAlbum(String albumID) {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
			EntityManager em = emFactory.createEntityManager();
			
			Album al = em.find(Album.class, albumID);
			
			String title = al.getTitle();
			String releaseDate = al.getReleaseDate();
			String recordingCompanyName = al.getRecordingCompanyName();
			int numberOfTracks = al.getNumberOfTracks();
			String pmrcRating = al.getPmrcRating();
			double length = al.getLength();
			
			System.out.println(title);
			System.out.println(releaseDate);
			System.out.println(recordingCompanyName);
			System.out.println(numberOfTracks);
			System.out.println(pmrcRating);
			System.out.println(length);
			
			em.close();
			emFactory.close();
			
		}
	}

