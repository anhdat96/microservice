package microservice.currencyexchangeservice.repository;

import microservice.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeServiceRepository extends JpaRepository<ExchangeValue,Long> {

    List<ExchangeValue> findByExchangeFromAndExchangeTo(String from, String to);
    ExchangeValue findByExchangeFrom(String from);

}
