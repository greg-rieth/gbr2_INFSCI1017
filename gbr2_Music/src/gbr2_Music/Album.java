package gbr2_Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class Album {

	//declare fields
	private String albumID;
	private String title;
	private String releaseDate;
	private String coverImagePath;
	private String recordingCompanyName;
	private int numberOfTracks;
	private String pmrcRating;
	private double length;
	private Map<String,Song> albumSongs;
	private DbUtilities db;
	
	//constructor for retrieving database entries
	public Album(String albumID) {
		this.albumID = albumID;
		db = new DbUtilities();
		
		String sql = "SELECT title, release_date, recording_company_name, number_of_tracks, PMRC_rating, length FROM album WHERE album_id = '" + this.albumID + "';";
		//try to retrieve result set for album and print out
		try {
			ResultSet rs = db.getResultSet(sql);
			if(rs.next()) {
				this.title = rs.getString("title");
				System.out.println(this.title);
				this.releaseDate = rs.getString("release_date");
				System.out.println(this.releaseDate);
				this.recordingCompanyName = rs.getString("recording_company_name");
				System.out.println(this.recordingCompanyName);
				this.numberOfTracks = rs.getInt("number_of_tracks");
				System.out.println(this.numberOfTracks);
				this.pmrcRating = rs.getString("PMRC_rating");
				System.out.println(this.pmrcRating);
				this.length = rs.getDouble("length");
				System.out.println(this.length);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//constructor for creating new database entries
	public Album(String title, String releaseDate, String recordingCompanyName, int numberOfTracks, String pmrcRating, double length) {
		this.title = title; 
		this.releaseDate = releaseDate;
		this.recordingCompanyName = recordingCompanyName;
		this.numberOfTracks = numberOfTracks;
		this.pmrcRating = pmrcRating;
		this.length = length;
		this.albumID = java.util.UUID.randomUUID().toString();
		this.albumSongs = new TreeMap<String, Song>();
		db = new DbUtilities();
		
		String sql = "INSERT INTO album (album_id, title, release_date, recording_company_name, number_of_tracks, PMRC_rating, length) VALUES ('" + albumID + "', '" + title + "', '" + releaseDate + "', '" + recordingCompanyName + "', '" + numberOfTracks + "', '" + pmrcRating + "', '" + length + "');";
		
		db.executeQuery(sql);
	}
	
	//get title
	public String getTitle() {
		return title;
	}
	//update title in database and object
	public void setTitle(String title) {
		String sql = "UPDATE album SET title = '" + title + "';";
		this.title = title;
		
		db.executeQuery(sql);
	}
	//get release date
	public String getReleaseDate() {
		return releaseDate;
	}
	//update release date in database and object
	public void setReleaseDate(String releaseDate) {
		String sql = "UPDATE album SET release_date = '" + releaseDate + "';";
		this.releaseDate = releaseDate;
		
		db.executeQuery(sql);
	}
	//get cover image path
	public String getCoverImagePath() {
		return coverImagePath;
	}
	//update cover image path in database and object
	public void setCoverImagePath(String coverImagePath) {
		String sql = "UPDATE album SET cover_image_path = '" + coverImagePath + "';";
		this.coverImagePath = coverImagePath;
		
		db.executeQuery(sql);
	}
	//get recording company name
	public String getRecordingCompanyName() {
		return recordingCompanyName;
	}
	//update recording company name in database and object
	public void setRecordingCompanyName(String recordingCompanyName) {
		String sql = "UPDATE album SET recording_company_name = '" + recordingCompanyName + "';";
		this.recordingCompanyName = recordingCompanyName;
		
		db.executeQuery(sql);
	}
	//get number of tracks
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	//update number of tracks in database and object
	public void setNumberOfTracks(int numberOfTracks) {
		String sql = "UPDATE album SET number_of_tracks = '" + numberOfTracks + "';";
		this.numberOfTracks = numberOfTracks;
		
		db.executeQuery(sql);
	}
	//get pmrc rating
	public String getPmrcRating() {
		return pmrcRating;
	}
	//update pmrc rating in database and object
	public void setPmrcRating(String pmrcRating) {
		String sql = "UPDATE album SET PMRC_rating = '" + pmrcRating + "';";
		this.pmrcRating = pmrcRating;
		
		db.executeQuery(sql);
	}
	//get length
	public double getLength() {
		return length;
	}
	//update length in database and object
	public void setLength(double length) {
		String sql = "UPDATE album SET length = '" + length + "';";
		this.length = length;
		
		db.executeQuery(sql);
	}
	//get album songs
	public Map<String, Song> getAlbumSongs() {
		return albumSongs;
	}
	//get album ID
	public String getAlbumID() {
		return albumID;
	}
	//delete album from database (NOTE: I couldn't destroy the associated object within this method without getting Null Pointer Exception)
	public void deleteAlbum(String albumID) {
		String sql = "DELETE FROM album WHERE album_id = '" + albumID + "';";
		
		db.executeQuery(sql);
	}
	//add song to list of album songs
	public void addSong(Song song) {
		
		albumSongs.put(song.getSongID(), song);
	}
	//delete song from list of album songs using ID
	public void deleteSong(String songID) {
		
		albumSongs.remove(songID);
	}
	//delete song from list of album songs using object
	public void deleteSong(Song song) {
		
		albumSongs.remove(song.getSongID(), song);
	}
}
