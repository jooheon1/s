package domain.photo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class FacePhoto {

    @Id
    @Column(length = 500, nullable = false)
    private String privateKey;

    @Column(length = 500, nullable = false)
    private String facePhotoUrl;

    @Builder
    public FacePhoto(String privateKey, String facePhotoUrl){
        this.privateKey = privateKey;
        this.facePhotoUrl = facePhotoUrl;
    }
}