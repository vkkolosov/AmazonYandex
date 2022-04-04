package com.hblack.amazonyandex.service;

import com.hblack.amazonyandex.entity.ImageEntity;
import com.hblack.amazonyandex.repository.LocalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {

    @Autowired
    private final LocalRepository localRepository;

    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public List<ImageEntity> showAll() {
        List<ImageEntity> imageEntityList = localRepository.findAll();
        return imageEntityList;
    }

    public void saveImage(String imagename) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImagename(imagename);
        localRepository.save(imageEntity);
    }



    /*public void deleteImage(String imagename) {
        localRepository.deleteByImageName(imagename);
    }*/

}
