package fhdw.mfwx413.flyingdutchmen.icls.utilities;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    private static Context context;

    // Create ICLS folder (this function could also be implemented directly in copyAssets() )
    public static void buildFolders(Context context) throws FileNotFoundException {

        // Choose folder name and create File object
        File iclsInternalFolder = new File(context.getFilesDir().toString() + "/UserProgresses/");
        // Build directory
        iclsInternalFolder.mkdirs();

        // INTERESSANT FUER DIE ERSTELLUNG DER DATEIEN
        // Create a File object for the output file
        //File outputFile = new File(wallpaperDirectory, "");
        // Now attach the OutputStream to the file object, instead of a String representation
        //FileOutputStream fos = new FileOutputStream(outputFile);
    }

    // TEST: Copy all assets and save them in external storage (SD card location) in ICLS folder
    public static void copyAssets(Context context) {
        AssetManager assetManager = context.getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");

        } catch (IOException e) {
            Log.e("IOException", "Failed to get asset file list.", e);
        }
        if (files != null) for (String filename : files) {
            if (filename.equals("users.csv")) {
                InputStream in = null;
                OutputStream out = null;
                //FileOutputStream outputStream;
                try {
                    in = assetManager.open(filename);
                    File outFile = new File(context.getFilesDir(), filename);
                    out = new FileOutputStream(outFile);
                    copyFile(in, out);
                } catch (IOException e) {
                    Log.e("IOException", "Failed to copy asset file: " + filename, e);
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            // ERROR
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            // ERROR
                        }
                    }
                }
            }
            else if(filename.equals("challenges.csv") || filename.equals("index.csv")){
                    InputStream in = null;
                    OutputStream out = null;
                    try {
                        in = assetManager.open(filename);
                        File outFile = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/", filename);
                        out = new FileOutputStream(outFile);
                        copyFile(in, out);
                    } catch (IOException e) {
                        Log.e("IOException", "Failed to copy asset file: " + filename, e);
                    } finally {
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e) {
                                // ERROR
                            }
                        }
                        if (out != null) {
                            try {
                                out.close();
                            } catch (IOException e) {
                                // ERROR
                            }
                        }
                    }
            }
        }
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

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

    // FUER initiales UserProgress erzeugen
    public static void saveUserProgressToCsv( List<String[]> progressList, String userName, Context context) throws IOException {

        CSVWriter mWriter;

        // Read the android path where the file should be saved
        String baseDir = context.getFilesDir().toString() + "/UserProgresses";
        String fileName = "progress_" + userName + ".csv";
        String filePath = baseDir + File.separator + fileName;
        Log.d("path", "" + filePath);
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