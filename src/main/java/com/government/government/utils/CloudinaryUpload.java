package com.government.government.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryUpload {
    Cloudinary cloudinary;
    private Map<String, String> valeMap =  new HashMap<>();

    public CloudinaryUpload(){
        valeMap.put("cloud_name", "laganch");
        valeMap.put("api_key", "772289742493398");
        valeMap.put("api_secret", "G22pApbNiOVM-Ydb1e6Q3_dwR88");
        cloudinary = new Cloudinary(valeMap);
    }



    public  Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }
    public Map delete(String id) throws IOException {
        return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }
    public File convert(@org.jetbrains.annotations.NotNull MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());

        fileOutputStream.close();

        return file;
    }
}
