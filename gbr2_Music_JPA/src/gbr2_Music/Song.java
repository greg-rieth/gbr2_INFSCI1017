package gbr2_Music;

import java.sql.SQLException;

import javax.persistence.*;

@Entity
@Table (name="song")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "song_id")
	private String songID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "length")
	private double length;
	
	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "record_date")
	private String recordDate;
	
		//constructor for new entries
		public Song() {
			this.songID = java.util.UUID.randomUUID().toString();
		}
		//get song ID
		public String getSongID() {
			return songID;
		}
		//set song ID
		public void setSongID(String songID) {
			this.songID = songID;
		}
		//get title
		public String getTitle() {
			return title;
		}
		//update title in database and object
		public void setTitle(String title) {
			this.title = title;
		}
		//get length
		public double getLength() {
			return length;
		}
		//update length in database and object
		public void setLength(double length) {
			this.length = length;
		}
		//get file path
		public String getFilePath() {
			return filePath;
		}
		//update file path in database and object
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		//get release date
		public String getReleaseDate() {
			return releaseDate;
		}
		//update release date in database and object
		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}
		//get record date
		public String getRecordDate() {
			return recordDate;
		}
		//update record date in database and object
		public void setRecordDate(String recordDate) {
			this.recordDate = recordDate;
		}
}
