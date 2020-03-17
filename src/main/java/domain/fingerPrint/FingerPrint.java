package domain.fingerPrint;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class FingerPrint {

    @Id
    @Column(length = 500, nullable = false)
    private String privateKey;

    @Column(length = 500, nullable = false)
    private String fingerPrintPhotoUrl;

    @Builder
    public FingerPrint(String privateKey, String fingerPrintPhotoUrl){
        this.privateKey = privateKey;
        this. fingerPrintPhotoUrl = fingerPrintPhotoUrl;
    }
}