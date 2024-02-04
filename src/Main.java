import java.util.*;
public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Album1","Amr Diab");

        album.addSong("Tmaly M3ak",4.5);
        album.addSong("Ally El Wada3",3.7);
        album.addSong("Noor El 3in",5.2);
        albums.add(album);

        album = new Album("Album2","Tamer Hosny");

        album.addSong("Nasiny Leh",5);
        album.addSong("Erga3ly",3.5);
        album.addSong("Ya Ta3ebny",4.3);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Ally El Wada3",playList_1);
        albums.get(0).addToPlayList("Noor El 3in",playList_1);
        albums.get(1).addToPlayList("Tmaly M3ak",playList_1);
        albums.get(1).addToPlayList("Nasiny Leh",playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                                System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options :");
        System.out.println("Press 0 : to quit\n"+
                "Press 1 : to play next song\n"+
                "Press 2 : to play previous song\n"+
                "Press 3 : to replay the current song\n"+
                "Press 4 : list of all songs \n"+
                "Press 5 : print all available options\n"+
                "Press 6 : delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }
}