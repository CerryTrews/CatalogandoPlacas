public class FileHelp {
    public static void main(String[] args) {
        Help hlpobj = new Help("C:\\Users\\Cerry\\IdeaProjects\\Java-HerbertSchildt\\Cap. 10\\10-2\\src\\helpfile.txt");
        String topic;

        System.out.println("Try the help system. ");

        do {
            topic = hlpobj.getSelection();

            if(!hlpobj.helpOn(topic)) {
                System.out.println("Topic not found.\n");
            }
        } while(topic.compareTo("stop") != 0);
    }
}
