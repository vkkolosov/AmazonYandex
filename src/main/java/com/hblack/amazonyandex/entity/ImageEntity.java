package com.hblack.amazonyandex.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "images")

public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //инкрементация
    private long id;

    private String imagename;

}
