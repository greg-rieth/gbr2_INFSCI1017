package gbr2_Music;

import java.sql.SQLException;

import javax.persistence.*;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table (name="album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "album_id")
	private String albumID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "cover_image_path")
	private String coverImagePath;
	
	@Column(name = "recording_company_name")
	private String recordingCompanyName;
	
	@Column(name = "number_of_tracks")
	private int numberOfTracks;
	
	@Column(name = "PMRC_rating")
	private String pmrcRating;
	
	@Column(name = "length")
	private double length;
		
		//constructor for new entries
		public Album() {
			this.albumID = java.util.UUID.randomUUID().toString();
		}
		//get title
		public String getTitle() {
			return title;
		}
		//update title in database and object
		public void setTitle(String title) {
			this.title = title;
		}
		//get release date
		public String getReleaseDate() {
			return releaseDate;
		}
		//update release date in database and object
		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}
		//get cover image path
		public String getCoverImagePath() {
			return coverImagePath;
		}
		//update cover image path in database and object
		public void setCoverImagePath(String coverImagePath) {
			this.coverImagePath = coverImagePath;
		}
		//get recording company name
		public String getRecordingCompanyName() {
			return recordingCompanyName;
		}
		//update recording company name in database and object
		public void setRecordingCompanyName(String recordingCompanyName) {
			this.recordingCompanyName = recordingCompanyName;
		}
		//get number of tracks
		public int getNumberOfTracks() {
			return numberOfTracks;
		}
		//update number of tracks in database and object
		public void setNumberOfTracks(int numberOfTracks) {
			this.numberOfTracks = numberOfTracks;
		}
		//get pmrc rating
		public String getPmrcRating() {
			return pmrcRating;
		}
		//update pmrc rating in database and object
		public void setPmrcRating(String pmrcRating) {	
			this.pmrcRating = pmrcRating;
		}
		//get length
		public double getLength() {
			return length;
		}
		//update length in database and object
		public void setLength(double length) {
			this.length = length;
		}
		//get album ID
		public String getAlbumID() {
			return albumID;
		}
		//set album ID
		public void setAlbumID(String albumID) {
			this.albumID = albumID;
		}
		
		public JSONObject toJSON() {
			JSONObject albumJson = new JSONObject();
			try {
				albumJson.put("album_id", this.albumID);
				albumJson.put("title", this.title);
				albumJson.put("release_date", this.releaseDate);
				albumJson.put("cover_image_path", this.coverImagePath);
				albumJson.put("recording_company_name", this.recordingCompanyName);
				albumJson.put("number_of_tracks", this.numberOfTracks);
				albumJson.put("PMRC_rating", this.pmrcRating);
				albumJson.put("length", this.length);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return albumJson;
		}
}
