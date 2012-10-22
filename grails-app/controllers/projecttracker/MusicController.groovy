package projecttracker
 

class MusicController {

    def index() {
		

		 Song s = new Song(2,5,3,12);
		 
		 def song =  s.getCompleteSongStringHtmlFormat();
		 		 
		 return[songInView: song]
		 
		 }
	
 
	
}
