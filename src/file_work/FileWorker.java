package file_work;

import candle.Candle;
import coordinate_plane.CoordinatePlain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWorker {

    public static ArrayList<Candle> getData(CoordinatePlain coordinatePlain) {
        ArrayList<Candle> data = new ArrayList<>();
        ArrayList<Integer> dataInt = new ArrayList<>();
        try {
            File file = new File("files/data.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                dataInt.add(scanner.nextInt());
            }
            for (int i = 0; i < dataInt.size() / 100; i++) {
                int open = 0;
                int close = 0;
                int max = 0;
                int min = dataInt.get(0);
                for (int j = i * 100; j < i * 100 + 100; j++) {
                    if (j == i * 100) {
                        open = dataInt.get(j);
                    } else if (j == i * 100 + 99) {
                        close = dataInt.get(j);
                    } else {
                        if (dataInt.get(j) > max) {
                            max = dataInt.get(j);
                        }
                        if (dataInt.get(j) < min) {
                            min = dataInt.get(j);
                        }
                    }
                }
                data.add(new Candle(30, open, close, max, min, i, coordinatePlain.getCoordinateXY()[1][0], coordinatePlain.getCoordinateXY()[0][1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
