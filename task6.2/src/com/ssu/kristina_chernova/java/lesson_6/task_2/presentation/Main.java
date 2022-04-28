package com.ssu.kristina_chernova.java.lesson_6.task_2.presentation;

import java.io.File;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws Exception {
        Main app = new Main();
        app.startApplication();
    }

    private final Scanner in = new Scanner(System.in);

    private static void startApplication() {
        while (true) {
            System.out.println("\n1.\tFind a file with max count of letter 's' \n" +
                    "2.\tTop-5 files with max size\n" +
                    "3.\tAverage size of file\n" +
                    "4.\tCounts of files sorted by first letters\n" +
                    "0.\tExit\n");

                Scanner inSc = new Scanner(System.in);
                int choice = inSc.nextInt();

                diskAnalyzer("C:/tessa/", choice);
        }
    }

    private static void diskAnalyzer(String directoryWay, int numOfCommand) {
        switch (numOfCommand) {
            case 0 -> exit(0);
            //1.	Поиск имени файла с максимальным количеством букв ‘s’ в имени,
            // вывод пути к нему
            case 1 -> {
                CountSObject file = new CountSObject();
                findFileWithMaxCountOfLetterS(directoryWay, file);
                System.out.println("Count s: " + file.getSize() + " Name: " + file.getName() +
                        "Path: " + file.getPath());
            }
            //2.	Top-5 файлов с самым большим размером
            case 2 -> {
                List<PairIntString> averageSizeFind = new ArrayList<PairIntString>();
                sizeList(directoryWay, averageSizeFind);

                for (int i = 0; i < averageSizeFind.size() - 1; ++i){
                    for (int j = 0; j < averageSizeFind.size(); ++j ){
                        if (averageSizeFind.get(i).getSize() > averageSizeFind.get(j).getSize()){
                            var current = averageSizeFind.get(i);
                            averageSizeFind.set(i, averageSizeFind.get(j));
                            averageSizeFind.set(j, current);
                        }
                    }
                }
                for (int i = 0; i < 5; ++i) {
                    PairIntString item = averageSizeFind.get(i);
                    System.out.println("Size: " + item.getSize() + " Name: " + item.getName());
                }

            }
            //3.	Средний размер файла в указанной директории или любой ее поддиректории
            case 3 -> {
                List<PairIntString> averageSizeFind = new ArrayList<PairIntString>();
                sizeList(directoryWay, averageSizeFind);

                System.out.println("Average size: " + averageSize(averageSizeFind));
            }
            //4.	Количество файлов и папок разбитое по первым буквам алфавита
            // (например на букву A – начинается 100 000 файлов и 200 папок)
            case 4 -> {
                Map<Character, Pair> dictionary = new TreeMap<Character, Pair>();
                countOfFilesAndDirectoriesWithAlphabetLettersSort(directoryWay, dictionary);
                for (Map.Entry<Character, Pair> item : dictionary.entrySet()
                ) {
                    System.out.println("Letter: " + item.getKey() + " Files: " + item.getValue().getCountFiles()
                            + " Folders: " + item.getValue().getCountFolders());
                }
            }
            default -> System.out.println("Enter correct action!");

        }
    }
        public static class Pair {
        private int countFiles;
        private int countFolders;

            public int getCountFiles() {return countFiles;}
            public void setCountFiles(int newCountFiles) {countFiles = newCountFiles;}

            public int getCountFolders() {return countFolders;}
            public void setCountFolders(int newCountFolders) {countFolders = newCountFolders;}
        }

    public static class PairIntString {
        private int size;
        private String name;

        public int getSize() {return size;}
        public void setSize(int newSize) {size = newSize;}

        public String getName() {return name;}
        public void setName(String newName) {name = newName;}
    }

    public static class CountSObject {
        private int size;
        private String name;
        private String path;

        public int getSize() {return size;}
        public void setSize(int newSize) {size = newSize;}

        public String getName() {return name;}
        public void setName(String newName) {name = newName;}

        public String getPath() {return path;}
        public void setPath(String newPath) {path = newPath;}
    }

    private static void countOfFilesAndDirectoriesWithAlphabetLettersSort(String directoryWay, Map<Character, Pair> dict) {
        File dir = new File(directoryWay);
        for (File f : dir.listFiles()) {
            if (f.isFile()) {
                char firstLetter = f.getName().toLowerCase().toCharArray()[0];

                if (dict.containsKey(firstLetter))
                {
                    Pair dictPair = dict.get(firstLetter);
                    dictPair.countFiles += 1;
                }
                else{
                    Pair newPair = new Pair();
                    newPair.setCountFiles(1);
                    newPair.setCountFolders(0);
                    dict.put(firstLetter, newPair);
                }

            } else if (f.isDirectory()) {
                char firstLetter = f.getName().toLowerCase().toCharArray()[0];

                if (dict.containsKey(firstLetter))
                {
                    Pair dictPair = dict.get(firstLetter);
                    dictPair.countFolders += 1;
                }
                else{
                    Pair newPair = new Pair();
                    newPair.setCountFiles(0);
                    newPair.setCountFolders(1);
                    dict.put(firstLetter, newPair);
                }

                countOfFilesAndDirectoriesWithAlphabetLettersSort(f.getAbsolutePath(), dict);
            }
        }
    }

    private static void findFileWithMaxCountOfLetterS(String directoryWay, CountSObject file) {
        File dir = new File(directoryWay);
        //System.out.println(dir);
        for (File f : dir.listFiles()) {
            if (f.isFile()) {
                int count = 0;

                for (char element : f.getName().toLowerCase().toCharArray()) {
                    if (element == 's') count++;
                }

                if (count > file.getSize()){
                    file.setSize(count);
                    file.setName(f.getName());
                    file.setPath(f.getPath());
                }

            } else if (f.isDirectory()) {
                findFileWithMaxCountOfLetterS(f.getAbsolutePath(), file);
            }
        }
    }


    private static void sizeList(String directoryWay,List <PairIntString> averageSizeFind) {
        File dir = new File(directoryWay);
        for (File f : dir.listFiles()) {
            if (f.isFile()) {
                int size = (int) f.length();

                PairIntString newPair = new PairIntString();
                newPair.setSize(size);
                newPair.setName(f.getName());
                averageSizeFind.add(newPair);

            } else if (f.isDirectory()) {
                sizeList(f.getAbsolutePath(), averageSizeFind);
            }
        }
    }

    private static int averageSize(List <PairIntString> averageSizeFind) {
        List<Integer> arrayOfInt = new ArrayList<Integer>();
        for(PairIntString item: averageSizeFind){
            arrayOfInt.add(item.getSize());
        }
        arrayOfInt.stream().sorted();
        int median;
        if (arrayOfInt.size() % 2 == 0)
            median = ((int)arrayOfInt.toArray()[arrayOfInt.size()/2] + (int)arrayOfInt.toArray()[arrayOfInt.size()/2 - 1])/2;
        else
            median = (int) arrayOfInt.toArray()[arrayOfInt.size()/2];

        return median;
    }

}
