package gbr2_Music;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Artist {
	
	//declare fields
	private String artistID;
	private String firstName;
	private String lastName;
	private String bandName;
	private String bio;
	private DbUtilities db;
	
	//constructor for retrieving database entries
	public Artist(String artistID) {
		this.artistID = artistID;
		db = new DbUtilities();
		
		String sql = "SELECT first_name, last_name, band_name, bio FROM artist WHERE artist_id = '" + this.artistID + "';";
		//try to retrieve result set for artist and print out
		try {
			ResultSet rs = db.getResultSet(sql);
			if(rs.next()) {
				this.firstName = rs.getString("first_name");
				System.out.println(this.firstName);
				this.lastName = rs.getString("last_name");
				System.out.println(this.lastName);
				this.bandName = rs.getString("band_name");
				System.out.println(this.bandName);
				this.bio = rs.getString("bio");
				System.out.println(this.bio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//constructor for creating new database entries
	public Artist(String firstName, String lastName, String bandName) {
		this.firstName = firstName; 
		this.lastName = lastName;
		this.bandName = bandName;
		this.artistID = java.util.UUID.randomUUID().toString();
		db = new DbUtilities();
		
		String sql = "INSERT INTO artist (artist_id, first_name, last_name, band_name) VALUES ('" + artistID + "', '" + firstName + "', '" + lastName + "', '" + bandName + "');";
		
		db.executeQuery(sql);
	}
	
	//get first name
	public String getFirstName() {
		return firstName;
	}
	//update first name in database and object
	public void setFirstName(String firstName) {
		String sql = "UPDATE artist SET first_name = '" + firstName + "';";
		this.firstName = firstName;
		
		db.executeQuery(sql);
	}
	//get last name
	public String getLastName() {
		return lastName;
	}
	//update last name in database and object
	public void setLastName(String lastName) {
		String sql = "UPDATE artist SET last_name = '" + lastName + "';";
		this.lastName = lastName;
		
		db.executeQuery(sql);
	}
	//get band name
	public String getBandName() {
		return bandName;
	}
	//update band name in database and object
	public void setBandName(String bandName) {
		String sql = "UPDATE artist SET band_name = '" + bandName + "';";
		this.bandName = bandName;
		
		db.executeQuery(sql);
	}
	//get bio
	public String getBio() {
		return bio;
	}
	//update bio in database and object
	public void setBio(String bio) {
		String sql = "UPDATE artist SET bio = '" + bio + "';";
		this.bio = bio;
		
		db.executeQuery(sql);
	}
	//get artist ID
	public String getArtistID() {
		return artistID;
	}
	//delete artist from database (NOTE: I couldn't destroy the associated object within this method without getting Null Pointer Exception)
	public void deleteArtist(String artistID) {
		String sql = "DELETE FROM artist WHERE artist_id = '" + artistID + "';";
		
		db.executeQuery(sql);
	}
}
