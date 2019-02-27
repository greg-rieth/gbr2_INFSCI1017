package gbr2_Music;

public class MusicTester {

	public static void main(String[] args) {
	
	//create new song, get ID, set file path, get file path
	Song s1 = new Song("Come Together", 4.19, "1969-10-08", "1969-7-30");
	System.out.println(s1.getSongID());
	s1.setFilePath("songs/cometogether.mp3");
	System.out.println(s1.getFilePath());
	
	//find song entry in database using its ID
	Song testS1 = new Song("2034a33a-dfaa-427a-a5cf-7068cfe420b9");
	
	//create new artist, set bio, find artist entry in database using its ID
	Artist a1 = new Artist("John", "Lennon", "The Beatles")	;
	a1.setBio("Rhythm guitarist, singer/songwriter");
	Artist testA1 = new Artist(a1.getArtistID());
	
	//add artist to song artists 
	s1.addArtist(a1);
	System.out.println(s1.getSongArtists());
	
	//create new album, set cover image path, and find album entry in database
	Album al1 = new Album("Abbey Road", "1969-09-26", "Apple Records", 17, "mature", 47.23);
	al1.setCoverImagePath("images/abbeyroad.jpg");
	Album testAl1 = new Album(al1.getAlbumID());
	
	//add song to album songs
	al1.addSong(s1);
	System.out.println(al1.getAlbumSongs());
	
	//create new album, set cover image path, and find album entry in database
	Album al2 = new Album("Revolver", "1966-08-05", "Parlophone", 14, "mature", 35.01);
	al2.setCoverImagePath("images/revolver.jpg");
	Album testAl2 = new Album(al2.getAlbumID());
	
	//delete album from database
	al2.deleteAlbum(al2.getAlbumID());
		
	
	}
}
