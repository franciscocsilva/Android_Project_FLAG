package movies.flag.pt.moviesapp.http.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Formando on 16/01/2018.
 */

public class TestMoviesResponse {

    /**
     * results : [{"vote_count":1472,"id":353486,"video":false,"vote_average":6.4,"title":"Jumanji: Welcome to the Jungle","popularity":729.588318,"poster_path":"/bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg","original_language":"en","original_title":"Jumanji: Welcome to the Jungle","genre_ids":[28,12,35,10751],"backdrop_path":"/rz3TAyd5kmiJmozp3GUbYeB5Kep.jpg","adult":false,"overview":"The tables are turned as four teenagers are sucked into Jumanji's world - pitted against rhinos, black mambas and an endless variety of jungle traps and puzzles. To survive, they'll play as characters from the game.","release_date":"2017-12-08"},{"vote_count":3126,"id":181808,"video":false,"vote_average":7.2,"title":"Star Wars: The Last Jedi","popularity":564.020945,"poster_path":"/xGWVjewoXnJhvxKW619cMzppJDQ.jpg","original_language":"en","original_title":"Star Wars: The Last Jedi","genre_ids":[28,12,14,878],"backdrop_path":"/5Iw7zQTHVRBOYpA0V6z0yypOPZh.jpg","adult":false,"overview":"Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares to do battle with the First Order.","release_date":"2017-12-13"},{"vote_count":1301,"id":354912,"video":false,"vote_average":7.6,"title":"Coco","popularity":425.133888,"poster_path":"/eKi8dIrr8voobbaGzDpe8w0PVbC.jpg","original_language":"en","original_title":"Coco","genre_ids":[12,16,10751,14],"backdrop_path":"/askg3SMvhqEl4OL52YuvdtY40Yb.jpg","adult":false,"overview":"Despite his family\u2019s baffling generations-old ban on music, Miguel dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector, and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history.","release_date":"2017-10-27"},{"vote_count":301,"id":460793,"video":false,"vote_average":5.9,"title":"Olaf's Frozen Adventure","popularity":410.212663,"poster_path":"/47pLZ1gr63WaciDfHCpmoiXJlVr.jpg","original_language":"en","original_title":"Olaf's Frozen Adventure","genre_ids":[12,16,35,10751,14,10402],"backdrop_path":"/woCxv9kua5uqtRNaiWUBDzrgZnH.jpg","adult":false,"overview":"Olaf is on a mission to harness the best holiday traditions for Anna, Elsa, and Kristoff.","release_date":"2017-10-27"},{"vote_count":516,"id":316029,"video":false,"vote_average":8,"title":"The Greatest Showman","popularity":385.29491,"poster_path":"/dfhztJRiElqmYW4kpvjYe1gENsD.jpg","original_language":"en","original_title":"The Greatest Showman","genre_ids":[18,10751,10402,10749],"backdrop_path":"/zpq404Sk7qQ7N4x3xOeNgp74GtU.jpg","adult":false,"overview":"The story of American showman P.T. Barnum, founder of the circus that became the famous traveling Ringling Bros. and Barnum & Bailey Circus.","release_date":"2017-12-20"},{"vote_count":320,"id":399055,"video":false,"vote_average":7.1,"title":"The Shape of Water","popularity":384.424319,"poster_path":"/iLYLADGA5oKGM92Ns1j9CDgk3iI.jpg","original_language":"en","original_title":"The Shape of Water","genre_ids":[12,18,14,27,10749,53],"backdrop_path":"/bAISaVhsaoyyQMZ55cpTwCdzek4.jpg","adult":false,"overview":"An other-worldly story, set against the backdrop of Cold War era America circa 1962, where a mute janitor working at a lab falls in love with an amphibious man being held captive there and devises a plan to help him escape.","release_date":"2017-12-01"},{"vote_count":91,"id":317091,"video":false,"vote_average":4.6,"title":"November Criminals","popularity":287.649409,"poster_path":"/m2JxGgarPvtemudLZ1CB6gLJeUb.jpg","original_language":"en","original_title":"November Criminals","genre_ids":[80,18,9648],"backdrop_path":"/8j089OjNSlmsDqt9vrAAvj021Em.jpg","adult":false,"overview":"Addison Schacht investigates the murder of his friend Kevin, with the help of Pheobe, and they discover the truth is darker than they ever imagined.","release_date":"2017-12-08"},{"vote_count":200,"id":271404,"video":false,"vote_average":4.9,"title":"Beyond Skyline","popularity":264.125425,"poster_path":"/lQUJZIm2nQj4mIsm0sUcznhMdpD.jpg","original_language":"en","original_title":"Beyond Skyline","genre_ids":[28,878],"backdrop_path":"/m5jvdwlI24XpFDSX79o97z76jis.jpg","adult":false,"overview":"A tough-as-nails detective embarks on a relentless pursuit to free his son from a nightmarish alien warship.","release_date":"2017-10-20"},{"vote_count":260,"id":353616,"video":false,"vote_average":6.4,"title":"Pitch Perfect 3","popularity":233.028934,"poster_path":"/hQriQIpHUeh66I89gypFXtqEuVq.jpg","original_language":"en","original_title":"Pitch Perfect 3","genre_ids":[35],"backdrop_path":"/1qIzlhLGPSm6TxlvXBWe0Q5er7O.jpg","adult":false,"overview":"After the highs of winning the world championships, the Bellas find themselves split apart and discovering there aren't job prospects for making music with your mouth. But when they get the chance to reunite for an overseas USO tour, this group of awesome nerds will come together to make some music, and some questionable decisions, one last time.","release_date":"2017-12-21"},{"vote_count":270,"id":371638,"video":false,"vote_average":7.3,"title":"The Disaster Artist","popularity":212.365815,"poster_path":"/uCH6FOFsDW6pfvbbmIIswuvuNtM.jpg","original_language":"en","original_title":"The Disaster Artist","genre_ids":[18,35,36],"backdrop_path":"/bAI7aPHQcvSZXvt7L11kMJdS0Gm.jpg","adult":false,"overview":"An aspiring actor in Hollywood meets an enigmatic stranger by the name of Tommy Wiseau, the meeting leads the actor down a path nobody could have predicted; creating the worst movie ever made.","release_date":"2017-11-30"},{"vote_count":117,"id":406563,"video":false,"vote_average":6.3,"title":"Insidious: The Last Key","popularity":189.492865,"poster_path":"/nb9fc9INMg8kQ8L7sE7XTNsZnUX.jpg","original_language":"en","original_title":"Insidious: The Last Key","genre_ids":[9648,53,27],"backdrop_path":"/auSRjQyVLw212IjATAbO3KOyxZg.jpg","adult":false,"overview":"Parapsychologist Elise Rainier and her team travel to Five Keys, N.M., to investigate a man's claim of a haunting. Terror soon strikes when Rainier realizes that the house he lives in was her family's old home.","release_date":"2018-01-03"},{"vote_count":82,"id":446354,"video":false,"vote_average":6.4,"title":"The Post","popularity":168.312733,"poster_path":"/qyRwj5VvuTRdJ76o2grP93grNxt.jpg","original_language":"en","original_title":"The Post","genre_ids":[18,36],"backdrop_path":"/8sb4aBST28vN3rBz704XJczS0Ld.jpg","adult":false,"overview":"A cover-up that spanned four U.S. Presidents pushed the country's first female newspaper publisher and a hard-driving editor to join an unprecedented battle between journalist and government. Inspired by true events.","release_date":"2017-12-22"},{"vote_count":69,"id":384680,"video":false,"vote_average":5.3,"title":"Hostiles","popularity":166.036556,"poster_path":"/rqoezyB51GfhiloOB5ZErg5HXas.jpg","original_language":"en","original_title":"Hostiles","genre_ids":[12,18,37],"backdrop_path":"/j4F5Bd1pT2KUNToejtXkxVgrBQ3.jpg","adult":false,"overview":"A legendary Native American-hating Army captain nearing retirement in 1892 is given one last assignment: to escort a Cheyenne chief and his family through dangerous territory back to his Montana reservation.","release_date":"2017-12-22"},{"vote_count":177,"id":364689,"video":false,"vote_average":6.5,"title":"Ferdinand","popularity":142.154553,"poster_path":"/qfuoOaCJLwNngfboYM7uxYaZvQx.jpg","original_language":"en","original_title":"Ferdinand","genre_ids":[16,35,10751],"backdrop_path":"/sTOhZruocNubL0HxjvdouwCEL9I.jpg","adult":false,"overview":"Ferdinand, a little bull, prefers sitting quietly under a cork tree just smelling the flowers versus jumping around, snorting, and butting heads with other bulls. As Ferdinand grows big and strong, his temperament remains mellow, but one day five men come to choose the \"biggest, fastest, roughest bull\" for the bullfights in Madrid and Ferdinand is mistakenly chosen.  Based on the classic 1936 children's book by Munro Leaf.","release_date":"2017-12-09"},{"vote_count":76,"id":399035,"video":false,"vote_average":5.4,"title":"The Commuter","popularity":140.938424,"poster_path":"/rDeGK6FIUfVcXmuBdEORPAGPMNg.jpg","original_language":"en","original_title":"The Commuter","genre_ids":[18,53,9648,80],"backdrop_path":"/nlsNr1BEmRgRYYOO24NSHm6BXYb.jpg","adult":false,"overview":"A businessman on his daily commute home gets unwittingly caught up in a criminal conspiracy that threatens not only his life but the lives of those around him.","release_date":"2018-01-11"},{"vote_count":152,"id":301337,"video":false,"vote_average":5.2,"title":"Downsizing","popularity":139.74035,"poster_path":"/uLlmtN33rMuimRq6bu0OoNzCGGs.jpg","original_language":"en","original_title":"Downsizing","genre_ids":[878,18,35],"backdrop_path":"/5RzW9i3vFsXCPLqYwgNJV1QuSgk.jpg","adult":false,"overview":"A kindly occupational therapist undergoes a new procedure to be shrunken to four inches tall so that he and his wife can help save the planet and afford a nice lifestyle at the same time.","release_date":"2017-12-22"},{"vote_count":159,"id":396371,"video":false,"vote_average":6.6,"title":"Molly's Game","popularity":128.685342,"poster_path":"/5YC8iVPxvRrz53FdfdejDgUUk2k.jpg","original_language":"en","original_title":"Molly's Game","genre_ids":[18],"backdrop_path":"/rHcBZ6ZKCe4FalWHyvBGsyMsh0k.jpg","adult":false,"overview":"Molly Bloom, a young skier and former Olympic hopeful becomes a successful entrepreneur (and a target of an FBI investigation) when she establishes a high-stakes, international poker game.","release_date":"2017-12-21"},{"vote_count":188,"id":389015,"video":false,"vote_average":7,"title":"I, Tonya","popularity":123.301175,"poster_path":"/6gNXwSHxaksR1PjVZRqNapmkgj3.jpg","original_language":"en","original_title":"I, Tonya","genre_ids":[18],"backdrop_path":"/jDai0rdlBHhcY8vpJ4XmTIDQU5i.jpg","adult":false,"overview":"Competitive ice skater Tonya Harding rises amongst the ranks at the U.S. Figure Skating Championships, but her future in the activity is thrown into doubt when her ex-husband intervenes.","release_date":"2017-12-08"},{"vote_count":128,"id":480572,"video":false,"vote_average":4.1,"title":"Bullet Head","popularity":113.439476,"poster_path":"/ySmKQPjWnNzuZ5YliQaOVEnWn2.jpg","original_language":"en","original_title":"Bullet Head","genre_ids":[18,80,53],"backdrop_path":"/eL0QAAtFfA0OvnBsY7tJKrFbc9B.jpg","adult":false,"overview":"A group of career criminals finds itself trapped in a warehouse with the law \u2013 and an Attack Dog named DeNiro closing in.","release_date":"2017-12-07"},{"vote_count":35,"id":442064,"video":false,"vote_average":6,"title":"Proud Mary","popularity":102.651683,"poster_path":"/5luceoVMU2FzWuyty7mZFcSY5ZW.jpg","original_language":"en","original_title":"Proud Mary","genre_ids":[53,28],"backdrop_path":"/6vNh2vkfXVL8PoVXVIeZB6DcwbM.jpg","adult":false,"overview":"A hit woman kills a drug boss only to learn that she has left a boy orphaned. A year later, she saves the boy from a dangerous life on the street but finds herself unable to give the boy or herself a fresh start.","release_date":"2018-01-12"}]
     * page : 1
     * total_results : 781
     * dates : {"maximum":"2018-01-14","minimum":"2017-11-27"}
     * total_pages : 40
     */

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("result")
    private ArrayList<TestEntity> movies;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<TestEntity> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<TestEntity> movies) {
        this.movies = movies;
    }
}
