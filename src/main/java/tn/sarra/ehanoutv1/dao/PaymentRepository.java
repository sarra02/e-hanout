package tn.sarra.ehanoutv1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.sarra.ehanoutv1.entities.Payment;

@CrossOrigin("*")
@RepositoryRestResource
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
