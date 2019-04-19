package gbr2_Music;

import java.sql.SQLException;

import javax.persistence.*;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table (name="artist")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "artist_id")
	private String artistID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "band_name")
	private String bandName;
	
	@Column(name = "bio")
	private String bio;
		
		//constructor for new entries
		public Artist() {
			this.artistID = java.util.UUID.randomUUID().toString();
		}
		//get first name
		public String getFirstName() {
			return firstName;
		}
		//update first name in database and object
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		//get last name
		public String getLastName() {
			return lastName;
		}
		//update last name in database and object
		public void setLastName(String lastName) {	
			this.lastName = lastName;
		}
		//get band name
		public String getBandName() {
			return bandName;
		}
		//update band name in database and object
		public void setBandName(String bandName) {
			this.bandName = bandName;
		}
		//get bio
		public String getBio() {
			return bio;
		}
		//update bio in database and object
		public void setBio(String bio) {
			this.bio = bio;
		}
		//get artist ID
		public String getArtistID() {
			return artistID;
		}
		//set artist ID
		public void setArtistID(String artistID) {
			this.artistID = artistID;
		}
		
		public JSONObject toJSON() {
			JSONObject artistJson = new JSONObject();
			try {
				artistJson.put("artist_id", this.artistID);
				artistJson.put("first_name", this.firstName);
				artistJson.put("last_name", this.lastName);
				artistJson.put("band_name", this.bandName);
				artistJson.put("bio", this.bio);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return artistJson;
		}
}
