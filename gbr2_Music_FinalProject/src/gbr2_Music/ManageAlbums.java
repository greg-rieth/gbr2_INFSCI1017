package gbr2_Music;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONArray;

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
		
		public Album getAlbum(String albumID){
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
			EntityManager em = emFactory.createEntityManager();
			em.getTransaction().begin();
			
			Album al = em.find(Album.class, albumID);
				
			em.close();
			emFactory.close();
			return al;
		}
		
		public JSONArray getAlbumList(String searchTerm, String searchType){
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("gbr2_Music_JPA");
			EntityManager em = emFactory.createEntityManager();
			//query database according by search term 
			String qry = "SELECT al.albumID FROM Album al ";
			
			if(!searchTerm.equals("")){
				if(searchType.equalsIgnoreCase("equals")){
					qry += "WHERE al.title = '" + searchTerm + "'";
				}
				else if(searchType.equalsIgnoreCase("begin")){
					qry += "WHERE al.title LIKE '" + searchTerm + "%'";
				}
				else if(searchType.equalsIgnoreCase("ends")){
					qry += "WHERE al.title LIKE '%" + searchTerm + "'";
				}
				else{
					qry += "WHERE al.title LIKE '%" + searchTerm + "%'";
				}
			}
			
			//create JSON array of returned albums
			List<String> albumIDs = em.createQuery(qry).getResultList();
			JSONArray albumListJSON = new JSONArray();
			for(String albumID : albumIDs){
				Album al = em.find(Album.class, albumID);
				albumListJSON.put(al.toJSON());
			}
			em.close();
			emFactory.close();
			
			return albumListJSON;
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

