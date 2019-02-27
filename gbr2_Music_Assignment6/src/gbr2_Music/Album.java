package gbr2_Music;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

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
		this.albumSongs = new Hashtable<String, Song>();
		db = new DbUtilities();
		
		String sql = "INSERT INTO album (album_id, title, release_date, recording_company_name, number_of_tracks, PMRC_rating, length) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setString(1, this.albumID);
			stmt.setString(2, this.title);
			stmt.setString(3, this.releaseDate);
			stmt.setString(4, this.recordingCompanyName);
			stmt.setInt(5, this.numberOfTracks);
			stmt.setString(6, this.pmrcRating);
			stmt.setDouble(7, this.length);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//get title
	public String getTitle() {
		return title;
	}
	//update title in database and object
	public void setTitle(String title) {
		String sql = "UPDATE album SET title = ?;";
		this.title = title;
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setString(1, this.title);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get release date
	public String getReleaseDate() {
		return releaseDate;
	}
	//update release date in database and object
	public void setReleaseDate(String releaseDate) {
		String sql = "UPDATE album SET release_date = ?;";
		this.releaseDate = releaseDate;
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setString(1, this.releaseDate);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get cover image path
	public String getCoverImagePath() {
		return coverImagePath;
	}
	//update cover image path in database and object
	public void setCoverImagePath(String coverImagePath) {
		String sql = "UPDATE album SET cover_image_path = ?;";
		this.coverImagePath = coverImagePath;
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setString(1, this.coverImagePath);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get recording company name
	public String getRecordingCompanyName() {
		return recordingCompanyName;
	}
	//update recording company name in database and object
	public void setRecordingCompanyName(String recordingCompanyName) {
		String sql = "UPDATE album SET recording_company_name = ?;";
		this.recordingCompanyName = recordingCompanyName;
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setString(1, this.recordingCompanyName);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get number of tracks
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	//update number of tracks in database and object
	public void setNumberOfTracks(int numberOfTracks) {
		String sql = "UPDATE album SET number_of_tracks = ?;";
		this.numberOfTracks = numberOfTracks;
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setInt(1, this.numberOfTracks);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get pmrc rating
	public String getPmrcRating() {
		return pmrcRating;
	}
	//update pmrc rating in database and object
	public void setPmrcRating(String pmrcRating) {
		String sql = "UPDATE album SET PMRC_rating = ?;";
		this.pmrcRating = pmrcRating;
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setString(1, this.pmrcRating);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//get length
	public double getLength() {
		return length;
	}
	//update length in database and object
	public void setLength(double length) {
		String sql = "UPDATE album SET length = ?;";
		this.length = length;
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setDouble(1, this.length);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		String sql = "DELETE FROM album WHERE album_id = ?;";
		
		try {
			PreparedStatement stmt = DbUtilities.conn.prepareStatement(sql);
			stmt.setString(1, this.albumID);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
