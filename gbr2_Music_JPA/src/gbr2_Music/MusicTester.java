package gbr2_Music;

import javax.persistence.*;

public class MusicTester {

	public static void main(String[] args) {
	
	//create, update, and delete new song
		ManageSongs ms = new ManageSongs();
		ms.createSong("Kashmir", 8.37, "songs/kashmir.mp3", "1975-2-24", "1974-6-18");
		ms.updateSong("27e042c7-4382-4ab4-9ece-634342c42df9", "", 0.0, "", "", "1974-7-12");
		ms.deleteSong("27e042c7-4382-4ab4-9ece-634342c42df9");
	
	//create, update, and delete new artist
		ManageArtists mar = new ManageArtists();
		mar.createArtist("Jimmy", "Page", "Led Zeppelin", "");
		mar.updateArtist("defeea52-4f12-4ccf-abc4-6c9b99046ade", "", "", "", "Guitarist from 1968-1980");
		mar.deleteArtist("defeea52-4f12-4ccf-abc4-6c9b99046ade");
		
	//create, update, and delete new album
		ManageAlbums mal = new ManageAlbums();
		mal.createAlbum("Physical Graffiti", "1975-2-24", "Atlantic", 2, "mature", 82.59);
		mal.updateAlbum("890e7d1d-fc61-45be-be6b-9f65a1d1811d", "", "", "", 15, "", 0.0);
		mal.deleteAlbum("890e7d1d-fc61-45be-be6b-9f65a1d1811d");
	}
}
	