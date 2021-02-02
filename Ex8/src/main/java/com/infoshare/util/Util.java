package com.infoshare.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshare.model.ActivityDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private Util() {
    }

    public static void saveActivityToJsonFile(Path path, List<ActivityDTO> activityList) {
        try (FileWriter fileWriter = new FileWriter(path.toString(), false)) {
            GSON.toJson(activityList, fileWriter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<ActivityDTO> readActivitiesFromFile(Path path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()))) {
            Type activityListType = new TypeToken<ArrayList<ActivityDTO>>() {
            }.getType();
            return GSON.fromJson(bufferedReader, activityListType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

}
