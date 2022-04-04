package com.hblack.amazonyandex.repository;

import com.hblack.amazonyandex.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalRepository extends JpaRepository<ImageEntity, Long> {


    void deleteImageEntityByImagename(String imagename);
    ImageEntity findByImagename(String imagename);


}
