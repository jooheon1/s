package domain.fingerPrint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FingerPrintRepository extends JpaRepository<FingerPrint, String> {
    Optional<FingerPrint> findByPrivateKey(String privateKey);
}
