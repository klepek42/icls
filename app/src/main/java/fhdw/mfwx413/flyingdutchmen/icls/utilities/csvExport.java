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

    // Create folders
    public static void buildFolders(Context context) throws FileNotFoundException {

        // Create folder under internal storage location of the app
        File iclsInternalFolder = new File(context.getFilesDir().toString() + "/UserProgresses/");
        // Build directory
        iclsInternalFolder.mkdirs();

        // Create folder "ICLS" in external storage
        File iclsExternalFolder = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/ICLS/");
        // Build directory
        iclsExternalFolder.mkdirs();
    }

    // Copy all assets and save them in internal and external storage
    public static void copyAssets(Context context) {
        AssetManager assetManager = context.getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");

        } catch (IOException e) {
            Log.e("IOException", "Failed to get asset file list.", e);
        }
        if (files != null) for (String filename : files) {
            // Save in internal storage
            if (filename.equals("users.csv")) {
                InputStream in = null;
                OutputStream out = null;
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
            // Save in external storage under "ICLS" folder
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
    // Internal copy function for copyAssets()
    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    // Save all users
    public static void saveUserToCsv(Context context, List<String[]> userList) throws IOException {

        CSVWriter mWriter;

        // Read the android path where the file should be saved
        String baseDir = context.getFilesDir().toString();
        String fileName = "users.csv";
        String filePath = baseDir + File.separator + fileName;
        Log.d("path", "" + filePath);
        mWriter = new CSVWriter(new FileWriter(filePath), ';', CSVWriter.NO_QUOTE_CHARACTER);

        List<String[]> data = userList;

        // Write all data to the file
        mWriter.writeAll(data);

        // Quit the output stream
        mWriter.close();
    }


    // Save all progresses
    // DIESE FUNKTION IST VERALTET, BITTE DIE NEUE DADRUNTER BENUTZEN
    public static void saveProgressToCsv( List<String[]> progressList) throws IOException {

        CSVWriter mWriter;

        // Read the android path where the file should be saved
        String baseDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = "progress.csv";
        String filePath = baseDir + File.separator + fileName;
        Log.d("path", "" + filePath);
        mWriter = new CSVWriter(new FileWriter(filePath), ';', CSVWriter.NO_QUOTE_CHARACTER);

        List<String[]> data = progressList;

        // Write all data to the file
        mWriter.writeAll(data);

        // Quit the output stream
        mWriter.close();
    }

    // Create an user progress file for a given user
    public static void saveUserProgressToCsv( List<String[]> progressList, String userName, Context context) throws IOException {

        CSVWriter mWriter;

        // Read the android path where the file should be saved
        String baseDir = context.getFilesDir().toString() + "/UserProgresses";
        String fileName = "progress_" + userName + ".csv";
        String filePath = baseDir + File.separator + fileName;
        Log.d("path", "" + filePath);
        mWriter = new CSVWriter(new FileWriter(filePath), ';', CSVWriter.NO_QUOTE_CHARACTER);

        List<String[]> data = progressList;

        // Write all data to the file
        mWriter.writeAll(data);

        // Quit the output stream
        mWriter.close();
    }

}