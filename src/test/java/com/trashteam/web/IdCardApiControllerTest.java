package com.trashteam.web;

import com.trashteam.domain.photo.FacePhoto;
import com.trashteam.domain.photo.FacePhotoRepository;
import com.trashteam.web.dto.FacePhotoSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IdCardApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private FacePhotoRepository photoRepository;

    @After
    public void tearDown() throws Exception{
        photoRepository.deleteAll();
    }

    @Test
    public void 얼굴사진_등록되다() throws Exception{
        //given
        String imgUrl = "king-hung-min is jjang";
        String imgName = "KingHungMin";
        FacePhotoSaveRequestDto requestDto = FacePhotoSaveRequestDto.builder()
                .faceImgName(imgName)
                .faceImgUrl(imgUrl)
                .build();

        String url = "http://localhost:" + port + "/api/idCard/facePhoto";

        //when
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestDto, String.class);

        List<FacePhoto> all = photoRepository.findAll();
        assertThat(all.get(0).getImgName()).isEqualTo(imgName);
        assertThat(all.get(0).getImgUrl()).isEqualTo(imgUrl);
        assertThat(all.get(0).getPrivateKey()).isEqualTo(all.get(0).getPrivateKey());
        System.out.println(all.get(0).getImgName());
        System.out.println(all.get(0).getImgUrl());
        System.out.println(all.get(0).getPrivateKey());
    }
}
