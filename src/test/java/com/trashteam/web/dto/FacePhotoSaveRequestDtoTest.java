package com.trashteam.web.dto;


import com.trashteam.tool.GenerateKey;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacePhotoSaveRequestDtoTest{
    @Autowired
    private GenerateKey generateKey;

    @Test
    public void save() throws Exception{
       FacePhotoSaveRequestDto requestDto = FacePhotoSaveRequestDto.builder()
               .faceImgUrl("king")
               .faceImgName("hungmin")
               .build();

       requestDto.setFacePhotoPrivateKey(generateKey.getFacePhotoPrivateKey());

        Assertions.assertThat(requestDto.getFaceImgName()).isEqualTo("hungmin");
        Assertions.assertThat(requestDto.getFaceImgUrl()).isEqualTo("king");
        Assertions.assertThat(requestDto.getFacePhotoPrivateKey()).isEqualTo(generateKey.getFacePhotoPrivateKey());
    }
}