package com.example.myapplication.Utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;

import androidx.annotation.NonNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtiil {
    @NonNull
    public static MappedByteBuffer loadMappedFile(@NonNull Context context, @NonNull String filePath) throws IOException {
        AssetFileDescriptor fileDescriptor = context.getAssets().openFd(filePath);

        MappedByteBuffer var9;
        try {
            FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());

            try {
                FileChannel fileChannel = inputStream.getChannel();
                long startOffset = fileDescriptor.getStartOffset();
                long declaredLength = fileDescriptor.getDeclaredLength();
                var9 = fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
            } catch (Throwable var12) {
                try {
                    inputStream.close();
                } catch (Throwable var11) {
                    var12.addSuppressed(var11);
                }

                throw var12;
            }

            inputStream.close();
        } catch (Throwable var13) {
            if (fileDescriptor != null) {
                try {
                    fileDescriptor.close();
                } catch (Throwable var10) {
                    var13.addSuppressed(var10);
                }
            }

            throw var13;
        }

        if (fileDescriptor != null) {
            fileDescriptor.close();
        }

        return var9;
    }
}
