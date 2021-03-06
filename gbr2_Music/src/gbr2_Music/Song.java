package gbr2_Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class Song {
	
	//declare fields
	private String songID;
	private String title;
	private double length;
	private String filePath;
	private String releaseDate;
	private String recordDate;
	private Map<String, Artist> songArtists;
	private DbUtilities db;
	
	//constructor for retrieving database entries
	public Song(String songID) {
		this.songID = songID;
		db = new DbUtilities();
		
		String sql = "SELECT title, length, release_date, record_date FROM song WHERE song_id = '" + this.songID + "';";
		//try to retrieve result set for song and print out
		try {
			ResultSet rs = db.getResultSet(sql);
			if(rs.next()) {
				this.title = rs.getString("title");
				System.out.println(this.title);
				this.length = rs.getDouble("length");
				System.out.println(this.length);
				this.releaseDate = rs.getString("release_date");
				System.out.println(this.releaseDate);
				this.recordDate = rs.getString("record_date");
				System.out.println(this.recordDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//constructor for creating new database entries
	public Song(String title, double length, String releaseDate, String recordDate) {
		this.title = title; 
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		this.songID = java.util.UUID.randomUUID().toString();
		this.songArtists = new TreeMap<String, Artist>();
		
		String sql = "INSERT INTO song (song_id, title, length, release_date, record_date) VALUES ('" + songID + "', '" + title + "', '" + length + "', '" + releaseDate + "', '" + recordDate + "');";
		
		db = new DbUtilities();
		db.executeQuery(sql);
	}
	
	//get song ID
	public String getSongID() {
		return songID;
	}
	//get title
	public String getTitle() {
		return title;
	}
	//update title in database and object
	public void setTitle(String title) {
		String sql = "UPDATE song SET title = '" + title + "';";
		this.title = title;
		
		db.executeQuery(sql);
	}
	//get length
	public double getLength() {
		return length;
	}
	//update length in database and object
	public void setLength(double length) {
		String sql = "UPDATE song SET length = '" + length + "';";
		this.length = length;
		
		db.executeQuery(sql);
	}
	//get file path
	public String getFilePath() {
		return filePath;
	}
	//update file path in database and object
	public void setFilePath(String filePath) {
		String sql = "UPDATE song SET file_path = '" + filePath + "';";
		this.filePath = filePath;

		db.executeQuery(sql);
	}
	//get release date
	public String getReleaseDate() {
		return releaseDate;
	}
	//update release date in database and object
	public void setReleaseDate(String releaseDate) {
		String sql = "UPDATE song SET release_date = '" + releaseDate + "';";
		this.releaseDate = releaseDate;
	
		db.executeQuery(sql);
	}
	//get record date
	public String getRecordDate() {
		return recordDate;
	}
	//update record date in database and object
	public void setRecordDate(String recordDate) {
		String sql = "UPDATE song SET record_date = '" + recordDate + "';";
		this.recordDate = recordDate;
	
		db.executeQuery(sql);
	}
	//get song artists
	public Map<String, Artist> getSongArtists() {
		return songArtists;
	}
	//delete song from database (NOTE: I couldn't destroy the associated object within this method without getting Null Pointer Exception)
	public void deleteSong(String songID) {
		String sql = "DELETE FROM song WHERE song_id = '" + songID + "';";
		
		db.executeQuery(sql);
	}
	//add artist to list of song artists
	public void addArtist(Artist artist) {
		
		songArtists.put(artist.getArtistID(), artist);
	}
	//delete artist from list of song artists using ID
	public void deleteArtist(String artistID) {
		
		songArtists.remove(artistID);
	}
	//delete artist from list of song artists using object
	public void deleteArtist(Artist artist) {
		
		songArtists.remove(artist.getArtistID(), artist);
	}
}
