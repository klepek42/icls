package fhdw.mfwx413.flyingdutchmen.icls.utilities;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fhdw.mfwx413.flyingdutchmen.icls.data.User;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;

/**
 * Created by edgar on 23.02.2016.
 * Responsibility: 23.02.2016
 */
public class csvExport {

    // Save data in csv and rebuild it
   //public static void saveToCsv(String fileName, UserCollection givenData) throws IOException {
    public static void saveUserToCsv( List<String[]> userList) throws IOException {

        Context mContext;
        CSVWriter mWriter;

        // Read the android path where the file should be saved (/downloads for testing)
        String baseDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = "users.csv";
        String filePath = baseDir + File.separator + fileName;
        Log.d("path", "" + filePath);
        //String downloads = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        mWriter = new CSVWriter(new FileWriter(filePath));

        List<String[]> test = userList;

        // Write all data to the file
        //mWriter.writeNext(writeData);
        mWriter.writeAll(test); //List String [] ArrayList erwartet

        // Quit the output stream
        mWriter.close();
    }

    // Save data in csv and rebuild it
    //public static void saveToCsv(String fileName, UserCollection givenData) throws IOException {
    public static void saveProgressToCsv( List<String[]> progressList) throws IOException {

        Context mContext;
        CSVWriter mWriter;

        // Read the android path where the file should be saved (/downloads for testing)
        String baseDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = "progress.csv";
        String filePath = baseDir + File.separator + fileName;
        Log.d("path", "" + filePath);
        //String downloads = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        mWriter = new CSVWriter(new FileWriter(filePath));

        List<String[]> test = progressList;

        // Write all data to the file
        //mWriter.writeNext(writeData);
        mWriter.writeAll(test);

        // Quit the output stream
        mWriter.close();
    }


/*
    public void write(String fileName, String data) {
        Writer writer;
        String absolutePath;

        File root = Environment.getExternalStorageDirectory();
        File outDir = new File(root.getAbsolutePath() + File.separator + "EZ_time_tracker");
        if (!outDir.isDirectory()) {
            outDir.mkdir();
        }
        try {
            if (!outDir.isDirectory()) {
                throw new IOException(
                        "Unable to create directory EZ_time_tracker. Maybe the SD card is mounted?");
            }
            File outputFile = new File(outDir, fileName);
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(data);
            Toast.makeText(context.getApplicationContext(),
                    "Report successfully saved to: " + outputFile.getAbsolutePath(),
                    Toast.LENGTH_LONG).show();
            writer.close();
        } catch (IOException e) {
            Log.w("eztt", e.getMessage(), e);
        }

    }*/


    /*
    String baseDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
    String fileName = "AnalysisData.csv";
    String filePath = baseDir + File.separator + fileName;
    File f = new File(filePath );
    CSVWriter writer;
// File exist
    if(f.exists() && !f.isDirectory()){
        mFileWriter = new FileWriter(filePath , true);
        writer = new CSVWriter(mFileWriter);
    }
    else {
        writer = new CSVWriter(new FileWriter(filePath));
    }
    String data[] = {};
    data.add("a", "b");

    writer.writeNext(data);

    writer.close();*/

}